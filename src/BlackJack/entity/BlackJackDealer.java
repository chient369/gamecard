package BlackJack.entity;

import java.util.ArrayList;

import BlackJack.BlackJackDealt;
import common.Card;

public class BlackJackDealer extends BlackJackDealt {

	private ArrayList<Card> dealerHand;

	public BlackJackDealer() {
		super();
		this.dealerHand = getHandCards();
	}

	public ArrayList<Card> getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(ArrayList<Card> dealerHand) {
		this.dealerHand = dealerHand;
	}

	public BJResult dealerTurn() {
		super.getBlackJackHandle().showHand();
		BJResult result = null;
		if (super.isBanBan(dealerHand)) {
			result = BJResult.BAN_BAN;

		} else if (super.isBanLuck(dealerHand)) {
			result = BJResult.BAN_LUCK;
		} else {
			int dealerPoint = dealerOfCurrentPoint(dealerHand);
			while (dealerPoint < 16) {
				this.hit();
				super.getBlackJackHandle().showHand();
				dealerPoint = dealerOfCurrentPoint(super.getHandCards());
			}
			if (isFiveDragonHands(dealerHand)) {
				result = BJResult.FIVE_DRAGON;
			}
			if (dealerPoint <= 21) {
				BJResult.FREE_HAND.setValue(dealerPoint);
				result = BJResult.FREE_HAND;
			} else {
				result = BJResult.BUSTS;

			}
		}
		return result;
	}

	public ArrayList<Card> toGetFiveDragon(ArrayList<Card> currentCards) {
		ArrayList<Card> fiveDragons = currentCards;
		if (dealerOfCurrentPoint(currentCards) < 14 && currentCards.size() <= 5 && currentCards.size() >= 3) {
			this.hit();
			fiveDragons = this.getHandCards();
			toGetFiveDragon(fiveDragons);
		}
		return fiveDragons;
	}

	public boolean isFiveDragonHands(ArrayList<Card> currentCards) {
		ArrayList<Card> fiveDragons = toGetFiveDragon(currentCards);
		return (fiveDragons.size() == 5 && dealerOfCurrentPoint(fiveDragons) <= 21) ? true : false;

	}

	private int dealerOfCurrentPoint(ArrayList<Card> hanCards) {
		return super.getBlackJackHandle().CurrentPoint(hanCards);

	}

	public static void main(String[] args) {
		BlackJackDealer blackJackDealer = new BlackJackDealer();
		BJResult rs = blackJackDealer.dealerTurn();
		System.out.println(rs);
	}

}
