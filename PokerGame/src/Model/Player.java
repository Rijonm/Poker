package Model;

import java.util.ArrayList;

import Game.PokerGame;
import View.CardLabel;


public class Player implements Comparable<Player> {
    public static final int HAND_SIZE = 5;
    
    private final String playerName; // This is the ID
    private final ArrayList<Card> cards = new ArrayList<>();
    private HandType handType;
    public static ArrayList<Integer> handTypeList = new ArrayList<>();
    public String winnerOrLoser;
    int playerNumb;
    
    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public void addCard(Card card) {
        if (cards.size() < HAND_SIZE) 
        		cards.add(card);
    }
    
    public void discardHand() {
        cards.clear();
        handType = null;
    }
    
    public int getNumCards() {
        return cards.size();
    }

    /**
     * If the hand has not been evaluated, but does have all cards, 
     * then evaluate it.
     */
    public HandType evaluateHand() {
        if (handType == null && cards.size() == HAND_SIZE) {
            handType = HandType.evaluateHand(cards);
        }
        return handType;
    }

    /**
     * Hands are compared, based on the evaluation they have.
     */
    @Override
    public int compareTo(Player o) {
    	
        return handType.compareTo(o.handType);
    }
    
    public void addHandTypeToList() {
    		handTypeList.add(this.handType.ordinal());
    }

	public void evaluateWinner() {
		playerNumb = Integer.parseInt(this.playerName.replaceAll("\\D+",""))-1;
		for (int a = 12 ; a >= 0 ; a--) {
			if(handTypeList.contains(a)) {
				if(handTypeList.get(playerNumb) == a) {
					winnerOrLoser = "Winner";
				}else {
					winnerOrLoser = "Loser";
				}
				if(evalSplitpot()) {
					winnerOrLoser = "Splitpot";
				}
				break;
			}
		}
		
	}
	
	public boolean evalSplitpot() {
		boolean moreHandsSame =false;
		ArrayList<Integer> clonedList = (ArrayList <Integer>) handTypeList.clone(); 
		for (int a = 12 ; a >= 0 ; a--) {
			if(clonedList.contains(a)) {
				if(clonedList.get(playerNumb) == a) {
					clonedList.remove(playerNumb);
					if(clonedList.contains(a)) {
						moreHandsSame = true;
						
						}
					}
				break;
				}
			}
		return moreHandsSame;
	}
	
}
