package highcard;

import java.util.Scanner;

import common.GameInput;
import common.player.GamePlayer;
import common.player.GamePlayerManege;
import common.player.GamePlayerService;

public class main {
	private static GamePlayerService playerService = new GamePlayerService(new GamePlayerManege());
	private static Scanner sc = new Scanner(System.in);
	private static boolean check_loop = true;

	public static void main(String[] args) {

		while (check_loop) {

			System.out.println("こんにちは \n 1. スタート \n 2.　ユーザー管理 \n 0. ゲーム終了");
			int inp = GameInput.inputSentaku();
			switch (inp) {
			case 1:
				System.out.println("あなたの名前を入力してください");
				String playerName = sc.next();
				GamePlayer player = playerService.createPlayer(playerName);
				GameProcess shobu = new GameProcess(player);
				shobu.gameProccess(shobu);
				break;
			case 2:
				playerService.playerService();
				break;
			case 0:
				check_loop = false;
				System.out.println("さよなら、またねー");
				break;
			default:
				System.err.println("正しく入力してください");
				inp = GameInput.inputSentaku();
			}

		}

	}
}