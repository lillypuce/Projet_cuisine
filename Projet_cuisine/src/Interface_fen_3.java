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

public class Interface_fen_3 extends Frame implements WindowListener, ItemListener {

	public Interface_fen_3() throws FileNotFoundException, IOException, ParseException {
		
		Modele m = new Modele();
		Controleur ctr2 = new Controleur(m);
		Recherche_recette Rr = new Recherche_recette();
		
		 
		this.setPreferredSize(new Dimension(980,680));
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(125,100,82));
		
		Fond_img2 panneaudedroite = new Fond_img2();
		this.add(panneaudedroite, BorderLayout.EAST);
		
		Formulaire1 panneaudegauche = new Formulaire1();
		this.add(panneaudegauche, BorderLayout.CENTER);
		panneaudegauche.setBackground(new Color(209,200,194));
	
		this.addWindowListener(this);
		this.setTitle("Résultat : Recherche recette");
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
		this.dispose();
		
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


