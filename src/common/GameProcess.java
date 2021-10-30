package common;

import common.player.GamePlayer;

public class GameProcess {
	private GamePlayer player;

	public GameProcess() {
	}

	public GameProcess(GamePlayer player) {
		super();
		this.player = player;
	}

	public GamePlayer getPlayer() {
		return player;
	}

}
