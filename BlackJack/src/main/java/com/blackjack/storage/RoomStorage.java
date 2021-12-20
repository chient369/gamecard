package com.blackjack.storage;

import java.util.HashMap;
import java.util.Map;

import com.blackjack.entity.Room;

public class RoomStorage {
	private Map<String, Room> rooms;
	private static RoomStorage instance;

	private RoomStorage() {
		rooms = new HashMap<String, Room>();
	}

	public synchronized static RoomStorage getInstance() {
		if (instance == null) {
			instance = new RoomStorage();
		}
		return instance;
	}

	public Map<String, Room> getRooms() {
		return rooms;
	}

	public void setGame(Room room) {
		rooms.put(room.getRoomId(), room);
	}
	public boolean isExist(String id) {
		return rooms.containsKey(id);
	}
}
