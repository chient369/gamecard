package game.common.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import highcard.player.HighCardPlayer;

public class HighCardPlayerManege extends GamePlayerManege {
	private ArrayList<HighCardPlayer> players = new ArrayList<HighCardPlayer>();

	public HighCardPlayerManege() {
		super();
	}

	public HighCardPlayerManege(ArrayList<HighCardPlayer> players) {
		super();
		this.players = players;
	}

	@Override
	public GamePlayer createPlayer(String playerName) {
		HighCardPlayer player = new HighCardPlayer(playerName);
		players.add(player);

		return player;
	}

	@Override
	protected void showBestPlayer() {
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
			showInfo(players);

		} else {
			System.out.println("データがありません");

		}

	}

	@Override
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

	@Override
	public void sortPlayerById() {
		Collections.sort(players, new Comparator<GamePlayer>() {

			@Override
			public int compare(GamePlayer o1, GamePlayer o2) {
				return o1.getPlayerId().compareTo(o2.getPlayerId());
			}
		});
		showPlayers(players);

	}

	@Override
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

	@Override
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
			showInfo(players);

		} else {
			System.out.println("データがありません");

		}

	}

	private  void showInfo(ArrayList<HighCardPlayer> players) {
		if (!players.isEmpty()) {
			String format = "%7s%13s%13d%15d %n";
			System.out.format("+--------------------------------------------------+%n");
			System.out.format("  ID    |    名前      |    最後の所持金    |      回数%n");
			for (GamePlayer player : players) {
				System.out.format(format, player.getPlayerId(), player.getPlayerName(), player.getShojikin(),
						player.getKaisu());
				System.out.format("+--------------------------------------------------+%n");

			}
		} else {
			System.out.println("データがありません");
			System.out.println("やってみましょう　");

		}
	}
		
	}

