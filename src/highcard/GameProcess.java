package highcard;

import highcard.card.CardHandle;
import highcard.player.Player;

public class GameProcess {
	private Player player;

	public GameProcess(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void gameProccess(GameProcess shobu) {
		boolean keizoku = true;
		System.out.println("ゲーム開始");
		System.out.println("🥀🥀🥀🥀🥀🥀🥀🥀🥀🥀");
		player.showPlayer();
		while (keizoku) {
			System.out.print("掛け金を入力してください : ");
			int kakekin = Input.inputKakekin();

			if (kakekin == 9999) {
				System.out.println("ゲーム終了");
				System.out.println("+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			while (kakekin > player.getShojikin()) {
				System.out.println("所持金以下の掛け金を入力してください　");
				kakekin = Input.inputKakekin();

			}

			CardHandle card_1 = new CardHandle();
			System.out.println("カード1 : "+ card_1.getCardFull());

			System.out.println("カード2 は カード1 より： \n 0. 弱い \n 1. 強い \n 2. ピタリ賞を狙う");
			int sentaku = Input.inputSentaku();
			CardHandle card_2 = new CardHandle();
			if (sentaku != 2) {
				System.out.println("カード　2 : "+ card_2.getCardFull());
			}
			shobu.kekka(sentaku, card_1, card_2, kakekin);
			Player player = shobu.getPlayer();
			if (player.getShojikin() < 100 || player.getShojikin() > 100000) {
				if (player.getShojikin() < 0) {
					player.saigo(kakekin);
				}
				System.out.println("ゲーム終了");
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+");

				keizoku = false;
			}

		}

	}

	public void kekka(int sentaku, CardHandle card_1, CardHandle card_2, int kakekin) {
		if (sentaku == 0) {
			if (card_1.isBiggerThan(card_2)) {
				player.kachi(kakekin);
				player.showPlayer();

			} else {
				player.make(kakekin);
				player.showPlayer();
			}

		} else if (sentaku == 1) {
			if (card_2.isBiggerThan(card_1)) {
				player.kachi(kakekin);
				player.showPlayer();
			} else {
				player.make(kakekin);
				player.showPlayer();
			}
		} else if (sentaku == 2) {
			pitari(card_2, kakekin);
		} else {
			System.err.println("正しく選択してください");
		}
	}

	public void pitari(CardHandle card_2, int kakekin) {
		System.out.print("次のカードはどの数値と思いますか : ");
		int yosoku = Input.inputCard();
		System.out.println("結果。。。。 カード2　は： "+ card_2.getCardFull());
		if (card_2.getCardNum() == yosoku) {
			System.out.println("おめでとうございます！🎆🎆🎆");
			System.out.printf("ピタリ賞 : %d \n", 12 * kakekin);
			player.pitari(kakekin);
			player.showPlayer();
		} else {
			System.out.println("惜しかったね！\n");
		}
	}

}
