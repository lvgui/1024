package dome1024;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class GradePanel extends Popup{
	JTextPane textPane;
	public GradePanel(Point point,int partentWidth,int partentHeight,final Readgrade r) {
	super(point,partentWidth,partentHeight,400,400,"天梯榜");		
	JLabel label = new JLabel("天梯榜");
	label.setFont(new Font("宋体", Font.PLAIN, 16));
	label.setBounds(135, 34, 93, 37);
	this.add(label);
	
	textPane = new JTextPane();
	textPane.setEditable(false);
	textPane.setBounds(41, 80, 298, 187);
	textPane.setText(r.showRank());
	this.add(textPane);
	JButton button = new JButton("重置记录");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane j = new JOptionPane();
			int n = j.showConfirmDialog(GradePanel.this, "确认重置记录吗?", "确认", JOptionPane.YES_NO_OPTION);  
	        if (n == j.YES_OPTION) {  
	            try {
					if(r.restRank()){
						System.out.println("重置成功");
						textPane.setText("重置成功----\n\r当前没有记录");
					}						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        } 
		}
		
	});
	button.setBounds(135, 298, 108, 37);
	this.add(button);
	this.setVisible(true);
	}
}
