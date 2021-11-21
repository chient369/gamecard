package BlackJack;

import java.util.ArrayList;

import common.Card;
import common.CardHandler;

public class BlackJackHandle {
	private static CardHandler cardHandler;

	public BlackJackHandle() {
		cardHandler = new CardHandler();
	}

	public static ArrayList<Card> getInitialCards() {
		ArrayList<Card> initCards = new ArrayList<Card>();
		for (int i = 0; i < 2; i++) {
			Card card = cardHandler.getCard();
			initCards.add(card);
		}

		return initCards;

	}

//withdraw one by one
	public synchronized Card hitCard() {
		return cardHandler.getCard();
	}

	public int CurrentPoint(ArrayList<Card> cardList) {
		int currentPoint = totalPoint(cardList);
		return currentPoint;
	}

	/*
	 * Point counting rules K, Q, J = 10 10, 9, 8, 7, 6, 5, 4, 3, 2 = respective
	 * face value If your total number of cards is 2, then Ace = 11 or 10 If your
	 * total number of cards is 3, then Ace = 10 or 1 If your total number of cards
	 * is 4 or 5, then Ace = 1
	 */
	public int totalPoint(ArrayList<Card> cards) {
		int total = 0;

		if (isHasAce(cards)) {
			total = isHasAcePoint(cards);
		} else {
			for (Card card : cards) {
				if (card.getCard_num() > 10) {
					total += 10;
				} else {
					total += card.getCard_num();
				}

			}
		}
		return total;

	}

	public int isHasAcePoint(ArrayList<Card> cards) {
		int subTotal = 0;
		int aceCount = 0;
		int ace_point = 1;
		for (Card card : cards) {
			if (card.getCard_num() != 1) {
				if (card.getCard_num() > 10) {
					subTotal += 10;
				} else {
					subTotal += card.getCard_num();
				}
			} else if (card.getCard_num() == 1) {
				aceCount++;
				if (cards.size() == 2) {
					ace_point = 11;
				} else if (cards.size() == 3 && aceCount >= 1) {
					ace_point = 10;
				} else {
					ace_point = 1;
				}
				subTotal += ace_point;

			}
			if (subTotal > 21 && aceCount >= 1 && cards.size() <= 3) {
				subTotal = subTotal - aceCount * 10 + aceCount;

			}
		}
		return subTotal;

	}

	public boolean isHasAce(ArrayList<Card> cards) {
		boolean hasAce = false;
		for (Card card : cards) {
			if (card.getCard_num() == 1) {
				hasAce = true;
			}
		}
		return hasAce;
	}

}
