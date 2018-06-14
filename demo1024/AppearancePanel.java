package dome1024;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AppearancePanel extends  JPanel {
	BufferedImage  style1;
	BufferedImage  style2;
	BufferedImage  style3;
	BufferedImage   mask;
	int choose = 0;
	public AppearancePanel() throws IOException{
		style1 =  ImageIO.read(this.getClass().getResource("/res/2.jpg"));
		style2 =  ImageIO.read(this.getClass().getResource("/res/1_2.jpg"));
		style3 =  ImageIO.read(this.getClass().getResource("/res/2_2.jpg"));
		mask = ImageIO.read(this.getClass().getResource("/res/mask1.png"));
		this.setSize(400,400);
		this.setLayout(null);
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u6837\u5F0F");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel.setBounds(140, 21, 121, 46);
		this.add(lblNewLabel); 
	/*	JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(46, 268, 93, 38);
		this.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�˳�");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppearancePanel.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(209, 268, 93, 38);
		this.add(btnNewButton_1);*/
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
	            int x = e.getX();  //�õ����x����
	            int y = e.getY();  //�õ����y����
//	            System.out.println("��굱ǰ���λ�õ�������" + x + "," + y);
//	            System.out.println(chance(x,y));
	            choose = chance(x,y);
	            AppearancePanel.this.repaint();  	            
			}
		});
		
	}
	public int chance(int x, int y){
		if((20<= x && x <= 120 && y >= 80 && y <= 180) || (48 <= x && x <= 88 && y > 180 && y <= 208) ){
			return 1;
		}
		if((140<= x && x <= 240 && y >= 80 && y <= 180) || (168 <= x && x <= 208 && y > 180 && y <= 208) ){
			return 2;
		}
		if((260<= x && x <= 360 && y >= 80 && y <= 180) || (288 <= x && x <= 328 && y > 180 && y <= 208) ){
			return 3;
		}
		return 0;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(style1, 20, 80, null);
		g.drawString("��ˮ��",50,200);
		g.drawImage(style2, 140, 80, null);
		g.drawString("�����",170,200);
		g.drawImage(style3, 260, 80, null);
		g.drawString("������",290,200);
		if(choose == 1){
			g.drawImage(mask, 15, 75, 110, 110, null);
			g.drawImage(mask, 48, 186, 40, 22, null);
		}else if(choose == 2){
			g.drawImage(mask, 135, 75, 110, 110, null);
			g.drawImage(mask, 168, 186, 40, 22, null);
		}else if(choose == 3){
			g.drawImage(mask, 255, 75, 110, 110, null);
			g.drawImage(mask, 288, 186, 40, 22, null);
		}
	}
//	public static void main(String[] args) throws IOException {
//		JFrame jf = new JFrame();
//		jf.setBounds(200, 200, 400, 400);
//		jf.add(new Test3());
//		jf.setVisible(true);
//		
//	}
}
