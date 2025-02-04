package model;

import helpers.IsValidCell;
import interfaces.IStraight;

public class Rook extends Piece implements IStraight{


	public Rook(int x, int y, boolean isBlack) {
		super(x, y, isBlack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int x, int y, Piece[][] board) {
		// TODO Auto-generated method stub
		//7 0
		//7 1
		//6 1 x
		//6 0 v
		if (!this.canStraight(x, y) 
				|| !IsValidCell.check(x, y)
				|| isObstructed(board, x, y)
				|| (board[y][x] != null && board[y][x].isBlack() == this.isBlack())) {
			
			return;
		}
		if (board[y][x] != null) board[y][x].setAlive(false);
		board[y][x] = this;
		board[getY()][getX()] = null;
		this.set(x, y);	
	}

	@Override
	public boolean canStraight(int x, int y) {
		// TODO Auto-generated method stub
		return this.getX() == x || this.getY() == y;
	}
	
	private boolean checkObstructed(Piece[][] board, int start, int end,
			int axis, boolean isY) {
		for (int i = start;i < end; i++) {
			if (isY) {
				if (board[axis][i] != null) {
					board[axis][i].show();
					return true;
				}				
			}else {
				if (board[i][axis] != null) {
					board[i][axis].show();
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isObstructed(Piece[][] board, int x, int y) {
		if (getY() == y) {
			int start = 1 + (x < getX()?x:getX());
			int end = x < getX()?getX():x;
			return checkObstructed(board, start, end, y, true);
		}else if (getX() == x) {
			int start = 1 + (y < getY()? y: getY());
			int end = y < getY()?getY():y;
			return checkObstructed(board, start, end, x, false);
		}
		return false;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.print("R");
	}


}
