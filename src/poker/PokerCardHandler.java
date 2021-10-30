package poker;

import java.util.ArrayList;

import common.Card;
import common.CardHandler;

public class PokerCardHandler extends CardHandler {
	private ArrayList<Card> five_cards = new ArrayList<Card>();

	public ArrayList<Card> getFiveCard() {

		for (int i = 0; i < 5; i++) {
			Card card = super.getCard();
			five_cards.add(card);
		}
		return five_cards;
	}

//	public static void main(String[] args) {
//		PokerCardHandler cardHandler = new PokerCardHandler();
//		ArrayList<Card> five_cards = cardHandler.getFiveCard();
//		for (Card card : five_cards) {
//			System.out.println(card.getCardFull());
//		}
//	}

}
