import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Recherche_recette extends Panel implements ActionListener {
	
	public Recherche_recette(){
		 TextField t1 = new TextField("Tapez un ingredient pour rechercher une recette"); 
		 Button b1 = new Button("Rechercher");
		 
		 b1.setForeground(Color.WHITE);
		 b1.setBackground(new Color(0,128,0));
		 
		 this.add(t1);
		 this.add(b1);
		 
		 
		 b1.addActionListener(new ActionListener() {
	            @Override
	     public void actionPerformed(ActionEvent e) {
	            	Interface I;
	            	Interface_fen_3 I3;
					try {
						I3 = new Interface_fen_3();
						I3.setVisible(true);
						
						//I = new Interface();
						//I.setVisible(false);
					} catch (IOException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	
	            	
	            	

	            }
			});
			this.add(b1);

		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	}

