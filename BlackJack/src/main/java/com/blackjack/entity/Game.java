package com.blackjack.entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.blackjack.game.GameResult;

@Component
public class Game {
	private String gameId;
	private String roomId;
	private Game_Status status;
	private ArrayList<GameResult> result = new ArrayList<GameResult>();
	public Game() {
		gameInit();
	}

	private void gameInit() {
		
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Game_Status getStatus() {
		return status;
	}

	public void setStatus(Game_Status status) {
		this.status = status;
	}

	public ArrayList<GameResult> getResult() {
		return result;
	}

	public void setResult(ArrayList<GameResult> result) {
		this.result = result;
	}

	

}
