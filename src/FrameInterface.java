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
        Player dealer = new Player();
        int cardValue;

        // PLAYER 1 label --------------------
        createTextField("Player 1:", frameMargin, frameMargin, true);

        // PLAYER 1 first card value
        cardValue = deck.getNewCardValue();
        player1.addPoints(cardValue);
        printValue(cardValue, 120, frameMargin);

        // PLAYER 1  "+"
        createTextField("+", 150, frameMargin, false);

        // PLAYER 1 second card value
        cardValue = deck.getNewCardValue();
        player1.addPoints(cardValue);
        printValue(cardValue, 180, frameMargin);

        // PLAYER 1  "="
        createTextField("=", 230, frameMargin, false);

        // PLAYER 1  total points
        printValue(player1.getPoints(), 250, frameMargin);

        // PLAYER 2 label --------------------
        createTextField("Player 2:", frameMargin, frameMargin + 40, true);

        // PLAYER 2 first card value
        cardValue = deck.getNewCardValue();
        player2.addPoints(cardValue);
        printValue(cardValue, 120, frameMargin + 40);

        // PLAYER 2  "+"
        createTextField("+", 150, frameMargin + 40, false);

        // PLAYER 2 second card value
        cardValue = deck.getNewCardValue();
        player2.addPoints(cardValue);
        printValue(cardValue, 180, frameMargin + 40);

        // PLAYER 2  "="
        createTextField("=", 230, frameMargin + 40, false);

        // PLAYER 2  total points
        printValue(player2.getPoints(), 250, frameMargin + 40);

        // DEALER label --------------------
        createTextField("Dealer:", frameWidth / 2 - 30, frameMargin + 90, true);

        // DEALER first card value
        cardValue = deck.getNewCardValue();
        dealer.addPoints(cardValue);
        printValue(cardValue, frameWidth / 2 - 40, frameMargin + 120);

        // DEALER "+"
        createTextField("+", frameWidth / 2 - 10, frameMargin + 120, false);

        // DEALER second card value
        cardValue = deck.getNewCardValue();
        dealer.addPoints(cardValue);
        printValue(cardValue, frameWidth / 2 + 20, frameMargin + 120);

        // DEALER "="
        createTextField("=", frameWidth / 2 - 20, frameMargin + 150, false);

        // DEALER total points
        printValue(dealer.getPoints(), frameWidth / 2, frameMargin + 150);
    }

    /**
     * creates a text field and adds the card value drew
     * @param cardValue value of the card drew that has to be printed
     */
    public void printValue(int cardValue, int x, int y){
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
        if(string.length() > 1) jTextField.setBounds(x, y, string.length() * 9, 40);
        else jTextField.setBounds(x, y, 20, 40);
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
