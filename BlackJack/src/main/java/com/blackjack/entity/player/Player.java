package com.blackjack.entity.player;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.blackjack.entity.user.User;

@Component
public class Player extends User {
	private String playerId;
	private Role role;

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", role=" + role + ", userName=" + userName + ", wallet=" + wallet
				+ "]";
	}
	
	

}
