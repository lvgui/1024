package dome1024;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Game extends JPanel{
	BufferedImage[] num = new BufferedImage[11];  //放置所有的图片
	int score; //分数
	int nums; //步数 
	int width; //宽
	int height; //高
	boolean moveBoolean = false; //是否需要移动
	public Game(){ //构造函数初始化
		width = Config.WIDTH;
		height = Config.HEIGHT;
		this.setSize(Config.WIDTH, Config.HEIGHT);
		Config.randFirse(); //随机数
		initImage(); 
		calcSore();//计算分数
		nums = 0;
	}

	private void initImage() { //初始化
//			num =  new BufferedImage[11];
		try {
			for (int i = 0; i < num.length; i++){ //赋值
				num[i] = ImageIO.read(this.getClass().getResource("/res/" + (int)Math.pow(2, i) + ".jpg"));
			}
	
		} catch (IOException e) {
			System.out.println("找不到图片的对应的路径");
			e.printStackTrace();
		} 
		
	}
	public void draw(int j,int i,BufferedImage a,Graphics g){ //定义绘画函数
		g.drawImage(a, (j + 1) * Config.CELL + j * Config.CELLWIDTH , (i + 1) * Config.CELL + i * Config.CELLWIDTH,null);
	}
	
	@Override
	public void paint(Graphics g) { //初始化画布
		g.setColor(new Color(236, 188, 42));
		g.fillRect(0, 0, Config.WIDTH, Config.HEIGHT);

		for(int i = 0; i < Config.arr.length; i++){
			for(int j = 0;j < Config.arr[i].length;j++){
				draw(j,i,num[Config.arr[i][j]],g);
			}
		}
	}
	public void play(int direction){ //操作
		switch(direction){
		case Config.LEFT:
			moveLeft();
			this.repaint();
			break;
		case Config.RIGHT:
			moveRight();
			this.repaint();
			break;	
		case Config.UP:
			moveUp();
			this.repaint();
			break;
		case Config.DOWN:
			moveDown();
			this.repaint();
			break;	
		}
		if(moveBoolean){
			generate(); //随机生成
			nums++; //步数加加
//			calcSore(); //计算分数
			moveBoolean = false; //初始化移动			
		}
		if(!overGame()){
			System.out.println("游戏真的结束");							      
		}
	}
//Config.arr.length  是一个恒定的值 为4  以下都用4做次数的代表。程序完成后  改过来
	private void moveLeft() { //左移动
//		boolean moveBoolean = false; //是否需要移动
		for(int i = 0; i < Config.arr.length;i++){
			int index = 0;
			for(int j = 0;j < Config.arr[i].length;j++){ //合并
				if(Config.arr[i][j] != 0 ){
					for(int k = j + 1;k < 4;k++){
						if(Config.arr[i][k] != 0) {
							if(Config.arr[i][k] == Config.arr[i][j]){
								moveBoolean = true;
								Config.arr[i][j]++;
								Config.arr[i][k] = 0;								
							}
								break;
						}
					}
					int temp = Config.arr[i][j];
					Config.arr[i][j] = 0;
					Config.arr[i][index] = temp;
					if(j != index){
						moveBoolean = true;
					}
					index++;
				}
			}
		}
	}
	
	private void generate() { //随机生成
		List<Coordinate> list = new ArrayList<Coordinate>();
		for(int j = 0;j < 4;j++){
			for(int i = 0;i < 4;i++){
				if(Config.arr[i][j] == 0){
					list.add(new Coordinate(i,j));
				}
			}
		}	
		if(!list.isEmpty()){
			int randNum = (int)Math.floor(Math.random() * list.size());
			Config.arr[list.get(randNum).x][list.get(randNum).y] = (int) Math.floor(Math.random() * 2) + 1;
			
		}
		calcSore(); //计算生成分数
		
	}

	private void moveRight() { //右移动
		for(int i = 0; i < Config.arr.length;i++){
			int index = 3;
			for(int j = 3;j >= 0;j--){ //合并
				if(Config.arr[i][j] != 0 ){
					for(int k = j - 1;k >= 0;k--){
						if(Config.arr[i][k] != 0) {
							if(Config.arr[i][k] == Config.arr[i][j]){
								moveBoolean = true;
								Config.arr[i][j]++;
								Config.arr[i][k] = 0;	
							}
								break;
						}
					}
					int temp = Config.arr[i][j];
					Config.arr[i][j] = 0;
					Config.arr[i][index] = temp;
					if(j != index){
						moveBoolean = true;
					}
					index--;					
				}
			}
		}
	}


	private void moveUp() { //上移动
		for(int i = 0; i < Config.arr.length;i++){ //i 代表列 向上移动连不变
			int index = 0;
			for(int j = 0;j < 4;j++){ //合并
				if(Config.arr[j][i] != 0 ){
					for(int k = j + 1;k < 4;k++){
						if(Config.arr[k][i] != 0) {
							if(Config.arr[k][i] == Config.arr[j][i]){
								moveBoolean = true;
								Config.arr[j][i]++;
								Config.arr[k][i] = 0;	
							}
								break;
						}
					}
					int temp = Config.arr[j][i];
					Config.arr[j][i] = 0;
					Config.arr[index][i] = temp;
					if(j != index){
						moveBoolean = true;
					}
					index++;
				}
			}
		}
	}
	 


	private void moveDown() { //下移动
		for(int i = 0; i < Config.arr.length;i++){//i 代表列 向上移动连不变
			int index = 3;
			for(int j = 3;j >= 0;j--){ //合并
				if(Config.arr[j][i] != 0 ){
					for(int k = j - 1;k >= 0;k--){
						if(Config.arr[k][i] != 0) {
							if(Config.arr[k][i] == Config.arr[j][i]){
								moveBoolean = true;
								Config.arr[j][i]++;
								Config.arr[k][i] = 0;
							}
								break;
						}
					}
					int temp = Config.arr[j][i];
					Config.arr[j][i] = 0;
					Config.arr[index][i] = temp;
					if(j != index){
						moveBoolean = true;
					}
					index--;
				}
			}
		}
	}
	
	public void calcSore(){ //游戏积分
		score = 0;
		for(int i = 0; i < Config.arr.length; i++){
			for(int j = 0; j < Config.arr[i].length; j++){
				if(Config.arr[i][j] != 0)
				score += Math.pow(2, Config.arr[i][j]);
			}
		}
	}
	public boolean overGame(){ //判断游戏结束的函数
		loop:for (int i = 0; i < Config.arr.length; i++){
			for (int j = 0; j < Config.arr[i].length;j++){
				if(Config.arr[i][j] == 0){
					return true;
				}
				if(i + 1 < Config.arr.length){
					if(Config.arr[i][j] == Config.arr[i + 1][j]){
						return true;
					}
				}
				if(j + 1 < Config.arr[i].length){
					 if(Config.arr[i][j] == Config.arr[i][j + 1]){
						 return true;
						}
				}
				}
		}
		return false;
	}
	public boolean GameVeci() {	//判断游戏胜利的函数
		loop:for (int i = 0; i < Config.arr.length; i++){
			for (int j = 0; j < Config.arr[i].length;j++){
				if(Config.arr[i][j] == 10) {
					return true;
				}
			}
		}
	return false;
	}
	
}
