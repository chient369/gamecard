package poker.turned;

import java.util.ArrayList;

public class TurnedHandle {
	private ArrayList<Turned> turnedList ;
	

	public TurnedHandle() {
		turnedList = new ArrayList<Turned>();
	}
	

	public ArrayList<Turned> getTurnedList() {
		return turnedList;
	}

	public void setTurnedList(ArrayList<Turned> turnedList) {
		this.turnedList = turnedList;
	}



	public void addTurned(String cards, int kakekin, int shojikin) {
		turnedList.add(new Turned(cards, kakekin, shojikin));
	}
	public void clearTurned() {
		this.turnedList.clear();
	}

}
