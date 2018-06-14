package dome1024;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ControlPane extends JPanel{
	Game g;
	BufferedImage logos;
	JTextField textField,textField_1;
	Music musicFrame;
	public ControlPane(Game g){ //构造
		this.setSize(300, 440);
		this.g = g;
		initImage();
		
	}
	/**
	 * 
	 */
	private void initImage() {
		try {
			logos = ImageIO.read(this.getClass().getResource("/res/bg.jpg"));
		} catch (IOException e) {
			System.out.println("找不到图片的路径");
			e.printStackTrace();
		}
		this.setFocusable(false); 
		this.setLayout(null);
		//音乐控件
	
		musicFrame = new Music(g);
		
		musicFrame.setBounds(40, 220, 220, 60);
//		musicFrame.setBackground(Color.red);
		this.add(musicFrame);
		//1024小游戏
		JLabel lblNewLabel = new JLabel("1024\u5C0F\u6E38\u620F");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel.setBounds(81, 40, 113, 36);
		this.add(lblNewLabel);
//		musicFrame.setBounds(56, 200, 120, 41);
//		this.add(musicFrame);
		//新游戏按钮
		JButton btnNewButton = new JButton("\u65B0\u6E38\u620F");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControlPane.this.g.requestFocus();
				init();
			}
		});
		btnNewButton.setBounds(56, 297, 161, 45);
		this.add(btnNewButton);
		
		//分数
		JLabel lblNewLabel_1 = new JLabel("\u5206\u6570");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(50, 103, 66, 29);
		this.add(lblNewLabel_1);
		
		//分数值
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(151, 100, 66, 32);
		this.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6B65\u6570"); //步数
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(42, 160, 74, 29);
		this.add(lblNewLabel_2);
		
		textField_1 = new JTextField(); //步数值
		textField_1.setEditable(false);
		textField_1.setBounds(151, 160, 66, 29);
		this.add(textField_1);
		textField_1.setColumns(10);
		
	}
	public void init(){ //重新开始游戏
		for(int i = 0; i < Config.arr.length; i++){
			for(int j = 0; j < Config.arr[i].length; j++){
				Config.arr[i][j] = 0;
			}
		}
		Config.randFirse();
		ControlPane.this.g.calcSore();
		ControlPane.this.g.repaint();
		ControlPane.this.textField.setText(g.score + "");
		g.nums = 0;
		ControlPane.this.textField_1.setText(g.nums + "");
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		g.fillRect(0, 10, 300, Config.HEIGHT);
		g.drawImage(logos, 0, 0, null);
	}

}
