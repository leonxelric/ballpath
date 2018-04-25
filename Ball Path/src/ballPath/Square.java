package ballPath;

import processing.core.PApplet;

public class Square extends PApplet
{
	private PApplet parent;
	private int xPos, yPos;
	private boolean isLit, isStart, isEnd;
	
	public Square(PApplet p, int x, int y, boolean lit)
	{
		parent = p;
		xPos = x;
		yPos = y;
		isLit = lit;
	}
	
	public void drawSquare()
	{
		if(isLit)
			parent.fill(255);
		else if(isStart)
			parent.fill(255, 0, 0);
		else if(isEnd)
			parent.fill(0, 255,0);
		else
			parent.fill(50);
		
		parent.stroke(255);
		parent.rect(xPos, yPos, 90, 90);
	}
	
	public void enlighten()
	{
		isLit = true;
		isStart = false;
		isEnd = false;
	}
	
	public void makeStart()
	{
		isLit = false;
		isStart = true;
		isEnd = false;
	}
	
	public void makeEnd()
	{
		isLit = false;
		isStart = false;
		isEnd = true;
	}

}






