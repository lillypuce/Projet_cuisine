import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import org.json.simple.parser.ParseException;

public class Interface_fen_3 extends Frame implements WindowListener, Observer{
	
	Modele m;
	public static List l_interface3;
	
	public Interface_fen_3(ItemListener l, Modele m)  throws FileNotFoundException, IOException, ParseException {
		
		this.setPreferredSize(new Dimension(1050,680));
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(209,200,194));
		
		Label lb=new Label("MA LISTE DE COURSES", Label.CENTER);
		lb.setFont(new Font("LucidaSans", Font.BOLD, 22));
		lb.setBackground(Color.orange);
		
		l_interface3 = new List(29);
		l_interface3 = AjouterCourses.l;
		l_interface3.setFont(new Font("LucidaSans", Font.BOLD, 17));
		l_interface3.addItemListener(l);
		
		Fond_img panneaudedroite = new Fond_img();
		this.add(panneaudedroite, BorderLayout.EAST);
		
		IngredientsCourses panneaudegauche = new IngredientsCourses(l,m);
		this.add(panneaudegauche, BorderLayout.WEST);
		
		this.add(l_interface3, BorderLayout.CENTER);
		
		this.add(lb, BorderLayout.NORTH);
		
		this.addWindowListener(this);
		this.setTitle("Liste de courses");
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}


