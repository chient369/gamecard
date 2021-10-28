package highcard.test;

import java.util.ArrayList;
import java.util.Random;

import game.common.player.HighCardPlayerManege;
import highcard.GameProcess;
import highcard.card.CardHandler;
import highcard.player.HighCardPlayer;


public class GameTest {
	public static void main(String[] args) {		
		ArrayList<HighCardPlayer> list = new ArrayList<HighCardPlayer>();
		Random rand = new Random();
		//init 50 players
		for (int i = 0; i < 50; i++) {
			HighCardPlayer player = new HighCardPlayer("TEST NO." +rand.nextInt(100)+1);
			GameProcess gameProcess = new GameProcess(player);
			//random turns
			for (int j = 0; j < rand.nextInt(20); j++) {
				gameProcess.kekka(1, new CardHandler(), new CardHandler(), rand.nextInt(1000));
			}
			list.add(player);
		}
		System.out.println(list.size());
//		for (Player player : list) {
//			player.showPlayer();
//			System.out.println("++++++++++++");
//		}
		System.out.println("///////////////////////////////////////");
		HighCardPlayerManege playerManege = new HighCardPlayerManege();
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
