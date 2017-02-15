package pong.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import pong.model.PongCourt;

public class GUI implements KeyListener {
	private JFrame frame;
	private Drawing drawPane;
	private PongCourt court;

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame
	 *            the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the drawPane
	 */
	public Drawing getDrawPane() {
		return drawPane;
	}

	/**
	 * @param drawPane
	 *            the drawPane to set
	 */
	public void setDrawPane(Drawing drawPane) {
		this.drawPane = drawPane;
	}

	public void initGUI() {
		frame = new JFrame("Pong");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(this);
		drawPane = new Drawing(frame.getHeight(), frame.getWidth());
		court = new PongCourt(drawPane);
		drawPane.setCourt(court);
		frame.getContentPane().add(drawPane);
		frame.setVisible(true);
	}

	/**
	 * @return the court
	 */
	public PongCourt getCourt() {
		return court;
	}

	/**
	 * @param court
	 *            the court to set
	 */
	public void setCourt(PongCourt court) {
		this.court = court;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN && drawPane.getLeft().getY() - drawPane.getLeft().getHeight() < 900) {
			drawPane.getLeft().setY(drawPane.getLeft().getY() + 25);
		} else if (arg0.getKeyCode() == KeyEvent.VK_UP && drawPane.getLeft().getY() > 0) {
			drawPane.getLeft().setY(drawPane.getLeft().getY() - 25);
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT
				&& drawPane.getRight().getY() - drawPane.getRight().getHeight() < 900) {
			drawPane.getRight().setY(drawPane.getRight().getY() + 25);
		} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT && drawPane.getRight().getY() > 0) {
			drawPane.getRight().setY(drawPane.getRight().getY() - 25);
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
