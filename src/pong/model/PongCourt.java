package pong.model;

import pong.view.Drawing;
import pong.view.GUI;

public class PongCourt {

	private Drawing panel;
	private GUI gui;
	private int ScoreLeft = 0;
	private int ScoreRight = 0;

	public PongCourt() {
	}

	/**
	 * 
	 * @param panel
	 *            the Main Gui panel
	 */
	public PongCourt(Drawing panel, GUI gui) {
		this.panel = panel;
		this.gui = gui;
	}

	/**
	 * 
	 * @return if there is a winner
	 */
	public void DetectWin() {
		if (ScoreLeft == 11) {
			panel.getTimer().stop();
			gui.displayWin();
		} else if (ScoreRight == 11) {
			panel.getTimer().stop();
			gui.displayWin();
		}
	}

	/**
	 * 
	 * @param panelWidth
	 *            the width of the main panel
	 * @param panelHeight
	 *            the height of the main panel Detects if the ball has hit the
	 *            top or buttem of the panel
	 */
	public void DetectBallWallCollision(int panelWidth, int panelHeight) {
		if (panel.getBall().getY() >= panelHeight - panel.getBall().getHeight()) {
			panel.getBall().setyVel(-panel.getBall().getyVel());
		} else if (panel.getBall().getY() <= 0) {
			panel.getBall().setyVel(-panel.getBall().getyVel());
		}
		if (panel.getBall().getX() + panel.getBall().getWidth() >= panelWidth) {
			// panel.getLeft().setScore(panel.getLeft().getScore() + 1);
			ScoreLeft += 1;
			panel.getBall().resetBall();
			DetectWin();
		} else if (panel.getBall().getX() <= 0) {
			// panel.getRight().setScore(panel.getRight().getScore() + 1);
			ScoreRight += 1;
			panel.getBall().resetBall();
			DetectWin();
		}
	}

	/**
	 * Detects if the ball has hit the paddles
	 */
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
/**
 * 
 * @return the right score as a String
 */
	public String getRightScore() {
		switch (ScoreRight) {
		case 0:
			return "0";
		case 1:
			return "1";
		case 2:
			return "2";
		case 3:
			return "3";
		case 4:
			return "4";
		case 5:
			return "5";
		case 6:
			return "6";
		case 7:
			return "7";
		case 8:
			return "8";
		case 9:
			return "9";
		case 10:
			return "10";
		case 11:
			return "11";
		default:
			break;
		}
		return null;
	}
/**
 * 
 * @return the left score as a String 
 */
	public String getLeftScore() {
		switch (ScoreLeft) {
		case 0:
			return "0";
		case 1:
			return "1";
		case 2:
			return "2";
		case 3:
			return "3";
		case 4:
			return "4";
		case 5:
			return "5";
		case 6:
			return "6";
		case 7:
			return "7";
		case 8:
			return "8";
		case 9:
			return "9";
		case 10:
			return "10";
		case 11:
			return "11";
		default:
			break;
		}
		return null;
	}

}
