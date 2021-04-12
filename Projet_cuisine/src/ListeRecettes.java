import java.awt.Dimension;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class ListeRecettes extends Panel implements Observer{
	
	Modele m;
	Categorie c;
	public static List lst;
	
	public static ArrayList lst_entree;
	public static ArrayList lst_plats;
	public static ArrayList lst_desserts;

	public ListeRecettes(ItemListener l, Modele m, Categorie c) {
		
		lst = new List(29);
		lst_entree = new ArrayList(29);
		lst_plats = new ArrayList(29);
		lst_desserts = new ArrayList(29);
		
		for (int i=0; i<3; i++) {
			for (HashMap.Entry<String, RecetteModele> entry : m.dicoRecettes.entrySet()) {
				
				String key = entry.getKey();
	
				String s=c.lst_categorie.getItem(i);
				String s2=m.dicoRecettes.get(key).categorie;
				
				if (i==0) {
					if (s.equals(s2)) {
						lst_plats.add(m.dicoRecettes.get(key).nom);
					}
				}
				if (i==1) {
					if (s.equals(s2)) {
						lst_entree.add(m.dicoRecettes.get(key).nom);
					}
				}
				if (i==2) {
					if (s.equals(s2)) {
						lst_desserts.add(m.dicoRecettes.get(key).nom);
					}
				}
			}
		}
		
		for (int i=0; i<lst_plats.size(); i++) {
			lst.add((String) lst_plats.get(i));
		}
		this.add(lst);
		lst.addItemListener(l);
		lst.select(0);
		
		m.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		lst.clear();
		
		if (m.categorie_selectionnee == 0) {
			for (int i=0; i<lst_plats.size(); i++) {
				lst.add((String) lst_plats.get(i));
			}
		}
		
		if (m.categorie_selectionnee == 1) {
			for (int i=0; i<lst_entree.size(); i++) {
				lst.add((String) lst_entree.get(i));
			}
		}
		
		if (m.categorie_selectionnee == 2) {
			for (int i=0; i<lst_desserts.size(); i++) {
				lst.add((String) lst_desserts.get(i));
			}
		}
		
		this.add(lst);
	}	
}