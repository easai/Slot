// SlotMachine.java  -- SlotMachine class implementation

// Copyright (c) 2014 easai

// Author: easai 
// Created: Thu Jan  9 07:34:45 2014
// Keywords: 

// This file is not part of GNU Emacs.

// SlotMachine.java is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2, or (at your option)
// any later version.

// This software is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program; see the file COPYING.  If not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA 02111-1307, USA.

// Commentary:
//
//
//

// Code:


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SlotMachine extends JPanel implements Runnable,ActionListener
{
    Thread thread=new Thread(this);
    Font font=new Font("Lucida Sans Unicode",Font.BOLD,100);
    Font smallFont=new Font("Lucida Sans Unicode",Font.BOLD,20);
    JButton start=new JButton("Start");

    int count=0;

    SlotNumber xImage=new SlotNumber();
    SlotNumber yImage=new SlotNumber();
    SlotNumber zImage=new SlotNumber();

    SlotMachine()
    {
	start.addActionListener(this);
	setLayout(new FlowLayout());
	add(xImage);	
	add(yImage);	
	add(zImage);	
	thread.start();	
    }

    int getRandomNumber()
    {
	return (int)(Math.random()*4+1);
    }

    public void run()
    {
	Thread me=Thread.currentThread();
	while(me==thread)
	    {
		try
		    {
			thread.sleep(1);
			if(count<300)
			    {
				count++;
			    }
			else if(count<600)
			    {
				xImage.pause=true;
				count++;
			    }
			else if(count<900)
			    {
				yImage.pause=true;
				count++;
			    }
			else 
			    {
				zImage.pause=true;
				if(xImage.x2==yImage.x2 && yImage.x2==zImage.x2)
				    {
					xImage.gotIt=true;
					yImage.gotIt=true;
					zImage.gotIt=true;
				    }
			    }

			xImage.updateImage();
			yImage.updateImage();
			zImage.updateImage();
			repaint();
		    }
		catch(Exception e){e.printStackTrace();}
	    }
    }

    public void actionPerformed(ActionEvent e)
    {
	reset();
    }

    private void reset()
    {
	count=0;
	xImage.reset();
	yImage.reset();
	zImage.reset();

	Graphics g=getGraphics();
	if(g!=null)
	    {
		g.setColor(Color.white);
		g.fillRect(0,0,getWidth(),getHeight());
	    }
    }

    public static void main(String args[])
    {
	JFrame frame=new JFrame();
	SlotMachine slot=new SlotMachine();
	frame.getContentPane().add(slot.start,BorderLayout.NORTH);
	frame.getContentPane().add(slot,BorderLayout.CENTER);
	frame.setTitle("Slot Machine");
	frame.setVisible(true);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}


// SlotMachine.java ends here
