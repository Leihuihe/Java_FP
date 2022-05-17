package com.fp.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.fp.GameWin;
import com.fp.utils.GameUtils;

public class BulletObj_enemy extends GameObj{

	
	
	public BulletObj_enemy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BulletObj_enemy(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
		// TODO Auto-generated constructor stub
	}

	public BulletObj_enemy(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
		super(img, x, y, width, height, speed, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintSelf(Graphics gImage) {
		// TODO Auto-generated method stub
		super.paintSelf(gImage);
		y += speed;
		
		if(y>1000)
		{
			this.x = -1506;
			this.y = 1256;
			GameUtils.removeList.add(this);
		}
		
		if(this.getRec().intersects(this.frame.fighterObj.getRec()))
		{
			this.frame.fighterObj.reduce_health_point();
			this.x = -880;
			this.y = 999;
			GameUtils.removeList.add(this);
			if(this.frame.fighterObj.zero_health_point())
			{
				GameWin.state = 3;
			}
		}
		
		for(ShellObj shellobj: GameUtils.shellObjList)
		{
			if(this.getRec().intersects(shellobj.getRec()))
			{
				shellobj.setX(-1300);
				shellobj.setY(1300);
				this.x = -1280;
				this.y = 999;
				GameUtils.removeList.add(shellobj);
				GameUtils.removeList.add(this);
				
			}
		}
	}

	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return super.getRec();
	}
	
	

}
