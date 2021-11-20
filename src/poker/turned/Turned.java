package poker.turned;

public class Turned {
	private static int cnt = 0;
	private String resultName;
	private int turn_num;
	private String cards;
	private int result;
	private int shojikin;

	public Turned() {
		super();
	}

	public int getTurn_num() {
		return turn_num;
	}

	public Turned(String cards, String resultName, int result, int shojikin) {
		super();
		cnt++;
		this.resultName = resultName;
		this.turn_num += cnt;
		this.cards = cards;
		this.result = result;
		this.shojikin = shojikin;
	}

	public String getCards() {
		return cards;
	}

	public void setCards(String cards) {
		this.cards = cards;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getShojikin() {
		return shojikin;
	}

	public void setShojikin(int shojikin) {
		this.shojikin = shojikin;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public String getResultName() {
		return resultName;
	}



}
