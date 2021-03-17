import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

public class Categorie extends Canvas implements Observer {

	public static Toolkit t = Toolkit.getDefaultToolkit();
	public static Dimension d = t.getScreenSize();
	
	public int HauteurFenetre = d.width/2;
	public int LargeurFenetre = d.height/2;
	
	public Categorie() {
		
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
