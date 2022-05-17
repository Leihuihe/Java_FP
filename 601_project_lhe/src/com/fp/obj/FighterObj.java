package com.fp.obj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.fp.GameWin;

public class FighterObj extends GameObj{
	
	int health_point = 3;
	
	public boolean zero_health_point()
	{
		return health_point == 0;
	}
	
	public void reduce_health_point()
	{
		health_point--;
	}
	
	public void set_health_point(int point)
	{
		this.health_point = point;
	}
	
	public int get_health_point()
	{
		return this.health_point;
	}

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
		gImage.setColor(Color.white);
		gImage.fillRect(this.getX(), this.getY()+this.getHeight()+20, this.getWidth()+5, 5);
		gImage.setColor(Color.red);
		gImage.fillRect(this.getX(), this.getY()+this.getHeight()+20, this.health_point*(this.getWidth()+5)/3, 5);
		
	}
	
	

	
}
