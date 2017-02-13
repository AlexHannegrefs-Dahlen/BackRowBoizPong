package pong.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import pong.model.PongCourt;
import pong.model.ball;
import pong.model.paddle;

public class Drawing extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Timer timer = new Timer((1000 / 40), this);

	private static ball ball;

	private static paddle left, right;

	public Drawing(int height, int width) {
		this.setBackground(Color.black);
		ball = new ball(width / 2 + 20, height / 2 - 20, 80, 80, 10, 10, Color.white);
		left = new paddle(60, height / 2 - 75, 30, 200, Color.white);
		right = new paddle(width - 110, height / 2 - 75, 30, 200, Color.white);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(ball.getColor());
		g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		g.fillRect(left.getX(), left.getY(), left.getWidth(), left.getHeight());
		g.fillRect(right.getX(), right.getY(), right.getWidth(), right.getHeight());
	}

	public static paddle getLeft() {
		return left;
	}

	public static paddle getRight() {
		return right;
	}
	
	public static ball getBall(){
		return ball;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball.setX(ball.getX() + ball.getxVel());
		ball.setY(ball.getY() + ball.getyVel());
		repaint();
		PongCourt.DetectBallPaddleCollision();
		PongCourt.DetectBallWallCollision(this.getWidth(), this.getHeight()); 
	}

}
