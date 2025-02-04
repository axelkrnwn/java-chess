package model;

import helpers.IsValidCell;
import interfaces.IDiagonal;

public class Bishop extends Piece implements IDiagonal{

	public Bishop(int x, int y, boolean isBlack) {
		super(x, y, isBlack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int x, int y, Piece[][] board) {
		// TODO Auto-generated method stub
		if ((this.getX() == x && this.getY() == y) 
				|| !this.canDiagonal(x, y) 
				|| !IsValidCell.check(x, y)
				|| isObstructed(board, x, y)
				|| (board[y][x] != null && board[y][x].isBlack() == this.isBlack())) {
			System.out.println("invalid here");
			return;
		}
		if (board[y][x] != null) board[y][x].setAlive(false);
		board[y][x] = this;
		board[getY()][getX()] = null;
		this.set(x, y);	
	}

	@Override
	public boolean canDiagonal(int x, int y) {
		// TODO Auto-generated method stub
		return (int) Math.abs(this.getX() - x) == (int) Math.abs(this.getY() - y);
	}
	
	private boolean isObstructed(Piece[][] board, int x, int y) {
		for (int i = 1;i < (int)Math.abs(getX() - x);i++) {
			if (getX() > x) {
				if (getY() > y) {
					if (board[getY() - i][getX() - i] != null) {
						return true;
					}
				}else {
					if (board[getY() + i][getX() - i] != null) {
						return true;
					}
				}
			}else if (getX() < x) {
				if (getY() > y) {
					if (board[getY() - i][getX() + i] != null) {
						return true;
					}
				}else {
					if (board[getY() + i][getX() + i] != null) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.print("B");
	}

}
