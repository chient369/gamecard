package com.blackjack.entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.blackjack.game.GameResult;

@Component
public class Game {
	private String gameId;
	private String roomId;
	private Game_Status status;
	private ArrayList<Card> gameCards;
	private ArrayList<GameResult> result = new ArrayList<GameResult>();
	public Game() {
		gameInit();
	}

	private void gameInit() {
		gameCards = new ArrayList<Card>();
		Suit[] suits = Suit.values();
		for (int i = 1; i <= 13; i++) {
			for (int j = 0; j < suits.length; j++) {
				gameCards.add(new Card(i, suits[j]));
			}
		}

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

	public void setGameCards(ArrayList<Card> gameCards) {
		this.gameCards = gameCards;
	}

	public ArrayList<Card> getGameCards() {
		return gameCards;
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
