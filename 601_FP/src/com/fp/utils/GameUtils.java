package com.fp.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import com.fp.obj.BossObj;
import com.fp.obj.BulletObj_enemy;
import com.fp.obj.EnemyObj;
import com.fp.obj.GameObj;
import com.fp.obj.GiftObj;
import com.fp.obj.ShellObj;

public class GameUtils {
	
	public static long starttime;
	public static long endtime;
	
	public static Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/background/bg1.jpg");
	
	public static Image bgImg2 = Toolkit.getDefaultToolkit().getImage("imgs/background/bg.jpg");
	
	public static Image bgImg3 = Toolkit.getDefaultToolkit().getImage("imgs/background/bg1.jpg");
	
	public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imgs/plane/boss001.png");
	
	public static Image bossImg2 = Toolkit.getDefaultToolkit().getImage("imgs/plane/boss002.png");
	
	public static Image bossImg3 = Toolkit.getDefaultToolkit().getImage("imgs/plane/boss003.png");
	
	public static Image giftImg1 = Toolkit.getDefaultToolkit().getImage("imgs/award/doubleFire01.png");
	
	public static Image giftImg2 = Toolkit.getDefaultToolkit().getImage("imgs/award/bee001.png");
	
	public static Image giftImg3 = Toolkit.getDefaultToolkit().getImage("imgs/award/atomBomb01.png");
	
	public static Image doublefire = Toolkit.getDefaultToolkit().getImage("imgs/award/doubleFire001.png");
	
	public static Image singlefire = Toolkit.getDefaultToolkit().getImage("imgs/plane/shell.png");
	
	
	public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
	
	public static Image fighterImg = Toolkit.getDefaultToolkit().getImage("imgs/plane/hero001.png");
	
	public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imgs/plane/shell.png");
	
	public static Image enemyImg = Toolkit.getDefaultToolkit().getImage("imgs/plane/enemy01.png");
	
	public static Image enemyImg2 = Toolkit.getDefaultToolkit().getImage("imgs/plane/enemy001.png");
	
	public static Image enemyImg3 = Toolkit.getDefaultToolkit().getImage("imgs/plane/enemy002.png");
	
	public static Image Bullet_enemyImg = Toolkit.getDefaultToolkit().getImage("imgs/plane/bullet.png");
	
	public static Image Bullet_enemyImg1 = Toolkit.getDefaultToolkit().getImage("imgs/plane/bullet001.png");
	
	public static Image Bullet_enemyImg2 = Toolkit.getDefaultToolkit().getImage("imgs/plane/bullet002.png");
	
	public static Image Bullet_bossImg = Toolkit.getDefaultToolkit().getImage("imgs/plane/bossBullet001.png");
	
	public static Image Bullet_bossImg2 = Toolkit.getDefaultToolkit().getImage("imgs/plane/bossBullet002.png");
	
	
	public static List<GameObj> gameObjList = new ArrayList<>();
	
	public static List<GameObj> removeList = new ArrayList<>();
	
	public static List<ShellObj> shellObjList = new ArrayList<>();

	public static List<EnemyObj> enemyObjList = new ArrayList<>();
	
	public static List<EnemyObj> enemyObjList2 = new ArrayList<>();
	
	public static List<EnemyObj> enemyObjList3 = new ArrayList<>();
	
	public static List<BossObj> BossObjList = new ArrayList<>();
	
	public static List<GiftObj> giftObjList = new ArrayList<>();

	public static List<BulletObj_enemy> BulletObj_enemyList = new ArrayList<>();

	
//	public static void drawScore(Graphics gImage, String str,Color color,int size,int x, int y)
//	{
//		gImage.setColor(color);
//		gImage.setFont(new Font("Calibri",Font.BOLD,size));
//		gImage.drawString(str, x, y);
//	}
}
