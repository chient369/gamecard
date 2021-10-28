package game.highcard;

import java.util.Scanner;

import game.common.GameInput;

public final class Input extends GameInput {
	private static Scanner sc = new Scanner(System.in);
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
		String input = sc.next();
		boolean check = true;
		while (check) {

			try {
				choose = Integer.parseInt(input);
				check = false;

			} catch (Exception e) {
				System.err.println("正しく入力してください");
				input = sc.next();
				check = true;

			}
		}
		return choose;
	}


}
