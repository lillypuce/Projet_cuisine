import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fond_img extends Canvas{
	
	Image ig = null;
	String chemin = "images/fond_img_formulaire.jpg";
	
	public Fond_img() {
		super();
		this.setPreferredSize(new Dimension(300,450));
		
		try {
			ig = ImageIO.read(new File(chemin));
		} catch (IOException e) {
			throw new RuntimeException("Fond Image nouvelle recette");
		}	
	}
	public void paint(Graphics g) {
		g.drawImage(ig,0,0, this.getWidth(), this.getHeight(), null);
	}

}
