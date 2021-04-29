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
		 TextField t1 = new TextField("Tapez un ingredient pour rechercher une recette", 30); 
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
						String[] nom = ing_rec.split(",");
						ArrayList<String> recette = new ArrayList<String>();
						if(nom.length == 1) {
							if(m.dicoIngredients.containsKey(nom[0])) {
								recette.addAll(m.dicoIngredients.get(nom[0]).recettes);
							}
                            for (int i = 0;i<recette.size();i++) {
                                String r1 = recette.get(i);
                                résultat = résultat + "\n" + r1;
                            }
						}
						else {
							if(m.dicoIngredients.containsKey(nom[0])) {
								recette.addAll(m.dicoIngredients.get(nom[0]).recettes);
							}
							for(int j = 1;j<nom.length;j++) {
								if(m.dicoIngredients.containsKey(nom[j])) {
									ArrayList<String> k = m.dicoIngredients.get(nom[j]).recettes;
									for(int i = 0;i<k.size();i++) {
										if(recette.contains(k.get(i))) {
											résultat = résultat + "\n" + k.get(i);
										}
									}
								}
							}
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
	

