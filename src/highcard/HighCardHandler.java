package highcard;

import common.Card;
import common.CardHandler;

public class HighCardHandler extends CardHandler {
	public Card setCard(int card_num, String card_symbol) {
		return new Card(card_num, card_symbol);
	}

}
