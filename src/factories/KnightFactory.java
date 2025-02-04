package factories;

import interfaces.IFactory;
import model.Knight;
import model.Piece;

public class KnightFactory implements IFactory{
	
	private int x, y;
	private boolean isBlack;
	
	public KnightFactory(int x, int y, boolean isBlack) {
		super();
		this.x = x;
		this.y = y;
		this.isBlack = isBlack;
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
		return new Knight(x, y, isBlack);
	}
	

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}
	
	

}
