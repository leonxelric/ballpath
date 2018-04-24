package ballPath;

import processing.core.PApplet;

public class Square extends PApplet
{
	private PApplet parent;
	private int xPos, yPos;
	private boolean isLit;
	
	public Square(PApplet p, int x, int y, boolean lit)
	{
		xPos = x;
		yPos = y;
		isLit = lit;
	}
	
	public void drawSquare()
	{
		if(isLit)
			fill(255);
		else
			fill(50);
		
		parent.stroke(255);
		parent.rect(xPos, yPos, 90, 90);
	}

}
