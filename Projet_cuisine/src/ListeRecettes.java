import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.util.Iterator;

public class ListeRecettes extends Panel{
	
	Modele m;
	
	public ListeRecettes(ItemListener l, Modele m) {	
		List plats = new List(29);
		
		Iterator<RecetteModele> i = m.dicoRecettes.values().iterator();
		while (i.hasNext()) {
			plats.add(i.next().nom);
		}
		
		this.add(plats);
		plats.addItemListener(l);
		
	}
}