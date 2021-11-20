package BlackJack.entity;

import java.util.ArrayList;

import BlackJack.BlackJackDealt;
import BlackJack.BlackJackHandle;
import common.Card;

public class BlackJackDealer extends BlackJackDealt {

	private ArrayList<Card> dealerHand;

	public BlackJackDealer(BlackJackHandle blackJackHandle) {
		super(blackJackHandle);
		this.dealerHand = initHandCards();
	}

	public ArrayList<Card> getDealerHand() {
		return dealerHand;
	}

	@Override
	protected ArrayList<Card> initHandCards() {
		return BlackJackHandle.getInitialCards();
	}

	@Override
	protected void hitCards() {
		Card card = super.hit();
		dealerHand.add(card);
	}

	@Override
	protected void showHand() {
		for (Card card : dealerHand) {
			System.out.print(card.getCardFull() + "  ");
		}

	}

	public BJResult dealerTurn() {
		System.out.println("It's Dealer");
		this.showHand();
		BJResult result = null;
		if (super.isBanBan(dealerHand)) {
			result = BJResult.BAN_BAN;

		} else if (super.isBanLuck(dealerHand)) {
			result = BJResult.BAN_LUCK;
		} else {
			int dealerPoint = dealerOfCurrentPoint(dealerHand);
			while (dealerPoint < 16) {
				this.hitCards();
				this.showHand();
				dealerPoint = dealerOfCurrentPoint(dealerHand);
				if (dealerHand.size() == 5) {
					result = BJResult.FIVE_DRAGON;
					break;
				}
			}

			if (dealerOfCurrentPoint(dealerHand) < 16 && dealerHand.size() < 5 && dealerHand.size() > 3) {
				toGetFiveDragon(dealerHand);
			}
			if (isFiveDragonHands(dealerHand)) {
				result = BJResult.FIVE_DRAGON;
			} else if (dealerPoint <= 21) {
				BJResult.DEALER_OF_FREE_HAND.setValue(dealerPoint);
				result = BJResult.DEALER_OF_FREE_HAND;
			} else {
				result = BJResult.BUSTS;

			}
		}
		return result;
	}

	public ArrayList<Card> toGetFiveDragon(ArrayList<Card> currentCards) {
		if (dealerOfCurrentPoint(dealerHand) < 14 && dealerHand.size() <= 5 && dealerHand.size() >= 3) {
			this.hitCards();
			toGetFiveDragon(dealerHand);
		}
		return dealerHand;
	}

	private int dealerOfCurrentPoint(ArrayList<Card> hanCards) {
		return super.CurrentPoint(hanCards);

	}

//	public static void main(String[] args) {
//		for (int i = 0; i < 50; i++) {
//			BlackJackDealer blackJackDealer = new BlackJackDealer();
//			BJResult rs = blackJackDealer.dealerTurn();
//			System.out.println(rs);
//			System.out.println(i + "-------------------");
//
//		}
//	}

}
