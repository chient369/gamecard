package BlackJack.entity;

import java.util.ArrayList;

import BlackJack.BlackJackDealt;
import BlackJack.BlackJackHandle;
import common.Card;

public class BlackJackDealer extends BlackJackDealt implements Runnable {
	private Thread dealerThread;
	private ArrayList<Card> dealerHand;
	private BJResult result;

	public BlackJackDealer(BlackJackHandle blackJackHandle) {
		super(blackJackHandle);
		this.dealerHand = initHandCards();
		this.result = null;
	}

	public ArrayList<Card> getDealerHand() {
		return dealerHand;
	}

	public BJResult getResult() {
		return result;
	}

	@Override
	public void run() {
		try {
			System.out.print("俺の番、ちょっとまって.");
			for (int i = 0; i < 5; i++) {
				System.out.print(".");
				Thread.sleep(400);
			}
			System.out.println("");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (super.isBanBan(dealerHand)) {
			result = BJResult.BAN_BAN;
			return;

		} else if (super.isBanLuck(dealerHand)) {
			result = BJResult.BAN_LUCK;
		} else {
			int dealerPoint = dealerOfCurrentPoint(dealerHand);
			while (dealerPoint < 16) {
				try {
					Thread.sleep(1000);
					this.hitCards();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

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

	}

	public void start() {
		if (dealerThread == null) {
			dealerThread = new Thread(this);
			dealerThread.start();
		}
	}

	@Override
	protected ArrayList<Card> initHandCards() {
		return BlackJackHandle.getInitialCards();
	}

	@Override
	protected void hitCards() {
		System.out.println("ボットは一枚目を引きました。");
		Card card = super.hit();
		dealerHand.add(card);
	}

	@Override
	public void showHand() {
		System.out.print("チェンボットのハンド :");
		for (Card card : dealerHand) {
			System.out.print(card.getCardFull() + "  ");
		}
		if (result != BJResult.BUSTS && result != BJResult.DEALER_OF_FREE_HAND && result != null) {
			System.out.println(result);
		}
		System.out.println();
	}

	public ArrayList<Card> toGetFiveDragon(ArrayList<Card> currentCards) {
		if (dealerOfCurrentPoint(dealerHand) < 14 && dealerHand.size() <= 5 && dealerHand.size() >= 3) {
			try {
				Thread.sleep(1000);
				this.hitCards();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

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
