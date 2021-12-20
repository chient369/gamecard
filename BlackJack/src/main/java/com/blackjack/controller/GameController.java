package com.blackjack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackjack.controller.dto.ConnectRequest;
import com.blackjack.controller.dto.GameDto;
import com.blackjack.entity.Card;
import com.blackjack.entity.Game;
import com.blackjack.entity.Player;
import com.blackjack.entity.Room;
import com.blackjack.exception.GameException;
import com.blackjack.exception.TransactionException;
import com.blackjack.game.GamePlay;
import com.blackjack.service.GameService;

@RestController
@RequestMapping("/api/")
public class GameController {
	private Logger log = LoggerFactory.getLogger(GameController.class);
	@Autowired
	private GameService gameService;

	@PostMapping("/create-room")
	public ResponseEntity<Room> createRoom(@RequestBody Player player) {
		log.info("Create new game : {} " + player);
		return ResponseEntity.ok(gameService.CreateRoom(player));
	}

	@PostMapping("/connect")
	public ResponseEntity<Room> connectRoom(@RequestBody ConnectRequest request) throws GameException{
		log.info("gameId : " + request.getRoomId() + "Player : " + request.getPlayer().getName());
		log.info("{} was connected to : {}",request.getPlayer().getName(), request.getRoomId());
		return ResponseEntity.ok(gameService.joinGame(request.getRoomId(), request.getPlayer()));
	}
	@PostMapping("/start")
	public ResponseEntity<Game> start(@RequestBody GameDto request) throws GameException{
		log.info("game started : {}", request.getRoomId());
		return ResponseEntity.ok(gameService.startGame(request.getRoomId()));
		
	}
	@PostMapping("/hit")
	public ResponseEntity<Card> hitCard(@RequestBody Player player){
		log.info("{} was hitted card", player.getName());
		return ResponseEntity.ok(gameService.hitCard(player.getId()));
		
	}
	@PostMapping("/gameplay")
	public ResponseEntity<Game> gamePlay(@RequestBody GamePlay gamePlay) throws GameException, TransactionException{
		log.info("Game Play Infp : {}, {}", gamePlay.getRoomId(), gamePlay.getFareOfAmount());
		return ResponseEntity.ok(gameService.gamePlay(gamePlay));
	}

}
