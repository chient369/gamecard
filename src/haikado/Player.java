package haikado;

public class Player {
	static int shojikin = 1000;
	static int kaisu = 0;
	public static  int kachi(int kakekin) {
		kaisu++;
		return shojikin + kakekin;
		
	}
	public static int make (int kakekin) {
		kaisu++;
		return shojikin - kakekin;
		
	}
	public static int pitari(int kakekin) {
		return shojikin + 12 * kakekin;
	}
}

