import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Categorie extends Canvas {

	public static Toolkit t = Toolkit.getDefaultToolkit();
	public static Dimension d = t.getScreenSize();
	
	public int HauteurFenetre = d.width/2;
	public int LargeurFenetre = d.height/2;
	
	public Categorie() {
		
		
	}

}
