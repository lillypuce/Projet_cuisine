import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Interface_fen_2 extends Frame implements WindowListener, ItemListener{

	public static Toolkit t = Toolkit.getDefaultToolkit();
	public static Dimension d = t.getScreenSize();
	
	public static int HauteurFenetre = d.width-300;
	public static int LargeurFenetre = d.height-120;
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		new Interface_fen_2();

	}
public Interface_fen_2() throws FileNotFoundException, IOException, ParseException {
	Modele m = new Modele();
	Controleur ctrl = new Controleur(m);
	Ajouter_recette ar = new Ajouter_recette();
	Recherche_recette rr = new Recherche_recette();
	Categorie c = new Categorie(this,m);
	
	
	this.setPreferredSize(new Dimension(HauteurFenetre,LargeurFenetre));
	this.setLayout(new BorderLayout());
	this.setBackground(new Color(200,200,200));
	
	Ajouter_recette panneaudegauche = new Ajouter_recette();
	this.add(panneaudegauche, BorderLayout.WEST);
	panneaudegauche.setBackground(new Color(200,200,200));
	
	

	
	
	
	
	this.addWindowListener(this);
	this.setTitle("Projet Cuisine ajout recette");
	this.pack();
	this.setVisible(true);
}
		
		

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
