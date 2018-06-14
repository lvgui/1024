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
	super(point,partentWidth,partentHeight,400,400,"帮助");
	JLabel lblNewLabel = new JLabel("\u5E2E\u52A9\u6587\u6863");
	lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
	lblNewLabel.setBounds(130, 23, 82, 41);
	this.add(lblNewLabel);
	
	JTextPane textPane = new JTextPane();
	textPane.setEditable(false);
	textPane.setText("10241024是一款简单有趣的益智小游戏"
			+ "\r\n 根据上下左右来移动合并数字\r\n    "
			+ "操作指令\r\n    "
			+ "↑    向上移动\r\n    "
			+ "←    向左移动\r\n    "
			+ "→    向右移动\r\n    "
			+ "↓    向下移动\r\n    "
			+ "F1        音乐\r\n      "
			+ "F2        新游戏\r\n     "
			+ "F3        更改外观\r\n    "
			+ "F4        统计数据\r\n    "
			+ "F5        查看帮助\r\n    "
			+ "F6        关于此游戏");
	textPane.setBounds(42, 73, 297, 250);
	this.add(textPane);	      
	this.setVisible(true);
	}
}
