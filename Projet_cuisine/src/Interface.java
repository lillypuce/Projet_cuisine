import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Interface extends Frame implements WindowListener{
	
	public static Toolkit t = Toolkit.getDefaultToolkit();
	public static Dimension d = t.getScreenSize();
	
	public int HauteurFenetre = d.width/2;
	public int LargeurFenetre = d.height/2;
	
	
	public static void main(String[] args) {
		new Interface();
	}
	
	public Interface() {
		
		this.setPreferredSize(new Dimension(HauteurFenetre,LargeurFenetre));
		
		this.setLayout(new BorderLayout());
		
		Categorie panneaudedroite = new Categorie();
		this.add(panneaudedroite, BorderLayout.EAST);
		
		Recette panneaucentral = new Recette();
		this.add(panneaucentral, BorderLayout.CENTER);
		
		this.addWindowListener(this);
		this.setTitle("Interface du projet");
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

		
}
