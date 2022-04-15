package com.fp.utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import com.fp.obj.EnemyObj;
import com.fp.obj.GameObj;
import com.fp.obj.ShellObj;

public class GameUtils {
	
	public static Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
	
	public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
	
	public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
	
	public static Image fighterImg = Toolkit.getDefaultToolkit().getImage("imgs/fighter.png");
	
	public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
	
	public static Image enemyImg = Toolkit.getDefaultToolkit().getImage("imgs/enemy.png");
	
	public static List<GameObj> gameObjList = new ArrayList<>();
	
	public static List<GameObj> removeList = new ArrayList<>();
	
	public static List<ShellObj> shellObjList = new ArrayList<>();

	public static List<EnemyObj> enemyObjList = new ArrayList<>();

}
