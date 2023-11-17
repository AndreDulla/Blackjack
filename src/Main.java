public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome in blackjack");

        FrameInterface frameInterface = new FrameInterface();

        Deck deck = new Deck();
        System.out.println(deck.getNewCardValue());
    }
}