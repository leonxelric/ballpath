package ballPath;

import processing.core.PApplet;

public class Runner extends PApplet
{
	int stage = 0;
	int startingX;
	int startingY;
	
	public static void main(String[] args)
	{
		PApplet.main("ballPath.Runner");
	}
	
	public void setup()
	{
		
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
				startingX = (mouseX/100*100) + 45;
				startingY = (mouseY/100*100) + 45;
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
	}
	
	public void drawStage0()
	{
		fill(0);
		textSize(100);
		text("Smart Ball", 50, 150);
		fill(255);
		textSize(50);
		text("On the next screen, you will make a path for a ball to follow. \n"
				+ "To make the path, click the squares you want to fill in. \n"
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
	}

	public void drawStage2()
	{
		
		//run ball thing
	}
}





