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

public class ShowGameVeci extends Popup { //��Ϸ����

	public ShowGameVeci(Point point,int partentWidth,int partentHeight,Game game,MaskPanel mask,ControlPane cotr,Readgrade r) throws Exception {
		super(point,partentWidth,partentHeight,400,400,"��Ϸͨ��");
		init(game,r,mask,cotr);
	}
	public void init(Game game,Readgrade r,final MaskPanel mask,final ControlPane cotr) throws Exception {
	      //��ǰ�޷��ƶ�
	      JLabel lblNewLabel = new JLabel("��ϲ��ͨ������Ϸ��");
	      lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 18));
	      lblNewLabel.setBounds(69, 45, 237, 35);
	      this.add(lblNewLabel);
	      //����
	      JTextPane textPane = new JTextPane();
	      textPane.setFont(new Font("΢���ź�", Font.PLAIN, 14));
	      textPane.setBounds(30, 90, 300, 140);
	      textPane.setEditable(false);
	      textPane.setText(r.writeRank(new Grade(game.score,game.nums)));
	      this.add(textPane);
	      //���¿�ʼ
			JButton btnNewButton = new JButton("����һ��");
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
			//�˳�
			JButton btnNewButton_1 = new JButton("�˳�");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnNewButton_1.setBackground(Color.PINK);
			btnNewButton_1.setBounds(213, 251, 93, 41);
			this.add(btnNewButton_1);
			//�ر�ʱ�����
			this.addWindowListener(new WindowAdapter(){     //���һ�����ڼ���
			       public void windowClosing(WindowEvent e) {    //���Ǵ��ڹر��¼�
			    	   mask.setVisible(false);
						cotr.init();
//						System.out.println("���");      
			    }
			 });	      
	      this.setVisible(true);
	}
}
