import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.simple.parser.ParseException;

public class Recherche_recette extends Panel implements ActionListener {
	
	Modele m;
	
	public ArrayList<String> liste_recette5 = new ArrayList<String>();
	
	public Recherche_recette(Modele m){
		 TextField t1 = new TextField("Tapez un ingredient pour rechercher une recette"); 
		 Button b1 = new Button("Rechercher");
		 
		 b1.setForeground(Color.WHITE);
		 b1.setBackground(new Color(0,128,0));
		 
		 this.add(t1);
		 this.add(b1);
		 
		 
		 
		 b1.addActionListener(new ActionListener() {
	            @Override
	     public void actionPerformed(ActionEvent e) {
	            	final JFrame parent = new JFrame();            	
						String ing_rec = t1.getText();
						String résultat = "Voici le résultat pour l'ingrédient :\n";
						if(m.dicoIngredients.containsKey(ing_rec)) {
							résultat = résultat + ing_rec + "\n";
							ArrayList<String> recette = m.dicoIngredients.get(ing_rec).recettes;
					     	for (int i = 0;i<recette.size();i++) {
					     		String r1 = recette.get(i);
					     		résultat = résultat + "\n" + r1;
					     		liste_recette5.add(r1);
					     	}
						}
						else {
							résultat = résultat + "Il n'y a aucune recette utilisant cet ingrédient";
						}
						
				     	JOptionPane.showMessageDialog(null, résultat);
	            	

	            }
			});
	}
		

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	}
	

