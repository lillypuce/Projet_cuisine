import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class Recherche_recette extends Panel {
	
	public Recherche_recette(){
		 TextField t = new TextField("Tapez ici pour rechercher une recette � partir d'ingr�dients"); 
		 Button b = new Button("Rechercher");
		 
		 b.setForeground(Color.WHITE);
		 b.setBackground(new Color(0,128,0));
		 
		 this.add(t);
		 this.add(b);
	}
}
