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
	
	int categorie_selectionnee = 0;
	
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

			dicoRecettes.put(id, l);

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
		
		//LIAGE DES RECETTES ET DES INGREDIENTS DANS UN DICO
		for(int i=0;i<ja_ingredient.size();i++) {
			for(int j=0;j<ja_recette.size();j++) {
				JSONObject ja2_ingredient = (JSONObject)ja_ingredient.get(i);
				JSONObject ja2_recette = (JSONObject)ja_recette.get(j);
				
				String id_ingredient = (String) ja2_ingredient.get("id");
				String id_recette = (String) ja2_recette.get("id");
				
				JSONArray ingredient = (JSONArray) ja2_recette.get("ingredients");
				
				for(int k=0;k<ingredient.size();k++) {
					JSONObject ing = (JSONObject)ingredient.get(k);
					String id = (String) ing.get("id");
					if(id.compareTo(id_ingredient) == 0) {
						
						//Ajout dans le dictionnaire
						if(Ing_Recettes.containsKey(id_ingredient)) {
							Ing_Recettes.get(id_ingredient).add(id_recette);
						}
						else {
							ArrayList<String> r = new ArrayList<String>();
							r.add(id_recette);
							Ing_Recettes.put(id_ingredient, r);
						}
					}
				}
				
			}
		}
		
		//System.out.println(Ing_Recettes);
		
		//ECRITURE DANS LE FICHIER .JSON
		for(int i=0;i<ja_ingredient.size();i++) {
			JSONObject ja2_ingredient = (JSONObject)ja_ingredient.get(i);
			String id_ingredient = (String) ja2_ingredient.get("id");
			ArrayList<String> a = Ing_Recettes.get(id_ingredient);
			JSONArray rec = (JSONArray) ja2_ingredient.get("recettes");
			//System.out.println(id_ingredient + " => " +a);
			
			//JSONObject jsonObj = (JSONObject)rec.get(i);
			
			//System.out.println(a);
			
			//PERMET D'ECRIRE MAIS SUPPRIME TOUT
			
			//try (FileWriter file = new FileWriter("ingredient.json")) {
	            //We can write any JSONArray or JSONObject instance to the file
	        //    file.write(rec.toJSONString(a)); 
	        //    file.flush();
	 
	        //} catch (IOException e) {
	        //    e.printStackTrace();
	        //}
			
		}	
	}
	
	public Modele(String dir){

		File repImages = new File(dir);
		File[] imagesListe = repImages.listFiles();
		this.images = new ArrayList<>();
		for (File file : imagesListe) {
			String nomImage = file.getName().split("\\.")[0];
			this.images.add(new ImagesModele(nomImage, "images/"+file.getName()));
		}

	}

	public void select_categ(Integer item) {
		this.categorie_selectionnee = item;
		this.setChanged();
		this.notifyObservers(this.images.get(this.categorie_selectionnee));
	}

}
