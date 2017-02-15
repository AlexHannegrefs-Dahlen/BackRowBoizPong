package pong.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import pong.controller.Controller;
import pong.model.PongCourt;

public class GUI extends JPanel implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JMenu game, run, settings;
	private JMenuBar menuBar;
	private JMenuItem start, stop, saveGame, loadGame, newGame, quitGame, increaseBallVel, decreaseBalllVel;
	private JFileChooser fileChooser;
	private Drawing drawPane;
	private PongCourt court;
	private Controller controller;

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame
	 *            the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the drawPane
	 */
	public Drawing getDrawPane() {
		return drawPane;
	}

	/**
	 * @param drawPane
	 *            the drawPane to set
	 */
	public void setDrawPane(Drawing drawPane) {
		this.drawPane = drawPane;
	}

	/**
	 * initiats the GUI sets the frame sets menu items sets the panel
	 * 
	 * @param controller2
	 */
	public void initGUI(Controller controller2) {
		this.controller = controller2;
		Font font = new Font("sans-serif", Font.PLAIN, 30);
		UIManager.put("Menu.font", font);
		UIManager.put("MenuItem.font", font);
		frame = new JFrame("Pong");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		newGame = new JMenuItem("New Game");
		saveGame = new JMenuItem("Save Game");
		loadGame = new JMenuItem("Load Game");
		quitGame = new JMenuItem("Quit Game");

		start = new JMenuItem("Start");
		stop = new JMenuItem("Stop");

		increaseBallVel = new JMenuItem("Increase Ball Velocity");
		decreaseBalllVel = new JMenuItem("Decrease Ball Velocity");

		game = new JMenu("Game");
		run = new JMenu("Run");
		settings = new JMenu("Settings");
		menuBar = new JMenuBar();
		fileChooser = new JFileChooser();

		settings.add(increaseBallVel);
		settings.add(decreaseBalllVel);

		game.add(newGame);
		game.add(saveGame);
		game.add(loadGame);
		game.add(quitGame);

		run.add(start);
		run.add(stop);

		menuBar.add(game);
		menuBar.add(run);
		menuBar.add(settings);
		frame.setJMenuBar(menuBar);

		newGame.addActionListener(this);
		saveGame.addActionListener(this);
		loadGame.addActionListener(this);
		quitGame.addActionListener(this);

		start.addActionListener(this);
		stop.addActionListener(this);

		increaseBallVel.addActionListener(this);
		decreaseBalllVel.addActionListener(this);

		frame.addKeyListener(this);
		drawPane = new Drawing(frame.getHeight(), frame.getWidth());
		court = new PongCourt(drawPane, this);
		drawPane.setCourt(court);
		frame.getContentPane().add(drawPane);
		frame.setVisible(true);
	}

	/**
	 * @return the court
	 */
	public PongCourt getCourt() {
		return court;
	}

	/**
	 * @param court
	 *            the court to set
	 */
	public void setCourt(PongCourt court) {
		this.court = court;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN && drawPane.getLeft().getY() - drawPane.getLeft().getHeight() < 900) {
			drawPane.getLeft().setY(drawPane.getLeft().getY() + drawPane.getLeft().getyVel());
		} else if (arg0.getKeyCode() == KeyEvent.VK_UP && drawPane.getLeft().getY() > 0) {
			drawPane.getLeft().setY(drawPane.getLeft().getY() - drawPane.getLeft().getyVel());
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT
				&& drawPane.getRight().getY() - drawPane.getRight().getHeight() < 900) {
			drawPane.getRight().setY(drawPane.getRight().getY() + drawPane.getRight().getyVel());
		} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT && drawPane.getRight().getY() > 0) {
			drawPane.getRight().setY(drawPane.getRight().getY() - drawPane.getRight().getyVel());
		}
		drawPane.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		keyPressed(arg0);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == newGame) {
			this.frame.dispose();
			controller.run();
		} else if (arg0.getSource() == saveGame) {
			if (fileChooser.showSaveDialog(GUI.this) == JFileChooser.APPROVE_OPTION) {
				File saveFile = fileChooser.getSelectedFile();
				try {
					controller.saveGame(saveFile, court, drawPane.getBall(), drawPane.getLeft(), drawPane.getRight());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} else if (arg0.getSource() == loadGame) {
			if (fileChooser.showOpenDialog(GUI.this) == JFileChooser.APPROVE_OPTION) {
				File loadFile = fileChooser.getSelectedFile();
				try {
					controller.loadGame(loadFile, court, drawPane);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} else if (arg0.getSource() == quitGame)
			System.exit(0);
		else if (arg0.getSource() == start)
			drawPane.getTimer().start();
		else if (arg0.getSource() == stop)
			drawPane.getTimer().stop();
		else if (arg0.getSource() == increaseBallVel) {
			if (drawPane.getBall().getxVel() < 20)
				drawPane.getBall().setxVel(drawPane.getBall().getxVel() + 5);
		} else if (arg0.getSource() == decreaseBalllVel) {
			if (drawPane.getBall().getxVel() > 6)
				drawPane.getBall().setxVel(drawPane.getBall().getxVel() - 5);
		}

	}

	public void displayWin(String winner) {
		JOptionPane.showMessageDialog(frame, "Congratulations, " + winner + " has won!");
	}

}
