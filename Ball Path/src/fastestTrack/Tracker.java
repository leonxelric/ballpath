package fastestTrack;

import processing.core.PApplet;

public abstract class Tracker extends PApplet
{
	
	Obj obj1;
	
	public void settings()
    {
		size(1800, 900);
    }
	
	public static void main(String[] args)
    {
        PApplet.main("fastestTrack.Tracker");
    }
	
	public void setup()
	{
		obj1 = new Obj(50, 50, 10, this);
	}
	
	public void draw()
	{
		obj1.move(width/100, height/100);
	}
	
	
}
