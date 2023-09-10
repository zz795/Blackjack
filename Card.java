public class Card {
    // constants for the ranks of non-numeric cards
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    
    // other constants for the ranks
    public static final int FIRST_RANK = 1;
    public static final int LAST_RANK = 13;
    
    // Arrays of strings for the rank names and abbreviations.
    // The name of the rank r is given by RANK_NAMES[r].
    // The abbreviation of the rank r is given by RANK_ABBREVS[r].
    private static final String[] RANK_NAMES = {
      null, "Ace", "2", "3", "4", "5", "6", 
      "7", "8", "9", "10", "Jack", "Queen", "King"
    };
    private static final String[] RANK_ABBREVS = {
      null, "A", "2", "3", "4", "5", "6",
      "7", "8", "9", "10", "J", "Q", "K"
    };
    
    // constants for the suits
    public static final int FIRST_SUIT = 0;
    public static final int LAST_SUIT = 3;
    public static final int CLUBS = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int SPADES = 3;
    
    // Arrays of strings for the suit names and abbreviations.
    // The name of the suit s is given by SUIT_NAMES[s].
    // The abbreviation of the suit s is given by SUIT_ABBREVS[s].
    private static final String[] SUIT_NAMES = {
      "Clubs", "Diamonds", "Hearts", "Spades"
    };
    private static final String[] SUIT_ABBREVS = {
      "C", "D", "H", "S"
    };
    
    private static int getSuitNum(String suit) {
        // The return statement below is included so the starter code 
        // will compile.
        // Replace it with your implementation of the method.
        for (int i = 0; i < SUIT_NAMES.length; i++) {
          if (SUIT_NAMES[i].equalsIgnoreCase(suit) == true) {
            return i;
          }
        }
        return -1;
    }

    /*
     * 3) private fields
     */
    private int rank;
    private int suitNum;

    /*
     * 4) constructor that takes 2 integer parameters
     * specifying the card’s rank and suit number
     */
    public Card(int r, int s) {
      if ( r < 1 || r > 13) {
        throw new IllegalArgumentException();
      }
      if (s < 0 || s > 3) {
        throw new IllegalArgumentException();
      }
      this.rank = r;
      this.suitNum = s;
    }
    
    /*
     * 4) constructor that takes an integer parameter
     * specifying the card’s rank
     * and a String parameter specifying the card’s suit
     */
    public Card(int r, String s) {
      if ( r < 1 || r > 13) {
        throw new IllegalArgumentException();
      }
      if (s.equalsIgnoreCase("DIAMONDS") == false && s.equalsIgnoreCase("HEARTS") == false && s.equalsIgnoreCase("CLUBS") == false && s.equalsIgnoreCase("SPADES") == false) {
        throw new IllegalArgumentException();
      }
      this.rank = r;
      this.suitNum = Card.getSuitNum(s);
    }

    /*
     * 5) getRank - returns the integer representing the Card object’s rank
     */
    public int getRank() {
      return this.rank;
    }
    
    /*
     * 5) getRankName - returns a String representation of
     * the Card object’s rank
     */
    public String getRankName() {
      return RANK_NAMES[this.rank];
    }
    
    /*
     * 5) getSuitNum - returns the Card object’s suit number
     */
    public int getSuitNum() {
      return this.suitNum;
    }
    
    /*
     * 5) getSuitName - returns a String representation of the Card object’s suit
     */
    public String getSuitName() {
      return SUIT_NAMES[this.suitNum];
    }
    
    /*
     * 5) getName - returns a String representing the full name of the Card
     */
    public String getName(){
      return RANK_NAMES[this.rank] + " of " + SUIT_NAMES[this.suitNum];
    }
    
    /*
     * 5) isAce - returns true if the Card is an Ace and and false if it is not
     */
    public boolean isAce() {
      return RANK_NAMES[this.rank].equalsIgnoreCase("Ace");
    }
    
    /*
     * 5) isFaceCard - returns true if the Card is a face card (Jack, Queen, or King)
     * and and false if it is not
     */
    public boolean isFaceCard() {
      if (RANK_NAMES[this.rank].equalsIgnoreCase("Jack") || RANK_NAMES[this.rank].equalsIgnoreCase("Queen") || RANK_NAMES[this.rank].equalsIgnoreCase("King")) {
        return true;
      } else {
        return false;
      }
    }

    /*
     * 5) getValue - returns the Card object’s value
     */
    public int getValue() {
      if (this.isFaceCard() == true) {
        return 10;
      } else {
        return this.rank;
      }
    }

    /*
     * 6) toString - returns a string representation of card’s rank abbreviation
     * followed immediately by its suit abbreviation
     */
    public String toString() {
      return RANK_ABBREVS[this.rank] + "" + SUIT_ABBREVS[this.suitNum];
    }
    
    /*
     * 7) sameSuitAs - takes a Card object as a parameter
     * and determines if it is has the same suit as the called object
     */
    public boolean sameSuitAs(Card other) {
      if (other == null) {
        return false;
      } else {
        return SUIT_NAMES[this.suitNum].equalsIgnoreCase(SUIT_NAMES[other.suitNum]);
      }
    }

    /*
     * 7) equals - takes a Card object as a parameter
     * and determines if it is equivalent to the called object
     */
    public boolean equals(Card other) {
      if (other == null) {
        return false;
      } else if (this.sameSuitAs(other) == false) {
        return false;
      } else if (this.rank != other.rank) {
        return false;
      } else {
        return true;
      }
    }

}
