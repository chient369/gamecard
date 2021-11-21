package BlackJack;

import BlackJack.entity.BJResult;
import BlackJack.entity.BlackJackDealer;
import BlackJack.entity.BlackJackPlayer;
import BlackJack.entity.BlackJackToCompete;
import common.GameInput;
import common.player.GamePlayer;

public final class BlackJackProcess {
	public static void BlackJackProcess(GamePlayer player) {

		BlackJackHandle handle = new BlackJackHandle();
		BlackJackPlayer blackJackPlayer = new BlackJackPlayer(handle, player);
		BlackJackDealer blackJackDealer = new BlackJackDealer(handle);
		BlackJackToCompete compete = new BlackJackToCompete(blackJackDealer, blackJackPlayer);
		Thread dealerThread = new Thread(blackJackDealer);

		System.out.print("掛け金を入力してください　");
		int fare = GameInput.inputKakekin(player);
		blackJackPlayer.showHand();
		boolean loop = true;
		while (loop) {
			if (blackJackPlayer.isSpecial(blackJackPlayer.getPlayerHand())) {
				loop = false;
				break;
			}
			System.out.println("1.Hit \n2.Stand");
			int choice = GameInput.inputChoose();
			switch (choice) {
			case 1:
				blackJackPlayer.hitCards();
				break;
			case 2:
				blackJackPlayer.playerOfTurn();
				loop = false;
				break;
			default:
				System.err.println("正しく選択してください");
				break;
			}

		}
		dealerThread.start();
		try {
			dealerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		blackJackDealer.showHand();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BJResult dealeResult = blackJackDealer.getResult();
		BJResult playerResult = blackJackPlayer.getResult();
		compete.showResult(dealeResult, playerResult);
		compete.compete(dealeResult, playerResult, fare);
		System.out.println();
		player.showPlayer();

	}

}
