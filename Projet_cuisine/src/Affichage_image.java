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
	
	public Affichage_image(Modele m) {
		super();
		this.setPreferredSize(new Dimension(140,60));
		String imgDefaut = m.images.get(0).chemin;
		try {
			img = ImageIO.read(new File(imgDefaut));
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
		// TODO Auto-generated method stub
		ImagesModele im = (ImagesModele)arg;
		try {
			img = ImageIO.read(new File(im.chemin));
			repaint();
		} catch (IOException e) {
			throw new RuntimeException("L'image " + im.chemin + " est introuvable");
		}
		
	}

}