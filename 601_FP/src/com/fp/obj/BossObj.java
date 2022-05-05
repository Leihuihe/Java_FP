package com.fp.obj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.fp.GameWin;
import com.fp.utils.GameUtils;

public class BossObj extends GameObj{

	int health_point = 20;
	
	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return super.getImg();
	}

	@Override
	public void paintSelf(Graphics gImage) {
		// TODO Auto-generated method stub
		super.paintSelf(gImage);
		if(x > 750 || x < -50)
		{
			speed = -speed;
		}
		x += speed;
		if(this.getRec().intersects(this.frame.fighterObj.getRec()))
		{
			this.frame.fighterObj.reduce_health_point();
			if(this.frame.fighterObj.zero_health_point())
			{
				GameWin.state = 3;
			}
			
		}
		
		for(ShellObj shellobj: GameUtils.shellObjList)
		{
			if(this.getRec().intersects(shellobj.getRec()))
			{
				this.health_point--;
				shellobj.setX(-1960);
				shellobj.setY(1000);				
				GameUtils.removeList.add(shellobj);
				if(this.health_point<=0)
				{
					this.x = -2500;
					this.y = 2600;
					GameUtils.removeList.add(this);
					GameUtils.BossObjList.clear();
					GameWin.score += 50;
				}
				
			}
		}
		gImage.setColor(Color.white);
		gImage.fillRect(20, 40, 100, 10);
		gImage.setColor(Color.red);
		gImage.fillRect(20, 40, this.health_point*100/20, 10);
	}

	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return super.getRec();
	}

	public BossObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BossObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
		// TODO Auto-generated constructor stub
	}

	public BossObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
		super(img, x, y, width, height, speed, frame);
		// TODO Auto-generated constructor stub
	}
	
	

}
