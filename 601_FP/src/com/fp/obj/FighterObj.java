package com.fp.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.fp.GameWin;

public class FighterObj extends GameObj{

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

	public FighterObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FighterObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
		
	}

	public FighterObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
		super(img, x, y, width, height, speed, frame);
		this.frame.addMouseMotionListener(new MouseAdapter() 
		{
			public void mouseMoved(MouseEvent e)
			{
				FighterObj.super.x = e.getX() - 11;
				FighterObj.super.y = e.getY() - 16;
				
				
			}
		});
	}

	@Override
	public void paintSelf(Graphics gImage) {
		// TODO Auto-generated method stub
		super.paintSelf(gImage);
	}
	
	

	
}
