package pong.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import pong.model.PongCourt;

public class GUI extends JPanel implements ActionListener, KeyListener {
	private JFrame frame;
	private JMenu menu, run;
	private JMenuBar menuBar;
	private JMenuItem start, stop, saveGame, loadGame, newGame, quitGame;
	private JFileChooser fileChooser;
	private Drawing drawPane;
	private PongCourt court;

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

	public void initGUI() {
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
		
		menu = new JMenu("Game");
		run = new JMenu("Run");
		menuBar = new JMenuBar();
		
		fileChooser = new JFileChooser();
		
		menu.add(newGame);
		menu.add(saveGame);
		menu.add(loadGame);
		menu.add(quitGame);
		
		run.add(start);
		run.add(stop);

		menuBar.add(menu);
		menuBar.add(run);
		frame.setJMenuBar(menuBar);
		
		newGame.addActionListener(this);
		saveGame.addActionListener(this);
		loadGame.addActionListener(this);
		quitGame.addActionListener(this);
		
		start.addActionListener(this);
		stop.addActionListener(this);
		
		frame.addKeyListener(this);
		drawPane = new Drawing(frame.getHeight(), frame.getWidth());
		court = new PongCourt(drawPane);
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
			drawPane.getLeft().setY(drawPane.getLeft().getY() + 25);
		} else if (arg0.getKeyCode() == KeyEvent.VK_UP && drawPane.getLeft().getY() > 0) {
			drawPane.getLeft().setY(drawPane.getLeft().getY() - 25);
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT
				&& drawPane.getRight().getY() - drawPane.getRight().getHeight() < 900) {
			drawPane.getRight().setY(drawPane.getRight().getY() + 25);
		} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT && drawPane.getRight().getY() > 0) {
			drawPane.getRight().setY(drawPane.getRight().getY() - 25);
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
		if(arg0.getSource() == newGame) {
			
		}
		
		else if(arg0.getSource() == saveGame) {
			if(fileChooser.showSaveDialog(GUI.this) == JFileChooser.APPROVE_OPTION) {
				File saveFile = fileChooser.getSelectedFile();
			}

		}
		
		else if(arg0.getSource() == loadGame) {
			if(fileChooser.showOpenDialog(GUI.this) == JFileChooser.APPROVE_OPTION) {
				File loadFile = fileChooser.getSelectedFile();
			}

		}
		
		else if(arg0.getSource() == quitGame) {
			System.exit(0);
		}
		
		else if(arg0.getSource() == start) {
			drawPane.getTimer().start();
		}
		else if(arg0.getSource() == stop) {
			drawPane.getTimer().stop();
		}
		
	}

}
