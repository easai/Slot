package easai.games;
// SlotMachine.java  -- SlotMachine class implementation

// Copyright (c) 2014 easai

// Author: easai 
// Created: Thu Jan  9 07:34:45 2014
// Keywords: 

// Commentary:
//
//
//

// Code:

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Slot extends JPanel implements Runnable, ActionListener {
	Thread thread = new Thread(this);
	Font font = new Font("Lucida Sans Unicode", Font.BOLD, 100);
	Font smallFont = new Font("Lucida Sans Unicode", Font.BOLD, 20);
	JButton start = new JButton("Start");

	int count = 0;

	SlotNumber xImage = new SlotNumber();
	SlotNumber yImage = new SlotNumber();
	SlotNumber zImage = new SlotNumber();

	Slot() {
		start.addActionListener(this);
		setLayout(new FlowLayout());
		add(xImage);
		add(yImage);
		add(zImage);
		thread.start();
	}

	int getRandomNumber() {
		return (int) (Math.random() * 4 + 1);
	}

	public void run() {
		Thread me = Thread.currentThread();
		while (me == thread) {
			try {
				thread.sleep(1);
				if (count < 300) {
					count++;
				} else if (count < 600) {
					xImage.pause = true;
					count++;
				} else if (count < 900) {
					yImage.pause = true;
					count++;
				} else {
					zImage.pause = true;
					if (xImage.x2 == yImage.x2 && yImage.x2 == zImage.x2) {
						xImage.gotIt = true;
						yImage.gotIt = true;
						zImage.gotIt = true;
					}
				}

				xImage.updateImage();
				yImage.updateImage();
				zImage.updateImage();
				repaint();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		reset();
	}

	private void reset() {
		count = 0;
		xImage.reset();
		yImage.reset();
		zImage.reset();

		Graphics g = getGraphics();
		if (g != null) {
			g.setColor(Color.white);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame();
		Slot slot = new Slot();
		frame.getContentPane().add(slot.start, BorderLayout.NORTH);
		frame.getContentPane().add(slot, BorderLayout.CENTER);
		frame.setTitle("Slot Machine");
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

// SlotMachine.java ends here
