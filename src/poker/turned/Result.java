package poker.turned;

public enum Result {
	STRAIGHT("ストレート"), FLUSH("フラッシュ"), THREE_CARD("スリーカード"),
	TWO_PAIR("ツウ・ペア"), ONE_PAIR("ワン・ペア"), LOSE(" "), FULL_HOUSE("フルハウス"),
	FOUR_CARD("フォア・カード"), STRAIGHT_FLUSH("ストレート・フラッシュ"),
	ROYAL_STRAIGHT_FLUSH("ロイヤルストレートフラッシュ"),NOTHING("配当なし");
	private String name;

	private Result(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
