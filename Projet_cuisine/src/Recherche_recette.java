import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextArea;

public class Recherche_recette extends Panel {
	
	public Recherche_recette(){
		 TextArea t = new TextArea("Tapez ici pour rechercher une recette à partir d'ingrédients",1,40); 
		 Button b = new Button("Rechercher");
		 
		 b.setForeground(Color.WHITE);
		 b.setBackground(new Color(0,128,0));
		 
		 this.add(t);
		 this.add(b);
	}
}
