// SlotNumber.java  -- SlotNumber class implementation

// Copyright (c) 2014 easai

// Author: easai 
// Created: Thu Jan  9 07:33:33 2014
// Keywords: 

// This file is not part of GNU Emacs.

// SlotNumber.java is free software; you can redistribute it and/or modify
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
import javax.swing.*;

public class SlotNumber extends JPanel
{
    int x1,x2,x3;

    int count=0;
    Font font=new Font("Lucida Sans Unicode",Font.BOLD,100);
    int imageHeight=0;
    int imageWidth=0;

    boolean pause=false;
    boolean gotIt=false;
 
    SlotNumber()
    {
	x1=getRandomNumber();
	x2=getRandomNumber();
	x3=getRandomNumber();

	FontMetrics fm=getFontMetrics(font);
	
	imageHeight=fm.getAscent()*2;
	imageWidth=fm.charWidth('8');
	setPreferredSize(new Dimension(imageWidth,imageHeight));
    }

    public void reset()
    {
	pause=false;
	gotIt=false;
    }

    public void paint(Graphics g)
    {
	if(gotIt)
	    {
		g.setColor(Color.red);
	    }
	else
	    {
		g.setColor(Color.white);
	    }
	g.fillRect(0,0,getWidth(),getHeight());

	g.setColor(Color.black);
	g.setFont(font);

	g.drawString(""+x1,0,imageHeight/4+count);
	g.drawString(""+x2,0,3*imageHeight/4+count);
	g.drawString(""+x3,0,5*imageHeight/4+count);
    }

    int getRandomNumber()
    {
	return (int)(Math.random()*2+1);
    }
    
    void updateImage()
    {
	if(!pause || (pause && count!=0))
	    {
		count+=10;
		if(imageHeight/2<count)
		    {
			x3=x2;
			x2=x1;
			x1=getRandomNumber();
			count=0;
		    }
	    }
    }    
}

// SlotNumber.java ends here
