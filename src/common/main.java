package common;

import common.player.GamePlayer;
import highcard.HighCardMain;
import poker.PokerMain;

public class main {
	public static void main(String[] args) {
		System.out.println("ようこそ");
		System.out.println("名前えを入力してください");
		String name = GameInput.inputName();
		// game init
		GameProcess gameProcess = new GameProcess(new GamePlayer(name));

		System.out.println("こんにちは。 " + gameProcess.getPlayer().getPlayerName());
		System.out.println("ゲームをやりましょう");

		boolean loop_check = true;
		while (loop_check) {

			System.out.println("  1. ハイカード \n  2. ポーカー\n  3. 情報参照\n  0. ゲーム終了");
			int choose = GameInput.inputChoose();
			switch (choose) {
			case 1:
				HighCardMain.main(gameProcess);
				break;
			case 2:
				PokerMain.main(gameProcess);
				break;
			case 3:
				System.out.println("編集中");
				break;
			case 0:
				System.out.println("さよなら");
				loop_check = false;
				break;
			default:
				System.err.println("正しく選択してください");
				break;
			}
		}

	}
}
