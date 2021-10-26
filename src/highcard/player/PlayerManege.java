package highcard.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class PlayerManege {
	private ArrayList<Player> players = new ArrayList<Player>();

	public PlayerManege() {
		super();
	}

	public PlayerManege(ArrayList<Player> list) {
		super();
		this.players = list;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public Player createPlayer(String playerName) {
		Player player = new Player(playerName);
		players.add(player);

		return player;
	}

	public void showBestPlayer() {
		Set<Player> bestList = new HashSet<Player>();
		if (!players.isEmpty()) {
			Player bestPlayer = players.get(0);
			for (Player player : players) {	
				if (bestPlayer.getShojikin() <= player.getShojikin()) {
					bestPlayer = player;
				}

			}
			for(Player player2 : players) {
				if (bestPlayer.getShojikin() <= player2.getShojikin()) {
					bestPlayer = player2;
				}
				bestList.add(bestPlayer);
			}
			System.out.println("総人数      : " + players.size());
			System.out.println("所持金が一番のユーザー：");
			for (Player player : bestList) {
				showInfo(player);
			}
			
		} else {
			System.out.println("データがありません");

		}

	}

	public void showPlayersRank() {
		Collections.sort(players, new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
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
		Collections.sort(players, new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
				return o1.getPlayerId().compareTo(o2.getPlayerId());
			}
		});
		showPlayers(players);

	}

	public void sortPlayerByKaisu() {
		Collections.sort(players, new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
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
		Set<Player> bestList = new HashSet<Player>();
		if (!players.isEmpty()) {
			Player bestPlayer = players.get(0);
			for (Player player : players) {	
				if (bestPlayer.getKaisu() <= player.getKaisu()) {
					bestPlayer = player;
				}
			}
			for(Player player2 : players) {
				if (bestPlayer.getKaisu() <= player2.getKaisu()) {
					bestPlayer = player2;
				}
				bestList.add(bestPlayer);
			}
			System.out.println("総人数      : " + players.size());
			System.out.println("総回数が一番のユーザー：");
			for (Player player : bestList) {
				showInfo(player);
			}
		} else {
			System.out.println("データがありません");

		}
	}

	private void showPlayers(ArrayList<Player> players) {
		if (!players.isEmpty()) {
			for (Player player : players) {
				showInfo(player);

			}
		} else {
			System.out.println("データがありません");
			System.out.println("やってみましょう　");
		}

	}

	private void showInfo(Player player) {
		System.out.println("ID            : " + player.getPlayerId());
		System.out.println("名前          : " + player.getPlayerName());
		System.out.println("最後の所持金　  :　" + player.getShojikin());
		System.out.println("総回数         : " + player.getKaisu());
		System.out.println("===========================");
	}

}
