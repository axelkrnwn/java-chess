package view;

import java.util.Scanner;

import helpers.Screen;

public class MenuView {
	
	Scanner scan = new Scanner(System.in);
	
	public int inputOption() {
		System.out.println("  Input Option >> ");
		int input = scan.nextInt();
		scan.nextLine();
		return input;
	}
	
	public void display() {
		Screen.clear();
		System.out.println("  DJumbo chess");
		System.out.println("  1. Play");
		System.out.println("  2. How to play");
		System.out.println("  3. Exit");
	}
	
	public void howToPlay() {
		Screen.clear();
		System.out.println("  ============================");
		System.out.println("  How to play");
		System.out.println("  ============================");
		System.out.println("  [1] Just like usual chess, there are chess pieces such as pawn, knight, rook, etc.");
		System.out.println("  [2] The movement also as same as the usual chess");
		System.out.println("  [3] The only different is how to win, you win if all of the opponent's piece has been defeated");
		scan.nextLine();
	}

}
