package dome1024;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class HelpPanel  extends Popup {
	public HelpPanel(Point point,int partentWidth,int partentHeight) {
	super(point,partentWidth,partentHeight,400,400,"����");
	JLabel lblNewLabel = new JLabel("\u5E2E\u52A9\u6587\u6863");
	lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
	lblNewLabel.setBounds(130, 23, 82, 41);
	this.add(lblNewLabel);
	
	JTextPane textPane = new JTextPane();
	textPane.setEditable(false);
	textPane.setText("10241024��һ�����Ȥ������С��Ϸ"
			+ "\r\n ���������������ƶ��ϲ�����\r\n    "
			+ "����ָ��\r\n    "
			+ "��    �����ƶ�\r\n    "
			+ "��    �����ƶ�\r\n    "
			+ "��    �����ƶ�\r\n    "
			+ "��    �����ƶ�\r\n    "
			+ "F1        ����\r\n      "
			+ "F2        ����Ϸ\r\n     "
			+ "F3        �������\r\n    "
			+ "F4        ͳ������\r\n    "
			+ "F5        �鿴����\r\n    "
			+ "F6        ���ڴ���Ϸ");
	textPane.setBounds(42, 73, 297, 250);
	this.add(textPane);	      
	this.setVisible(true);
	}
}
