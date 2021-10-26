package haikado;

import java.util.Random;
import java.util.Scanner;

public class main {

	static int shojikin = 1000;
	static int kaisu = 0;
	static Random rand = new Random();
	static Scanner stdIn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] cardlist = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		boolean keizoku = true;
		while (keizoku) {
			int num1 = getNum();
			System.out.println("num 1 :" + num1);
			System.out.println("利用者がいくら賭けるかをキーボードで入力");
			System.out.print("掛け金：");
			int kakekin = stdIn.nextInt();
			System.out.println("0. 弱いと思う\n1. 強いと思う\n2. ピタリ賞");
			int kakeru = stdIn.nextInt();
			System.out.print("num2 :");
			int num2 = getNum();
			System.out.println("num2 :" + num2);
			kakeru(kakeru, num1, num2, kakekin);
			show();

			if (shojikin < 100 || shojikin > 100000) {
				keizoku = false;
			}
		}

	}

	public static void pitariNum() {
		int num = stdIn.nextInt();

	}

	public static void kakeru(int kakeru, int num1, int num2, int kakekin) {
		if (kakeru == 0) {
			if (num1 > num2) {
				kachi(kakekin);
				System.out.println("ok");
				show();

			} else {
				make(kakekin);
				show();
			}

		} else if (kakeru == 1) {
			if (num1 < num2) {
				kachi(kakekin);
				show();

			} else {
				make(kakekin);
				show();
			}

		} else {
			System.out.println("era!");
		}

	}

	public static void show() {
		System.out.println("所持金 : " + shojikin);
		System.out.println("回数目 : " + kaisu);

	}

	public static int getNum() {
		return rand.nextInt(13);
	}

	public static void kachi(int kakekin) {
		kaisu++;
		shojikin += kakekin;

	}

	public static void make(int kakekin) {
		kaisu++;
		shojikin -= kakekin;

	}

	public static void pitari(int kakekin) {
		shojikin += 12 * kakekin;
	}

}
