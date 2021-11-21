package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import common.Card;
import common.player.GamePlayer;
import poker.turned.Result;
import poker.turned.Turned;
import poker.turned.TurnedHandle;

public class PokerGameRules {
	private TurnedHandle turnedHandle;

	private GamePlayer player;

	public PokerGameRules(GamePlayer player) {
		super();

		this.player = player;
		this.turnedHandle = new TurnedHandle();
	}

	public GamePlayer getPlayer() {
		return this.player;
	}

	public void isTwoPairOrThreeOrFour(ArrayList<Card> fiveCards, int kakekin) {
		int cnt = 0;
		Set<Integer> filter1 = new HashSet<Integer>();
		Set<Integer> filter2 = new HashSet<Integer>();

		for (int i = 0; i < fiveCards.size(); i++) {
			if (filter1.contains(fiveCards.get(i).getCard_num())) {
				cnt++;
				filter2.add(fiveCards.get(i).getCard_num());
			}
			filter1.add(fiveCards.get(i).getCard_num());
		}
		if (cnt == 2) {
			if (filter2.size() == 1) {
				int bonus = threeCardBonus(kakekin);
				addTurned(fiveCards, Result.THREE_CARD.getName(), bonus, player.getShojikin());
			} else {
				int bonus = twoPairBonus(kakekin);
				addTurned(fiveCards, Result.TWO_PAIR.getName(), bonus, player.getShojikin());
			}
		} else if (cnt == 3) {
			if (filter2.size() == 2) {
				int bonus = fullHouse(kakekin);
				addTurned(fiveCards, Result.FULL_HOUSE.getName(), bonus, player.getShojikin());
			} else {
				int bonus = fourCardBonus(kakekin);
				addTurned(fiveCards, Result.FOUR_CARD.getName(), bonus, player.getShojikin());
			}
		} else {
			int shojikin = lose(kakekin);
			System.out.print("残念。配当はありません ");
			System.out.println("- " + kakekin);
			addTurned(fiveCards, Result.NOTHING.getName(), -kakekin, shojikin);
		}
		fiveCards.clear();
		filter2.clear();
		filter1.clear();
	}

	/*
	 * is flush method return Boolean
	 */
	public boolean isFlush(ArrayList<Card> fiveCards) {
		Set<String> flushSet = new HashSet<String>();
		for (int i = 0; i < fiveCards.size(); i++) {
			flushSet.add(fiveCards.get(i).getCard_symbols());
		}
		if (flushSet.size() == 1) {
			return true;
		}
		return false;

	}

	/*
	 * is Straight
	 */
	public boolean isStraight(ArrayList<Card> fiveCards) {
		boolean isStraight = false;
		Collections.sort(fiveCards, new Comparator<Card>() {

			@Override
			public int compare(Card o1, Card o2) {
				if (o1.getCard_num() > o2.getCard_num()) {
					return 1;
				}
				if (o1.getCard_num() < o2.getCard_num()) {
					return -1;
				}
				return 0;
			}
		});
		int cnt = 0;
		while (cnt < fiveCards.size() - 1) {
			if (fiveCards.get(cnt).getCard_num() + 1 == fiveCards.get(cnt + 1).getCard_num()) {
				isStraight = true;
			} else {
				return false;
			}
			cnt++;
		}
		return isStraight;
	}

	public boolean isRoyalStraightFlush(ArrayList<Card> fiveCards) {
		boolean isRoyal = true;
		if (this.isStraight(fiveCards) && this.isFlush(fiveCards)) {
			for (int i = 0; i < fiveCards.size(); i++) {
				if (fiveCards.get(i).getCard_num() >= 10) {
					continue;
				} else {
					isRoyal = false;
				}
			}

		}
		return isRoyal;

	}

	// show fiveCards
	public void showCardsList(ArrayList<Card> fiveCards) {
		for (Card card : fiveCards) {
			System.out.print(card.getCardFull() + " ");
		}
		System.out.println();
	}

	// show info
	public void showPlayer() {
		System.out.println("名前　  : " + player.getPlayerName());
		System.out.println("所持金  : " + player.getShojikin());
	}

	// bonus method
	private int twoPairBonus(int kakekin) {
		player.setShojikin(player.getShojikin() + kakekin * 9);
		System.out.println("two couple + " + kakekin * 9);
		showPlayer();
		return kakekin * 9;
	}

	private int threeCardBonus(int kakekin) {
		player.setShojikin(player.getShojikin() + kakekin * 12);
		System.out.println("three card + " + kakekin * 12);
		showPlayer();
		return kakekin * 12;
	}

	private int fullHouse(int kakekin) {
		player.setShojikin(player.getShojikin() + kakekin * 50);
		System.out.println("double bonus + " + kakekin * 50);
		showPlayer();
		return kakekin * 50;
	}

	private int fourCardBonus(int kakekin) {
		player.setShojikin(player.getShojikin() + kakekin * 200);
		System.out.println("four card + " + kakekin * 200);
		showPlayer();
		return kakekin * 200;
	}

	public int flushBonus(int kakekin) {
		player.setShojikin(player.getShojikin() + kakekin * 42);
		System.out.println("flush bonus + " + kakekin * 42);
		showPlayer();
		return kakekin * 42;
	}

	public int straightBonus(int kakekin) {
		player.setShojikin(player.getShojikin() + kakekin * 1000);
		System.out.println("straight bonus + " + kakekin * 1000);
		showPlayer();
		return kakekin * 1000;
	}

	public int straightFlushBonus(int kakekin) {
		player.setShojikin(player.getShojikin() + kakekin * 10000);
		System.out.println("flush bonus + " + kakekin * 10000);
		showPlayer();
		return kakekin * 10000;
	}

	public int lose(int kakekin) {
		player.setShojikin(player.getShojikin() - kakekin);
		return player.getShojikin();
	}

	public void addTurned(ArrayList<Card> fiveCards, String resultName, int kakekin, int shojikin) {
		String cards = "";
		for (Card card : fiveCards) {
			cards += card.getCardFull() + " ";
		}
		turnedHandle.addTurned(cards, resultName, kakekin, shojikin);
	}

	public ArrayList<Turned> getTurnedList() {
		return turnedHandle.getTurnedList();
	}

//	public void clearTurned() {
//		turnedHandle.clearTurned();
//	}

}
