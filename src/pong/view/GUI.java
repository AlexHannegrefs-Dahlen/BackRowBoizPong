package pong.view;

import javax.swing.JFrame;

public class GUI {
	private static JFrame frame;

	public static void initGUI() {
		frame = new JFrame("Pong");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Drawing drawPane = new Drawing();
		frame.getContentPane().add(drawPane);

	}

}
