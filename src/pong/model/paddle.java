package pong.model;

import java.awt.Color;
import java.io.Serializable;

public class paddle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int x, y, width, height, yVel;

	private Color color;

	public paddle() {

	}

	/**
	 * 
	 * @param x
	 *            the x of the paddle
	 * @param y
	 *            the y of the paddle
	 * @param width
	 *            the width of the paddle
	 * @param height
	 *            the height of the paddle
	 * @param vVel
	 *            the velocity on the y axis of the paddle
	 * @param color
	 *            the color of the paddle
	 */
	public paddle(int x, int y, int width, int height, int yVel, Color color) {
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setyVel(yVel);
		this.setColor(color);
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
