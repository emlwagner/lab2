package lab2;

import java.util.ArrayList;

public class evaluateHand {

	Hand hand = new Hand();

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

	public boolean isRoyalFlush(ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		int i = 0;
		Card c0 = hand.get(0);
		eCardValue jack = eCardValue.values()[9];
		if (c0.getValue() != jack) {
			return false;
		}
		else {
			while (i < 4) {
				Card c1 = hand.get(i);
				Card c2 = hand.get(i + 1);
				if (c1.getSuit() == c2.getSuit()) {
					i++;
				}
				else {
					return false;
				}
			}
			return true;
		}
	}
	
	public boolean isStraightFlush(ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		int i = 0;
		while(i < 4) {
			Card c1 = hand.get(i);
			Card c2 = hand.get(i+1);
			if(c1.getSuit() == c2.getSuit()) {
				i++;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public boolean isFourOfAKind(ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		if(hand.get(0) == hand.get(3)) {
			Card kicker = hand.get(4);
			return true;
		}
		else if(hand.get(1) == hand.get(4)) {
			Card kicker = hand.get(0);
			return true;
		}
		else {
			return false;
		}
	}
			
			
			
			

}
