import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Formulaire1 extends Panel implements ActionListener{
	Recherche_recette rr;
	
	public Formulaire1(Recherche_recette rr) {
		Label lab0,lab1;
	
		lab0=new Label("Liste des recettes :");
		lab0.setFont(new Font("LucidaSans", Font.BOLD, 22));
		lab0.setBounds(50,10,250,40);
		
		System.out.println(rr.liste_recette5);
		 this.add(lab0);
		
		 this.setSize(500,500);
		 this.setLayout(null);
		 this.setVisible(true);
	

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}