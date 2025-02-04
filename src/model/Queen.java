package model;

import helpers.IsValidCell;
import interfaces.IDiagonal;
import interfaces.IStraight;

public class Queen extends Piece implements IStraight, IDiagonal{

	
	public Queen(int x, int y, boolean isBlack) {
		super(x, y, isBlack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canDiagonal(int x, int y) {
		// TODO Auto-generated method stub
		return (int) Math.abs(this.getX() - x) == (int) Math.abs(this.getY() - y);
	}

	@Override
	public boolean canStraight(int x, int y) {
		// TODO Auto-generated method stub
		return this.getX() == x || this.getY() == y;
	}

	@Override
	public void move(int x, int y, Piece[][] board) {
		// TODO Auto-generated method stub
		if ((!this.canDiagonal(x, y) && !this.canStraight(x, y)) 
				|| !IsValidCell.check(x, y)
				|| isObstructedDiagonal(board, x, y) 
				|| isObstructedStraight(board, x, y)
				|| (board[y][x] != null && board[y][x].isBlack() == isBlack())) {
			System.out.println("invalid queen");
			return;
		}
		if (board[y][x] != null) board[y][x].setAlive(false);
		board[y][x] = this;
		board[getY()][getX()] = null;
		this.set(x,y);
	}
	
	private boolean isObstructedDiagonal(Piece[][] board, int x, int y) {
		if (getX() > x) {
			if (getY() > y) {
				for (int i = x+1, j = y+1;i < getX() && j < getY();i++,j++) {
					if (board[j][i] != null) {
						return true;
					}
				}
			}else {
				for (int i = x+1, j = getY()-1;i < getX() && j > y;i++,j--) {
					if (board[j][i] != null) {
						return true;
					}
				}
			}
		}else if (getX() < x) {
			if (getY() < y) {
				for (int i = getX()+1, j = getY()+1;i < x && j < y;i++,j++) {
					if (board[j][i] != null) {
						return true;
					}
				}
			}else {
				for (int i = getX()+1, j = getY()-1;i < x && j < getY();i++,j--) {
					if (board[j][i] != null) {
						return true;
					}
				}
			}
		}
		return false;
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
	
	private boolean isObstructedStraight(Piece[][] board, int x, int y) {
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
		System.out.print("Q");
	}

}
