package com.fp.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.fp.GameWin;
import com.fp.utils.GameUtils;

public class GiftObj extends GameObj{

	//category: 1: double_fire 2: increse fire speed 3: kill all enemy
	int gift_category;
	boolean status;
	@Override
	public void paintSelf(Graphics gImage) {
		// TODO Auto-generated method stub
		super.paintSelf(gImage);
		if(x > 770 || x < -30)
		{
			speed = -speed;
		}
		x += speed/2;
		y += Math.abs(speed);
		if(this.getRec().intersects(this.frame.fighterObj.getRec()))
		{
			this.x = -199;
			this.y = -1000;
			this.status = true;
			GameUtils.removeList.add(this);	
			GameUtils.starttime = System.currentTimeMillis();
		}
		if(y>1000)
		{
			this.x = -2906;
			this.y = 2506;
			GameUtils.removeList.add(this);
			GameUtils.giftObjList.clear();
		}
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return super.getRec();
	}

	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return super.getImg();
	}

	public GiftObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiftObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
		this.status = false;
		// TODO Auto-generated constructor stub
	}

	public GiftObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
		super(img, x, y, width, height, speed, frame);
		this.status = false;
		// TODO Auto-generated constructor stub
	}

	public int getGift_category() {
		return gift_category;
	}

	public void setGift_category(int gift_category) {
		this.gift_category = gift_category;
	}
	
	



}
