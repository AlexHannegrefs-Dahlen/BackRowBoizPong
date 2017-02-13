package pong.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GUI implements KeyListener {
	private static JFrame frame;
	private static Drawing drawPane;

	/**
	 * @return the frame
	 */
	public static JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame
	 *            the frame to set
	 */
	public static void setFrame(JFrame frame) {
		GUI.frame = frame;
	}

	/**
	 * @return the drawPane
	 */
	public static Drawing getDrawPane() {
		return drawPane;
	}

	/**
	 * @param drawPane
	 *            the drawPane to set
	 */
	public static void setDrawPane(Drawing drawPane) {
		GUI.drawPane = drawPane;
	}

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
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			Drawing.getLeft().setY(Drawing.getLeft().getY() + 20);
		} else if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			Drawing.getLeft().setY(Drawing.getLeft().getY() - 20);
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			Drawing.getRight().setY(Drawing.getRight().getY() + 20);
		} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			Drawing.getRight().setY(Drawing.getRight().getY() - 20);
		}
		drawPane.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		keyPressed(arg0);
	}

}
