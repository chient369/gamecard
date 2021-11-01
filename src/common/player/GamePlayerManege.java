package common.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class GamePlayerManege {
	private ArrayList<GamePlayer> players = new ArrayList<GamePlayer>();

	public GamePlayerManege() {
		super();
	}

	public GamePlayerManege(ArrayList<GamePlayer> players) {
		super();
		this.players = players;
	}

	public void setPlayers(ArrayList<GamePlayer> players) {
		this.players = players;
	}

	public void createPlayer(GamePlayer gamePlayer) {
		players.add(gamePlayer);
	}

	public void showBestPlayer() {
		Set<GamePlayer> bestList = new HashSet<GamePlayer>();
		if (!players.isEmpty()) {
			GamePlayer bestPlayer = players.get(0);
			for (GamePlayer player : players) {
				if (bestPlayer.getShojikin() <= player.getShojikin()) {
					bestPlayer = player;
				}

			}
			for (GamePlayer player2 : players) {
				if (bestPlayer.getShojikin() <= player2.getShojikin()) {
					bestPlayer = player2;
				}
				bestList.add(bestPlayer);
			}
			System.out.println("総人数      : " + players.size());
			System.out.println("所持金が一番のユーザー：");
			for (GamePlayer player : bestList) {
				showInfo(player);
			}

		} else {
			System.out.println("データがありません");

		}

	}

	public void showPlayersRank() {
		Collections.sort(players, new Comparator<GamePlayer>() {

			@Override
			public int compare(GamePlayer o1, GamePlayer o2) {
				if (o1.getShojikin() > o2.getShojikin()) {
					return 1;
				} else if (o1.getShojikin() < o2.getShojikin()) {
					return -1;

				}
				return 0;
			}
		});
		showPlayers(players);

	}

	public void sortPlayerById() {
		Collections.sort(players, new Comparator<GamePlayer>() {

			@Override
			public int compare(GamePlayer o1, GamePlayer o2) {
				return o1.getPlayerId().compareTo(o2.getPlayerId());
			}
		});
		showPlayers(players);

	}

	public void sortPlayerByKaisu() {
		Collections.sort(players, new Comparator<GamePlayer>() {

			@Override
			public int compare(GamePlayer o1, GamePlayer o2) {
				if (o1.getKaisu() > o2.getKaisu()) {
					return 1;
				} else if (o1.getKaisu() < o2.getKaisu()) {
					return -1;

				}
				return 0;
			}
		});
		showPlayers(players);

	}

	public void showPlayerBestKaisu() {
		Set<GamePlayer> bestList = new HashSet<GamePlayer>();
		if (!players.isEmpty()) {
			GamePlayer bestPlayer = players.get(0);
			for (GamePlayer player : players) {
				if (bestPlayer.getKaisu() <= player.getKaisu()) {
					bestPlayer = player;
				}
			}
			for (GamePlayer player2 : players) {
				if (bestPlayer.getKaisu() <= player2.getKaisu()) {
					bestPlayer = player2;
				}
				bestList.add(bestPlayer);
			}
			System.out.println("総人数      : " + players.size());
			System.out.println("総回数が一番のユーザー：");
			for (GamePlayer player : bestList) {
				showInfo(player);
			}
		} else {
			System.out.println("データがありません");

		}
	}

	private static void showPlayers(ArrayList<GamePlayer> players) {

		if (!players.isEmpty()) {
			System.out.format("----------------------------------------------------------%n");
			System.out.format("    ID         名前           最後の所持金　           総回数%n");
			for (GamePlayer player : players) {
				System.out.format("  %-5s%15s%15d%18d%n", player.getPlayerId(), player.getPlayerName(), player.getShojikin(),
						player.getKaisu());
				System.out.format("----------------------------------------------------------%n");

			}
		} else {
			System.out.println("データがありません");
			System.out.println("やってみましょう　");
		}

	}

	private void showInfo(GamePlayer player) {
		System.out.println("ID            : " + player.getPlayerId());
		System.out.println("名前          : " + player.getPlayerName());
		System.out.println("最後の所持金　  :　" + player.getShojikin());
		System.out.println("総回数         : " + player.getKaisu());
		System.out.println("===========================");
	}

}