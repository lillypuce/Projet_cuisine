import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;


public class Affichage_recette extends Panel implements Observer{
	
	public TextArea text;
	public String s="";
	
	Modele m;
	
	public Affichage_recette(ItemListener l, Modele m) {
		
		Label consignes = new Label("CONSIGNES");
		consignes.setFont(new Font("Serif", Font.BOLD, 15));
		
		Label ingredients = new Label("INGREDIENTS");
		ingredients.setFont(new Font("Serif", Font.BOLD, 15));
		
		for (int i=0; i<m.dicoRecettes.get("poisson_pane").consignes.size(); i++) {
			s=s+m.dicoRecettes.get("poisson_pane").consignes.get(i);
			s=s+"\n";
			
		}
		text = new TextArea(s,10,65);
		
		text.setEditable(false);
		this.add(consignes);
		this.add(text);
		this.add(ingredients);
		m.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		text.setText("");
		s = m.aff_recette;
		text.setText(s);
		text.setEditable(false);
		
		this.add(text);
		
	}
}
