import java.awt.Checkbox;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;

public class IngredientsCourses extends Panel implements Observer{
	
	public static int taille=15;
	
	Checkbox[] ingredients;
	Modele m;
	
	public IngredientsCourses(ItemListener l, Modele m) {
		this.setLayout(new GridLayout(16,0));
		
		Label lb = new Label("LISTE DES INGREDIENTS\n");
		lb.setFont(new Font("Serif", Font.BOLD, 18));
		
		ingredients = new Checkbox[taille];
		
		this.add(lb);
		
		for (int i=0; i<taille; i++) {
			this.ingredients[i] = new Checkbox("");
			this.ingredients[i].addItemListener(l);
			this.add(ingredients[i]);
		}
		m.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if (m.al.size()<taille) {	
			for (int i=0; i<m.al.size(); i++) {
				this.ingredients[i].setLabel(m.al.get(i));
				this.add(ingredients[i]);
			}
		}
		else {
			for (int i=0; i<taille; i++) {
				this.ingredients[i].setLabel(m.al.get(i));
				this.add(ingredients[i]);
			}
		}
	}
}