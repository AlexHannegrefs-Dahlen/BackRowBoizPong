package pong.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import pong.model.PongCourt;
import pong.model.ball;
import pong.model.paddle;
import pong.view.Drawing;
import pong.view.GUI;

public class Controller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void saveGame(File saveFile, PongCourt court, ball ball, paddle left, paddle right)
			throws FileNotFoundException, IOException {
		Object[] objects = new Object[] { court, ball, left, right };
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
		out.writeObject(objects);
		out.close();
	}

	public void loadGame(File loadFile, PongCourt court, Drawing drawPane) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(loadFile));
		Object[] objects = (Object[]) in.readObject();
		court = (PongCourt) objects[0];
		drawPane.setBall((ball)objects[1]);
		drawPane.setLeft((paddle)objects[2]);
		drawPane.setRight((paddle)objects[3]);
	}

	public void run() {
		GUI gui = new GUI();
		gui.initGUI(this);
	}
}
