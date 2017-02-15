package pong.model;

import pong.view.Drawing;

public class PongCourt {

	private Drawing panel;

	public PongCourt(Drawing panel) {
		this.panel = panel;
	}

	public int Score() {
		return 0;
	}

	public boolean Win() {
		return false;
	}

	public void DetectBallWallCollision(int panelWidth, int panelHeight) {
		if (panel.getBall().getY() >= panelHeight - panel.getBall().getHeight()) {
			panel.getBall().setyVel(-panel.getBall().getyVel());
		} else if (panel.getBall().getY() <= 0) {
			panel.getBall().setyVel(-panel.getBall().getyVel());
		}
		if (panel.getBall().getX() + panel.getBall().getWidth() >= panelWidth) {
			panel.getLeft().setScore(panel.getLeft().getScore() + 1);
			panel.getBall().resetBall();
		} else if (panel.getBall().getX() <= 0) {
			panel.getRight().setScore(panel.getRight().getScore() + 1);
			panel.getBall().resetBall();
		}
	}

	public void DetectBallPaddleCollision() {
		if (panel.getRight().getX() - panel.getBall().getX() <= panel.getBall().getWidth() && panel.getBall().getX()
				+ panel.getBall().getWidth() <= panel.getRight().getX() + panel.getRight().getWidth()) {
			if (panel.getBall().getY() > panel.getRight().getY() && panel.getBall().getY() < panel.getRight().getY()
					+ panel.getRight().getHeight() - panel.getBall().getHeight()) {
				panel.getBall().setxVel(-panel.getBall().getxVel());
			}
		} else if (panel.getLeft().getX() <= panel.getBall().getX()
				&& panel.getLeft().getX() + panel.getLeft().getWidth() > panel.getBall().getX()) {
			if (panel.getBall().getY() > panel.getLeft().getY() && panel.getBall().getY() <= panel.getLeft().getY()
					+ panel.getLeft().getHeight() - panel.getBall().getHeight()) {
				panel.getBall().setxVel(-panel.getBall().getxVel());
			}
		}
	}
}
