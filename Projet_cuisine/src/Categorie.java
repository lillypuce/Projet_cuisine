import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Categorie extends Panel implements Observer{
	
	public static List lst_categorie;
	int categorie_selectionnee=0;
	
	public Categorie(ItemListener l, Modele m) {
		
		lst_categorie = new List(29);
		ArrayList<String> lst = new ArrayList<>();
		
		for (HashMap.Entry<String, RecetteModele> entry : m.dicoRecettes.entrySet()) {
			String key = entry.getKey();
			
			
			if (!lst.contains(m.dicoRecettes.get(key).categorie)) {	
				lst_categorie.add(m.dicoRecettes.get(key).categorie);
				lst.add(m.dicoRecettes.get(key).categorie);
			}
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
