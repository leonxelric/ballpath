package fastestTrack;

import processing.core.PApplet;
import processing.core.PConstants;

public class Obj
{
	PApplet p;
	final double scale = (double) .005;
	double x;
	double y;
	double xvel;
	double yvel;
	double theta;
	int dia;
	
	public Obj(double x, double y, double inixvel, double iniyvel, int dia, double iniTheta, PApplet parent)
	{
		this.x = x;
		this.y = y;
		xvel = inixvel;
		yvel = iniyvel;
		this.dia = dia;
		theta = iniTheta;
		p = parent;
	}
	
	public void drawSelf()
	{
		p.ellipse((int) x, (int) y, dia, dia);
	}
	
	public void setVels(double xmov, double ymov)
	{
		xvel = xmov;
		yvel = ymov;
	}
	
	public void move()
	{
		x += xvel;
		y += yvel;
	}
	
	public void move(double x, double y)
	{
		this.x += x;
		this.y += y;
	}
	
	public void acc()
	{
		
		yvel += 9.81 * scale;
		xvel += 9.81 * Math.sin(theta) * scale;
		yvel -= 9.81 * Math.cos(theta) * scale;
		move();
		
//		yvel += 9.81 * (1 - Math.cos(theta)) * .005;
	}
}









































