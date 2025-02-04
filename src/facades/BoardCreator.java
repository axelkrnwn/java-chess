package facades;

import java.util.ArrayList;

import factories.BishopFactory;
import factories.KingFactory;
import factories.KnightFactory;
import factories.PawnFactory;
import factories.QueenFactory;
import factories.RookFactory;
import interfaces.IFactory;
import model.Piece;

public class BoardCreator {
	
	private IFactory factory;
	private int width = 8, height = 8;
	
	private void initPawn(Piece[][] board, boolean isBlack) {
		int start = isBlack ? 1 : height - 2;
		factory = new PawnFactory(0, start, isBlack);
		for (int i = 0;i < width;i++) {
			factory.setX(i);
			board[start][i] = factory.create();
		}
	}
	
	private void initGuards(Piece[][] board, IFactory factory, int val) {
		board[0][val] = factory.create();
		factory.setX(width - 1 - val);
		board[0][width - 1 - val] = factory.create();
		factory.setY(height - 1);
		factory.setBlack(false);
		board[height - 1][width - 1- val] = factory.create();
		factory.setX(val);
		board[height - 1][val] = factory.create();
	}
	
	private void initKingAndQueen(Piece[][] board, boolean isBlack) {
		int start = isBlack ? 0 : height - 1;
		factory = new KingFactory(4, start, isBlack);
		board[start][4] = factory.create();
		factory = new QueenFactory(3, start, isBlack);
		board[start][3] = factory.create();
		
	}
	
	public void initList(Piece[][] board, ArrayList<Piece> list, int startY, int height) {
		for(int i = startY;i < startY + height;i++) {
			for (int j = 0;j < 8;j++) {
				list.add(board[i][j]);
			}
		}
	}
	
	public Piece[][] initialize(ArrayList<Piece> black, ArrayList<Piece> white){
		Piece[][] board = new Piece[height][width];
		
		initPawn(board, true);
		initPawn(board, false);
		factory = new RookFactory(0, 0, true);
		initGuards(board, factory, 0);
		factory = new KnightFactory(0, 1, true);
		initGuards(board, factory, 1);
		factory = new BishopFactory(0, 2, true);
		initGuards(board, factory, 2);
		
		initKingAndQueen(board, true);
		initKingAndQueen(board, false);
		initList(board, black, 0, 2);
		initList(board, white, 6, 2);
		
		return board;
	}
	
}
