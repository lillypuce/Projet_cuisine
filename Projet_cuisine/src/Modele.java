import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Modele  extends Observable{

	
	
	public ArrayList<ImagesModele> images;
	
	public Map<String,ArrayList<String>> Ing_Recettes;
	public HashMap<String, RecetteModele> dicoRecettes;
	
	public static int categorie_selectionnee = 0;
	
	public Modele() throws FileNotFoundException, IOException, ParseException {
		Object obj_recette = new JSONParser().parse(new FileReader("recette.json"));
		JSONObject jo_recette =(JSONObject) obj_recette;

		JSONArray ja_recette = (JSONArray) jo_recette.get("recettes");

		this.dicoRecettes = new HashMap<String,RecetteModele>();

		this.Ing_Recettes = new HashMap<String,ArrayList<String>>();
		
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

			l.ingredients = (ArrayList<String>)ingredient;
			l.consignes = (ArrayList<String>)consigne;

			this.dicoRecettes.put(id, l);

			for(int j=0;j<ingredient.size();j++) {
				JSONObject ing = (JSONObject)ingredient.get(j);

				String id_ingredient = (String) ing.get("id");	
			}
		}
		
		//REMPLISSAGE DU DICO POUR LES INGREDIENTS
		Object obj_ingredient = new JSONParser().parse(new FileReader("ingredient.json"));
		JSONObject jo_ingredient = (JSONObject) obj_ingredient; 
		
		JSONArray ja_ingredient = (JSONArray) jo_ingredient.get("ingredients");
		
		Map<String, Ingredient> dicoIngredients = new HashMap<String, Ingredient>();
		
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
		System.out.println(dicoIngredients.get("sel"));
		

		}
		
	
	public Modele(String dir){

		File repImages = new File(dir);
		File[] imagesListe = repImages.listFiles();
		this.images = new ArrayList<>();
		for (File file : imagesListe) {
			String nomImage = file.getName().split("\\.")[0];
			this.images.add(new ImagesModele(nomImage, "images/"+file.getName(),0));
		}

	}

	public void select_categ(Integer item) {
		this.categorie_selectionnee = item;
		this.setChanged();
		this.notifyObservers(Categorie.lst_categorie.getItem(this.categorie_selectionnee));
	}
	
	public void changeNote(int nouvelleNote) {
		this.images.get(this.categorie_selectionnee).note=nouvelleNote;
		this.setChanged();
		this.notifyObservers(this.images.get(this.categorie_selectionnee));

	}



}
