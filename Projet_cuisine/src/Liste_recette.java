import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;

public class Liste_recette extends Panel{
	
	public static String[] recette = {"Margherita", "Océane", "Magret de canard aux pommes et au cidre"};
	
	public Liste_recette(ItemListener l) {
		
		List lst_recette = new List(10);
		for (int i=0; i<recette.length; i++) {
			lst_recette.add(Liste_recette.recette[i]);
		}
		this.add(lst_recette);
		lst_recette.addItemListener(l);
	}
}
