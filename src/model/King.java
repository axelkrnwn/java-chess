package model;

import helpers.IsValidCell;

public class King extends Piece{
	
	public King(int x, int y, boolean isBlack) {
		super(x, y, isBlack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int x, int y, Piece[][] board) {
		// TODO Auto-generated method stub
		if (!IsValidCell.check(x, y) || 
			(int) Math.abs(x - getX()) != 1 || 
			(int) Math.abs(y - getY()) != 1 || 
			board[y][x].isBlack() == this.isBlack()) {
			return;
		}
		if (board[y][x] != null) board[y][x].setAlive(false);
		board[y][x] = this;
		board[getY()][getX()] = null;
		this.set(x,y);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.print("K");
	}

}
