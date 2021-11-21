package BlackJack.entity;

import java.util.ArrayList;

import BlackJack.BlackJackDealt;
import BlackJack.BlackJackHandle;
import common.Card;
import common.player.GamePlayer;

public class BlackJackPlayer extends BlackJackDealt {
	private ArrayList<Card> playerHand;
	private GamePlayer player;
	private BJResult result;

	public BlackJackPlayer(BlackJackHandle blackJackHandle, GamePlayer player) {
		super(blackJackHandle);
		this.playerHand = initHandCards();
		this.player = player;
		this.result = null;
	}

	public GamePlayer getPlayer() {
		return player;
	}

	public int getShojikin() {
		return player.getShojikin();
	}

	public ArrayList<Card> getPlayerHand() {
		return playerHand;
	}

	public BJResult getResult() {
		return result;
	}

	@Override
	protected ArrayList<Card> initHandCards() {
		return BlackJackHandle.getInitialCards();
	}

	@Override
	public void hitCards() {
		Card card = super.hit();
		playerHand.add(card);
		this.showHand();
	}

	@Override
	public void showHand() {
		System.out.print("あなたのカード :");
		for (Card card : playerHand) {
			System.out.print(card.getCardFull() + "  ");
		}
		if (result != BJResult.BUSTS && result != BJResult.PLAYER_OF_FREE_HAND && result != null) {
			System.out.println(result);
		}
		System.out.println();
	}

	public void playerOfTurn() {
		int playerPoints = playerOfPoints(this.playerHand);
		if (playerPoints <= 21) {
			BJResult.PLAYER_OF_FREE_HAND.setValue(playerPoints);
			this.result = BJResult.PLAYER_OF_FREE_HAND;
			return;
		} else {
			this.result = BJResult.BUSTS;
		}
	}

	public int playerOfPoints(ArrayList<Card> playerHand) {
		return super.CurrentPoint(playerHand);
	}

	public boolean isSpecial(ArrayList<Card> list) {
		if (isBanBan(list)) {
			this.result = BJResult.BAN_BAN;
			System.out.println(BJResult.BAN_BAN);
			return true;
		}
		if (isBanLuck(list)) {
			this.result = BJResult.BAN_LUCK;
			System.out.println(BJResult.BAN_LUCK);
			return true;
		}
		if (isFiveDragonHands(list)) {
			this.result = BJResult.FIVE_DRAGON;
			System.out.println(BJResult.FIVE_DRAGON);
			return true;
		}
		return false;
	}

//	public static void main(String[] args) {
//		BlackJackHandle blackJackHandle = new BlackJackHandle();
//		for (int i = 0; i < 12; i++) {
//			BlackJackDealer blackJackDealer = new BlackJackDealer(blackJackHandle);
//			BlackJackPlayer blackJackPlayer = new BlackJackPlayer(blackJackHandle);
//			blackJackDealer.showHand();
//			System.out.println("-");
//			System.out.println("------------------------");
//			blackJackPlayer.showHand();
//
//		}
	// }

}
