package highcard;

import common.GameInput;
import common.player.GamePlayer;
import common.player.GamePlayerManege;
import common.player.GamePlayerService;

public final class HighCardMain {

	public static void main(GamePlayer player) {
		GamePlayerManege playerManege = new GamePlayerManege();
		GamePlayerService playerService = new GamePlayerService(playerManege);
		playerManege.createPlayer(player);
		boolean check_loop = true;
		while (check_loop) {
			System.out.println("こんにちは \n 1. スタート \n 2.　ユーザー管理 \n 0. 戻る");
			int choose = GameInput.inputSentaku();
			switch (choose) {
			case 1:
				HighCardGameProcess hc_process = new HighCardGameProcess(player);
				hc_process.gameProccess();
				break;
			case 2:
				playerService.playerService();
				break;
			case 0:
				check_loop = false;
				break;
			default:
				System.err.println("正しく入力してください");
				choose = GameInput.inputSentaku();
			}

		}

	}
}