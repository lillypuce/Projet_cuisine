import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;

public class Categorie extends Panel implements Observer{
	
	public static String[] categ = {"Entrees","Plats","Desserts", "Boissons"};
	
	List lst_categorie;
	
	public Categorie(ItemListener l, Modele m) {
		
		lst_categorie = new List(29);
		
		for (int i=0; i< categ.length; i++) {
			lst_categorie.add(Categorie.categ[i]);
		}
		this.add(lst_categorie);
		lst_categorie.addItemListener(l);
		lst_categorie.select(0);
		
		m.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		int i = this.lst_categorie.getSelectedIndex();
		this.lst_categorie.replaceItem(arg.toString(), i);
		this.lst_categorie.select(i);
	}

}
