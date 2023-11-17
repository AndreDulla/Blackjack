import java.io.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final int frameSizeX = 500;
        final int frameSizeY = 600;
        final int buttonWidth = 200;
        final int buttonHeight = 50;
        final int frameMargin = 20;

        JFrame frame = new JFrame(); // creating instance of JFrame

        // BUTTON 1
        JButton buttonPlayer1 = new JButton("1 giocatore"); // creating button
        buttonPlayer1.setBounds(frameMargin, 200, buttonWidth, buttonHeight); // x axis, y axis, width, height
        frame.add(buttonPlayer1); // adding button in JFrame

        // BUTTON 2
        JButton buttonPlayer2 = new JButton("2 giocatori"); // creating button
        buttonPlayer2.setBounds(frameSizeX - buttonWidth - frameMargin, 200, buttonWidth, buttonHeight); // x axis, y axis, width, height
        frame.add(buttonPlayer2); // adding button in JFrame


        frame.setSize(frameSizeX, 600); // 400 width and 500 height
        frame.setLayout(null); // using no layout managers
        frame.setVisible(true); // making the frame visible


        System.out.println("Welcome in blackjack");

        Deck deck = new Deck();
        System.out.println(deck.getNewCardValue());
    }
}