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
	BufferedImage[] num = new BufferedImage[11];  //�������е�ͼƬ
	int score; //����
	int nums; //���� 
	int width; //��
	int height; //��
	boolean moveBoolean = false; //�Ƿ���Ҫ�ƶ�
	public Game(){ //���캯����ʼ��
		width = Config.WIDTH;
		height = Config.HEIGHT;
		this.setSize(Config.WIDTH, Config.HEIGHT);
		Config.randFirse(); //�����
		initImage(); 
		calcSore();//�������
		nums = 0;
	}

	private void initImage() { //��ʼ��
//			num =  new BufferedImage[11];
		try {
			for (int i = 0; i < num.length; i++){ //��ֵ
				num[i] = ImageIO.read(this.getClass().getResource("/res/" + (int)Math.pow(2, i) + ".jpg"));
			}
	
		} catch (IOException e) {
			System.out.println("�Ҳ���ͼƬ�Ķ�Ӧ��·��");
			e.printStackTrace();
		} 
		
	}
	public void draw(int j,int i,BufferedImage a,Graphics g){ //����滭����
		g.drawImage(a, (j + 1) * Config.CELL + j * Config.CELLWIDTH , (i + 1) * Config.CELL + i * Config.CELLWIDTH,null);
	}
	
	@Override
	public void paint(Graphics g) { //��ʼ������
		g.setColor(new Color(236, 188, 42));
		g.fillRect(0, 0, Config.WIDTH, Config.HEIGHT);

		for(int i = 0; i < Config.arr.length; i++){
			for(int j = 0;j < Config.arr[i].length;j++){
				draw(j,i,num[Config.arr[i][j]],g);
			}
		}
	}
	public void play(int direction){ //����
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
			generate(); //�������
			nums++; //�����Ӽ�
//			calcSore(); //�������
			moveBoolean = false; //��ʼ���ƶ�			
		}
		if(!overGame()){
			System.out.println("��Ϸ��Ľ���");							      
		}
	}
//Config.arr.length  ��һ���㶨��ֵ Ϊ4  ���¶���4�������Ĵ���������ɺ�  �Ĺ���
	private void moveLeft() { //���ƶ�
//		boolean moveBoolean = false; //�Ƿ���Ҫ�ƶ�
		for(int i = 0; i < Config.arr.length;i++){
			int index = 0;
			for(int j = 0;j < Config.arr[i].length;j++){ //�ϲ�
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
	
	private void generate() { //�������
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
		calcSore(); //�������ɷ���
		
	}

	private void moveRight() { //���ƶ�
		for(int i = 0; i < Config.arr.length;i++){
			int index = 3;
			for(int j = 3;j >= 0;j--){ //�ϲ�
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


	private void moveUp() { //���ƶ�
		for(int i = 0; i < Config.arr.length;i++){ //i ������ �����ƶ�������
			int index = 0;
			for(int j = 0;j < 4;j++){ //�ϲ�
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
	 


	private void moveDown() { //���ƶ�
		for(int i = 0; i < Config.arr.length;i++){//i ������ �����ƶ�������
			int index = 3;
			for(int j = 3;j >= 0;j--){ //�ϲ�
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
	
	public void calcSore(){ //��Ϸ����
		score = 0;
		for(int i = 0; i < Config.arr.length; i++){
			for(int j = 0; j < Config.arr[i].length; j++){
				if(Config.arr[i][j] != 0)
				score += Math.pow(2, Config.arr[i][j]);
			}
		}
	}
	public boolean overGame(){ //�ж���Ϸ�����ĺ���
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
	public boolean GameVeci() {	//�ж���Ϸʤ���ĺ���
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
