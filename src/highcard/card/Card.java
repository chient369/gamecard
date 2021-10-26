package highcard.card;

public  class Card {
	private String card_symbols;
	private int card_num;

	public Card() {
		super();
	}

	public Card(String card_symbols, int card_num) {
		super();
		this.card_symbols = card_symbols;
		this.card_num = card_num;
	}

	public String getCard_symbols() {
		return card_symbols;
	}

	public void setCard_symbols(String card_symbols) {
		this.card_symbols = card_symbols;
	}

	public void setCadr_num(int card_num) {
		this.card_num = card_num;
	}

	public int getCard_num() {
		return card_num;
	}
	public String getCardFull() {
		return this.card_num + this.card_symbols;
	}
//	public static void main(String[] args) {
//		Card card = new Card("H", 1);
//		System.out.println(card.getCardFull());
//	}
	
}




