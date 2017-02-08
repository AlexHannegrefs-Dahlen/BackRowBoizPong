package pong.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import pong.model.ball;
import pong.model.paddle;

public class Drawing extends JPanel implements ActionListener {
	private Timer timer = new Timer((1000 / 3), this);

	private static ball ball;

	private static paddle left, right;

	public Drawing() {
		this.setBackground(Color.black);
		ball = new ball(this.getWidth() / 2, this.getHeight() / 2, 20, 20, 10, 10, Color.white);
		left = new paddle(20, (this.getHeight() / 2) - 20, 20, 40, Color.white);
		right = new paddle(this.getWidth() - 20, (this.getHeight() / 2) - 20, 20, 40, Color.white);
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
		// TODO Auto-generated method stub

	}
}
