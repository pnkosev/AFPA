import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PenduPanel extends JPanel {
	private int value;
	
	public PenduPanel() {
		this.value = 0;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		String path = new File("src/test" + this.value + ".jpg").getAbsolutePath();
		
		Image img;
		try {
			img = ImageIO.read(new File(path));
			g.drawImage(img, 0, 0, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
