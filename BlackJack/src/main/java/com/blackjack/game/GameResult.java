package com.blackjack.game;

import org.springframework.stereotype.Component;

@Component
public class GameResult {
	private String masterId;
	private String joinerId;
	private Game_Result result;
	private String roomId;
	private int fare;
	public GameResult() {
	}
	
	
	public GameResult(String masterId, String joinerId, int fare) {
		super();
		this.masterId = masterId;
		this.joinerId = joinerId;
		this.fare = fare;
	}


	public int getFare() {
		return fare;
	}


	public void setFare(int fare) {
		this.fare = fare;
	}


	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getJoinerId() {
		return joinerId;
	}
	public void setJoinerId(String joinerId) {
		this.joinerId = joinerId;
	}
	public Game_Result getResult() {
		return result;
	}
	public void setResult(Game_Result result) {
		this.result = result;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
	

}
