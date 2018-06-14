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
	super(point,partentWidth,partentHeight,400,400,"���ݰ�");		
	JLabel label = new JLabel("���ݰ�");
	label.setFont(new Font("����", Font.PLAIN, 16));
	label.setBounds(135, 34, 93, 37);
	this.add(label);
	
	textPane = new JTextPane();
	textPane.setEditable(false);
	textPane.setBounds(41, 80, 298, 187);
	textPane.setText(r.showRank());
	this.add(textPane);
	JButton button = new JButton("���ü�¼");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane j = new JOptionPane();
			int n = j.showConfirmDialog(GradePanel.this, "ȷ�����ü�¼��?", "ȷ��", JOptionPane.YES_NO_OPTION);  
	        if (n == j.YES_OPTION) {  
	            try {
					if(r.restRank()){
						System.out.println("���óɹ�");
						textPane.setText("���óɹ�----\n\r��ǰû�м�¼");
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
