import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Ajouter_recette extends Panel implements ActionListener{
	
	public Ajouter_recette() {
		
		Frame f= new Frame("Test");
		
		Label l1,l2,l3,l4;
		
		l1=new Label("Tapez ici la catégorie de la recette");
		l1.setBounds(50,50,250,20);
		TextField cat = new TextField("ex: Plats"); 
		cat.setBounds(50,100,250,20);
		
		l2=new Label("Tapez ici le nom de la recette");
		l2.setBounds(50,150,250,20);
		TextField tnom = new TextField("ex: Tarte aux pommes..."); 
		tnom.setBounds(50,200,250,20);
		
		l3=new Label("Tapez ici la liste des ingrédients");
		l3.setBounds(50,250,250,20);
		TextField ing = new TextField("ex: sel,poivre..."); 
		ing.setBounds(50,300,250,20);
		
		l4=new Label("Tapez ici la quatité de l'ingrédients");
		l4.setBounds(50,400,250,20);
		TextField dos = new TextField("ex: 2"); 
		dos.setBounds(50,450,250,20);
		
		Button b = new Button("Ajouter recette");
		 
		 b.setForeground(Color.WHITE);
		 b.setBackground(new Color(200,200,200));
		 
		 
		 f.add(l1);
		 f.add(cat);
		 
		 f.add(l2);
		 f.add(tnom);
		 		 
		 f.add(l3);
		 f.add(ing);
		 
		 f.add(l4);
		 f.add(dos);
		 
		 
		 
		 f.add(b);
		 f.setSize(900,900);
		 f.setLayout(null);
		 f.setVisible(true);
		
		
		b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
		});
		this.add(b);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
