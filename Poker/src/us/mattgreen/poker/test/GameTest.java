package us.mattgreen.poker.test;

import org.junit.Before;
import org.junit.Test;
import us.mattgreen.poker.Card;
import us.mattgreen.poker.Game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static us.mattgreen.poker.Face.*;
import static us.mattgreen.poker.Suit.*;

public class GameTest {
    private Card[] hand;

    @Before
    public void setUp() {
        hand = new Card[]{new Card(JACK,CLUBS, 11), new Card(FIVE,CLUBS, 5), new Card(JACK,SPADES, 11)};
    }

    @Test
    public void oneOfAKindTestTrue(){
        hand = new Card[]{new Card(KING, CLUBS, 13), new Card(KING, HEARTS, 13)};
        assertTrue("One pair should have matched", Game.onePair(hand));
    }

    @Test
    public void oneOfAKindTestFalse(){
        hand = new Card[]{new Card(JACK, CLUBS, 11), new Card(KING, HEARTS, 13)};
        assertFalse("One pair did not match", Game.onePair(hand));
    }

    @Test
    public void twoPairsTestTrue() {
        hand = new Card[]{new Card(KING, CLUBS, 13), new Card(KING, HEARTS, 13), new Card(ACE, DIAMONDS, 14), new Card(ACE, CLUBS, 14)};
        assertTrue("Two pairs should have matched", Game.twoOfAKind(hand));
    }

    @Test
    public void twoPairsTestFalse() {
        hand = new Card[]{new Card(JACK, CLUBS, 11), new Card(KING, HEARTS, 13), new Card(ACE, DIAMONDS, 14)};
        assertFalse("Two pairs did not match", Game.twoOfAKind(hand));
    }

    @Test
    public void threeOfAKindTestTrue() {
        hand = new Card[]{new Card(KING, CLUBS, 13), new Card(KING, HEARTS, 13), new Card(KING, DIAMONDS, 13)};
        assertTrue("Three of a kind should have matched", Game.threeOfAKind(hand));
    }

    @Test
    public void threeOfAKindTestFalse() {
        hand = new Card[]{new Card(JACK, CLUBS, 11), new Card(KING, HEARTS, 13), new Card(ACE, DIAMONDS, 14)};
        assertFalse("Three of a kind did not match", Game.threeOfAKind(hand));
    }

    @Test
    public void flushTestTrue() {
        hand = new Card[]{new Card(KING, CLUBS, 13), new Card(TEN, CLUBS, 10), new Card(SEVEN, CLUBS, 7), new Card(TWO, CLUBS, 2), new Card(FOUR, CLUBS, 4)};
        assertTrue("Flush should have matched", Game.flush(hand));
    }

    @Test
    public void flushTestFalse() {
        hand = new Card[]{new Card(KING, CLUBS, 13), new Card(TEN, CLUBS, 10), new Card(SEVEN, DIAMONDS, 7), new Card(TWO, CLUBS, 2), new Card(FOUR, CLUBS, 4)};
        assertFalse("Flush did not match", Game.flush(hand));
    }
}
