package BlackJack.entity;

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
		if (playerResult == BJResult.FIVE_DRAGON) {
			if (dealerResult == BJResult.FIVE_DRAGON) {
				return;
			}
			gamePlayer.setShojikin(shojikin + BlackJackBonus.winForFiveDragon(fare));
			System.out.println("YOU WIN!  +" + BlackJackBonus.winForFiveDragon(fare));
			return;

		}
		if (dealerResult == BJResult.FIVE_DRAGON) {
			gamePlayer.setShojikin(shojikin + BlackJackBonus.loseWithFiveDragon(fare));
			System.out.println("YOU LOSE!  " + BlackJackBonus.loseWithFiveDragon(fare));
			return;

		}
		if (playerResult == BJResult.BAN_BAN) {
			if (dealerResult == BJResult.BAN_BAN) {
				return;
			}
			gamePlayer.setShojikin(shojikin + BlackJackBonus.winForBanBan(fare));
			System.out.println("YOU WIN!  +" + BlackJackBonus.winForBanBan(fare));
			return;

		}
		if (dealerResult == BJResult.BAN_BAN) {
			gamePlayer.setShojikin(shojikin + BlackJackBonus.loseWithBanBan(fare));
			System.out.println("YOU LOSE!  " + BlackJackBonus.loseWithBanBan(fare));
			return;
		}
		if (playerResult == BJResult.BAN_LUCK) {
			if (dealerResult == BJResult.BAN_LUCK) {
				return;
			}
			gamePlayer.setShojikin(shojikin + BlackJackBonus.winOfBonus(fare));
			System.out.println("YOU WIN!  +" + BlackJackBonus.winOfBonus(fare));
			return;
		}
		if (dealerResult == BJResult.BAN_LUCK) {
			gamePlayer.setShojikin(shojikin + BlackJackBonus.lose(fare));
			System.out.println("YOU LOSE!  " + BlackJackBonus.lose(fare));
			return;
		}

		if (playerResult == BJResult.BUSTS) {
			if (dealerResult == BJResult.BUSTS) {
				System.out.println("EQUALIZE");
				return;
			} else {
				gamePlayer.setShojikin(shojikin + BlackJackBonus.lose(fare));
				System.out.println("YOU LOSE!  " + BlackJackBonus.lose(fare));
				return;
			}
		}
		if (dealerResult == BJResult.BUSTS) {
			gamePlayer.setShojikin(shojikin + BlackJackBonus.winOfBonus(fare));
			System.out.println("YOU WIN!  +" + BlackJackBonus.winOfBonus(fare));
			return;
		}
		if (playerResult == BJResult.PLAYER_OF_FREE_HAND && dealerResult == BJResult.DEALER_OF_FREE_HAND) {
			int playerPoints = playerResult.getValue();
			int dealerPoints = dealerResult.getValue();
			if (playerPoints == dealerPoints) {
				System.out.println("aiko");
				return;

			}
			if (playerPoints > dealerPoints) {
				gamePlayer.setShojikin(shojikin + BlackJackBonus.winOfBonus(fare));
				System.out.println("YOU WIN!  +" + BlackJackBonus.winOfBonus(fare));
			} else {
				gamePlayer.setShojikin(shojikin + BlackJackBonus.lose(fare));
				System.out.println("YOU LOSE!  " + BlackJackBonus.lose(fare));
			}
		}
	}

	public void showResult(BJResult dealeResult, BJResult playerResult) {
		System.out.println();
		if (playerResult == BJResult.PLAYER_OF_FREE_HAND) {
			System.out.println("あなたのポイント: " + playerResult.getValue());
		} else {
			System.out.println("あなたの結果: " + playerResult);
		}
		if (dealeResult == BJResult.DEALER_OF_FREE_HAND) {
			System.out.println("チェンボットのポイント　： " + dealeResult.getValue());
		} else {
			System.out.println("チェンボットの結果: " + dealeResult);

		}
	}

//	public static void main(String[] args) {
//		GamePlayer player = new GamePlayer("TEST CASE 01");
//		BlackJackHandle handle = new BlackJackHandle();
//		BlackJackDealer dealer = new BlackJackDealer(handle);
//		BlackJackPlayer player2 = new BlackJackPlayer(handle, player);
//		BlackJackToCompete compete = new BlackJackToCompete(dealer, player2);
//		int fare = 100;
//		ArrayList<Card> cards = new ArrayList<Card>();
//		cards.add(new Card(1, "♥"));
//		cards.add(new Card(2, "♥"));
//		cards.add(new Card(3, "♥"));
//		cards.add(new Card(4, "♥"));
//		cards.add(new Card(5, "♥"));
//		
//		compete.compete(BJResult.BAN_LUCK, BJResult.BAN_LUCK, fare);
//		
//	}
}
