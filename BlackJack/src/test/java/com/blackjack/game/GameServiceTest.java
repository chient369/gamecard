package com.blackjack.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blackjack.entity.Card;
import com.blackjack.entity.Game;
import com.blackjack.entity.Game_Status;
import com.blackjack.entity.Player;
import com.blackjack.entity.Role;
import com.blackjack.exception.GameException;
import com.blackjack.exception.TransactionException;
import com.blackjack.service.GameService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameServiceTest {

	@Autowired
	private GameService gameService;
	
	static Player player2 = new Player("p3", "T03");;
	static Player player1 = new Player("p3", "T05");
	
	@BeforeClass
	static void init() {
		System.out.println("beforeClass");
		
	}

	@Test
	public void CreateGame() throws GameException {
		Game game = gameService.CreateGame(player1);
		System.out.println(game.getGameId());
		assertThat(game.getStatus().equals(Game_Status.NEW));
		
	}
	@Test
	public void joinGame() throws GameException {
		Game game1 = gameService.CreateGame(player1);
		String gameid = game1.getGameId();
		Game game2 = gameService.joinGame(gameid, player2);
		
		assertThat(game1.equals(game2));
		assertThat(game2.getStatus().equals(Game_Status.NEW));
	}
	@Test
	public void startGameTest() throws GameException {
		Game_Status rs = Game_Status.IN_PROCESS;
		Game game1 = gameService.CreateGame(player1);
		String gameid = game1.getGameId();
		Game game2 = gameService.joinGame(gameid, player2);
		
		Game start = gameService.startGame(gameid);
		assertThat(start.equals(rs));
		
		Card card = gameService.hitCard(player1.getId());
		System.out.println(card.getNo()+ " " + card.getSuit());
		assertTrue(card!= null);
	
	}
	@Test
	public void gamePlayTest() throws GameException, TransactionException {
		Game game1 = gameService.CreateGame(player1);
		String gameid = game1.getGameId();
		Game game2 = gameService.joinGame(gameid, player2);
		
		GamePlay gamePlay = new GamePlay(100, gameid);
		
		Game game = gameService.gamePlay(gamePlay);
		
		System.out.println("winner :" + game.getWinner());
		assertThat(game.getWinner().equals(nullValue()));
		assertTrue(game!=null);
		
	}
}
