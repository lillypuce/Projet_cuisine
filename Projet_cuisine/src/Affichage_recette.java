import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;


public class Affichage_recette extends Panel implements Observer{
	
	public static Label titre;
	
	public TextArea text,text2;
	public String s="Consignes de préparation : \n\n", s2, s3="Ingrédients : \n\n";
	
	
	Modele m;
	
	public Affichage_recette(ItemListener l, Modele m) {
		
		//titre
		s2 = "POISSON PANE";
		titre = new Label(s2);
		titre.setFont(new Font("Serif", Font.BOLD, 18));
		
		//consignes
		for (int i=0; i<m.dicoRecettes.get("poisson_pane").consignes.size(); i++) {
			s=s+m.dicoRecettes.get("poisson_pane").consignes.get(i);
			s=s+"\n";
			
		}
		text = new TextArea(s,10,65);
		text.setEditable(false);
		
		//ingredients
		for (int i=0; i<m.dicoRecettes.get("poisson_pane").affichage_ingredients.size(); i++) {
			s3=s3+"NOM : " + m.dicoRecettes.get("poisson_pane").affichage_ingredients.get(i).get(0);
			s3=s3+"\nQUANTITE : " + m.dicoRecettes.get("poisson_pane").affichage_ingredients.get(i).get(1);
			s3=s3+"\n\n";
		}
		text2 = new TextArea(s3,10,65);
		text2.setEditable(false);

		
		this.add(titre);
		this.add(text);
		this.add(text2);
		m.addObserver(this);
	
	}
	
	@Override
	public void update(Observable o, Object arg) {
		s2 = m.nom_recette_selectionnee.toUpperCase();
		titre.setText(s2);
		titre.setBounds(330-((s2.length()/2)*12),12,500,13);
		
		text.setText("");
		s = "Consignes de préparation : \n\n";
		s = s + m.consignes_recette;
		text.setText(s);
		text.setEditable(false);
		
		text2.setText("");
		s3 = "Ingrédients : \n\n";
		s3 = s3 + m.ingredients_recette;
		text2.setText(s3);
		text2.setEditable(false);
		
		this.add(titre);
		this.add(text);
		this.add(text2);
	}
}
