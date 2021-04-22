import java.awt.BorderLayout;
import java.awt.Color;
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
	public String s="CONSIGNES DE PREPARATION : \n\n", s2, s3="INGREDIENTS : \n\n";
	
	Modele m;
	public Affichage_recette(ItemListener l, Modele m) {
		this.setLayout(new BorderLayout());
		
		//titre
		s2 = "POISSON PANE";
		titre = new Label(s2, Label.CENTER);
		titre.setFont(new Font("Serif", Font.BOLD, 18));
		titre.setForeground(Color.ORANGE);
		//consignes
		for (int i=0; i<m.dicoRecettes.get("poisson_pane").consignes.size(); i++) {
			s=s+m.dicoRecettes.get("poisson_pane").consignes.get(i);
			s=s+"\n\n";
			
		}
		text = new TextArea(s,10,43);
		text.setEditable(false);
		
		//Ingredients
		for (int i=0; i<m.dicoRecettes.get("poisson_pane").affichage_ingredients.size(); i++) {
			String nom = m.dicoRecettes.get("poisson_pane").affichage_ingredients.get(i).get(0);
			String quantite = m.dicoRecettes.get("poisson_pane").affichage_ingredients.get(i).get(1);
			
			s3=s3+"NOM : " + nom + "\nQUANTITE : " + quantite + "\n\n";
		}
		
		text2 = new TextArea(s3,8,20);
		text2.setEditable(false);
		this.add(titre, BorderLayout.NORTH);
		this.add(text, BorderLayout.WEST);
		this.add(text2, BorderLayout.EAST);
		
		m.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		s2 = m.nom_recette_selectionnee.toUpperCase();
		titre.setText(s2);
		titre.setBounds(s2.length()+80,8,500,13);
		
		text.setText("");
		s = "CONSIGNES DE PREPARATION : \n\n";
		s = s + m.consignes_recette;
		text.setText(s);
		text.setEditable(false);
		
		text2.setText("");
		s3 = "INGREDIENTS : \n\n";
		s3 = s3 + m.ingredients_recette;
		text2.setText(s3);
		text2.setEditable(false);
		
		this.add(titre);
		this.add(text);
		this.add(text2);
	}
}
