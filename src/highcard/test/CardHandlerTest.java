package highcard.test;

import common.CardHandler;

public class CardHandlerTest {
	public static void main(String[] args) {
		CardHandler cardHandler = new CardHandler();
		for (int i = 0; i < 20; i++) {
			cardHandler = new CardHandler();

		}
		cardHandler.showCardRepo();

	}

}
