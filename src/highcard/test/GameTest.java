package highcard.test;

import java.util.ArrayList;
import java.util.Random;

import common.CardHandler;
import common.GameProcess;
import common.player.GamePlayer;
import common.player.GamePlayerManege;
import highcard.HighCardGameProcess;

public class GameTest {
	public static void main(String[] args) {		
		ArrayList<GamePlayer> list = new ArrayList<GamePlayer>();
		Random rand = new Random();
		//init 50 players
		for (int i = 0; i < 10; i++) {
			GamePlayer player = new GamePlayer("test num" + rand.nextInt(100));
			HighCardGameProcess hCardGameProcess = new HighCardGameProcess(player);
			//random turns
			for (int j = 0; j < rand.nextInt(20); j++) {
				hCardGameProcess.kekka(1, new CardHandler(), new CardHandler(), rand.nextInt(1000));
			}
			list.add(player);
		}
		System.out.println(list.size());
//		for (Player player : list) {
//			player.showPlayer();
//			System.out.println("++++++++++++");
//		}
		System.out.println("///////////////////////////////////////");
		GamePlayerManege playerManege = new GamePlayerManege(list);
		System.out.println("**********show best**********");
		playerManege.showBestPlayer();
		System.out.println("**********  show best turns**********");
		playerManege.showPlayerBestKaisu();
		System.out.println("**********  rank  **********");
		playerManege.showPlayersRank();
		System.out.println("********** sort by id**********");
		playerManege.sortPlayerById();
		System.out.println("**********sort by turns**********");
		playerManege.sortPlayerByKaisu();
		
		
	}

}
