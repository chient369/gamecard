package highcard.card;

import java.util.Random;

public  class CardHandle {
	static private Random rand = new Random();
	static private int[] card_nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	static private String[] card_symbols = {"♥","♦","♠","♣"};
	//private Set<Card> cardRepo = new HashSet<Card>(53);
	private Card card;



	public CardHandle() {
	 this.card  = new Card(card_nums[rand.nextInt(13)],card_symbols[rand.nextInt(3)]);
	}
	public Card setCard(int card_num, String card_symbol) {
		return new Card(card_num, card_symbol);
	}
//	public Card getCard() {
//		return this.card;♣
//	}
	public  int getCardNum() {
		return card.getCard_num();
	}
	public  String getCardFull() {
		return card.getCardFull();
	}

	public boolean isBiggerThan(CardHandle card) {
		if (this.getCardNum() > card.getCardNum()) {
			return true;
		}
		return false;

	}


//	public static void main(String[] args) {
//	System.out.println(GetCard.getCard());
//	System.out.println(GetCard.getCardNum());
//}


}
