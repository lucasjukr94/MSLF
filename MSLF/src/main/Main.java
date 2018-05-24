package main;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable{
	private BaseEntity base = new BaseEntity(100,100,100);
	private JFrame frame = new JFrame();
	private static Main mainproj = new Main();
	
	public static void main(String args[]) {
		Thread t = new Thread(mainproj);
		t.start();
	}

	@Override
	//método iniciado quando a thread der start
	//método da interface Runnable, é obrigatório ser nomeado run
	public void run() {
		//System.out.println("funcionou");
		init();
	}
	
	//método de configuração inicial
	public void init() {
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setTitle("MSFL");
		frame.setLocation(0, 0);
		frame.add(mainproj);
	}
	
	//método paint é o método padrão da classe abstrata canvas
	//obrigatório ser nomeado paint
	//o método é instanciado automaticamente pelo awt, não sendo necessário passar um objeto Graphics e instanciá-lo
	public void paint(Graphics g) {
		base.render(g);
		g.dispose();
	}
}
