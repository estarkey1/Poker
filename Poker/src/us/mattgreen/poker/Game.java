package us.mattgreen.poker;

import java.util.Arrays;

/**
 * This is a utility class consisting of static methods to determine if a hand matches a specific
 * @author  Dr. Green
 * @version 1.0
 */
public class Game {
    /**
     *
     * @param hand An Array of Cards
     * @return True if there are two of a kind and false if not
     */
    public static boolean onePair(Card[] hand) {
        Arrays.sort(hand, (a, b) -> a.getFace().compareTo(b.getFace()));
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].getFace().equals(hand[i + 1].getFace())) {
                return true;
            }
        }
        return false;
    }

    public static boolean twoOfAKind(Card[] hand) {
        Arrays.sort(hand, (a, b) -> a.getFace().compareTo(b.getFace()));
        int numberOFmatches = 0;
        for(int i=0;i < hand.length-1; i++) {
            if (hand[i].getFace().equals(hand[i+1].getFace())) return true;
        }
        return false;
    }

    public static boolean threeOfAKind(Card[] hand) {
        Arrays.sort(hand, (a, b) -> a.getFace().compareTo(b.getFace()));
        for (int i = 0; i < hand.length - 2; i++) {
            if (hand[i].getFace().equals(hand[i + 1].getFace()) &&
                    hand[i + 1].getFace().equals(hand[i + 2].getFace())) {
                return true;
            }
        }
        return false;
    }

    public static boolean flush(Card[] hand) {
        Suit firstSuit = hand[0].getSuit();
        for (int i = 1; i < hand.length; i++) {
            if (!hand[i].getSuit().equals(firstSuit)) {
                return false;
            }
        }
        return true;
    }
}
