package BlackJack;

import java.util.ArrayList;

import BlackJack.entity.BlackJackHandle;
import common.Card;


public class BlackJackDealt {
	private BlackJackHandle blackJackHandle;

	public BlackJackDealt() {
		this.blackJackHandle = new BlackJackHandle();
	}

	public BlackJackHandle getBlackJackHandle() {
		return blackJackHandle;
	}


	public ArrayList<Card> getHandCards() {
		return blackJackHandle.getCardList();
	}

	/***********************************/
	public void hit() {
		blackJackHandle.draw();
	}

	// Ace + (10/J/Q/K) = ban-luck
	public boolean isBanLuck(ArrayList<Card> handCards) {
		boolean isBanLuck = false;
		if (blackJackHandle.isHasAce(handCards)) {
			for (Card card : handCards) {
				if (card.getCard_num() >= 10) {
					isBanLuck = true;

				}
			}
		}
		return isBanLuck;
	}

	// Ace + Ace = ban-ban
	public boolean isBanBan(ArrayList<Card> handCards) {
		boolean isBanBan = true;
		for (Card card : handCards) {
			if (card.getCard_num() !=1) {
				isBanBan = false;
			}
		}
		return isBanBan;

	}

	// total > 21, busts.
	public boolean isBust(ArrayList<Card> handCards) {
		return blackJackHandle.totalPoint(handCards) > 21 ? true : false;
	}
	/* to get 5-Dragon
	 * 5-Dragon is number of cards = 5 and total <= 21
	 * */
	

//	public static void main(String[] args) {
//		BlackJackDealt blackJackDealt = new BlackJackDealt();
//		BlackJackHandle blackJackHandle = blackJackDealt.getBlackJackHandle();
//		ArrayList<Card> handCards = blackJackDealt.getHandCards();
//		System.out.println("init 2 cards");
//		blackJackHandle.getInitialCards();
//		blackJackHandle.showHand();
//		blackJackHandle.CurrentPoint(handCards);
//		System.out.println();
//		System.out.println("is ban ban :" +blackJackDealt.isBanBan(handCards));
//		System.out.println("is ban luck : " +blackJackDealt.isBanLuck(handCards));
//		System.out.println("1 turns hit of hand cards");
//		blackJackDealt.hit();
//		System.out.println("is bust : " + blackJackDealt.isBust(handCards));
//		System.out.println("------------get 5 dragon----------------");
//		ArrayList<Card> handCards2 = blackJackDealt.getHandCards();
//		ArrayList<Card> fiveDr = blackJackDealt.toGetFiveDragon(handCards);
//		for (Card card : fiveDr) {
//			System.out.print(card.getCardFull() + " ");
//		}
//	}

}
