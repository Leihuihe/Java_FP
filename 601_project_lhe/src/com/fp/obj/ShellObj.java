package com.fp.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.fp.GameWin;
import com.fp.utils.GameUtils;

public class ShellObj extends GameObj{

	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return super.getImg();
	}

	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return super.getRec();
	}

	public ShellObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShellObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
		// TODO Auto-generated constructor stub
	}

	public ShellObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
		super(img, x, y, width, height, speed, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintSelf(Graphics gImage) {
		// TODO Auto-generated method stub
		super.paintSelf(gImage);
		y -= speed;
		if(y<0)
		{
			this.x = -123;
			this.y = 123;
			GameUtils.removeList.add(this);
		}
	}
	
	
	
	
}
