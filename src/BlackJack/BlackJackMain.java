package BlackJack;

import common.GameInput;
import common.player.GamePlayer;

public class BlackJackMain {

	public static void main(GamePlayer player) {
		boolean loop = true;
		System.out.println("こんにちは、ブラックジャックゲームをようこそ");

		while (loop) {
			if(player.getShojikin() <= 0) {
				System.out.println("GAMEOVER!");
				break;
			}
			System.out.println("1.スタート \n0.戻る");
			int choice = GameInput.inputChoose();
			switch (choice) {
			case 1:
				BlackJackProcess.BlackJackProcess(player);
				break;
			case 0:
				System.out.println("さよなら");
				loop = false;
				break;
			default:
				System.err.println("正しく入力してください");
				break;
			}

		}
	}

}
