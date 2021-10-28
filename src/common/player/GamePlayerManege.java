package game.common.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public abstract class GamePlayerManege {

	public abstract GamePlayer createPlayer(String playerName);

	public abstract void showBestPlayer();

	public abstract void showPlayersRank();

	public abstract void sortPlayerById();

	public abstract void sortPlayerByKaisu();

	public abstract void showPlayerBestKaisu();

	public abstract <T> void showPlayers();
}