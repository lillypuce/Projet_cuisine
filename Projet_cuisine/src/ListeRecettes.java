import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ListeRecettes extends Panel{
	
	Modele m;
	
	public ListeRecettes(ItemListener l, Modele m) {
		/*
		Iterator<RecetteModele> i = m.dicoRecettes.values().iterator();
		
		while (i.hasNext()) {
			lst.add(i.next().nom);
		}
		*/
		List lst = new List(29);
		
		for (HashMap.Entry<String, RecetteModele> entry : m.dicoRecettes.entrySet()) {
			String key = entry.getKey();
			
			String s="Entrée";
			String s2=m.dicoRecettes.get(key).categorie;
			
			if (s.equals(s2)) {
				lst.add(m.dicoRecettes.get(key).nom);
			}
			
			//System.out.println(m.dicoRecettes.get(key).categorie + s);
		}
		
		this.add(lst);
		lst.addItemListener(l);
		lst.select(0);
	}
}