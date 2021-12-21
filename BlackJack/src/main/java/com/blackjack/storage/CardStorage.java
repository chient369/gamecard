package com.blackjack.storage;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.blackjack.entity.Card;
import com.blackjack.entity.Suit;

@Component
public class CardStorage {
	private ArrayList<Card> cardStorage;
//	private static CardStorage INSTANCE;
	
	public CardStorage() {
//		INSTANCE = new CardStorage();
		cardStorage = new ArrayList<Card>();
		Suit[] suits = Suit.values();
		for (int i = 1; i <= 13; i++) {
			for (int j = 0; j < suits.length; j++) {
				cardStorage.add(new Card(i, suits[j]));
			}
		}

	}
//	public synchronized static CardStorage getInsance() {
//		if (INSTANCE == null) {
//			INSTANCE = new CardStorage();			
//		}
//		return INSTANCE;
//		
//	}
	public ArrayList<Card> getCardStorage() {
		return cardStorage;
	}
	public void setCardStorage(ArrayList<Card> cardStorage) {
		this.cardStorage = cardStorage;
	}

}
