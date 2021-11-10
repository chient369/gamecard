package poker;

import java.util.ArrayList;

import common.Card;
import common.GameInput;
import common.GameProcess;
import common.player.GamePlayer;
import poker.turned.Turned;

public class PokerGameProcess {
	private GameProcess gameProcess;
	private PokerGameRules pGameRules;
	private GamePlayer player;

	public PokerGameProcess() {
	}

	public PokerGameProcess(GameProcess gameProcess) {
		super();
		this.gameProcess = gameProcess;
		this.pGameRules = new PokerGameRules(gameProcess);
		player = pGameRules.getPlayer();
	}

	public GameProcess getGameProcess() {
		return gameProcess;
	}

	public void setGameProcess(GameProcess gameProcess) {
		this.gameProcess = gameProcess;
	}

	public void oneTurn() {
		System.out.print("掛け金を入力してください : ");
		int kakekin = GameInput.inputKakekin();
		oneTurnProcess(kakekin);

	}

	public void tenTurns() {
		pGameRules.clearTurned();
		System.out.print("掛け金を入力してください : ");
		int kakekin = GameInput.inputKakekin();
		int tenKakekin = kakekin * 10;
		System.out.println("必要所持金 : " + tenKakekin);
		if (isEnoughMoney(tenKakekin)) {
			for (int i = 0; i < 10; i++) {
				oneTurnProcess(kakekin);
			}

			showTenTurns();
			pGameRules.showPlayer();
		} else {
			System.err.println("所持金が足りません");
		}

	}

	public void oneTurnProcess(int kakekin) {
		ArrayList<Card> fiveCards = new PokerCardHandler().getFiveCard();
		pGameRules.showCardsList(fiveCards);

		if (pGameRules.isStraight(fiveCards)) {
			int bonus = pGameRules.straightBonus(kakekin);
			pGameRules.addTurned(fiveCards, bonus, player.getShojikin());
		} else if (pGameRules.isFlush(fiveCards)) {
			int bonus = pGameRules.flushBonus(kakekin);
			pGameRules.addTurned(fiveCards, bonus, player.getShojikin());
		} else {
			pGameRules.isTwoPairOrThreeOrFour(fiveCards, kakekin);
		}

	}

	private void showTenTurns() {
		ArrayList<Turned> turneds = pGameRules.getTurnedList();
		String fomat = "    %-10d%-25s%-15d%-15d%n";
		System.out.format("  回数目            カード群              結果          所持金　　%n");
		for (Turned turned : turneds) {
			System.out.format(fomat, turned.getTurn_num(), turned.getCards(), turned.getResult(), turned.getShojikin());
		}
		pGameRules.clearTurned();

	}

	private boolean isEnoughMoney(int kakekin) {
		return (player.getShojikin() > kakekin) ? true : false;
	}

}
