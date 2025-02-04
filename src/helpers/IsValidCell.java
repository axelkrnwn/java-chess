package helpers;

public class IsValidCell {

	public static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x <= 7 && y <= 7;
	}
}
