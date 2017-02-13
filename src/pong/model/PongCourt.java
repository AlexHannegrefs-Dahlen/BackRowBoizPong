package pong.model;

import java.io.Serializable;

import pong.view.Drawing;

public class PongCourt implements Serializable {

	private static final long serialVersionUID = 1L;

	private static ball Ball = Drawing.getBall();

	private static paddle PaddleLeft = Drawing.getLeft(), PaddleRight = Drawing.getRight();

	public static int Score() {
		return 0;
	}

	public static boolean Win() {
		return false;
	}

	public static void DetectBallWallCollision(int panelWidth, int panelHeight) {
		if (Ball.getY() >= panelHeight - Ball.getHeight()) {
			Ball.setyVel(-Ball.getyVel());
		} else if (Ball.getY() < 0) {
			Ball.setyVel(-Ball.getyVel());
		}
		if (Ball.getX() + Ball.getWidth() >= panelWidth) {
			PaddleLeft.setScore(PaddleLeft.getScore() + 1);
			Ball.resetBall();
		} else if (Ball.getX() <= 0) {
			PaddleRight.setScore(PaddleRight.getScore() + 1);
			Ball.resetBall();
		}
	}

	public static void DetectBallPaddleCollision() {
		if (PaddleRight.getX() - Ball.getX() <= Ball.getWidth()
				&& Ball.getX() + Ball.getWidth() < PaddleRight.getX() + PaddleRight.getWidth()) {
			if (Ball.getY() > PaddleRight.getY()
					&& Ball.getY() < PaddleRight.getY() + PaddleRight.getHeight() - Ball.getHeight()) {
				Ball.setxVel(-Ball.getxVel());
			}
		} else if (PaddleLeft.getX() <= Ball.getX() && PaddleLeft.getX() + PaddleLeft.getWidth() > Ball.getX()) {
			if (Ball.getY() > PaddleLeft.getY()
					&& Ball.getY() < PaddleLeft.getY() + PaddleLeft.getHeight() - Ball.getHeight()) {
				Ball.setxVel(-Ball.getxVel());
			}
		}
	}
}
