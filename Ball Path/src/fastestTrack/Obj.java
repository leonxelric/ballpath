package fastestTrack;

import processing.core.PApplet;

public class Obj
{
	PApplet p;
	int x;
	int y;
	int dia;
	
	public Obj(int x, int y, int dia, PApplet parent)
	{
		this.x = x;
		this.y = y;
		this.dia = dia;
		p = parent;
	}
	
	public void drawSelf()
	{
		p.ellipse(x, y, dia, dia);
	}
	
	public void move(float x, float y)
	{
		this.x += x;
		this.y += y;
	}
}
