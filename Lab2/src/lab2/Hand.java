package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand extends Deck {
	
	private Deck deck = new Deck();
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	protected Hand() {
		for(int i = 0; i < 5; i++) {
			hand.add(deck.draw());
			this.hand = hand;
		}
	}
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
	public boolean isStraight(ArrayList<Card> myHand) {
		ArrayList<Card> hand = sort(myHand);
		int i = 0;
		while(i < 4) {
			Card c1 = hand.get(i);
			Card c2 = hand.get(i+1);
			if(c1.getValue() == c2.getValue()) {
				i++;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public boolean isFlush(ArrayList<Card> myHand) {
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
	
	public String judgeHand(ArrayList<Card> myHand) {
		if(isStraight(myHand)) {
			String result = new String("It is a straight");
			return result;
		}
		else if(isFlush(myHand)) {
			String result = new String("It is a flush");
			return result;
		}
		else {
			String result = new String("It is not a straight or a flush");
			return result;
		}
	}
	
	
	
	

}
