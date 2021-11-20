package BlackJack.entity;

import java.util.ArrayList;

import BlackJack.BlackJackDealt;
import BlackJack.BlackJackHandle;
import common.Card;
import common.player.GamePlayer;

public class BlackJackPlayer extends BlackJackDealt {
	private ArrayList<Card> playerHand;
	private GamePlayer player;

	public BlackJackPlayer(BlackJackHandle blackJackHandle, GamePlayer player) {
		super(blackJackHandle);
		this.playerHand = initHandCards();
		this.player = player;
	}

	public GamePlayer getPlayer() {
		return player;
	}

	public int getShojikin() {
		return player.getShojikin();
	}

	public ArrayList<Card> getDealerHand() {
		return playerHand;
	}

	@Override
	protected ArrayList<Card> initHandCards() {
		return BlackJackHandle.getInitialCards();
	}

	@Override
	protected void hitCards() {
		Card card = super.hit();
		playerHand.add(card);
	}

	@Override
	protected void showHand() {
		for (Card card : playerHand) {
			System.out.print(card.getCardFull() + "  ");
		}

	}

	public BJResult playerOfTurn() {
		System.out.println("It's player");
		this.showHand();
		BJResult result = null;
		int playerPoints = playerOfPoints(this.playerHand);
		if (super.isBanBan(playerHand)) {
			result = BJResult.BAN_BAN;

		} else if (super.isBanLuck(playerHand)) {
			result = BJResult.BAN_LUCK;
		} else {
			if (isFiveDragonHands(playerHand)) {
				result = BJResult.FIVE_DRAGON;
			} else if (playerPoints <= 21) {
				BJResult.PLAYER_OF_FREE_HAND.setValue(playerPoints);
				result = BJResult.PLAYER_OF_FREE_HAND;
			} else {
				result = BJResult.BUSTS;

			}
		}
		return result;
	}

	public int playerOfPoints(ArrayList<Card> playerHand) {
		return super.CurrentPoint(playerHand);
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
	//}

}
