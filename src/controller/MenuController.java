package controller;

import helpers.Logo;
import view.MenuView;

public class MenuController {

	MenuView menuView;
	ChessController chess;
	
	public MenuController() {
		menuView = new MenuView();
		chess = new ChessController();
	}
	
	public void option(int key) {
		switch (key) {
		case 1:
			chess.play();
			break;
		case 2:
			menuView.howToPlay();
			break;
		}
	}
	
	public void play() {
		while (true) {
			menuView.display();
			int input;
			do {
				input = menuView.inputOption();
			}while(input < 1 || input > 3);
			if (input == 3) { Logo.printLogo();return; }
			option(input);
		}
		
	}
}
