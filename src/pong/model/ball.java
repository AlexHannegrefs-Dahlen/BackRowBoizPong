package pong.model;

import java.awt.Color;

public class ball {
	private int x, y, middleX, middleY, width, height, xVel, yVel;

	private Color color;

	public ball() {

	}

	/**
	 * 
	 * @param x
	 *            the x location for the ball
	 * @param y
	 *            the y location for the ball
	 * @param width
	 *            the width of the ball
	 * @param height
	 *            the height of the ball
	 * @param xVel
	 *            the balls x velosity
	 * @param yVel
	 *            the balls y velosity
	 * @param color
	 *            the color of the ball
	 */
	public ball(int x, int y, int width, int height, int xVel, int yVel, Color color) {
		this.setX(x);
		this.setMiddleX(x);
		this.setMiddleY(y);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setxVel(xVel);
		this.setyVel(yVel);
		this.setColor(color);
	}
/**
 * resets the ball to the middle  
 */
	public void resetBall() {
		this.setX(middleX);
		this.setY(middleY);
		this.setxVel(-this.getxVel());
	}
/**
 * 
 * @param middleX the middle x location
 * sets the balls x to the middle 
 */
	private void setMiddleX(int middleX) {
		this.middleX = middleX;
	}
/**
 * 
 * @param middleY the middle y location 
 * sets the ball to the middle 
 */
	private void setMiddleY(int middleY) {
		this.middleY = middleY;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the xVel
	 */
	public int getxVel() {
		return xVel;
	}

	/**
	 * @param xVel
	 *            the xVel to set
	 */
	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	/**
	 * @return the yVel
	 */
	public int getyVel() {
		return yVel;
	}

	/**
	 * @param yVel
	 *            the yVel to set
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
}
