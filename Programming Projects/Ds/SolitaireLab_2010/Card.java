/**
 * creates a card for the game of solitare that has all the required attributes
 *
 * @author Keshav Kotamraju
 * @version 12/11/23
 */
public class Card {

    // instance variables - replace the example below with your own
    private int rank;
    private String suit;
    private boolean isFaceUp;

    /**
     * Constructor for objects of class Card
     */
    public Card(int r, String s) {
        rank = r;
        suit = s;
        isFaceUp = false;
    }

    /**
     * Gets the rank of the card
     *
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Gets the suit of the card
     *
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns whether the card is red or not
     *
     * @return true if the card is red; otherwise, false
     */
    public boolean isRed() {
        if (suit == "h" || suit == "d")
            return true;
        return false;
    }

    /**
     * Returns whether or not the card is facing up or not
     *
     * @return true if the card is facing up; otherwise, false
     */
    public boolean isFaceUp() {
        if (isFaceUp)
            return true;
        return false;
    }

    /**
     * Turns the card to face up
     */
    public void turnUp() {
        isFaceUp = true;
    }

    /**
     * Turns the card to face down
     */
    public void turnDown() {
        isFaceUp = false;
    }

    /**
     * Gets the file name
     *
     * @return string containing the file name
     */
    public String getFileName() {
        if (!isFaceUp) {
            return "cards/back.gif";
        }
        String temp = Integer.toString(rank);
        switch(rank)
        {
            case (1) -> temp = "a";
            case (10) -> temp = "t";
            case (11) -> temp = "j";
            case (12) -> temp = "q";
            case (13) -> temp = "k";
            default -> temp = "" + rank;
        }

        return "cards/" + temp + suit + ".gif";
    }
}