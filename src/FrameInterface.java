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
        setButtonsPlayerProperties();
        setStartingGUI();
    }

    /**
     * Sets the starting GUI of the game
     */
    public void setStartingGUI(){
        frame.setTitle("Blackjack");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // stop esecution when frame is closed
        frame.add(buttonPlayer1); // adding button in JFrame
        frame.add(buttonPlayer2); // adding button in JFrame
    }

    public void setButtonsPlayerProperties(){
        // button 1
        buttonPlayer1.setBounds(frameMargin, 200, buttonWidth, buttonHeight); // x axis, y axis, width, height
        buttonPlayer1.addActionListener(this);//Registering ActionListener to the button
        // button 2
        buttonPlayer2.setBounds(frameWidth - buttonWidth - frameMargin, 200, buttonWidth, buttonHeight); // x axis, y axis, width, height
        buttonPlayer2.addActionListener(this);//Registering ActionListener to the button
    }

    public int getnPlayers() {
        return nPlayers;
    }

    public void removeButtons(){
        frame.remove(buttonPlayer1);
        frame.remove(buttonPlayer2);
    }

    /**
     * Sets the GUI of the actual game
     */
    public void setGamingGUI() {
        // GUI where the game happens
        Deck deck = new Deck();

        // Player 1 label
        JTextField jTextField = new JTextField();
        jTextField.setEditable(false);
        jTextField.setFont(new Font("Tahoma", Font. BOLD, 14));
        String string = "Player 1:";
        jTextField.setText(string);
        jTextField.setBounds(frameMargin, frameMargin, 80, 40);
        frame.add(jTextField);


        printCardValue(deck.getNewCardValue());
    }

    public void printCardValue(int casualNumber){
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 15);
        String string = " " + casualNumber;

        JTextField jTextField = new JTextField();
        jTextField.setEditable(false);
        jTextField.setText(string);
        jTextField.setFont(font);

        int textWidth = 11 * string.length();
        jTextField.setBounds(130, frameMargin, textWidth, 40);
        frame.add(jTextField);
    }

    @Override
    // when one button is pressed:
    public void actionPerformed(ActionEvent e) {
        // checks which buttons has been pressed
        if("1 player".equals(e.getActionCommand())){
            nPlayers = 1;
            frame.getContentPane().setBackground(Color.white);       // Changing Background Color
        }else{
            nPlayers = 2;
            frame.getContentPane().setBackground(Color.white);        // Changing Background Color
        }
        System.out.println(e.getActionCommand());
        removeButtons();    // clears actual GUI

        setGamingGUI();     // set the new GUI
    }
}
