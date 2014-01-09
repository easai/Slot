// SlotMachineApplet.java  -- SlotMachineApplet class implementation

// Copyright (c) 2014 easai

// Author: easai 
// Created: Thu Jan  9 07:35:31 2014
// Keywords: 

// This file is not part of GNU Emacs.

// SlotMachineApplet.java is free software; you can redistribute it and/or modify
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

public class SlotMachineApplet extends JApplet
{
    SlotMachine slot=new SlotMachine();

    public void init()
    {
	add(slot.start,BorderLayout.NORTH);
	add(slot,BorderLayout.CENTER);
    }

}

// SlotMachineApplet.java ends here
