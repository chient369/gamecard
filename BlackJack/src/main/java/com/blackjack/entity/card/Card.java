package com.blackjack.entity.card;

import org.springframework.stereotype.Component;

@Component
public class Card {

	private int no;
	private Suit suit;

	public Card() {
	}

	public Card(int no, Suit suit) {
		super();
		this.no = no;
		this.suit = suit;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

}
