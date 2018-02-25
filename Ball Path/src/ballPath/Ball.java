package ballPath;

import java.util.*;
import processing.core.PApplet;

public class Ball 
{
	private ArrayList<Integer> instructions;
	private PApplet parent;
	private double posX;
	private double posY;
	private double changeX;
	private double changeY;
	
	public Ball(PApplet p, int startX, int startY)
	{
		parent = p;
		posX = startX;
		posY = startY;
		instructions = new ArrayList<Integer>();
	}
	
	public void setSpeed(double speedX, double speedY)
	{
		changeX = speedX;
		changeY = speedY;
	}
	
	public void moveBall()
	{
//		for(int i = 0; i < instructions.size(); i++)
//		{
//			if(instructions.get(i) == 0)
//				posY -= 8;
//			else if(instructions.get(i) == 1)
//				posX += 8;
//			else if(instructions.get(i) == 2)
//				posY += 8;
//			else if(instructions.get(i) == 3)
//				posX -= 8;
//			parent.background(0);
//			drawBall();
//		}
		
		posX += changeX;
		posY += changeY;
	}
	
	public void changeVelocity(int newXMove, int newYMove)
	{
		
	}
	
	public void drawBall()
	{
		parent.fill(50, 200, 0);
		parent.ellipse((float)posX, (float)posY, 50, 50);
	}
	
	public void addMove(int move)
	{
		
		instructions.add(move);
	}
	
	public int getDiffMove()
	{
		int move = (int)parent.random(0, 4);
		if(instructions.size() < 1)
			return move;
		while(move == instructions.get(instructions.size() - 1))
			move = (int)parent.random(0, 4);
		return move;
	}
	
	public void removeMove()
	{
		instructions.remove(instructions.size() - 1);
	}
	
	public boolean inBounds(int rectX, int rectY, int size)
	{
		return (posX > rectX && posX < rectX + size) && ((posY > rectY && posY < rectY + size));
	}
	
	public void setPos(double pX, double pY)
	{
		posX = pX;
		posY = pY;
	}
	
	public ArrayList<Integer> getInstruct()
	{
		return instructions;
	}
	
	public double getX()
	{
		return posX;
	}
	
	public double getY()
	{
		return posY;
	}
	
	public double sX()
	{
		return changeX;
	}
	
	public double sY()
	{
		return changeY;
	}
}
