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
import java.util.HashMap;
import java.util.Map;

public class formulaire extends Panel implements ActionListener{
	
	Map<String, String> NouvRecette = new HashMap<String, String>();
	
	public formulaire() {
		Label l0,l1,l2,l3,l4,l5,l6;
		TextArea text;
		
		l0=new Label("Nouvelle recette");
		l0.setFont(new Font("LucidaSans", Font.BOLD, 22));
		l0.setBounds(50,10,250,40);
		
		
		l1=new Label("Tapez ici la catégorie de la recette");
		//l1.setFont(new Font("Arial", Font.BOLD, 12));
		l1.setBounds(50,80,250,20);
		TextField cat = new TextField("ex: Plats"); 
		cat.setBounds(50,100,250,20);
		
		l2=new Label("Tapez ici la sous-catégorie de la recette");
		l2.setBounds(50,180,250,20);
		TextField scat = new TextField("ex: Pizza"); 
		scat.setBounds(50,200,250,20);
		
		l3=new Label("Tapez ici le nom de la recette");
		l3.setBounds(50,280,250,20);
		TextField tnom = new TextField("ex: Margherita..."); 
		tnom.setBounds(50,300,250,20);
		
		l4=new Label("Tapez ici la liste des ingrédients");
		l4.setBounds(50,380,250,20);
		TextField ing = new TextField("ex: sel,poivre..."); 
		ing.setBounds(50,400,250,20);
		
		l5=new Label("Tapez ici la quatité de l'ingrédients");
		l5.setBounds(50,480,250,20);
		TextField dos = new TextField("ex: 2g"); 
		dos.setBounds(50,500,250,20);
		
		l6=new Label("Entrez ici les consignes de la recette");
		l6.setBounds(330,80,250,20);
		text = new TextArea("ex: 1. Préchauffez le four Th8 (240°C). ",100,65);
		text.setEditable(true);
		text.setBounds(330, 100, 310, 310);
		
		
		Button b = new Button("Ajouter recette");
		 
		 b.setForeground(Color.WHITE);
		 b.setBackground(new Color(0,128,0));
		 b.setBounds(50,550,250,20);
		 
		 
		 
		 b.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String tcat=cat.getText();
	            	String tscat=scat.getText();
	            	String texnom=tnom.getText();
	            	String ting=ing.getText();
	            	String tdos=dos.getText();
	            	String Ttext=text.getText();
	                
	                
	                NouvRecette.put("categorie", tcat);
	                NouvRecette.put("SousCategorie", tscat);
	                NouvRecette.put("nom", texnom);
	                NouvRecette.put("id", texnom.toLowerCase ());
	                NouvRecette.put("ingredients", ting);
	                NouvRecette.put("quantite", tdos);
	                NouvRecette.put("consigne", Ttext);
	                
	                System.out.println(NouvRecette);
	                 
	            }
			});
		 
		 this.add(l0);
		 
		 this.add(l1);
		 this.add(cat);
		 
		 this.add(l2);
		 this.add(scat);
		 
		 this.add(l3);
		 this.add(tnom);
		 		 
		 this.add(l4);
		 this.add(ing);
		 
		 this.add(l5);
		 this.add(dos);
		 
		 this.add(l6);
		 this.add(text);
		 
		 this.add(b);
		 this.setSize(900,800);
		 this.setLayout(null);
		 this.setVisible(true);
	

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}