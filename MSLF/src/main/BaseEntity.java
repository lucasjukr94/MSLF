package main;

import java.awt.Graphics;

public class BaseEntity{
	private int x;
	private int y;
	private int z;
	
	public BaseEntity(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void render(Graphics g) {
		g.drawRect(50, 50, x, y);
	}
}
