package pong.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GUI implements KeyListener {
	private static JFrame frame;
	private static Drawing drawPane;

	public void initGUI() {
		frame = new JFrame("Pong");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		drawPane = new Drawing(frame.getHeight(), frame.getWidth());
		frame.addKeyListener(this);
		frame.getContentPane().add(drawPane);
		frame.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("KeyPressed");
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			drawPane.getLeft().setY(drawPane.getLeft().getY() + 15);
		} else if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			drawPane.getLeft().setY(drawPane.getLeft().getY() - 15);
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			drawPane.getRight().setY(drawPane.getRight().getY() + 15);
		} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			drawPane.getRight().setY(drawPane.getRight().getY() - 15);
		}
		drawPane.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("KeyReleased");
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("KeyTyped");
	}

}
