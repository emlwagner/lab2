package lab2;

import java.util.ArrayList;

public class evaluateHand {
	
	Hand hand = new Hand();
	
	public ArrayList<Card> sort(ArrayList<Card> myHand) {
		int i = 0;
		while(i < 4) {
			Card c1 = myHand.get(i);
			Card c2 = myHand.get(i+1);
			eCardValue v1 = c1.getValue();
			eCardValue v2 = c2.getValue();
			Card temp = c1;
			if(v1.getCardValue() > v2.getCardValue()) {
				c1 = c2;
				c2 = temp;
			}
			i++;
		}
		return myHand;
	}
	
	
	public int isRoyalFlush (ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		int i = 0;
		Card c0 = hand.get(0);
		eCardValue jack = eCardValue.values()[9];
		if(c0.getValue() == jack) {
			while(i < 4) {
				Card c1 = hand.get(i);
				Card c2 = hand.get(i+1);
				if(c1.getSuit() == c2.getSuit()) {
					continue;
				}
			return 10;
				
			}	
		}
		else {
			return 0;
		}
	}

}
