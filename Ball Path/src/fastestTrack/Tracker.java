package fastestTrack;

import processing.core.PApplet;

public class Tracker extends PApplet
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
		noStroke();
		obj1 = new Obj(50, height/5, 0, 0, 10, (double) Math.toRadians(90), this);
	}
	
	public void draw()
	{
		background(0);
		
		obj1.acc();
		obj1.drawSelf();
		
//		obj1.theta -= .007;
		
		System.out.println(Math.toDegrees(obj1.theta));
		
//		System.out.println(Math.asin(obj1.xvel) + Math.acos(obj1.yvel));
	}
	
	
}
