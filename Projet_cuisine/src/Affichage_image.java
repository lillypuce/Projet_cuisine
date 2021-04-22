import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

public class Affichage_image extends Canvas implements Observer {
	
	Image img = null;
	String imgDefaut;
	
	public Affichage_image(Modele m) {
		super();
		this.setPreferredSize(new Dimension(500,200));
		
		imgDefaut = "fond_image_recette";
		File chemin= new File("images/"+imgDefaut+".jpg");
		
		try {
			img = ImageIO.read(chemin);
		} catch (IOException e) {
			throw new RuntimeException("L'image "+imgDefaut+" est introuvable");
		}
		
		m.addObserver(this);
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		imgDefaut = Modele.id_recette;
		File chemin= new File("images2/"+imgDefaut+".jpg");
		
		try {
			if (chemin.isFile()) {
				//Affiche l'image correspondant à la recette
				img = ImageIO.read(chemin);
				repaint();
			}
			else {
				//Si la recette n'a pas d'image, on affiche l'image par défaut
				img = ImageIO.read(new File("images/fond_image_recette.jpg"));
				repaint();
			}
		} catch (IOException e) {
			throw new RuntimeException("L'image fond_image_recette.jpg est introuvable");
		}
	}

}
