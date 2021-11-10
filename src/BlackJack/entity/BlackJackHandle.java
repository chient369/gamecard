package BlackJack.entity;

import java.util.ArrayList;

import BlackJack.BlackJackCard;
import common.Card;

public class BlackJackHandle extends BlackJackCard {
	private ArrayList<Card> cardList;

	public BlackJackHandle() {
		super();
		this.cardList = super.getInitialCards();
	}

	public void draw() {
		Card card = super.drawCard();
		cardList.add(card);
	}

	public void showHand() {
		for (Card card : cardList) {
			System.out.print(card.getCardFull() + "  ");
		}
	}

	public int CurrentPoint(ArrayList<Card> cardList) {
		int currentPoint = totalPoint(cardList);
		System.out.println("現在のポイント : " + currentPoint);
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
		for (Card card : cards) {
			if (isHasAce(cards)) {
				total = isHasAcePoint(cards);
			} else if (card.getCard_num() > 10) {
				total += 10;
			} else {
				total += card.getCard_num();
			}

		}
		return total;

	}

	public int isHasAcePoint(ArrayList<Card> cards) {
		int subTotal = 0;
		for (Card card : cards) {
			if (card.getCard_num() != 1) {
				subTotal += card.getCard_num();
			}
			if (card.getCard_num() == 1) {
				if (cards.size() == 3) {
					subTotal += 10;
				} else if (cards.size() == 2) {
					subTotal += 11;
				} else {
					subTotal += 1;
				}
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

	public ArrayList<Card> getCardList() {
		return cardList;
	}

}
