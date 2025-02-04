package model;

public abstract class Piece {
	
	private int x, y;
	private boolean isAlive;
	private boolean isBlack;
	
	public Piece(int x, int y, boolean isBlack) {
		super();
		this.x = x;
		this.y = y;
		this.isAlive = true;
		this.isBlack = isBlack;
	}

	public abstract void move(int x,int y, Piece[][] board);
	
	public abstract void show();

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isBlack() {
		return isBlack;
	}

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}
	
	
}