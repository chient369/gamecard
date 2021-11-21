package poker;

import java.util.ArrayList;

import common.Card;
import common.GameInput;
import common.player.GamePlayer;
import poker.turned.Result;
import poker.turned.Turned;

public class PokerGameProcess {
	private PokerGameRules pGameRules;
	private GamePlayer player;

	public PokerGameProcess() {
	}

	public PokerGameProcess(GamePlayer player) {
		super();
		this.pGameRules = new PokerGameRules(player);
		this.player = player;
	}

	public void oneTurn() {
		System.out.print("掛け金を入力してください : ");
		int kakekin = GameInput.inputKakekin(player);
		oneTurnProcess(kakekin);

	}

	public void tenTurns() {
		System.out.print("掛け金を入力してください : ");
		int kakekin = GameInput.inputKakekin(player);
		int tenKakekin = kakekin * 10;
		System.out.println("必要所持金 : " + tenKakekin);
			for (int i = 0; i < 10; i++) {
				oneTurnProcess(kakekin);
			}

			showTenTurned();
			pGameRules.showPlayer();
		}

	public void oneTurnProcess(int kakekin) {
		ArrayList<Card> fiveCards = new PokerCardHandler().getFiveCard();
		pGameRules.showCardsList(fiveCards);

		if (pGameRules.isStraight(fiveCards)) {
			int bonus = pGameRules.straightBonus(kakekin);
			pGameRules.addTurned(fiveCards, Result.STRAIGHT.getName(), bonus, player.getShojikin());
		} else if (pGameRules.isFlush(fiveCards)) {
			int bonus = pGameRules.flushBonus(kakekin);
			pGameRules.addTurned(fiveCards, Result.FLUSH.getName(), bonus, player.getShojikin());
		} else {
			pGameRules.isTwoPairOrThreeOrFour(fiveCards, kakekin);
		}
		pGameRules.showPlayer();

	}

	private void showTenTurned() {
		int turnedLenght = pGameRules.getTurnedList().size();
		ArrayList<Turned> turneds = pGameRules.getTurnedList();
		String fomat = "    %-10d%-25s%-15d%-15d%n";
		System.out.format("  回数目          カード群              結果          所持金%n");
		if (pGameRules.getTurnedList().size() > 9) {
			for (int i = turnedLenght - 10; i < turnedLenght; i++) {
				Turned turned = turneds.get(i);
				System.out.format(fomat, turned.getTurn_num(), turned.getCards(), turned.getResult(),
						turned.getShojikin());
			}

		} else {
			for (Turned turned : turneds) {
				System.out.format(fomat, turned.getTurn_num(), turned.getCards(), turned.getResult(),
						turned.getShojikin());
			}
		}

	}

	public void showTurned() {
		System.out.println("                          履歴          \n");
		ArrayList<Turned> turneds = pGameRules.getTurnedList();
		if (turneds.isEmpty()) {
			System.out.println("              --------データがありません----------");
		} else {
			String fomat = "    %-10d%-25s%-25s%-15d%-15d%n";
			System.out.format("  回数目          カード群                結果                    変動           所持金　　%n");
			for (Turned turned : turneds) {
				System.out.format(fomat, turned.getTurn_num(), turned.getCards(), turned.getResultName(),
						turned.getResult(), turned.getShojikin());
			}
		}
	}


}
