import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class OptionCourses extends Panel{

	public OptionCourses() {
		
		Button supprimer = new Button("Supprimer la recette de cette liste");
		supprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String recette = Modele.nom_recette_ing;
				
				if (recette == "") {
					JOptionPane.showMessageDialog(null,"Veuillez sélectionner une recette");
				}
				else {
					Interface_fen_3.l_interface3.remove(recette);
					AjouterCourses.l2.remove(recette);
					for (int i=0; i<IngredientsCourses.taille; i++) {
						IngredientsCourses.ingredients[i].setLabel("");
					}
					Modele.nom_recette_ing="";
				}
			}	
		});
		
		Button toutsupprimer = new Button("Vider ma liste de courses");
		toutsupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Interface_fen_3.l_interface3.clear();
				AjouterCourses.l2.clear();
				for (int i=0; i<IngredientsCourses.taille; i++) {
					IngredientsCourses.ingredients[i].setLabel("");
				}
				Modele.nom_recette_ing="";
			}
			
		});
		
		this.add(supprimer);
		this.add(toutsupprimer);
		this.setBackground(new Color(139,108,66));
	}
}
