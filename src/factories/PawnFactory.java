package factories;

import interfaces.IFactory;
import model.Pawn;
import model.Piece;

public class PawnFactory implements IFactory{

	private int x;
	private int y;
	private boolean isBlack;
	
	public PawnFactory(int x, int y, boolean isBlack) {
		super();
		this.x = x;
		this.y = y;
		this.isBlack = isBlack;
	}

	@Override
	public Piece create() {
		// TODO Auto-generated method stub
		return new Pawn(x, y, isBlack);
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
