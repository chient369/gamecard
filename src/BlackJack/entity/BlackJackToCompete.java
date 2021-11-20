package BlackJack.entity;

import BlackJack.BlackJackHandle;
import common.player.GamePlayer;

public class BlackJackToCompete {
	private BlackJackDealer dealer;
	private BlackJackPlayer player;
	private GamePlayer gamePlayer;

	public BlackJackToCompete(BlackJackDealer dealer, BlackJackPlayer player) {
		super();
		this.dealer = dealer;
		this.player = player;
		this.gamePlayer = player.getPlayer();
	}

	public BlackJackToCompete() {
	}

	public BlackJackDealer getDealer() {
		return dealer;
	}

	public BlackJackPlayer getPlayer() {
		return player;
	}

	public GamePlayer getGamePlayer() {
		return gamePlayer;
	}

	public void compete(BJResult dealerResult, BJResult playerResult, int fare) {
		int shojikin = player.getShojikin();
		if (playerResult == BJResult.BUSTS) {
			if (dealerResult == BJResult.BUSTS) {
				return;
			} else {
				gamePlayer.setShojikin(shojikin + BlackJackBonus.lose(fare));
				return;
			}
		}
		if (dealerResult == BJResult.BUSTS && playerResult == BJResult.PLAYER_OF_FREE_HAND) {
			gamePlayer.setShojikin(shojikin + BlackJackBonus.winOfBonus(fare));
			return;
		}

		if (playerResult == BJResult.BAN_LUCK) {
			if (dealerResult == BJResult.BAN_LUCK) {
				gamePlayer.setShojikin(shojikin);
			} else if (dealerResult == BJResult.BAN_BAN) {
				gamePlayer.setShojikin(shojikin + BlackJackBonus.loseWithBanBan(fare));
			} else {
				gamePlayer.setShojikin(shojikin + BlackJackBonus.winOfBonus(fare));
			}

		}
		if (dealerResult == BJResult.BAN_LUCK) {
			gamePlayer.setShojikin(shojikin + BlackJackBonus.lose(fare));
			return;
		}
		if (playerResult == BJResult.BAN_BAN) {
			if (dealerResult != BJResult.BAN_BAN) {
				gamePlayer.setShojikin(shojikin + BlackJackBonus.winForBanBan(fare));
			}
			return;

		}
		if (playerResult == BJResult.FIVE_DRAGON) {
			gamePlayer.setShojikin(shojikin + BlackJackBonus.winForFiveDragon(fare));
			return;
		}
		if (dealerResult == BJResult.FIVE_DRAGON) {
			gamePlayer.setShojikin(shojikin + BlackJackBonus.loseWithFiveDragon(fare));
		}
		if (playerResult == BJResult.PLAYER_OF_FREE_HAND && dealerResult == BJResult.DEALER_OF_FREE_HAND) {
			int playerPoints = playerResult.getValue();
			int dealerPoints = dealerResult.getValue();
			if (playerPoints > dealerPoints) {
				gamePlayer.setShojikin(shojikin + BlackJackBonus.winOfBonus(fare));
			} else {
				gamePlayer.setShojikin(shojikin + BlackJackBonus.lose(fare));
			}
			return;

		}

	}

	public static void main(String[] args) {
		GamePlayer player = new GamePlayer("TEST CASE 01");
		BlackJackHandle handle = new BlackJackHandle();
		BlackJackDealer dealer = new BlackJackDealer(handle);
		BlackJackPlayer player2 = new BlackJackPlayer(handle, player);
		BlackJackToCompete compete = new BlackJackToCompete(dealer, player2);
		int fare = 100;

		compete.compete(BJResult.BAN_BAN, BJResult.BAN_BAN, fare);
		System.out.println("case Ban ban" + player.getShojikin());
		compete.compete(BJResult.BAN_LUCK, BJResult.PLAYER_OF_FREE_HAND, fare);
		System.out.println("case Ban luck- free hand " + player.getShojikin());

		compete.compete(dealer.dealerTurn(), player2.playerOfTurn(), fare);
		System.out.println("case free hand (1)" + player.getShojikin());

		compete.compete(BJResult.BUSTS, BJResult.BUSTS, fare);
		System.out.println("case alow bust" + player.getShojikin());
		compete.compete(BJResult.DEALER_OF_FREE_HAND,BJResult.FIVE_DRAGON, fare);
		System.out.println("case five dragon" + player.getShojikin());
	}
}
