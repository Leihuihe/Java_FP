package com.fp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import com.fp.obj.BackgroundObj;
import com.fp.obj.EnemyObj;
import com.fp.obj.FighterObj;
import com.fp.obj.ShellObj;
import com.fp.utils.GameUtils;

public class GameWin extends JFrame{
	//Game state 0:not begin 1:beginning 2:pause 3:fail 4:success
	public static int state = 0;
	int width = 600;
	int height = 800;
	int counts = 1;
	
	Image ScreenImage = null;
	
	public FighterObj fighterObj = new FighterObj(GameUtils.fighterImg,290,550,20,30,0,this);
	
	BackgroundObj bgobj = new BackgroundObj(GameUtils.bgImg,0,-2000,2);
	
	
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
			gImage.drawImage(GameUtils.bgImg,200,100,null);
			gImage.drawImage(GameUtils.bossImg,350,100,null);
			gImage.drawImage(GameUtils.explodeImg,400,700,null);
			gImage.setColor(Color.yellow);
			gImage.setFont(new Font("Calibri",Font.BOLD,40));
			gImage.drawString("CLICK TO BEGIN", 310, 350);
			
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
			gImage.drawString("GAME OVER", 300, 300);
			
		}
		graphic.drawImage(ScreenImage,0,0,null);
		counts++;
		
	}
	
	public void createObj()
	{
		if(counts%10 == 0)
		{
			GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, fighterObj.getX()+3, fighterObj.getY()-16,14,29,7, this));
			GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
	
		}
		if(counts%15 == 0)
		{
			GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg,(int)(Math.random()*12)*50,0,49,36,5,this));
			GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size() - 1));
	
		}
	}
	
	public static void main(String[] args)
	{
		GameWin gamewin = new GameWin();
		gamewin.launch();
	}

}
