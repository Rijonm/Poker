package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public enum HandType {
    HighCard, OnePair, TwoPair, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush;
    
    /**
     * Determine the value of this hand. Note that this does not
     * account for any tie-breaking
     */
	
	
    public static HandType evaluateHand(ArrayList<Card> cards) {
        HandType currentEval = HighCard;
        
        if (isOnePair(cards)) currentEval = OnePair;
        if (isTwoPair(cards)) currentEval = TwoPair;
        if (isThreeOfAKind(cards)) currentEval = ThreeOfAKind;
        if (isStraight(cards)) currentEval = Straight;
        if (isFlush(cards)) currentEval = Flush;
        if (isFullHouse(cards)) currentEval = FullHouse;
        if (isFourOfAKind(cards)) currentEval = FourOfAKind;
        if (isStraightFlush(cards)) currentEval = StraightFlush;
        
        return currentEval;
    }
    
    private static boolean isOnePair(ArrayList<Card> cards) {
        boolean found = false;
        for (int i = 0; i < cards.size() - 1 && !found; i++) {
            for (int j = i+1; j < cards.size() && !found; j++) {
                if (cards.get(i).getRank() == cards.get(j).getRank()) found = true;
            }
        }
        return found;
    }
    
    private static boolean isTwoPair(ArrayList<Card> cards) {
        // Clone the cards, because we will be altering the list
        ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();

        // Find the first pair; if found, remove the cards from the list
        boolean firstPairFound = false;
        for (int i = 0; i < clonedCards.size() - 1 && !firstPairFound; i++) {
            for (int j = i+1; j < clonedCards.size() && !firstPairFound; j++) {
                if (clonedCards.get(i).getRank() == clonedCards.get(j).getRank()) {
                    firstPairFound = true;
                    clonedCards.remove(j);  // Remove the later card
                    clonedCards.remove(i);  // Before the earlier one
                }
            }
        }
        // If a first pair was found, see if there is a second pair
        return firstPairFound && isOnePair(clonedCards);
    }
    
    private static boolean isThreeOfAKind(ArrayList<Card> cards) {
    	boolean found = false;
        for (int i = 0; i < cards.size() - 2 && !found; i++) {
            for (int j = i+1; j < cards.size() -1 && !found; j++) {
            		for(int k = j+1; k< cards.size() && !found; k++) {
                if (cards.get(i).getRank() == cards.get(j).getRank() && cards.get(j).getRank() == cards.get(k).getRank()) 
                		found = true;
            		}
            }
        }
        return found;
    }
    
    private static boolean isStraight(ArrayList<Card> cards) {
    	ArrayList<Integer> inte = new ArrayList<Integer>();
    	boolean found = false;
    	
    	for(Card c : cards) {
    		inte.add(c.getRank().ordinal());
    		}
    	Collections.sort(inte);
    	
    	if(inte.get(0) == (inte.get(1))-1) {
    		if(inte.get(1) == (inte.get(2))-1) {
    			if(inte.get(2) == (inte.get(3))-1) {
    				if(inte.get(3) == (inte.get(4))-1) {
    					found = true;
    				}
    			}
    		}
    	}
    	//Wenn ordinal beginnt bei 0, kann auch mit Ass Strasse sein
    	if((inte.get(0) == (inte.get(1))-1) && (inte.get(0) == 0)) {
    		if(inte.get(1) == (inte.get(2))-1) {
    			if(inte.get(2) == (inte.get(3))-1) {
    				if(inte.get(4) == 12) {
    					found = true;
    				}
    			}
    		}
    	}
        return found;
    }
    
    private static boolean isFlush(ArrayList<Card> cards) {
        
    if(cards.get(0).getSuit().equals(cards.get(1).getSuit()))
    		if(cards.get(0).getSuit().equals(cards.get(2).getSuit()))
    			if(cards.get(0).getSuit().equals(cards.get(3).getSuit()))
    				if(cards.get(0).getSuit().equals(cards.get(4).getSuit()))
        return true;
    
    return false;
    		}
    
    private static boolean isFullHouse(ArrayList<Card> cards) {
        
    	if(isThreeOfAKind(cards) && isTwoPair(cards))        
        return true;
    	
    		return false;
		}
    
    private static boolean isFourOfAKind(ArrayList<Card> cards) {
    	boolean found = false;
        for (int i = 0; i < cards.size() - 3 && !found; i++) {
            for (int j = i+1; j < cards.size()-2 && !found; j++) {
            		for(int k = j+1; k< cards.size()-1 && !found; k++) {
            			for(int l = k+1; l < cards.size() && !found; l++) {
                if (cards.get(i).getRank() == cards.get(j).getRank() && cards.get(j).getRank() == cards.get(k).getRank() && cards.get(k).getRank() == cards.get(l).getRank())
                	found = true;
            			}
            		}
            }
        }
        return found;
    }
    
    private static boolean isStraightFlush(ArrayList<Card> cards) {
    	
    	if(isStraight(cards) && isFlush(cards))        
            return true;
        	
        		return false;
    		}
}
