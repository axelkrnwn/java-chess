package factories;

import interfaces.IFactory;
import model.Piece;
import model.Queen;

public class QueenFactory implements IFactory{

	private int x, y;
	private boolean isBlack;

	public QueenFactory(int x, int y, boolean isBlack) {
		super();
		this.x = x;
		this.isBlack = isBlack;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public Piece create() {
		// TODO Auto-generated method stub
		return new Queen(x, y, isBlack);
	}
	

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}
	
}
