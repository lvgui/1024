package dome1024;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Appearance extends Popup {
	AppearancePanel a;
	public Appearance(Point point,int partentWidth,int partentHeight,final Game game) throws Exception {	
		super(point,partentWidth,partentHeight,400,400,"设置外观");
		a = new AppearancePanel();
		a.setBounds(0, 0, 400, 250);
		this.add(a);
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a.choose == 1){
//					game.num =  new BufferedImage[11];
					try {
							for (int i = 0; i < game.num.length; i++){ //赋值
								game.num[i] = ImageIO.read(this.getClass().getResource("/res/" + (int)Math.pow(2, i) + ".jpg"));
								game.repaint();
							}
						} catch (IOException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}

	
				}else if(a.choose == 2){
//					game.num =  new BufferedImage[11];
					try {
						for (int i = 0; i < game.num.length; i++){ //赋值
							game.num[i] = ImageIO.read(this.getClass().getResource("/res/1_" + (int)Math.pow(2, i) + ".jpg"));
							game.repaint();
						}
					} catch (IOException e1) {
							// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(a.choose == 3){
//					game.num =  new BufferedImage[11];
					try {
						for (int i = 0; i < game.num.length; i++){ //赋值
							game.num[i] = ImageIO.read(this.getClass().getResource("/res/2_" + (int)Math.pow(2, i) + ".jpg"));
							game.repaint();
						}
					} catch (IOException e1) {
							// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				Appearance.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(46, 268, 93, 38);
		this.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Appearance.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(209, 268, 93, 38);
		this.add(btnNewButton_1);
		this.setVisible(true);
	}
}
