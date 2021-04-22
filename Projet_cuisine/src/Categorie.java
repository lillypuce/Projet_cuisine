import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Categorie extends Panel implements Observer{
	
	public static List lst_categorie;
	
	public Categorie(ItemListener l, Modele m) {
		
		this.setLayout(new BorderLayout());
		
		lst_categorie = new List(29);
		ArrayList<String> lst = new ArrayList<>();
		
		for (HashMap.Entry<String, RecetteModele> entry : m.dicoRecettes.entrySet()) {
			String key = entry.getKey();
			
			if (!lst.contains(m.dicoRecettes.get(key).categorie)) {	
				lst_categorie.add(m.dicoRecettes.get(key).categorie);
				lst.add(m.dicoRecettes.get(key).categorie);
			}
		}
		
		Label c = new Label("CATEGORIES");
		c.setFont(new Font("Serif", Font.BOLD, 17));
		
		lst_categorie.setFont(new Font("Serif", Font.ITALIC, 14));
		
		this.add(c, BorderLayout.NORTH);
		this.add(lst_categorie, BorderLayout.CENTER);
		lst_categorie.addItemListener(l);
		lst_categorie.select(0);
		
		m.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
