package com.blackjack.entity.player;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.blackjack.entity.user.User;

@Component
public class Player extends User {
	private String playerId;
	private GameRole gameRole;

	public Player() {
		super();

	}

	public Player(String userName, String password) {
		super(userName, password);
		this.playerId = UUID.randomUUID().toString();
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public GameRole getGameRole() {
		return gameRole;
	}

	public void setGameRole(GameRole gameRole) {
		this.gameRole = gameRole;
	}

	

}
