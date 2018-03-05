package ballPath;

import processing.core.PApplet;
import java.util.*;

public class Runner extends PApplet
{
	int stage = 0;
	int startingX;
	int startingY;
	Ball b = new Ball(this, 0, 0);
	
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
			fill(0, 0, 255);
			endFlag = true;
		}
	}
	
	public void mousePressed()
	{	
		if(stage == 1)
		{
			if(startFlag)
			{
				fill(255, 0, 0);
				startingX = (int)(mouseX/90*90) + 45;
				startingY = (int)(mouseY/90*90) + 45;
				b.setPos(startingX, startingY);
				startFlag = false;
			}
			else if(! endFlag)
				fill(255);
			
			rect(mouseX/90*90, mouseY/90*90, 90, 90);
			
			if(endFlag)
			{
				stage = 2;
				fill(50);
				rect(0, 0, 89, 89);
			}
		}
		
		b.setSpeed(random(-5, 6), random(-5, 6));
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
	
	
	public void drawStage1()
	{
		if(stage1Flag)
		{
			fill(50);
			rect(-20, -20, width + 20, height + 20);
			stage1Flag = false;
		}
		
		stroke(255);
		
		for(int i = 90; i < width; i += 90)
		{
			line(i, 0, i, height);
		}
		
		for(int i = 90; i < height; i += 90)
		{
			line(0, i, width, i);
		}
	}
	
	public void drawStage2()
	{
		if(stage1Flag)
		{
			background(50);
			stage1Flag = false;
		}
		
		stroke(255);
		
		for(int i = 90; i < width; i += 90)
		{
			line(i, 0, i, height);
		}
		
		for(int i = 90; i < height; i += 90)
		{
			line(0, i, width, i);
		}
		
		b.drawBall();
		b.moveBall();
		
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
		System.out.println(get(mouseX, mouseY));
	}
}








