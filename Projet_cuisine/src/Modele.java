import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	//public Map<String,String> Ing_Recettes;
	
	public Modele() throws FileNotFoundException, IOException, ParseException {
		Object obj_recette = new JSONParser().parse(new FileReader("recette.json"));
		JSONObject jo_recette =(JSONObject) obj_recette;

		JSONArray ja_recette = (JSONArray) jo_recette.get("recettes");

		Map<String,Recette> dicoRecettes = new HashMap<String,Recette>();

		//this.Ing_Recettes = new LinkedHashMap<String,String>();
		
		
		
		for (int i=0;i<ja_recette.size();i++) {
			JSONObject ja2 = (JSONObject)ja_recette.get(i);

			JSONArray ingredient = (JSONArray) ja2.get("ingredients");
			JSONArray consigne = (JSONArray) ja2.get("consignes");

			String id = (String) ja2.get("id");
			String nom = (String) ja2.get("nom");
			String categorie = (String) ja2.get("categorie");
			String souscategorie = (String) ja2.get("sous categorie");

			Recette l = new Recette(id,nom,categorie,souscategorie);

			l.ingredients = (ArrayList<String>)ingredient;
			l.consignes = (ArrayList<String>)consigne;

			dicoRecettes.put(id, l);

			for(int j=0;j<ingredient.size();j++) {
				JSONObject ing = (JSONObject)ingredient.get(j);

				String id_ingredient = (String) ing.get("id");
				
				
				
				//System.out.println(nom + " " +id_ingredient);
				//Ing_Recettes.put(nom,id_ingredient);
			}
		}
		
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
		
		for(int i=0;i<ja_ingredient.size();i++) {
			for(int j=0;j<ja_recette.size();j++) {
				JSONObject ja2_ingredient = (JSONObject)ja_ingredient.get(i);
				JSONObject ja2_recette = (JSONObject)ja_recette.get(i);
				
				String id_ingredient = (String) ja2_ingredient.get("id");
				String id_recette = (String) ja2_recette.get("id");
				
				JSONArray ingredient = (JSONArray) ja2_recette.get("ingredients");
				
				for(int k=0;k<ingredient.size();k++) {
					JSONObject ing = (JSONObject)ingredient.get(j);
					String id = (String) ing.get("id");
					if(id == id_ingredient) {
						System.out.println(id_recette + " " + id_ingredient + " " + id);
					}
				}
				
			}
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


}
