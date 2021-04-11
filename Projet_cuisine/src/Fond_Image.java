import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fond_Image extends Canvas{
	
	Image img = null;
	String chemin = "images/fond_image_recette.jpg";
	
	public Fond_Image() {
		super();
		this.setPreferredSize(new Dimension(500,150));
		
		try {
			img = ImageIO.read(new File(chemin));
		} catch (IOException e) {
			throw new RuntimeException("Fond Image");
		}	
	}
	public void paint(Graphics g) {
		g.drawImage(img,0,0, this.getWidth(), this.getHeight(), null);
	}
}
