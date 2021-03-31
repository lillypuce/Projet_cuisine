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
}
