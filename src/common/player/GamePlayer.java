package common.player;



import java.util.Objects;

public class GamePlayer {
	private int bonusCount = 0;
	static private int playerIdCount = 0;
	private String playerName;
	private String playerId = null;
	private int shojikin = 1000;
	private int kaisu = 0;

	public GamePlayer() {
		super();
	}

	public GamePlayer(String playerName) {
		super();
		this.playerName = playerName;
		playerId = "NO."+playerIdCount++;
	}

	
	public int getShojikin() {
		return shojikin;
	}
	

	public String getPlayerId() {
		return playerId;
	}

	public int getBonusCount() {
		return bonusCount;
	}

	public void setShojikin(int shojikin) {
		this.shojikin = shojikin;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getKaisu() {
		return kaisu;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void make(int kakekin) {
		kaisu++;
		shojikin -= kakekin;
		if (shojikin<0) {
			shojikin=0;
		}
		System.out.printf("残念でした　　　-%d \n\n", kakekin);
	}

	public void kachi(int kakekin) {
		kaisu++;
		shojikin += kakekin;
		System.out.printf("おめでとうございます +%d \n\n", kakekin);
	}

	public void pitari(int kakekin) {
		kaisu++;
		shojikin += 12 * kakekin;
		bonusCount++;
		
	}

	public void saigo(int saigokakekin) {
//		if (shojikin > 100000) {
//			shojikin -= saigokakekin;
//
//		}
		if (shojikin < 100) {
			shojikin += saigokakekin;

		}

	}
	

	@Override
	public int hashCode() {
		return Objects.hash(playerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GamePlayer other = (GamePlayer) obj;
		return Objects.equals(playerId, other.playerId);
	}

	public void showPlayer() {
		System.out.printf("ID           : %s \n", playerId);
		System.out.printf("名前         : %s \n", this.playerName);
		System.out.printf("現在の所持金  : %d \n", shojikin);
		System.out.printf("回数目       : %d \n", kaisu);
		System.out.println("---------------------");
	}

}
