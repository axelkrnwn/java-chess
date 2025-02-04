package view;

import java.util.Scanner;

import helpers.Screen;
import model.Piece;

public class ChessView {
	private Scanner scan = new Scanner(System.in);
	
	public int[] inputCoordinate() {
		int srcX, srcY;
		System.out.print("  Input piece coordinate (x y): ");
		srcX = scan.nextInt();
		srcY = scan.nextInt();
		scan.nextLine();				
		return new int[]{srcX - 1, srcY - 1};
	}
	
	public void displayResult(boolean isBlack) {
		Screen.clear();
		System.out.print(isBlack?"  Player 2 win!\n":"");
		System.out.print(!isBlack?"  Player 1 win!\n":"");
	}
	
	public void display(Piece[][] board, boolean isBlack) {
		Screen.clear();
		System.out.println("  Player 2" + (isBlack?" <<":""));
		System.out.println("   1 2 3 4 5 6 7 8 ");
		for (int i = 0;i < 17;i ++) {
			
			if (i % 2 == 0) {
				System.out.print("  +" + "-+".repeat(8));
			}else {
				System.out.print(" " + (i/2+1));
				for (int j = 0;j < 17;j ++) {
					if (i%2 == 1) {
						if (j%2 == 1) {
							if (board[i/2][j/2] != null) {
								board[i/2][j/2].show();
							}else {
								System.out.print(" ");
							}													
						}else {
							System.out.print("|");
						}
					}
				}				
			}
			System.out.println();
		}
		System.out.println("  Player 1" + (!isBlack?" <<":""));
	}

}
