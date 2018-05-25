package Entity;

import java.awt.Graphics;

public class BaseEntity {
	private int x,y,z;
	public BaseEntity(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void render(Graphics g) {
		g.drawRect(x, y, 50, 50);
	}
	
	public void moveRight() {
		x++;
	}
	
	public void moveLeft() {
		x--;
	}
	
	public void moveTop() {
		y++;
	}
	
	public void moveBot() {
		y--;
	}
}
