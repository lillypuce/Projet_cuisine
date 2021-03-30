import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ItemListener;

public class Categorie extends Panel {
	
	public static String[] categ = {"Entrees","Plats","Desserts", "Boissons"};
	
	public Categorie(ItemListener l) {
		
		List lst_categorie = new List(29);
		
		for (int i=0; i< categ.length; i++) {
			lst_categorie.add(Categorie.categ[i]);
		}
		this.add(lst_categorie);
		lst_categorie.addItemListener(l);
	}

}
