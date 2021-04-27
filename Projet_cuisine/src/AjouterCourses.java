import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AjouterCourses extends Panel{
	
	Modele m;
	public static List l;
	public static ArrayList<String> l2;
	
	public AjouterCourses() {
		
		Button b = new Button("Ajouter courses");
		b.setFont(new Font("Serif", Font.BOLD, 12));
		b.setBackground(new Color(209,200,194));
		
		l = new List(29);
		l2 = new ArrayList<>();
		
		
		b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (l2.contains(m.nom_recette_selectionnee)) {
            		String attention = m.nom_recette_selectionnee + " est déjà dans votre liste de courses.";
            		JOptionPane.showMessageDialog(null, attention);
            	}	
            	if (m.nom_recette_selectionnee =="") {
            		m.nom_recette_selectionnee = ListeRecettes.lst.getItem(0);
            		l.add(m.nom_recette_selectionnee);
            		l2.add(m.nom_recette_selectionnee);
            		
            		String message = m.nom_recette_selectionnee + " a été ajouté dans votre liste de courses.";
            		
            		JOptionPane.showMessageDialog(null, message);
            	}
            	if (!l2.contains(m.nom_recette_selectionnee)) {
            		l.add(m.nom_recette_selectionnee);
            		l2.add(m.nom_recette_selectionnee);
            		
            		String message = m.nom_recette_selectionnee + " a été ajouté dans votre liste de courses.";
            		
            		JOptionPane.showMessageDialog(null, message);
            	}
            }
		});
		this.add(b);
	}
}
