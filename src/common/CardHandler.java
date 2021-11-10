package common;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CardHandler {
	private static Random rand = new Random();
	protected int[] card_nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	protected String[] card_symbols = { "♥", "♦", "♠", "♣" };
	private static Set<Card> cardRepos = new HashSet<Card>(53);
	private Card card;

	public CardHandler() {
	}

	public Card getCard() {
		Card game_card = new Card(card_nums[rand.nextInt(13)], card_symbols[rand.nextInt(4)]);
		while (cardRepos.contains(game_card)) {
			game_card = new Card(card_nums[rand.nextInt(13)], card_symbols[rand.nextInt(4)]);
		}
		cardRepos.add(game_card);
		if (cardRepos.size() > 50) {
			cardRepos.clear();
		}
		return game_card;
	}

//	public ArrayList<Card> createPlayingCards() {
//		ArrayList<Card> playingCards = new ArrayList<Card>();
//		for (int i = 0; i < card_nums.length; i++) {
//			for (int j = 0; j < card_symbols.length; j++) {
//				playingCards.add(new Card(card_nums[i], card_symbols[j]));
//			}
//
//		}
//		return playingCards;
//	}

//	public void showCardRepo() {
//		Iterator<Card> it = cardRepos.iterator();
//		while (it.hasNext()) {
//			Card card = (Card) it.next();
//			System.out.println(card.getCardFull());
//		}
//		System.out.println("repo size :" + cardRepos.size());
//	}

	public Card setCard(int card_num, String card_symbol) {
		return new Card(card_num, card_symbol);
	}

	public int getCardNum() {
		return card.getCard_num();
	}

	public String getCardFull() {
		return card.getCardFull();
	}

	public boolean isBiggerThan(CardHandler card) {
		if (this.getCardNum() > card.getCardNum()) {
			return true;
		}
		return false;

	}

}
