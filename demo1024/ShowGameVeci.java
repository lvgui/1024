package dome1024;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class ShowGameVeci extends Popup { //游戏结束

	public ShowGameVeci(Point point,int partentWidth,int partentHeight,Game game,MaskPanel mask,ControlPane cotr,Readgrade r) throws Exception {
		super(point,partentWidth,partentHeight,400,400,"游戏通过");
		init(game,r,mask,cotr);
	}
	public void init(Game game,Readgrade r,final MaskPanel mask,final ControlPane cotr) throws Exception {
	      //当前无法移动
	      JLabel lblNewLabel = new JLabel("恭喜你通关了游戏！");
	      lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
	      lblNewLabel.setBounds(69, 45, 237, 35);
	      this.add(lblNewLabel);
	      //分数
	      JTextPane textPane = new JTextPane();
	      textPane.setFont(new Font("微软雅黑", Font.PLAIN, 14));
	      textPane.setBounds(30, 90, 300, 140);
	      textPane.setEditable(false);
	      textPane.setText(r.writeRank(new Grade(game.score,game.nums)));
	      this.add(textPane);
	      //重新开始
			JButton btnNewButton = new JButton("再来一局");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ShowGameVeci.this.setVisible(false);
					mask.setVisible(false);
					cotr.init();
				}
			});
			btnNewButton.setBackground(Color.PINK);
			btnNewButton.setBounds(47, 251, 93, 41);
			this.add(btnNewButton);
			//退出
			JButton btnNewButton_1 = new JButton("退出");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnNewButton_1.setBackground(Color.PINK);
			btnNewButton_1.setBounds(213, 251, 93, 41);
			this.add(btnNewButton_1);
			//关闭时间监听
			this.addWindowListener(new WindowAdapter(){     //添加一个窗口监听
			       public void windowClosing(WindowEvent e) {    //这是窗口关闭事件
			    	   mask.setVisible(false);
						cotr.init();
//						System.out.println("你好");      
			    }
			 });	      
	      this.setVisible(true);
	}
}
