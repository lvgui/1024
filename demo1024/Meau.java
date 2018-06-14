package dome1024;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

//public class Meau extends JFrame {
public class Meau extends JMenuBar {
	JMenu jm1, jm2;
	JMenuItem jmt1_1, jmt1_2, jmt1_3, jmt1_4, jmt2_1, jmt2_2;
	BufferedImage logo;
	ControlPane con; // �������
	public Meau(final ControlPane con) {
		// �˵���
		
//		jmb.add(Box.createHorizontalStrut(10)); �հ�
		this.con = con;
		Font f = new Font("����", Font.PLAIN, 12);
		this.setBackground(Color.white);
		jm1 = new JMenu("��Ϸ(G)");
		jm1.setFont(f);
		jm1.setOpaque(true);
		jm1.setBackground(null);
		try {
			logo = ImageIO.read(this.getClass().getResource("/res/logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSeparator seph = new JSeparator();
	//	JMenuItem newf = new JMenuItem("New",new ImageIcon("icons/new24.gif"));
	//	���������հ�
		addMouse(jm1);
		jm2 = new JMenu("����(H)");
		jm2.setFont(f);
		jm2.setOpaque(true);
		jm2.setBackground(null);
		addMouse(jm2);
		this.add(jm1);
		this.add(jm2);
		ImageIcon ico=new ImageIcon(this.getClass().getResource("/res/logo.png"));
		ico.setImage(ico.getImage().getScaledInstance(12,12,Image.SCALE_DEFAULT));
		ImageIcon icoBlack=new ImageIcon(this.getClass().getResource("/res/black.png"));
		icoBlack.setImage(icoBlack.getImage().getScaledInstance(12,12,Image.SCALE_DEFAULT));
	
		jmt1_1 = new JMenuItem("����Ϸ(N) F2",ico);
		jmt1_1.addMouseListener(new MouseAdapter() {  //����Ϸ�¼�
			@Override  
	        public void mousePressed(MouseEvent e) {//ֻ�ܼ�⵽mousePressed�¼�  
				con.init();
//				System.out.println("����Ϸ�¼�");
	        }    
		});  
		jmt1_2 = new JMenuItem("������� F3");
		jmt1_2.addMouseListener(new MouseAdapter() {  //����¼�
			@Override  
	        public void mousePressed(MouseEvent e) {//ֻ�ܼ�⵽mousePressed�¼�  
				try {
					Thread.sleep(200);
//					System.out.println('a');
					new Robot().keyPress(KeyEvent.VK_F3);
				} catch (AWTException | InterruptedException e1) {
					// TODO Auto-generated catch block
					System.out.println("�������");
				}
	        } 
		});
		jmt1_3 = new JMenuItem("ͳ������ F4");
		jmt1_3.addMouseListener(new MouseAdapter() {  //ͳ���¼�
			@Override  
	        public void mousePressed(MouseEvent e) {//ֻ�ܼ�⵽mousePressed�¼�  
				try {
					Thread.sleep(200);
//					System.out.println('a');
					new Robot().keyPress(KeyEvent.VK_F4);
				} catch (AWTException | InterruptedException e1) {
					// TODO Auto-generated catch block
					System.out.println("�������");
				}
	        } 
		});
		jmt1_4 = new JMenuItem("�˳�");
		jmt1_4.addMouseListener(new MouseAdapter() {  //�˳�
	        @Override  
	        public void mousePressed(MouseEvent e) {//ֻ�ܼ�⵽mousePressed�¼�  
	            System.exit(0);  
	        }  
	    });  
		jmt2_1 = new JMenuItem("�鿴���� F5",icoBlack);
		jmt2_1.addMouseListener(new MouseAdapter() {  //�����¼�
			@Override  
	        public void mousePressed(MouseEvent e) {//ֻ�ܼ�⵽mousePressed�¼�  
				try {
					Thread.sleep(200);
//					System.out.println('a');
					new Robot().keyPress(KeyEvent.VK_F5);
				} catch (AWTException | InterruptedException e1) {
					// TODO Auto-generated catch block
					System.out.println("�������");
				}
	        } 
		});

 
		jmt2_2 = new JMenuItem("���ڴ���ϷF6");
		jmt2_2.addMouseListener(new MouseAdapter() {  //������Ϸ
			@Override  
	        public void mousePressed(MouseEvent e) {//ֻ�ܼ�⵽mousePressed�¼�  
				try {
					Thread.sleep(200);
//					System.out.println('a');
					new Robot().keyPress(KeyEvent.VK_F6);
				} catch (AWTException | InterruptedException e1) {
					// TODO Auto-generated catch block
					System.out.println("�������");
				}
	        } 
		});
		jm1.add(jmt1_1);
		jm1.add(jmt1_2);
		jm1.add(jmt1_3);
		jm1.addSeparator();//��ӷָ���
		jm1.add(jmt1_4);
		jm2.add(jmt2_1);
		jm2.add(jmt2_2);
		jmt1_1.setFont(f);
		jmt1_2.setFont(f);
		jmt1_3.setFont(f);
		jmt1_4.setFont(f);
		jmt2_1.setFont(f);
		jmt2_2.setFont(f);
//		this.add(jmb, "North");
//		this.setVisible(true);
//		this.setSize(400, 300);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void addMouse(final JMenu jm1) { //�����������¼�
		jm1.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				jm1.setBackground(new Color(183, 236, 246));
			}
			public void mouseExited(MouseEvent e) {
				jm1.setBackground(null);
			}
			});
	}
//	public static void main(String args[]) {
//		new Meau();
//	}
}