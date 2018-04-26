package ballPath;

import processing.core.PApplet;

public class Runner extends PApplet
{
	int stage = 0;
	int startingX;
	int startingY;
	Ball b = new Ball(this, 0, 0);
	Square[] squares = new Square[200];
	
	public static void main(String[] args)
	{
		PApplet.main("ballPath.Runner");
	}
	
	public void setup()
	{
		b.setSpeed(2, 2);
	}
	
	public void settings()
	{
		size(1800, 900);
	}
	
	public void draw()
	{
		if(stage == 0)
			drawStage0();
		
		if(stage == 1)
			drawStage1();
		
		if(stage == 2)
			drawStage2();
		
		fill(0, 255, 0);
		textSize(70);
		text(stage, 5, 60);
	}
	
	public void keyPressed()
	{
		if(stage == 0 && key == 's')
			stage = 1;
		
		if(stage == 1 && key == 'e')
		{
			endFlag = true;
		}
		
		if(stage == 2 && key == 's')
			b.setSpeed(10, 10);
	}
	
	public int getIndexInSquares()
	{
		return ((mouseY/90)*20) + mouseX/90;
	}
	
	public void mousePressed()
	{	
		if(stage == 1)
		{
			if(startFlag)
			{
				squares[getIndexInSquares()].makeStart();
				startingX = (int)(mouseX/90*90) + 45;
				startingY = (int)(mouseY/90*90) + 45;
				b.setPos(startingX, startingY);
				startFlag = false;
			}
			else if(! endFlag)
				squares[getIndexInSquares()].enlighten();
			
			if(endFlag)
			{
				squares[getIndexInSquares()].makeEnd();
				stage = 2;
			}
		}
		
		int xnegChange = (int) random(0, 2);
		int ynegChange = (int) random(0, 2);
		
		if(xnegChange == 0)
			xnegChange = -1;
		
		if(ynegChange == 0)
			ynegChange = -1;
		
		int speed = (int)(random(-10, 11));
		b.setSpeed(speed*xnegChange, speed*ynegChange);
	}
	
	public void drawStage0()
	{
		fill(0);
		textSize(100);
		text("Persistent Ball", 50, 150);
		fill(255);
		textSize(50);
		text("On the next screen, you will make a path for a ball to follow. \n"
				+ "To make the path, click the squares you want to fill in. \n"
				+ "Stay away from the edges. \n"
				+ "The first square you click will be the starting square. \n"
				+ "To make the end square, press e and then click on where you want it. \n"
				+ "Press the s to go to the next stage.", 50, 250);
	}
	
	boolean stage1Flag = true;
	boolean startFlag = true;
	boolean endFlag = false;
	int index = 0;
	
	public void drawStage1()
	{
		while(index <= 199)
		{
			for(int y = 0; y < 899; y += 90)
			{
				for(int x = 0; x < 1799; x += 90)
				{
					squares[index] = new Square(this, x, y, false);
					squares[index].drawSquare();
					index++;
				}
			}
		}
		
		for(int i = 0; i < 200; i++)
		{
			squares[i].drawSquare();
		}
		
//		if(stage1Flag)
//		{
//			fill(50);
//			rect(-20, -20, width + 20, height + 20);
//			stage1Flag = false;
//		}
//		
//		stroke(255);
//		
//		for(int i = 90; i < width; i += 90)
//		{
//			line(i, 0, i, height);
//		}
//		
//		for(int i = 90; i < height; i += 90)
//		{
//			line(0, i, width, i);
//		}
	}
	
	public void drawStage2()
	{
//		if(stage1Flag)
//		{
//			background(50);
//			stage1Flag = false;
//		}
		
//		stroke(255);
//		
//		for(int i = 90; i < width; i += 90)
//		{
//			line(i, 0, i, height);
//		}
//		
//		for(int i = 90; i < height; i += 90)
//		{
//			line(0, i, width, i);
//		}
		
		for(int i = 0; i < 200; i++)
		{
			squares[i].drawSquare();
		}
		
		b.drawBall();
		
		if(get((int)b.getX() + 27, (int)b.getY()) == -13487566 || get((int)b.getX() - 27, (int)b.getY()) == -13487566)
			b.setSpeed(b.sX() * -1, b.sY());
		
		if(get((int)b.getX(), (int)b.getY() + 27) == -13487566 || get((int)b.getX(), (int)b.getY() -27) == -13487566)
			b.setSpeed(b.sX(), b.sY() * -1);
		
		if(get((int)b.getX(), (int)b.getY() + 27) == -16711936 || get((int)b.getX(), (int)b.getY() -27) == -16711936 
				|| get((int)b.getX() + 27, (int)b.getY()) == -16711936 || get((int)b.getX() - 27, (int)b.getY()) == -16711936)
		{
			b.setSpeed(0, 0);
			textSize(200);
			fill(0, 0, 255);
			text("you wON.!", 50, 500);
		}
	}
	
	public void mouseClicked()
	{
		
	}
}








