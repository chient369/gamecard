package poker;

import common.GameInput;
import common.GameProcess;

public final class PokerMain {
	public static void main(GameProcess gameProcess) {
		PokerGameProcess process = new PokerGameProcess(gameProcess);
		boolean loop = true;
		System.out.println("こんにちは、ポーカーゲームをようこそ");
		while (loop) {
			System.out.println("  1. 単発 \n  2.連10回 \n  3.ルールを見る\n  4.履歴\n  0.戻る");
			int choose = GameInput.inputChoose();
			switch (choose) {
			case 1:
				process.oneTurn();
				break;
			case 2:
				process.tenTurns();
				break;
			case 3:
				System.out.println("まだ終わらない");
				break;
			case 4:
				process.showTurned();
				break;
			case 0:
				System.out.println("ありがとうございます。");
				loop = false;
				break;
			default:
				System.err.println("正しく選択してください");
				break;
			}

		}

	}

}
