import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Ajouter_recette extends Panel implements ActionListener{

	public Ajouter_recette() {
		Button b = new Button("Ajouter recette");
		b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Interface I;
            	Interface_fen_2 I2;
				try {
					I2 = new Interface_fen_2();
					I2.setVisible(true);
					
					//I = new Interface();
					//I.setVisible(false);
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
            	

            }
		});
		this.add(b);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}