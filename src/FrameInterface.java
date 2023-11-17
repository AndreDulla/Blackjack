import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FrameInterface implements ActionListener {
    final int frameWidth = 500;
    final int frameHeight = 600;
    final int buttonWidth = 200;
    final int buttonHeight = 50;
    final int frameMargin = 20;
    private int nPlayers;

    JFrame frame = new JFrame(); // creating instance of JFrame
    JButton buttonPlayer2 = new JButton("2 players"); // creating button
    JButton buttonPlayer1 = new JButton("1 player"); // creating button

    public FrameInterface(){
        setButtonPlayer1Properties();
        setButtonPlayer2Properties();
        prepareGUI();
    }

    public void prepareGUI(){
        frame.setTitle("Blackjack");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // stop esecution when frame is closed
        frame.add(buttonPlayer1); // adding button in JFrame
        frame.add(buttonPlayer2); // adding button in JFrame
    }

    // BUTTON 1
    public void setButtonPlayer1Properties(){
        buttonPlayer1.setName("1");
        buttonPlayer1.setBounds(frameMargin, 200, buttonWidth, buttonHeight); // x axis, y axis, width, height
        buttonPlayer1.addActionListener(this);//Registering ActionListener to the button
    }

    // BUTTON 2
    public void setButtonPlayer2Properties(){
        buttonPlayer2.setBounds(frameWidth - buttonWidth - frameMargin, 200, buttonWidth, buttonHeight); // x axis, y axis, width, height
        buttonPlayer2.addActionListener(this);//Registering ActionListener to the button
    }

    public int getnPlayers() {
        return nPlayers;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("1 player".equals(e.getActionCommand())){
            nPlayers = 1;
            frame.getContentPane().setBackground(Color.lightGray);
        }else{
            nPlayers = 2;
            frame.getContentPane().setBackground(Color.pink);
        }
        System.out.println(e.getActionCommand());

        // Changing Background Color


    }
}
