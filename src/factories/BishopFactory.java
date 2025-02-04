package factories;

import interfaces.IFactory;
import model.Bishop;
import model.Piece;

public class BishopFactory implements IFactory{

	private int x;
	private int y;
	private boolean isBlack;
	
	public BishopFactory(int x, int y, boolean isBlack) {
		super();
		this.x = x;
		this.y = y;
		this.isBlack = isBlack;
	}

	@Override
	public Piece create() {
		// TODO Auto-generated method stub
		return new Bishop(x, y, isBlack);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}
	
}
