package com.fp.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.fp.GameWin;
import com.fp.utils.GameUtils;

public class EnemyObj extends GameObj{

	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return super.getImg();
	}

	@Override
	public void paintSelf(Graphics gImage) {
		// TODO Auto-generated method stub
		super.paintSelf(gImage);
		y += speed;
		
		if(this.getRec().intersects(this.frame.fighterObj.getRec()))
		{
			GameWin.state = 3;
		}
		
		for(ShellObj shellobj: GameUtils.shellObjList)
		{
			if(this.getRec().intersects(shellobj.getRec()))
			{
				shellobj.setX(-100);
				shellobj.setX(100);
				this.x = -200;
				this.y = 200;
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

	public EnemyObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnemyObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
		// TODO Auto-generated constructor stub
	}

	public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
		super(img, x, y, width, height, speed, frame);
		// TODO Auto-generated constructor stub
	}

}
