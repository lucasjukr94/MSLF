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
	//m�todo iniciado quando a thread der start
	//m�todo da interface Runnable, � obrigat�rio ser nomeado run
	public void run() {
		//System.out.println("funcionou");
		init();
	}
	
	//m�todo de configura��o inicial
	public void init() {
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setTitle("MSFL");
		frame.setLocation(0, 0);
		frame.add(mainproj);
	}
	
	//m�todo paint � o m�todo padr�o da classe abstrata canvas
	//obrigat�rio ser nomeado paint
	//o m�todo � instanciado automaticamente pelo awt, n�o sendo necess�rio passar um objeto Graphics e instanci�-lo
	public void paint(Graphics g) {
		base.render(g);
		g.dispose();
	}
}
