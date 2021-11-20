package BlackJack.entity;

public final class BlackJackBonus {
	public static int winOfBonus(int fare) {
		return fare;

	}

	public static int winForFiveDragon(int fare) {
		return fare * 2;
	}

	public static int winForBanBan(int fare) {
		return fare * 3;
	}

	public static int lose(int fare) {
		return -fare;
	}
	public static int loseWithBanBan(int fare) {
		return -fare *2;
	}

	public static int loseWithFiveDragon(int fare) {
		return -2 * fare;
	}

}
