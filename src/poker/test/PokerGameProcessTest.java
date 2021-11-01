package poker.test;

import java.util.ArrayList;

import common.Card;
import common.GameProcess;
import common.player.GamePlayer;
import poker.PokerCardHandler;
import poker.PokerGameProcess;
import poker.PokerGameRules;

public class PokerGameProcessTest {
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer("xnh");
		GameProcess gameProcess = new GameProcess(player);
		PokerGameProcess pokerGameProcess = new PokerGameProcess();
		// test one
		PokerGameRules pokerGameRules = new PokerGameRules(gameProcess);
		for (int i = 0; i < 10; i++) {
			ArrayList<Card> arrayList = new PokerCardHandler().getFiveCard();
			for (Card card : arrayList) {
				System.out.print(card.getCardFull() + " ");
			}

			// test twopair
			pokerGameRules.isTwoPairOrThreeOrFour(arrayList, i);
			System.out.println("------------------");

			// test flush
			boolean test = pokerGameRules.isFlush(arrayList);
			System.out.println("is Flush :" + test);
			System.out.println("------------------");
			// test flush
			System.out.println("Is Straight :" + pokerGameRules.isStraight(arrayList));
			System.out.println("++++++++++++");
		}
		
		
		System.out.println("+++++++++++++++++++++++");
		pokerGameProcess.oneTurn();
		pokerGameProcess.tenTurns();
		
		

	}
}
