package easai.games;
// SlotMachineApplet.java  -- SlotMachineApplet class implementation

// Copyright (c) 2014 easai

// Author: easai 
// Created: Thu Jan  9 07:35:31 2014
// Keywords: 

// Commentary:
//
//
//

// Code:

import java.awt.*;
import javax.swing.*;

public class SlotMachineApplet extends JApplet {
	Slot slot = new Slot();

	public void init() {
		add(slot.start, BorderLayout.NORTH);
		add(slot, BorderLayout.CENTER);
	}

}

// SlotMachineApplet.java ends here
