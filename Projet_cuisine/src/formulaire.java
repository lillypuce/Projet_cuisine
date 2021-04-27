import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.json.simple.parser.ParseException;

public class formulaire extends Panel implements ActionListener{
	
	Modele m;
	
	public formulaire() throws FileNotFoundException, IOException, ParseException {
		
		Label l0,l1,l2,l3,l4,l5,l6;
		TextArea text;
		
		l0=new Label("Nouvelle recette");
		l0.setFont(new Font("LucidaSans", Font.BOLD, 22));
		l0.setBounds(50,10,250,40);
		
		
		l1=new Label("Sélectionnez ici la catégorie de la recette");
		//l1.setFont(new Font("Arial", Font.BOLD, 12));
		l1.setBounds(50,80,380,20);
		Choice cat = new Choice();
		cat.addItem("Entrée");
		cat.addItem("Plats");
		cat.addItem("Dessert");
		
		cat.setBounds(50,100,320,20);
		
		l2=new Label("Tapez ici la sous-catégorie de la recette");
		l2.setBounds(50,180,250,20);
		TextField scat = new TextField("ex: Pizza"); 
		scat.selectAll();
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
		TextField dos = new TextField("ex: 2g,3g"); 
		dos.setBounds(50,500,250,20);
		
		l6=new Label("Entrez ici les consignes de la recette");
		l6.setBounds(370,80,250,20);
		text = new TextArea("ex: 1. Préchauffez le four Th8 (240°C). ",100,65);
		text.setEditable(true);
		text.setBounds(370, 100, 310, 310);
		
		
		Button b = new Button("Ajouter recette");
		 
		 b.setForeground(Color.WHITE);
		 b.setBackground(new Color(0,128,0));
		 b.setBounds(50,550,250,20);
		 
		 
		 
		 b.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	String tcat=cat.getSelectedItem();
	            	String tscat=scat.getText();
	            	String texnom=tnom.getText();
	            	String ting=ing.getText();
	            	String tdos=dos.getText();
	            	String tconsig=text.getText();
	                
	            	String tid=texnom.toLowerCase ();
	            	tid = tid.replaceAll("\\s", "_");
	            	
	            	//Ingrédients et dosages
	            	String[] noming = ting.split(",");
	            	String[] ingdos = tdos.split(",");
	            	
	            	ArrayList<ArrayList<String>> al = new ArrayList<>();
	            	ArrayList<String> al2 = new ArrayList<>();
	            	
	            	
	            	if (noming.length != ingdos.length) {
	            		JOptionPane.showMessageDialog(null, "Les valeurs entrées dans les ingrédients et le dosage sont incorrectes");
	            	}
	            	else {
		            	for (int i=0;i<noming.length;i++) {
		            		String noming1=noming[i];
		            		String ti=noming1.toLowerCase ();
		            		ti = ti.replaceAll("\\s", "_");
		            		//Ingrédients 
		            		Ingredient b = new Ingredient(ti,noming1);
		            		m.dicoIngredients.putIfAbsent(ti, b);
		            		Ingredient ingredientR = m.dicoIngredients.get(ti);
		            		
		            		if(ingredientR.id.compareTo(ti) == 0) {
		            			if(ingredientR.recettes.contains(tid) == false) {
		            				ingredientR.recettes.add(tid);
		            			}
		            		}
		            	
		            		String ingdos1 = ingdos[i];
		            		String td = ingdos1.toLowerCase ();
		            		
		            		al2.add(ti);
		            		al2.add(td);
		            		al.add(al2);
		            		al2 = new ArrayList<>();
			            		}
			            	}
		            	
		            	//Consignes
		            	String[] consig = tconsig.split("\n");
		            	
		            	ArrayList<String> al3 = new ArrayList<>();
		            	
		            	for (int i=0; i<consig.length; i++) {
		            		al3.add(consig[i]);
		            	}
		            	
		            	RecetteModele r= new RecetteModele(tid,texnom,tcat,tscat);
		                
		            	r.affichage_ingredients = al;
		            	r.consignes = al3;
		            	
		            	m.dicoRecettes.put(tid, r);
		            	
		            	//Insertion des recettes dans les listes des categories pour ensuite être lu par les autres classes
		            	if (m.dicoRecettes.get(tid).categorie.equals("Plats")) {
		            		ListeRecettes.lst_plats.add(m.dicoRecettes.get(tid).nom);
		            	}
		            	if (m.dicoRecettes.get(tid).categorie.equals("Dessert")) {
		            		ListeRecettes.lst_desserts.add(m.dicoRecettes.get(tid).nom);
		            	}
		            	if (m.dicoRecettes.get(tid).categorie.equals("Entrée")) {
		            		ListeRecettes.lst_entree.add(m.dicoRecettes.get(tid).nom);
		            	}

		            	try {
							FileWriter fw = new FileWriter("recetteajoutee.txt", true);
							fw.write("[\n");
							fw.write(tid + "\n");
							fw.write(texnom + "\n");
							fw.write(tcat + "\n");
							fw.write(tscat + "\n");
							fw.write(ting + "\n");
							fw.write(tdos + "\n");
							fw.write(tconsig + "\n");
							fw.write("]\n");
							fw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
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