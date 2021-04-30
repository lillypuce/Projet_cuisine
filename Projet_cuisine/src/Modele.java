import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Modele  extends Observable{

	public ArrayList<ImagesModele> images;
	
	formulaire f;
	
	public Map<String,ArrayList<String>> Ing_Recettes;
	public static HashMap<String, RecetteModele> dicoRecettes = new HashMap<String,RecetteModele>();
	public static Map<String, Ingredient> dicoIngredients = new HashMap<String, Ingredient>();
	
	public static int categorie_selectionnee = 0;
	public static int recette_selectionnee = 0;
	public static int recette_ing_selectionnee = 0;
	public static int ingredient_taille=0;
	
	
	public static String nom_recette_selectionnee="", consignes_recette="", ingredients_recette="",id_recette="", nom_recette_ing="";
	
	public static ArrayList<String> al = new ArrayList<>();
	
	public Modele() throws FileNotFoundException, IOException, ParseException {
		
		Object obj_recette = new JSONParser().parse(new FileReader("recette.json"));
		JSONObject jo_recette =(JSONObject) obj_recette;

		JSONArray ja_recette = (JSONArray) jo_recette.get("recettes");

		dicoRecettes = new HashMap<String,RecetteModele>();
		dicoIngredients = new HashMap<String, Ingredient>();
		Ing_Recettes = new HashMap<String,ArrayList<String>>();
		
		//REMPLISSAGE DU DICTIONNAIRE POUR LES RECETTES
		for (int i=0;i<ja_recette.size();i++) {
			JSONObject ja2 = (JSONObject)ja_recette.get(i);

			JSONArray ingredient = (JSONArray) ja2.get("ingredients");
			JSONArray consigne = (JSONArray) ja2.get("consignes");

			String id = (String) ja2.get("id");
			String nom = (String) ja2.get("nom");
			String categorie = (String) ja2.get("categorie");
			String souscategorie = (String) ja2.get("sous categorie");

			RecetteModele l = new RecetteModele(id,nom,categorie,souscategorie);
			
			ArrayList<ArrayList<String>> l_ingredient = new ArrayList<>();
			ArrayList<String> l_ingredient2 = new ArrayList<>();
			
			for(int j=0;j<ingredient.size();j++) {
				JSONObject ing = (JSONObject)ingredient.get(j);
				String id_ingredient = (String) ing.get("id");
				String quantite_ingredient = (String) ing.get("quantite");
				
				l_ingredient2.add(id_ingredient);
				l_ingredient2.add(quantite_ingredient);
				l_ingredient.add(l_ingredient2);
				l_ingredient2 = new ArrayList<>();
			}
			l.affichage_ingredients = l_ingredient;
			l.ingredients = (ArrayList<String>)ingredient;
			l.consignes = (ArrayList<String>)consigne;
			
			dicoRecettes.put(id, l);
			
		}
	
		
		//Object obj_recette_ajoutee = new JSONParser().parse(new FileReader("recetteajoutee.json"));
		//JSONObject jo_recette_ajoutee = (JSONObject) obj_recette_ajoutee;
		
		
		ArrayList<String>  recup_id=new ArrayList<String>(); 
	    ArrayList<String>  recup_nom=new ArrayList<String>(); 
	    ArrayList<String>  recup_cat=new ArrayList<String>(); 
	    ArrayList<String>  recup_scat=new ArrayList<String>(); 
	    ArrayList<String>  recup_ing=new ArrayList<String>(); 
	    ArrayList<String>  recup_dos=new ArrayList<String>(); 
	    ArrayList<String>  recup_consigne=new ArrayList<String>(); 
		
		

		try
	    {
		  File file = new File("recetteajoutee.txt");
		  FileReader fr = new FileReader(file);
	      BufferedReader br = new BufferedReader(fr);
	      StringBuffer sb = new StringBuffer();
	      String line;
	      
	      
	      while((line = br.readLine()) != null)
	      {
	    	  String[] contenue = line.split(":");
	    		if(contenue[0].equals("id")) {
	    			recup_id.add(contenue[1]);
	    		}
	    		if(contenue[0].equals("nom")) {
	    			recup_nom.add(contenue[1]);
	    		}
	    		if(contenue[0].equals("catégorie")) {
	    			recup_cat.add(contenue[1]);
	    		}
	    		if(contenue[0].equals("sous_catégorie")) {
	    			recup_scat.add(contenue[1]);
	    		}
	    		if(contenue[0].equals("ingrédient")) {
	    			recup_ing.add(contenue[1]);
	    		}
	    		if(contenue[0].equals("dosage")) {
	    			recup_dos.add(contenue[1]);
	    		}
	    		if(contenue[0].equals("consigne")) {
	    			recup_consigne.add(contenue[1]);
	    		}
	      }
	      fr.close();
	      
	    }
	    catch(IOException e)
	    {
	      e.printStackTrace();
	    }
		
	
		
		for(int i=0;i<recup_id.size();i++) {
			String id = recup_id.get(i);
			String nom = recup_nom.get(i);
			String categorie = recup_cat.get(i);
			String sous_categorie = recup_scat.get(i);
			
			RecetteModele l = new RecetteModele(id,nom,categorie,sous_categorie);
			
			String tempo = recup_ing.get(i);
			String[] ing_temp = tempo.split(",");
			
			//System.out.println(dicoRecettes.get("margherita").ingredients);
			
			//String tempo2 = recup_dos.get(i);
			
			for(int j = 0;j<ing_temp.length-1;j++) {
				l.ingredients.add(ing_temp[j]);
			}
			l.consignes.add(recup_consigne.get(i));
			
			dicoRecettes.put(id, l);
		}
		
		

		
		
		
		//REMPLISSAGE DU DICO POUR LES INGREDIENTS
		Object obj_ingredient = new JSONParser().parse(new FileReader("ingredient.json"));
		JSONObject jo_ingredient = (JSONObject) obj_ingredient; 
		
		JSONArray ja_ingredient = (JSONArray) jo_ingredient.get("ingredients");
		
		
		for (int i=0;i<ja_ingredient.size();i++) {
			JSONObject ja2 = (JSONObject)ja_ingredient.get(i);
			String id = (String) ja2.get("id");
			String type = (String) ja2.get("type");
			
			JSONArray recettes = (JSONArray)ja2.get("recettes");
			
			Ingredient l = new Ingredient(id,type);
			
			l.recettes = (ArrayList<String>)recettes;
			dicoIngredients.put(id, l);
		}
		
		for (int i=0;i<ja_recette.size();i++) {
			JSONObject ja2 = (JSONObject)ja_recette.get(i);
			
			//récupération de l'id de la recette :
			String id_re = (String) ja2.get("id");
			
			//récupération dans le dicoRecettes de la valeur de l'id
			RecetteModele re = dicoRecettes.get(id_re);
			
			//Récupération des ingrédients 
			JSONArray r1 = (JSONArray)re.ingredients;
			for(int j = 0;j<r1.size();j++) {
				JSONObject r_ing = (JSONObject)r1.get(j);
				String r_ing2 = (String)r_ing.get("id");
				Ingredient ingredient_test = dicoIngredients.get(r_ing2);
				if(ingredient_test.id.compareTo(r_ing2) == 0) {
					if(ingredient_test.recettes.contains(id_re) == false) {
						ingredient_test.recettes.add(id_re);
					}
				}
				}
			}
		}
		
	
	public Modele(String dir) throws ClassNotFoundException, IOException{

		File repImages = new File(dir);
		File[] imagesListe = repImages.listFiles();
		this.images = new ArrayList<>();
		for (File file : imagesListe) {
			String nomImage = file.getName().split("\\.")[0];
			this.images.add(new ImagesModele(nomImage, "images/"+file.getName(),0));
		}

	}

	public void select_categ(Integer item) {
		if (id_recette == null) {
			id_recette = "poisson_pane";
		}
		
		this.categorie_selectionnee = item;
		this.setChanged();
		this.notifyObservers(Categorie.lst_categorie.getItem(this.categorie_selectionnee));
	}

	public void select_recette(Integer item) {
		
		nom_recette_selectionnee = ListeRecettes.lst.getItem(item);
		consignes_recette = "";
		ingredients_recette="";
		id_recette="";
		
		for (HashMap.Entry<String, RecetteModele> entry : dicoRecettes.entrySet()) {
			String key = entry.getKey();
			
			if (dicoRecettes.get(key).nom == nom_recette_selectionnee) {
				id_recette=dicoRecettes.get(key).id;
				for (int i=0; i<dicoRecettes.get(key).consignes.size(); i++) {
					
					consignes_recette=consignes_recette+dicoRecettes.get(key).consignes.get(i);
					consignes_recette=consignes_recette+"\n\n";
				}
				for (int i=0; i<dicoRecettes.get(key).affichage_ingredients.size(); i++) {
					String nom =  dicoRecettes.get(key).affichage_ingredients.get(i).get(0);
					String quantite =  dicoRecettes.get(key).affichage_ingredients.get(i).get(1);
					
					ingredients_recette=ingredients_recette + "-" + nom + " (" + quantite + ")\n\n";
				}
			}
		}
		
		this.recette_selectionnee = item;
		this.setChanged();
		this.notifyObservers(ListeRecettes.lst.getItem(this.recette_selectionnee));
	}

	public void select_ingredient(Integer item) {
		nom_recette_ing = Interface_fen_3.l_interface3.getItem(item);
		al.clear();
		
		for (HashMap.Entry<String, RecetteModele> entry : dicoRecettes.entrySet()) {
			String key = entry.getKey();
			if (dicoRecettes.get(key).nom == nom_recette_ing) {
				for (int i=0; i<dicoRecettes.get(key).affichage_ingredients.size(); i++) {
					String nom = dicoRecettes.get(key).affichage_ingredients.get(i).get(0);
					String quantite = dicoRecettes.get(key).affichage_ingredients.get(i).get(1);
				
					String s = nom + " (" + quantite + ")";
					al.add(s);
				}
			}
		}
		
		this.recette_ing_selectionnee = item;
		this.setChanged();
		this.notifyObservers(Interface_fen_3.l_interface3.getItem(this.recette_ing_selectionnee));
	}
	
	
}