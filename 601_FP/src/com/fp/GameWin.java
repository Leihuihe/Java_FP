package com.fp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import com.fp.obj.BackgroundObj;
import com.fp.obj.BossObj;
import com.fp.obj.BulletObj_enemy;
import com.fp.obj.EnemyObj;
import com.fp.obj.FighterObj;
import com.fp.obj.ShellObj;
import com.fp.utils.GameUtils;


public class GameWin extends JFrame{
	//Game state 0:not begin 1:beginning 2:pause 3:fail 
	public static int state = 0;
	public static int score = 0;
	public static int shootspeed = 6;
	public static int enemy_speed =10;
	public static int boss_shootspeed = 15;
	public static int enemy_shootspeed = 20;
	int width = 800;
	int height = 1000;
	int counts = 1;
	int enemyCount = 0;
	
	
	Image ScreenImage = null;
	
	public FighterObj fighterObj = new FighterObj(GameUtils.fighterImg,290,550,20,30,0,this);
	
	//public BossObj bossObj = null;

	
	BackgroundObj bgobj = new BackgroundObj(GameUtils.bgImg,0,-4200,2);
	
	
	public void launch() 
	{
		this.setVisible(true);
		this.setSize(width,height);
		this.setLocationRelativeTo(null);
		this.setTitle("Flight Game");
		
		GameUtils.gameObjList.add(bgobj);
		GameUtils.gameObjList.add(fighterObj);
		
		this.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == 1 && state == 0)
				{
					state = 1;
					repaint();
				}
				
				if(e.getButton() == 1 && state == 3)
				{
					state = 0;
					repaint();
				}
			}
		});
		
		//pause
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 32)
				{
					switch(state)
					{
					case 1:
						state = 2;
						break;
					case 2:
						state = 1;
						break;
					}
				}
			}
		});
		
		while(true)
		{
			if(state == 1)
			{
				createObj();
				repaint();
			}
						
			try {
				Thread.sleep(20);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics graphic)
	{
		if(ScreenImage == null)
		{
			ScreenImage = createImage(width,height);
		}
		Graphics gImage = ScreenImage.getGraphics();
		gImage.fillRect(0, 0, width, height);
		if (state == 0)
		{
			gImage.drawImage(GameUtils.bgImg2,0,-1000,null);
			gImage.drawImage(GameUtils.bossImg3,270,100,null);
			//gImage.drawImage(GameUtils.explodeImg,200,500,null);
			gImage.setColor(Color.yellow);
			gImage.setFont(new Font("Calibri",Font.BOLD,40));
			gImage.drawString("CLICK TO BEGIN", 280, 800);
			
		}
		if (state == 1)
		{
			
			for(int i=0; i<GameUtils.gameObjList.size(); i++)
			{
				GameUtils.gameObjList.get(i).paintSelf(gImage);
			}
			GameUtils.gameObjList.removeAll(GameUtils.removeList);
			
		}
		if (state == 3)
		{
			gImage.drawImage(GameUtils.explodeImg,fighterObj.getX()-35,fighterObj.getY()-50,null);		
			gImage.setColor(Color.RED);
			gImage.setFont(new Font("Calibri",Font.BOLD,40));
			gImage.drawString("GAME OVER", 300, 770);
			gImage.drawString("CLICK TO RESTART", 270, 800);
			this.score = 0;
			fighterObj.set_health_point(3);
			
		}
		gImage.setColor(Color.green);
		gImage.setFont(new Font("Calibri",Font.BOLD,30));
		gImage.drawString("Score: "+score, 30, 100);
		graphic.drawImage(ScreenImage,0,0,null);
		counts++;
		
		
	}
	
	public void createObj()
	{
		if(counts%shootspeed == 0)
		{
			GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, fighterObj.getX()+3, fighterObj.getY()-16,14,29,7, this));
			GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
	
		}
		if(counts%enemy_speed == 0)
		{
			GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg,(int)(Math.random()*19)*40,0,49,36,7,this));
			GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size() - 1));
			enemyCount++;
			if(score > 5)
			{
				if(score % 10 == 0)
				{
					GameUtils.enemyObjList2.add(new EnemyObj(GameUtils.enemyImg2,(int)(Math.random()*19)*40,0,39,60,3,this));
					GameUtils.gameObjList.add(GameUtils.enemyObjList2.get(GameUtils.enemyObjList2.size() - 1));
					enemyCount++;
				}
			}
			
			if(score > 8)
			{
				if(score % 10 == 0)
				{
					GameUtils.enemyObjList3.add(new EnemyObj(GameUtils.enemyImg3,(int)(Math.random()*17)*40,0,90,120,2,this));
					GameUtils.gameObjList.add(GameUtils.enemyObjList3.get(GameUtils.enemyObjList3.size() - 1));
				}
			}
		}
		
		if(counts%enemy_shootspeed == 0 && GameUtils.enemyObjList2.size() != 0)
		{
			for(EnemyObj enemyObj: GameUtils.enemyObjList2)
			{
				GameUtils.BulletObj_enemyList.add(new BulletObj_enemy(GameUtils.Bullet_enemyImg,enemyObj.getX()+15,enemyObj.getY()+40,15,25,5,this));
				GameUtils.gameObjList.add(GameUtils.BulletObj_enemyList.get(GameUtils.BulletObj_enemyList.size() - 1));
			}
	
		}
		
		if(counts%enemy_shootspeed == 0 && GameUtils.enemyObjList3.size() != 0)
		{
			for(EnemyObj enemyObj: GameUtils.enemyObjList3)
			{
				GameUtils.BulletObj_enemyList.add(new BulletObj_enemy(GameUtils.Bullet_enemyImg2,enemyObj.getX()+40,enemyObj.getY()+60,15,25,6,this));
				GameUtils.gameObjList.add(GameUtils.BulletObj_enemyList.get(GameUtils.BulletObj_enemyList.size() - 1));
			}
	
		}
		
		if(counts%boss_shootspeed == 0 && GameUtils.BossObjList.size() != 0)
		{
			for(BossObj bossObj: GameUtils.BossObjList)
			{
				GameUtils.BulletObj_enemyList.add(new BulletObj_enemy(GameUtils.Bullet_bossImg,bossObj.getX()+60,bossObj.getY()+100,15,25,10,this));
				GameUtils.gameObjList.add(GameUtils.BulletObj_enemyList.get(GameUtils.BulletObj_enemyList.size() - 1));
			}
	
		}
		
		
		
		if(enemyCount % 100 == 0 && enemyCount > 1 && GameUtils.BossObjList.size() < 1)
		{
			GameUtils.BossObjList.add(new BossObj(GameUtils.bossImg,(int)(Math.random()*100+50),(int)(Math.random()*20+25),155,100,5,this));
			GameUtils.gameObjList.add(GameUtils.BossObjList.get(GameUtils.BossObjList.size() - 1));
		}
	}
	
	public static void main(String[] args)
	{
		GameWin gamewin = new GameWin();
		gamewin.launch();
	}

}
