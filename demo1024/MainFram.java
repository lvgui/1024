package dome1024;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Menu;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class MainFram extends JFrame{
	Game game = new Game();
	ControlPane cotr = new ControlPane(game);
	MaskPanel mask;
	Readgrade r = new Readgrade();
	BufferedImage logo;
	private int width;
	private int height;
	private Point point;//记录父窗体在屏幕的坐标
	Meau meau; //菜单
	public MainFram(){
		super("1024");
		width = Config.WIDTH + 6 + 300 + 10;
		height = Config.HEIGHT + 28 + 30;
		this.setLocation(200, 200);
		this.setSize(width, height);
		scoreValue();
		try {
			logo = ImageIO.read(this.getClass().getResource("/res/logo.png"));
		} catch (IOException e1) {
			System.out.println("找不到图片");
			e1.printStackTrace();
		}
		this.setIconImage(logo);
		this.setResizable(false);
		
		mask = new MaskPanel(width, height);
		this.add(mask);
		meau = new Meau(cotr);
		meau.setBounds(0, 0, width, 20);
		this.add(meau);
//		game.setBounds(0, 4, 450, 450);
		this.setLayout(null);
		game.setBounds(5, 25, 450, 450);
		cotr.setBounds(455, 25, 300, 450);
//		game.setBounds(0, 0, 450, 450);
//		cotr.setBounds(450, 0, 300, 450);
		this.add(game);
		this.add(cotr);
		mask.setVisible(false);

		this.game.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT:
					game.play(Config.LEFT);
					scoreValue();
					break;
				case KeyEvent.VK_RIGHT:
					game.play(Config.RIGHT);
					scoreValue();
					break;
				case KeyEvent.VK_UP:
					game.play(Config.UP);
					scoreValue();
					break;
				case KeyEvent.VK_DOWN:
					game.play(Config.DOWN);
					scoreValue();
					break;
				case KeyEvent.VK_F2:
					cotr.init();
					break;
				case KeyEvent.VK_F5: //产看帮助
					help();
					break;
				case KeyEvent.VK_F6: //产看帮助
					about();
					break; 	
				case KeyEvent.VK_F1: //音乐控制
					cotr.musicFrame.btnNewButton.doClick();
					break; 
				case KeyEvent.VK_F4: //音乐控制
					rank();
					break; 
				case KeyEvent.VK_F3: //音乐控制
					try {
						appear();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					break;
				}
				if(!game.overGame()){
//					System.out.println("游戏真的结束");
					mask.setVisible(true);
					try {
						showGameOver();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(game.GameVeci()) {
					try {
						showGameVeci();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		this.setVisible(true);
		this.game.setFocusable(true);
	}
	public void scoreValue(){ //输出值
		cotr.textField.setText(game.score + "");
		cotr.textField_1.setText(game.nums + "");
	}
	public void showGameOver() throws Exception{ //游戏结束
		point = this.getLocation();
//		try {
//			r.writeRank(new Grade(game.score,game.nums));
//		} catch (Exception e) {
//			System.out.println("程序错误");
//			e.printStackTrace();
//		}
		new ShowGameOver(point,width,height,game,mask,cotr,r);
	}
	public void showGameVeci() throws Exception{ //游戏通关
		point = this.getLocation();
		try {
			r.writeRank(new Grade(game.score,game.nums));
		} catch (Exception e) {
			System.out.println("程序错误");
			e.printStackTrace();
		}
		new ShowGameVeci(point,width,height,game,mask,cotr,r);
	}
	public void help(){ //帮助指令
		point = this.getLocation();
		new HelpPanel(point,width,height);
	}
	public void about(){ //关于
		point = this.getLocation();
		new AboutPanel(point,width,height);
	}
	public void rank(){ //记录
		point = this.getLocation();
		new GradePanel(point,width,height,r);
	}
	public void appear() throws Exception{ //外观
		point = this.getLocation();
		new Appearance(point,width,height,game);
	}
	public static void main(String[] args) {
		new MainFram();
	}
}
