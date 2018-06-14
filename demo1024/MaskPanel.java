package dome1024;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MaskPanel extends JPanel { //ÕÚÕÖ²ã
	BufferedImage bg; 
	public MaskPanel(int width, int height){
		try {
			bg = ImageIO.read(this.getClass().getResource("/res/mask1.png"));
		} catch (IOException e) {
			System.out.println("ÎÄ¼þÂ·¾¶´íÎó");
			e.printStackTrace();
		}
		this.setSize(width, height);
		this.setBackground(null);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(236, 188, 42));
		g.drawImage(bg, 0, 0, null);
	}
}
