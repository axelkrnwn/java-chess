package view;

import java.util.Scanner;

import helpers.Screen;
import model.Piece;

public class ChessView {
	private Scanner scan = new Scanner(System.in);
	
	public int[] inputCoordinate() {
		int srcX, srcY;
		System.out.print("  Input piece coordinate (x y) [1-8] >> ");
		srcX = scan.nextInt();
		srcY = scan.nextInt();
		scan.nextLine();				
		return new int[]{srcX - 1, srcY - 1};
	}
	
	public void displayResult(boolean isBlack) {
		Screen.clear();
		System.out.print(isBlack?"  \r\n" + 
				"    ___     _              _  _                             ___           __      __  _               _    \r\n" + 
				"   | _ \\   | |    __ _    | || |   ___      _ _     o O O  |_  )     o O O\\ \\    / / (_)    _ _      | |   \r\n" + 
				"   |  _/   | |   / _` |    \\_, |  / -_)    | '_|   o        / /     o      \\ \\/\\/ /  | |   | ' \\     |_|   \r\n" + 
				"  _|_|_   _|_|_  \\__,_|   _|__/   \\___|   _|_|_   TS__[O]  /___|   TS__[O]  \\_/\\_/  _|_|_  |_||_|   _(_)_  \r\n" + 
				"_| \"\"\" |_|\"\"\"\"\"|_|\"\"\"\"\"|_| \"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| {======|_|\"\"\"\"\"| {======|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_| \"\"\" | \r\n" + 
				"\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'./o--000'\"`-0-0-'./o--000'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-' \r\n" + 
				"\n":"");
		System.out.print(!isBlack?"  \r\n" + 
				"    ___     _              _  _                              _            __      __  _               _    \r\n" + 
				"   | _ \\   | |    __ _    | || |   ___      _ _     o O O   / |      o O O\\ \\    / / (_)    _ _      | |   \r\n" + 
				"   |  _/   | |   / _` |    \\_, |  / -_)    | '_|   o        | |     o      \\ \\/\\/ /  | |   | ' \\     |_|   \r\n" + 
				"  _|_|_   _|_|_  \\__,_|   _|__/   \\___|   _|_|_   TS__[O]  _|_|_   TS__[O]  \\_/\\_/  _|_|_  |_||_|   _(_)_  \r\n" + 
				"_| \"\"\" |_|\"\"\"\"\"|_|\"\"\"\"\"|_| \"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| {======|_|\"\"\"\"\"| {======|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_| \"\"\" | \r\n" + 
				"\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'./o--000'\"`-0-0-'./o--000'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-' \r\n" + 
				"\n":"");
	}
	
	public void display(Piece[][] board, boolean isBlack, String errorMessage) {
		Screen.clear();
		System.out.println("  Player 2\n");
		
		System.out.println("    1-2-3-4-5-6-7-8");
		for (int i = 0;i < 17;i ++) {
			
			if (i % 2 == 0) {
				if (i == 0) System.out.print("   +" + "-+".repeat(8));
				else System.out.print("   +" + "-+".repeat(8));
			}else {
				System.out.print("  " + (i/2+1));
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
			if (i < 16) {
				if (i == 17/2) {
					System.out.print(" y");
					System.out.print("       " + (isBlack?"Player 2 turn":"Player 1 turn"));
				}else{
					System.out.print(" |");		
					if (i == 17/2 + 1) {
						System.out.print("       " + errorMessage);
					}
				}
			}else {
				System.out.print(" v");
			}
			System.out.println();
		}
		System.out.println("   --------x-------->");
		System.out.println();
		System.out.println("  Player 1");
	}

}
