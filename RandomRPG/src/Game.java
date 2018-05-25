import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import Entity.BaseEntity;

public class Game extends Canvas implements Runnable{
	private Thread t;
	private boolean running = false; 
	private static int x = 0;
	
	private static BaseEntity entity;
	
	public static void main(String args[]){
		entity = new BaseEntity(0,0,0);
		
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KeyListener key = new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch(e.getKeyCode()){
					case KeyEvent.VK_D:
						System.out.println(e.getKeyChar());
						x++;
						entity.moveRight();
						break;
					case KeyEvent.VK_A:
						entity.moveLeft();
						break;
					case KeyEvent.VK_W:
						entity.moveTop();
						break;
					case KeyEvent.VK_S:
						entity.moveBot();
						break;
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		game.addKeyListener(key);
		game.start();//Inicializa a Thread que inicializa o método run
	}
	
	public synchronized void start(){
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run(){
		System.out.println("Game running");
		running = true;
		
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			//game loop
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + "Ticks,Fps " +frames);
				updates = 0;
				frames = 0;
			}
			
		}
	}

	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();//anything below this you can draw
		
		entity.render(g);
		g.draw3DRect(x, 50, 50, 50, true);
		
		g.dispose();
		bs.show();
	}
}
