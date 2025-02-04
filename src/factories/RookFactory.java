package factories;

import interfaces.IFactory;
import model.Piece;
import model.Rook;

public class RookFactory implements IFactory {

	private int x, y;
	private boolean isBlack;
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public RookFactory(int x, int y, boolean isBlack) {
		super();
		this.x = x;
		this.y = y;
		this.isBlack = isBlack;
	}

	@Override
	public Piece create() {
		// TODO Auto-generated method stub
		return new Rook(x, y, isBlack);
	}
	

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}

}
