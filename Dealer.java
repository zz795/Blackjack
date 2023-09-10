import java.util.*;

public class Dealer extends Player {
    private boolean revealing;

    /*
     * constructor
     */
    public Dealer(){
        super("dealer");
        this.revealing = false;
    }

    /*
     * revealFirstCard - takes no parameters and changes the value of
     * the called object’s boolean field to indicate that
     * the dealer’s first card should now be revealed
     */
    public void revealFirstCard() {
        this.revealing = true;
    }

    /*
     * printHand - overrides the inherited version
     */
    public void printHand() {
        if (this.revealing == false) {
            System.out.print("XX  ");
            for (int i=1; i < this.getNumCards(); i++) {
                System.out.print(this.getCard(i).toString() + "  ");
            }
        } else {
            super.printHand();
        }
    }

    /*
     * wantsHit - overrides the inherited version
     */
    public boolean wantsHit(Scanner console, Player p) {
        if (p.hasBlackjack() == true) {
            return false;
        } else if (p.getHandValue() < 17 && this.getHandValue() > p.getHandValue()) {
            return false;
        } else if (p.getHandValue() >= 17 && this.getHandValue() >= p.getHandValue()) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * discardCards - overrides the inherited version
     */
    public void discardCards() {
        super.discardCards();
        this.revealing = false;
    }
}
