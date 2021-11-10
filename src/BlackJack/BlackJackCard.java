package BlackJack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import common.Card;
import common.CardHandler;

public class BlackJackCard extends CardHandler {
	private static Random random = new Random();
	private ArrayList<Card> playingCards;
	private Set<Card> drawCards = new HashSet<Card>();

//init playing card for 52 card
	public BlackJackCard() {
		ArrayList<Card> playingCards = new ArrayList<Card>();
		for (int i = 0; i < card_nums.length; i++) {
			for (int j = 0; j < card_symbols.length; j++) {
				playingCards.add(new Card(card_nums[i], card_symbols[j]));
			}

		}
		this.playingCards = playingCards;
	}

	// it returns the first two cards dealt

	public ArrayList<Card> getInitialCards() {
		ArrayList<Card> initCards = new ArrayList<Card>();
		for (int i = 0; i < 2; i++) {
			Card card = drawCard();
			initCards.add(card);
		}

		return initCards;

	}

//withdraw one by one
	public synchronized Card drawCard() {
		Card card = playingCards.get(random.nextInt(52));
		while (drawCards.contains(card)) {
			card = playingCards.get(random.nextInt(52));
		}
		drawCards.add(card);
		return card;
	}
}

	

//	public static void main(String[] args) {
//		BlackJackCard blackJackCard = new BlackJackCard();
//		ArrayList<Card> cards = blackJackCard.getInitialCards();
//		for (Card card : cards) {
//			System.out.println(card.getCardFull());
//		}
//		System.out.println("--------------------");
//		for (int i = 0; i < 20; i++) {
//			System.out.println(blackJackCard.drawCard().getCardFull());
//		}
//		System.out.println("-------------");
//		Iterator<Card> it = blackJackCard.drawCards.iterator();
//		while (it.hasNext()) {
//			Card card = (Card) it.next();
//			System.out.println(card.getCardFull());
//
//		}
//	}
	

