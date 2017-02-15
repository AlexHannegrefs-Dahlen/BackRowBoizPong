package pong.view;

import java.awt.Color;
import java.awt.Font;
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

	private final int MiddleXScore = 100;

	private final int MiddleYScore = 100;

	private Timer timer = new Timer((25 / 5), this);

	private ball ball;

	private paddle left, right;

	private PongCourt court;

	/**
	 * 
	 * @param height
	 *            the height of the panel
	 * @param width
	 *            the height of the panel
	 */
	public Drawing(int height, int width) {
		this.setBackground(Color.black);
		ball = new ball(width / 2 + 20, height / 2 - 20, 45, 45, 5, 5, Color.white);
		left = new paddle(60, height / 2 - 75, 30, 200, Color.white);
		right = new paddle(width - 110, height / 2 - 75, 30, 200, Color.white);
		timer.start();
	}

	/**
	 * sets the color of the ball paints the ball sets the color of the paddles
	 * paints the paddles
	 */
	public void paint(Graphics g) {
		super.paint(g);
		int fontSize = 24;
		g.setColor(ball.getColor());
		g.fillRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		g.setColor(left.getColor());
		g.fillRect(left.getX(), left.getY(), left.getWidth(), left.getHeight());
		g.setColor(right.getColor());
		g.fillRect(right.getX(), right.getY(), right.getWidth(), right.getHeight());

		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		g.setColor(Color.WHITE);

		g.drawString("Score", MiddleXScore, MiddleYScore);
		g.drawString(court.getRightScore(), MiddleXScore+60, MiddleYScore+20);
		g.drawString(court.getLeftScore(), MiddleXScore-20, MiddleYScore+20);
	}

	public void setCourt(PongCourt court) {
		this.court = court;
	}

	public PongCourt getCourt() {
		return this.court;
	}

	public paddle getLeft() {
		return this.left;
	}

	public paddle getRight() {
		return this.right;
	}

	public ball getBall() {
		return this.ball;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball.setX(ball.getX() + ball.getxVel());
		ball.setY(ball.getY() + ball.getyVel());
		repaint();
		court.DetectBallPaddleCollision();
		court.DetectBallWallCollision(this.getWidth(), this.getHeight());
	}

}
