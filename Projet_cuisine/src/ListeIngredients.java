import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;


public class ListeIngredients {
	
	String id, type;
	String[] recettes;
	
	public ListeIngredients(String i,String t) {
		this.id = i;
		this.type = t;
	}
	
	public ListeIngredients(String[] r) {
		this.recettes = r;
	}
	
	
	public static void main(String[] args)throws Exception  {  
		//Récupération fichier ingredients.json
		
		Object obj = new JSONParser().parse(new FileReader("ingredient.json"));
		JSONObject jo = (JSONObject) obj; 
		
		//Récupération recettes(quand on les aura remplit avant)
		JSONArray ja = (JSONArray) jo.get("ingredients");
		
		Map ingredient = new LinkedHashMap();
		
		for (int i=0;i<ja.size();i++) {
			JSONObject ja2 = (JSONObject)ja.get(i);
			JSONArray ja3 = (JSONArray) ja2.get("recettes");
			
			
			
			String id = (String) ja2.get("id");
			String type = (String) ja2.get("type");


			ListeIngredients l = new ListeIngredients(id,type);
			ingredient.put(l,recette);
		}
		System.out.println(ingredient);
	}
	
	public String toString() {
		return this.id + " "+this.type;
	}
}
