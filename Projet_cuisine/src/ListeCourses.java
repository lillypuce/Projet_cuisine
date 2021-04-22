import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class ListeCourses extends Panel{
	
	public ListeCourses(ItemListener l, Modele m){
		
		Button b = new Button("Liste de courses");
		b.setFont(new Font("Serif", Font.BOLD, 12));
		b.setBackground(new Color(209,200,194));
		
		b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Interface I;
            	Interface_fen_3 I3;
				try {
					I3 = new Interface_fen_3(l, m);
					I3.setVisible(true);
					
				} catch (IOException | ParseException e1) {
					e1.printStackTrace();
				}
            }
		});
		this.add(b);
	}
}
