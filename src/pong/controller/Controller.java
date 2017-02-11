package pong.controller;

import javax.swing.JFrame;

import pong.view.Drawing;

public class Controller {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Drawing panel = new Drawing();
		panel.addKeyListener(panel);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
