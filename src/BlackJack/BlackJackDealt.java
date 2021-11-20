package BlackJack;

import java.util.ArrayList;

import common.Card;

public abstract class BlackJackDealt implements Runnable {
	private BlackJackHandle blackJackHandle;

	public BlackJackDealt() {
	}

	public BlackJackDealt(BlackJackHandle blackJackHandle) {
		super();
		this.blackJackHandle = blackJackHandle;
	}

	public BlackJackHandle getBlackJackHandle() {
		return blackJackHandle;
	}

	/***********************************/
	public Card hit() {
		return blackJackHandle.hitCard();
	}

	protected abstract ArrayList<Card> initHandCards();

	protected abstract void hitCards();

	protected abstract void showHand();

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
			if (card.getCard_num() != 1) {
				isBanBan = false;
			}
		}
		return isBanBan;

	}

	// total > 21, busts.
	public boolean isBust(ArrayList<Card> handCards) {
		return blackJackHandle.totalPoint(handCards) > 21 ? true : false;
	}

	public int CurrentPoint(ArrayList<Card> cardList) {
		return blackJackHandle.CurrentPoint(cardList);
	}

	public boolean isFiveDragonHands(ArrayList<Card> currentCards) {
		return (currentCards.size() == 5 && CurrentPoint(currentCards) <= 21) ? true : false;

	}

	@Override
	public void run() {

	}

//	public static void main(String[] args) {
//		BlackJackDealt blackJackDealt = new BlackJackDealt();
//		BlackJackHandle blackJackHandle = blackJackDealt.getBlackJackHandle();
//		ArrayList<Card> handCards = blackJackDealt.getHandCards();
//		System.out.println("init 2 cards");
//		blackJackHandle.getInitialCards();
//		blackJackHandle.showHand();
//		blackJackHandle.CurrentPoint(handCards);
//		System.out.println();
//		System.out.println("is ban ban :" + blackJackDealt.isBanBan(handCards));
//		System.out.println("is ban luck : " + blackJackDealt.isBanLuck(handCards));
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
