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

public class Drawing extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Timer timer = new Timer((1000 / 10), this);

	private static ball ball;

	private static paddle left, right;

	public Drawing(int height, int width) {
		this.setBackground(Color.black);
		ball = new ball(width / 2, height / 2, 40, 40, 20, 20, Color.white);
		left = new paddle(20, height / 2, 30, 100, Color.white);
		right = new paddle(width - 70, height / 2, 30, 100, Color.white);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(ball.getColor());
		g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		g.fillRect(left.getX(), left.getY(), left.getWidth(), left.getHeight());
		g.fillRect(right.getX(), right.getY(), right.getWidth(), right.getHeight());
	}

	public paddle getLeft() {
		return left;
	}

	public paddle getRight() {
		return right;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball.setX(ball.getX() + ball.getxVel());
		ball.setY(ball.getY() + ball.getyVel());
		repaint();
	}

}
