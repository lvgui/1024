package dome1024;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dome1024.MainFram;

public class Music extends JPanel implements ActionListener{
//public class Music extends JPanel{
	File[] arrfile;
	int index = 0;
	AudioClip aau; 
	boolean ring;
	JComboBox<String> comboBox;
	Game g;
	JButton btnNewButton;
	public Music(Game g) {
		this.g = g;
		ring = true;
		File f = new File(this.getClass().getResource("").getPath()); 
		File file = new File(f.getParent() + "//music");
		arrfile = file.listFiles();
		this.setLayout(null);	
		comboBox = new JComboBox<String>();
//		comboBox.setForeground(Color.BLACK);
//		comboBox.setBackground(Color.red);
		
		for(int i = 0;i < arrfile.length;i++){
			String str = arrfile[i].getName();
			str = str.substring(0,str.lastIndexOf('.'));
			comboBox.addItem(str);
			//System.out.println(str);
		}
		
		comboBox.setBounds(10, 10, 120, 42);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);  
		this.add(comboBox);
		btnNewButton = new JButton("暂停  F1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(ring) {
					if(aau != null) {
						aau.stop();
					}
					btnNewButton.setText("播放  F1");
					ring = false;
				}else {
					playMusic(index);
					btnNewButton.setText("暂停  F1");
					ring = true;
				}
				Music.this.g.requestFocus();
				
			}
		});
		btnNewButton.setBounds(138, 10, 80, 42);
		this.add(btnNewButton);
		this.setBackground(null);
		playMusic(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 int i=comboBox.getSelectedIndex();  
		    //String s=(String)comboBox.getSelectedItem();  
		    //System.out.println("你选中的是第"+i+"项"+",内容是:"+s);  
		    // 把i插入你数据库中对应的属性字段
		  	if(i != index) {
		  		stopMusic(index);
		  		playMusic(i);
		  		index = i;
		  	}
		  	Music.this.g.requestFocus();
		    
		
	}

	public void stopMusic(int i) {
		    aau.stop();  //循环播放		
	}
	public void playMusic(int i) {
		btnNewButton.setText("暂停  F1");
		if(aau != null) {
			aau.stop();
		}
		File f = arrfile[i];
	    URI  uri = f.toURI();
	    URL url;
		try {
			url = uri.toURL();
		    aau = Applet.newAudioClip(url);
		    aau.loop();  //循环播放
		} catch (MalformedURLException e) {
			System.out.println("无法解析文件");
			e.printStackTrace();
		}  
	    
	}
}
