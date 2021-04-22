import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Controleur implements ItemListener {
	
	Modele modl;
	
	public Controleur(Modele m) {
		this.modl=m;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == Categorie.lst_categorie) {
			this.modl.select_categ((Integer)e.getItem());
			this.modl.select_recette(0);
			
		}
		if (e.getSource() == ListeRecettes.lst) {
			this.modl.select_recette((Integer)e.getItem());
		}
		
	}

}
