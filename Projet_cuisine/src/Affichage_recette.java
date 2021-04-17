import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;


public class Affichage_recette extends Panel implements Observer{
	
	public TextArea text;
	public String s="", s2;
	public static Label titre;
	
	Modele m;
	
	public Affichage_recette(ItemListener l, Modele m) {
		
		s2 = "POISSON PANE";
		titre = new Label(s2);
		titre.setFont(new Font("Serif", Font.BOLD, 18));
		
		for (int i=0; i<m.dicoRecettes.get("poisson_pane").consignes.size(); i++) {
			s=s+m.dicoRecettes.get("poisson_pane").consignes.get(i);
			s=s+"\n";
			
		}
		text = new TextArea(s,10,65);
		
		text.setEditable(false);
		this.add(titre);
		this.add(text);
		m.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		text.setText("");
		s = m.aff_recette;
		text.setText(s);
		text.setEditable(false);
		
		s2 = m.nom_recette_selectionnee.toUpperCase();
		titre.setText(s2);
		titre.setBounds(330-((s2.length()/2)*12),12,500,13);
		
		this.add(titre);
		this.add(text);
	}
}
