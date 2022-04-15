package com.fp.obj;

import java.awt.Graphics;
import java.awt.Image;

import com.fp.GameWin;

public class BackgroundObj extends GameObj{

	public BackgroundObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BackgroundObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
		// TODO Auto-generated constructor stub
	}

	public BackgroundObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
		super(img, x, y, width, height, speed, frame);
		// TODO Auto-generated constructor stub
	}
	
	public void paintSelf(Graphics gImage)
	{
		super.paintSelf(gImage);
		y += speed;
		if(y >= 0) y = -2000;
	}
	
	
}
