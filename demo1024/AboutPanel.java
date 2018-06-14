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
	super(point,partentWidth,partentHeight,400,400,"关于");	
	JLabel lblNewLabel = new JLabel("1024幕后");
	lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
	lblNewLabel.setEnabled(false);
	lblNewLabel.setBounds(128, 25, 94, 45);
	this.add(lblNewLabel);
	
	JTextPane textPane = new JTextPane();
	textPane.setEditable(false);
	textPane.setText("各位同学好！\r\n    "
			+ "感谢大家使用本小组制作的《1024小游戏》\r\n"
			+ "小组成员：\r\n    "
			+ "贾强、陈辉、辛琪、吕贵\r\n"
			+ "如果大家对游戏有任何建议都可以发送邮件到\r\n   "
			+ "1319557659@qq.com\r\n"
			+ "我们会精心查看每位玩家的意见，努力为大家带来更多的游戏");
	textPane.setBounds(32, 67, 303, 195);
	this.add(textPane);
	
	JButton btnNewButton = new JButton("过程说明");
	btnNewButton.setBounds(41, 284, 93, 47);
	this.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("源文件下载");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	btnNewButton_1.setBounds(213, 284, 93, 47);
	this.add(btnNewButton_1);      
	this.setVisible(true);
	}
}

