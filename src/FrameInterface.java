import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;


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
        prepareStartingGUI();
    }

    public void prepareStartingGUI(){
        frame.setTitle("Blackjack");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // stop esecution when frame is closed
        frame.add(buttonPlayer1); // adding button in JFrame
        frame.add(buttonPlayer2); // adding button in JFrame
    }

    /**
     * Sets properties for each button
     */
    public void setButtonsPlayerProperties(){
        // button 1
        buttonPlayer1.setBounds(frameMargin, 200, buttonWidth, buttonHeight); // x axis, y axis, width, height
        buttonPlayer1.addActionListener(this);//Registering ActionListener to the button
        // button 2
        buttonPlayer2.setBounds(frameWidth - buttonWidth - frameMargin, 200, buttonWidth, buttonHeight); // x axis, y axis, width, height
        buttonPlayer2.addActionListener(this);//Registering ActionListener to the button
    }

    public int getnPlayers() { return nPlayers; }

    /**
     * Removes buttons from the interface
     */
    public void removeButtons(){
        frame.remove(buttonPlayer1);
        frame.remove(buttonPlayer2);
    }

    /**
     * Manages all the interface while playing
     */
    public void setGamingGUI() {
        // GUI where the game happens
        Deck deck = new Deck();
        Player player1 = new Player();
        Player player2 = new Player();

        JTextField jTextField = new JTextField();
        jTextField.setEditable(false);
        jTextField.setText("Pesco la carta...");
        jTextField.setBounds(0, 0, 110, 40);
        frame.add(jTextField);

        int cardValue = deck.getNewCardValue();
        player1.setPoints(cardValue);
        printCardValue(cardValue);
    }

    /**
     * creates a text field and adds the card value drew
     * @param cardValue value of the card drew that has to be printed
     */
    public void printCardValue(int cardValue){
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 15);
        String string = "Ho pescato " + cardValue;

        JTextField jTextField = new JTextField();
        jTextField.setEditable(false);
        jTextField.setText(string);
        jTextField.setFont(font);

        int textWidth = 11 * string.length();
        jTextField.setBounds(130, 0, textWidth, 40);
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
