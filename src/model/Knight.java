package model;

import helpers.IsValidCell;

public class Knight extends Piece{


	public Knight(int x, int y, boolean isBlack) {
		super(x, y, isBlack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int x, int y, Piece[][] board) {
		// TODO Auto-generated method stub
		//x = 1, y = 7
		//x = 2, y = 5
		
		if (!IsValidCell.check(x, y) || 
			(!isL(this.getX(), this.getY(), x, y) && !isL(this.getY(), this.getX(), y, x)) ||
			(board[y][x] != null && board[y][x].isBlack() == this.isBlack())
		) {
			System.out.println("invalid");
			return;
		}
		if (board[y][x] != null) board[y][x].setAlive(false);
		board[y][x] = this;
		board[getY()][getX()] = null;
		this.set(x, y);
	}
	
	public boolean isL(int srcA, int srcB, int dstA, int dstB) {
		return (int) Math.abs(srcA - dstA) == 2 && ((int) Math.abs(srcB - dstB) == 1);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.print("L");
	}

}
