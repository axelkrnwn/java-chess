package controller;

import java.util.ArrayList;

import facades.BoardCreator;
import helpers.IsValidCell;
import model.Piece;
import view.ChessView;

public class ChessController {

	private BoardCreator chessCreator = new BoardCreator();
	private Piece[][] board;
	private ChessView view;
	private ArrayList<Piece> black, white;
	private boolean isBlack;
	
	public ChessController() {
		view = new ChessView();
		black = new ArrayList<>();
		white = new ArrayList<>();
	}
	
	public boolean isDefeated(ArrayList<Piece> pieces) {
		for (Piece p: pieces) {
			if (p.isAlive()) return false;
		}
		black.clear();
		white.clear();
		return true;
	}
	
	public void play() {
		isBlack = false;
		board = chessCreator.initialize(black, white);
		
		while(!isDefeated(black) && !isDefeated(white)) {
			view.display(board, isBlack);
			int[] src, dst;			
			do {		
				System.out.print("  [Choose the piece to be moved]");
				src = view.inputCoordinate();
			}while(!IsValidCell.check(src[0], src[1]) || board[src[1]][src[0]] == null || board[src[1]][src[0]].isBlack() != isBlack);	
			do {
				System.out.print("  [Choose the destination]");
				dst = view.inputCoordinate();
			}while(!IsValidCell.check(dst[0], dst[1]) || dst[0] == src[0] && dst[1] == src[1]);
			board[src[1]][src[0]].move(dst[0], dst[1], board);
			if (board[src[1]][src[0]] == null) isBlack = !isBlack;
		}
		view.displayResult(isBlack);
	}
	
}
