package pong.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import pong.model.ball;
import pong.model.paddle;

public class Drawing extends JPanel implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Timer timer = new Timer((1000 / 10), this);

	private static ball ball;

	private static paddle left, right;

	public Drawing() {
		this.setBackground(Color.black);
		ball = new ball(this.getWidth() / 2, this.getHeight() / 2, 20, 20, 40, 40, Color.white);
		left = new paddle(40, 40, 20, 40, Color.white);
		right = new paddle(100, 100, 20, 40, Color.white);
		addKeyListener(this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(ball.getColor());
		g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		g.fillRect(left.getX(), left.getY(), left.getWidth(), left.getHeight());
		g.fillRect(right.getX(), right.getY(), right.getWidth(), right.getHeight());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball.setX(ball.getX() + ball.getxVel());
		ball.setY(ball.getY() + ball.getyVel());
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("KeyPressed");
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			left.setY(left.getY() + 5);
		} else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			left.setY(left.getY() - 5);
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			right.setY(right.getY() + 5);
		} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			right.setY(right.getY() - 5);
		}
		repaint();
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
