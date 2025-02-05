package model;

import helpers.IsValidCell;

public class Pawn extends Piece{
	
	private int moveAmount;
	
	public Pawn(int x, int y, boolean isBlack) {
		super(x, y, isBlack);
		this.moveAmount = 2;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int x, int y, Piece[][] board) 
	{
		if (!IsValidCell.check(x+1, y+1)) {
			return;
		}
		boolean eat = false;
		if (this.isBlack()) {
			
			if ((int)Math.abs(x - getX()) == 1 && 
				(int)Math.abs(y - getY()) == 1 && 
				board[y][x] != null && 
				board[y][x].isBlack()) {
				board[y][x].setAlive(false);
				eat = true;
			}
			if (!eat && !(x == getX() && y > getY() && y <= getY() + moveAmount)) {
				return;
			}
			
		}else {
			if ((int)Math.abs(x - getX()) == 1 && 
				(int)Math.abs(y - getY()) == 1 && 
				board[y][x] != null && 
				board[y][x].isBlack()) {
				eat = true;
				board[y][x].setAlive(false);
			}
			if (!eat && !(x == getX() && y < getY() && y >= getY() - moveAmount && board[y][x] == null)) {
				return;
			}
		}
		board[y][x] = this;
		board[getY()][getX()] = null;
		this.set(x, y);
		System.out.println("success");
		this.moveAmount = 1;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.print("P");
	}

}
