package com.blackjack.entity;

import org.springframework.stereotype.Component;

@Component
public class Player {
	private String name;
	private String id;
	private Role role;
	private int wallet = 1000;

	public Player() {
		super();
	}

	public Player(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getWallet() {
		return wallet;
	}
	public void setWallet(int wallet) {
		 this.wallet = wallet;
	}

}
