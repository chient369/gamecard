package common.player;

import common.GameInput;

public class GamePlayerService {
	private final GamePlayerManege playerManege;
	public GamePlayerService(GamePlayerManege playerManege) {
		super();
		this.playerManege = playerManege;
	}

	public GamePlayer createPlayer(String playerName) {
		return playerManege.createPlayer(playerName);
	}

	public void playerService() {
		boolean check = true;
		while (check) {
			System.out.println("ユーザー管理 ");
			System.out.println("　1. ユーザーリストを見る \n 2. ランクを見る \n 3. 所持金が一番多いユーザーをみる "
					+ "\n 4. 回数が一番多いユーザーを見る \n 5. 回数の昇順を整列する \n 0.戻る");
			int choose = GameInput.inputChoose();
			switch (choose) {
			case 1:
				playerManege.sortPlayerById();
				;
				break;
			case 2:
				playerManege.showPlayersRank();
				break;
			case 3:
				playerManege.showBestPlayer();
				break;
			case 4:
				playerManege.showPlayerBestKaisu();
				break;
			case 5:
				playerManege.sortPlayerByKaisu();
				;
				break;
			case 0:
				check = false;
				break;
			default:
				System.err.println("正しく選択してください");
				break;
			}
		}

	}

}
