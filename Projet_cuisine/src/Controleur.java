import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

public class Controleur implements ItemListener {
	
	Modele modl;
	
	public Controleur(Modele m) {
		this.modl=m;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof java.awt.List) {
			this.modl.select_categ((Integer)e.getItem());	
		}
		
	}

}
