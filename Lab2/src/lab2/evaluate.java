package lab2;

import java.util.ArrayList;

public class evaluate {
	
	
	public ArrayList<Card> sort(ArrayList<Card> myHand) {
		int i = 0;
		while (i < 4) {
			Card c1 = myHand.get(i);
			Card c2 = myHand.get(i + 1);
			eCardValue v1 = c1.getValue();
			eCardValue v2 = c2.getValue();
			Card temp = c1;
			if (v1.getCardValue() > v2.getCardValue()) {
				c1 = c2;
				c2 = temp;
			}
			i++;
		}
		return myHand;
	}

	// checks the hand to see if it is a Royal Flush
	public boolean isRoyalFlush(ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		int i = 0;
		Card c0 = hand.get(0);
		eCardValue jack = eCardValue.values()[9];
		if (c0.getValue() == jack) {
			while (i < 4) {
				Card c1 = hand.get(i);
				Card c2 = hand.get(i + 1);
				if (c1.getSuit() == c2.getSuit())
					continue;
			}
		} else
			return false;
		return true;
	}

	public boolean isStraightFlush(ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		int i = 0;
		while (i < 4) {
			Card c1 = hand.get(i);
			Card c2 = hand.get(i + 1);
			if ((c1.getValue() == c2.getValue()) 
					&& c1.getSuit() == c2.getSuit()) {
				i++;
			}
			else {
				return false;
			}
		}
		return true;
	}

	public boolean isFourofaKind(ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		Card c1 = hand.get(0);
		Card c2 = hand.get(1);
		Card c4 = hand.get(3);
		Card c5 = hand.get(4);
		if ((c1.getValue() == c4.getValue())
				|| (c2.getValue() == c5.getValue())) {
			return true;
		} else
			return false;
		
	}
	
	public eHandStrength getHandStrength(ArrayList<Card> myHand) {
		if(isRoyalFlush(myHand)) {
			return eHandStrength.values()[0];
		}
		else if(isStraightFlush(myHand)) {
			return eHandStrength.values()[1];
		}
		else if(isFourofaKind(myHand)) {
			return eHandStrength.values()[2];
			}
		else {
			return eHandStrength.values()[9];
			// for right now, it's just returning the eHandStrength value for no pairs, because we aren't yet testing for the other hand strengths
		}
		}

}
