import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Interface extends Frame implements WindowListener, ItemListener{
	
	public static Toolkit t = Toolkit.getDefaultToolkit();
	public static Dimension d = t.getScreenSize();
	
	public static int HauteurFenetre = d.width/2;
	public static int LargeurFenetre = d.height/2;
	
	
	public static void main(String[] args) {
		new Interface();
	}
	
	public Interface() {
		
		this.setPreferredSize(new Dimension(HauteurFenetre,LargeurFenetre));
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(169,169,169));
		
		Categorie panneaudedroite = new Categorie(this);
		this.add(panneaudedroite, BorderLayout.EAST);
		panneaudedroite.setBackground(new Color(139,108,66));
		
		Liste_recette panneaudegauche = new Liste_recette(this);
		this.add(panneaudegauche , BorderLayout.WEST);
		panneaudegauche.setBackground(new Color(139,108,66));
		
		
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
