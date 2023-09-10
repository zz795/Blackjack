import java.util.*;

public class Player {
    private String name;
    private Card[] hand;
    private int numCards;

    /*
     * constructor - takes a single parameter for the name of the player
     */
    public Player(String n) {
        this.name = n;
        this.hand = new Card[Blackjack.MAX_CARDS_PER_PLAYER];
        this.numCards = 0;
    }

    /*
     * getName - returns the player’s name
     */
    public String getName() {
        return this.name;
    }

    /*
     * getNumCards - returns the current number of cards in the player’s hand
     */
    public int getNumCards() {
        return this.numCards;
    }

    /*
     * addCard - takes a Card object as a parameter
     * and adds the specified card to the player’s hand
     */
    public void addCard(Card c){
        if (c == null || this.numCards == this.hand.length) {
            throw new IllegalArgumentException();
        } else {
            this.hand[this.numCards] = c;
            this.numCards++;
        }
    }

    /*
     * getCard - takes an integer index as a parameter
     * and returns the Card at the specified position in the player’s hand
     * without actually removing the card from the hand
     */
    public Card getCard(int i) {
        if (i < 0 || i > this.numCards) {
            throw new IllegalArgumentException();
        } else {
            return this.hand[i];
        }
    }

    /*
     * getHandValue - computes and returns the total value of
     * the player’s current hand
     */
    public int getHandValue() {
        int sum = 0;
        int numAces = 0;
        for (int i=0; i < this.numCards; i++) {
            sum += this.hand[i].getValue();
            if (this.hand[i].isAce() == true) {
                numAces++;
            }
        }
        if (numAces >= 1 && sum <=11) {
            sum +=10;
        }
        return sum;
    }

    /*
     * printHand - prints the current contents of the player’s hand
     * followed by the value of the player’s hand
     */
    public void printHand() {
        for (int i=0; i < this.numCards; i++) {
            System.out.print(this.hand[i].toString() + "  ");
        }
        System.out.println("(value = " + this.getHandValue() + ")");
    }

    /*
     * hasBlackjack - returns true if the player has Blackjack
     * and false otherwise
     */
    public boolean hasBlackjack(){
        if (this.numCards == 2 && this.getHandValue() == 21) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * wantsHit - return true if the player wants another hit
     * and false if the player does not want another hit
     */
    public boolean wantsHit(Scanner console, Player p) {
        System.out.print("Want another hit, " + this.name + " (y/n)? ");
        String answer = console.nextLine();
        if (answer.equalsIgnoreCase("y") == true) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * discardCards - get rid of all of the cards in the player’s hand
     */
    public void discardCards() {
        this.hand = new Card[Blackjack.MAX_CARDS_PER_PLAYER];
        this.numCards = 0;
    }
}
