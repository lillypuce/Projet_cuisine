import java.awt.Canvas;
import java.awt.Color;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;


public class Affichage_recette extends Panel implements Observer{
	
	public static List liste;
	
	public Affichage_recette(ItemListener l, Modele m) {
		liste = new List(29);
		
		liste.add(m.dicoRecettes.get("poisson_pane").nom);
		this.add(liste);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
