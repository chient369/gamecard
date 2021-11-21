package common;

import java.util.Scanner;

import common.player.GamePlayer;

public class GameInput {
	private static Scanner sc = new Scanner(System.in);

	public static int inputKakekin(GamePlayer player) {
		int kakekin = 0;
		String input = sc.next();
		boolean check = true;
		while (check) {
			try {
				kakekin = Integer.parseInt(input);
				if (kakekin == 9999) {
					break;
				}
				if (kakekin > player.getShojikin()) {
					System.err.println("所持金以下の掛け金を入力してください");
					input = sc.next();
				} else {
					check = false;
				}
				if (kakekin < 0) {
					System.err.println("非負の掛け金を入力してください");
					input = sc.next();

				}

			} catch (Exception e) {
				System.err.println("正しく入力してください");
				input = sc.next();

			}
		}
		return kakekin;
	}

	public static int inputCard() {
		int card = 0;
		String input = sc.next();
		boolean check = true;
		while (check) {
			try {
				card = Integer.parseInt(input);
				check = false;
				if (card < 1 || card > 13) {
					System.err.println("予測のカードは1以上、13以下を入力すること！");
					input = sc.next();
					check = true;

				}

			} catch (Exception e) {
				System.err.println("正しく入力してください");
				input = sc.next();
				check = true;
			}
		}
		return card;
	}

	public static int inputSentaku() {
		int sentaku = 0;
		String input = sc.next();
		boolean check = true;
		while (check) {

			try {
				sentaku = Integer.parseInt(input);
				check = false;
				if (sentaku < 0 || sentaku > 2) {
					System.err.println("正しく選択してください");
					input = sc.next();
					check = true;
				}
			} catch (Exception e) {
				System.err.println("正しく入力してください");
				input = sc.next();
				check = true;

			}
		}
		return sentaku;
	}

	public static int inputChoose() {
		int choose = 0;

		boolean check = true;
		while (check) {
			String input = sc.next();
			try {
				choose = Integer.parseInt(input);
				check = false;

			} catch (Exception e) {
				System.err.println("正しく入力してください");

			}
		}
		return choose;
	}

	public static String inputName() {
		return sc.next();
	}

}
