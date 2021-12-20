package com.blackjack.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blackjack.entity.Card;
import com.blackjack.entity.Game;
import com.blackjack.entity.Player;
import com.blackjack.entity.Role;
import com.blackjack.entity.Suit;
import com.blackjack.exception.GameException;
import com.blackjack.storage.HandCardsStorage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameProcessTest {
	@Autowired
	GameProcess gameProcess;
	
    @Autowired
    Game game;

	 Player player1;
	 Player player2;

	@BeforeEach
	void init() {
		player1 = new Player("chien", "011");
		player2 = new Player("chien2", "02");
	}
	

	@Test
	public void testHitCardTest() {
		Card card = gameProcess.hitCard();
		gameProcess.hitCard();
		gameProcess.hitCard();
		gameProcess.hitCard();
		assertThat(card != null);
	}
	@Test
	public void resultOfSpecialHandTest_BANBAN() throws GameException {
		BJResult rs = BJResult.BAN_BAN;
		
		Card card1 = new Card(1, Suit.CLUBS);
		Card card2 = new Card(1, Suit.SPADES);
		ArrayList<Card> handCard1 = new ArrayList<Card>();
		handCard1.add(card2);
		handCard1.add(card1);
		HandCardsStorage.getInstance().addHandCard(player1.getId(), handCard1);
		BJResult rsP1 = gameProcess.getResult(player1);
		 
		assertTrue(rs.equals(rsP1));
		
		HandCardsStorage.getInstance().getHandCards(player1.getId()).clear();
		HandCardsStorage.getInstance().clearGame();
		
	}
	@Test
	public void resultOfSpecialHandTest_BANLUCK() throws GameException {
		BJResult rs = BJResult.BAN_LUCK;
		
		Card card1 = new Card(1, Suit.CLUBS);
		Card card2 = new Card(13, Suit.SPADES);
		ArrayList<Card> handCard2 = new ArrayList<Card>();
		handCard2.add(card2);
		handCard2.add(card1);
		HandCardsStorage.getInstance().addHandCard(player2.getId(), handCard2);
		BJResult rsP1 = gameProcess.getResult(player2);
		 
		assertTrue(rs.equals(rsP1));
		
		HandCardsStorage.getInstance().getHandCards(player1.getId()).clear();
		HandCardsStorage.getInstance().clearGame();
	}

	@Test
	public void getStartCardTest() throws GameException {

		gameProcess.startOfCards(player1);
		gameProcess.startOfCards(player2);
		ArrayList<Card> cards1 = HandCardsStorage.getInstance().getHandCards(player1.getId());
		cards1.forEach(ca -> System.out.println(ca.getNo() +" "+ ca.getSuit()));
		
		ArrayList<Card> cards2 = HandCardsStorage.getInstance().getHandCards(player2.getId());
		cards2.forEach(ca -> System.out.println(ca.getNo() +" "+ ca.getSuit()));
		assertThat(!cards2.isEmpty());
	}

	@Test
	public  void getResultTest() {
		BJResult rs = gameProcess.getResult(player1);
		System.out.println(rs);
		BJResult rs2 = gameProcess.getResult(player2);
		System.out.println(rs2);
		assertThat(rs.equals(nullValue()));
	}
	

}
