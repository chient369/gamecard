package com.blackjack.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class Room {

	private String roomId;
	private Map<String, Player> players;
	private Room_Status status;

	public Room() {
		players = new HashMap<String, Player>();
	}

	public Map<String, Player> getPlayers() {
		return players;
	}

	public Player addPlayer(Player player) {
		return players.put(player.getId(), player);
	}
     
	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Room_Status getStatus() {
		return status;
	}

	public void setStatus(Room_Status status) {
		this.status = status;
	}

}
