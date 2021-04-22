import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Interface extends Frame implements WindowListener, ItemListener{
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		new Interface();
	}
	
	public Interface() throws FileNotFoundException, IOException, ParseException {
		
		Modele m = new Modele();
		Controleur ctrl = new Controleur(m);
		Ajouter_recette ar = new Ajouter_recette();
		Recherche_recette rr = new Recherche_recette(m);
		Categorie c = new Categorie(this,m);
		
		this.setPreferredSize(new Dimension(980,680));
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(169,169,169));
		
		Categorie panneaudedroite = new Categorie(ctrl, m);
		this.add(panneaudedroite, BorderLayout.EAST);
		panneaudedroite.setBackground(new Color(139,108,66));
		
		ListeRecettes panneaudegauche = new ListeRecettes(ctrl,m,c);
		this.add(panneaudegauche, BorderLayout.WEST);
		panneaudegauche.setBackground(new Color(139,108,66));
		
		Note_recette panneaudebas = new Note_recette(this, ar, rr);
		this.add(panneaudebas, BorderLayout.SOUTH);
		panneaudebas.setBackground(new Color(139,108,66));
		
		Affichage_image panneaudehaut = new Affichage_image(m);
		this.add(panneaudehaut, BorderLayout.NORTH);
		
		Affichage_recette panneaucentral = new Affichage_recette(this, m);
		this.add(panneaucentral, BorderLayout.CENTER);
		panneaucentral.setBackground(new Color(139,108,66));
		
		this.addWindowListener(this);
		this.setTitle("Projet Cuisine");
		this.pack();
		this.setVisible(true);
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

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
