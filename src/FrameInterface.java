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
        int cardValue;

        // PLAYER 1 label
        createTextField("Player 1:", frameMargin, frameMargin, true);

        // PLAYER 1 first card value
        cardValue = deck.getNewCardValue();
        player1.addPoints(cardValue);
        System.out.println("Player 1 points: " + player1.getPoints());
        printCardValue(cardValue, 130, frameMargin);

        // PLAYER 1  "+"
        JTextField jTextField2 = new JTextField();
        jTextField2.setEditable(false);
        jTextField2.setText("+");
        jTextField2.setBounds(160, frameMargin, 20, 40);
        frame.add(jTextField2);

        // PLAYER 1 second card value
        cardValue = deck.getNewCardValue();
        player1.addPoints(cardValue);
        System.out.println("Player 1 points: " + player1.getPoints());
        printCardValue(cardValue, 180, frameMargin);

        // PLAYER 1  "="
        JTextField jTextField3 = new JTextField();
        jTextField3.setEditable(false);
        jTextField3.setText("=");
        jTextField3.setBounds(210, frameMargin, 20, 40);
        frame.add(jTextField3);

        // PLAYER 1  total points
        JTextField jTextField4 = new JTextField();
        jTextField4.setEditable(false);
        jTextField4.setText(" " + player1.getPoints());
        jTextField4.setBounds(240, frameMargin, 40, 40);
        frame.add(jTextField4);

    }

    /**
     * creates a text field and adds the card value drew
     * @param cardValue value of the card drew that has to be printed
     */
    public void printCardValue(int cardValue, int x, int y){
        String string = " " + cardValue;

        JTextField jTextField = new JTextField();
        jTextField.setEditable(false);
        jTextField.setText(string);
        jTextField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

        int textWidth = 11 * string.length();
        jTextField.setBounds(x, y, textWidth, 40);
        frame.add(jTextField);
    }

    /**
     * Creates a text field
     * @param string label of the field
     * @param x position x
     * @param y position y
     * @param bold true -> bold text
     */
    public void createTextField(String string, int x, int y, boolean bold){
        JTextField jTextField = new JTextField();
        jTextField.setEditable(false);
        jTextField.setText(string);
        if(bold) jTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextField.setBounds(x, y, string.length() * 9, 40);
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
