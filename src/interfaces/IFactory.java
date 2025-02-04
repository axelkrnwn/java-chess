package interfaces;

import model.Piece;

public interface IFactory {
	
	public Piece create();
	public void setX(int x);
	public void setY(int y);
	public void setBlack(boolean isBlack);

}
