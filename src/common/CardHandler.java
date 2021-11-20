package common;

import java.util.ArrayList;
import java.util.Random;

public class CardHandler {
	private static Random rand = new Random();
	private int[] card_nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	private String[] card_symbols = { "♥", "♦", "♠", "♣" };
	private ArrayList<Card> playingCards = new ArrayList<Card>();

	private int cards_length = 52;

	public CardHandler() {
		this.playingCards = initPlayingCards();
	}

	private ArrayList<Card> initPlayingCards() {
		for (int i = 0; i < card_nums.length; i++) {
			for (int j = 0; j < card_symbols.length; j++) {
				playingCards.add(new Card(card_nums[i], card_symbols[j]));
			}
		}
		return playingCards;
	}

	public Card getCard() throws IllegalArgumentException {
		Card card = this.playingCards.get(rand.nextInt(cards_length));
		this.playingCards.remove(card);
		cards_length--;
		if (cards_length < 1) {
			throw new IllegalArgumentException("the deck is over");
		}
		return card;
	}

//	public static void main(String[] args) {
//		CardHandler cardHandler = new CardHandler();
//		for (int i = 0; i < 52; i++) {
//			try {
//				System.out.println( i  +" : "+ cardHandler.getCard().getCardFull() + " ");
//			} catch (InitialExeptions e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//	}

}
