import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Ingredient {
	
	String id, type;
	ArrayList<String> recettes;
	
	public Ingredient(String i,String t) {
		this.id = i;
		this.type = t;
		this.recettes = new ArrayList<>();
	}
	
	
	public String toString() {
		return this.id + " "+this.type+" "+this.recettes;
	}
	
	public static void main(String[] args)throws Exception  {  
		Object obj = new JSONParser().parse(new FileReader("ingredient.json"));
		JSONObject jo = (JSONObject) obj; 
		
		JSONArray ja = (JSONArray) jo.get("ingredients");
		
		Map<String, Ingredient> dicoIngredients = new HashMap<String, Ingredient>();
		
		for (int i=0;i<ja.size();i++) {
			JSONObject ja2 = (JSONObject)ja.get(i);
			String id = (String) ja2.get("id");
			String type = (String) ja2.get("type");
			JSONArray recettes = (JSONArray)ja2.get("recettes");
			Ingredient l = new Ingredient(id,type);
			l.recettes = (ArrayList<String>)recettes;
			dicoIngredients.put(id, l);
		}
		System.out.println(dicoIngredients);
	}
}
