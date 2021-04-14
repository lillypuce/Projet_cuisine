import java.awt.Canvas;
import java.awt.Color;
import java.awt.List;
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
		for (int i=0; i<m.dicoRecettes.get("poisson_pane").consignes.size(); i++) {
			s=s+m.dicoRecettes.get("poisson_pane").consignes.get(i);
			s=s+"\n";
		}
		text = new TextArea(s,32,100);
		
		text.setEditable(false);
		this.add(text);
		m.addObserver(this);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
