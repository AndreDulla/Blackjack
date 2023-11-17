public class Deck {
    private int cardValue;
    private int casualNumber;


    /**
     * Extracts a card from the deck
     * @return value of the extracted card
     */
    public int getNewCardValue(){
        casualNumber = getRandomNumber(1, 104);
        cardValue = (casualNumber % 13 + 1);  // finding the value of the card (there are 13 card for each seed)
        if(cardValue > 10) cardValue = 10;  // every figure value is 10
        return cardValue;
    }

    /**
     *
     * @param min minimum value of the casual number
     * @param max maximum value of the casual number
     * @return Casual number between min and max included (I hope)
     */
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}