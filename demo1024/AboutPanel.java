package dome1024;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class AboutPanel  extends Popup {
	public AboutPanel(Point point,int partentWidth,int partentHeight) {
	super(point,partentWidth,partentHeight,400,400,"����");	
	JLabel lblNewLabel = new JLabel("1024Ļ��");
	lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
	lblNewLabel.setEnabled(false);
	lblNewLabel.setBounds(128, 25, 94, 45);
	this.add(lblNewLabel);
	
	JTextPane textPane = new JTextPane();
	textPane.setEditable(false);
	textPane.setText("��λͬѧ�ã�\r\n    "
			+ "��л���ʹ�ñ�С�������ġ�1024С��Ϸ��\r\n"
			+ "С���Ա��\r\n    "
			+ "��ǿ���»ԡ�����������\r\n"
			+ "�����Ҷ���Ϸ���κν��鶼���Է����ʼ���\r\n   "
			+ "1319557659@qq.com\r\n"
			+ "���ǻᾫ�Ĳ鿴ÿλ��ҵ������Ŭ��Ϊ��Ҵ����������Ϸ");
	textPane.setBounds(32, 67, 303, 195);
	this.add(textPane);
	
	JButton btnNewButton = new JButton("����˵��");
	btnNewButton.setBounds(41, 284, 93, 47);
	this.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Դ�ļ�����");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	btnNewButton_1.setBounds(213, 284, 93, 47);
	this.add(btnNewButton_1);      
	this.setVisible(true);
	}
}

