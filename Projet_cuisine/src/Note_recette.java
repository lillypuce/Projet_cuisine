import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ItemListener;

public class Note_recette extends Panel{
	
	Checkbox[] etoiles = new Checkbox[5];
	
	public static String[] libelles = {"1 etoile", "2 etoiles", "3 etoiles", "4 etoiles", "5 etoiles"};
	
	public Note_recette(ItemListener l) {
		
		this.setLayout(new FlowLayout());
		
		CheckboxGroup cg=new CheckboxGroup();
		for (int i=0; i<5; i++) {
			this.etoiles[i] = new Checkbox(libelles[i], false, cg);
			this.etoiles[i].addItemListener(l);
			this.add(this.etoiles[i]);
		}
	}
}
