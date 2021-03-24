

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 


public class ListeIngredients {
	String id, type;
	
	public ListeIngredients() {
		
	}
	
	
	
	
	 public static void main(String[] args)throws Exception  
	    {  {
		 //recup fichier ingredients.json
		 Object obj = new JSONParser().parse(new FileReader("ingredient.json"));
		// Object recobj = new JSONParser().parse(new FileReader("recette.json"));
		 
		 JSONObject jo = (JSONObject) obj; 
		// JSONObject jr = (JSONObject) recobj; 
		 
		 //recup id et type
		 String id = (String) jo.get("id");
		 String type = (String) jo.get("type");
		 
		// String idr = (String) jr.get("id");
		// String rec = (String) jr.get("recettes");
		 //JSONArray ja = new JSONArray();
		 //m = new LinkedHashMap(2); 
	       // m.put(ja); 
		 //ja.add(m);
		 //jr.put(rec, ja); 
		 
		 System.out.println(id);
		 System.out.println(type);
		 
		 //recup recettes(quand on les aura remplit avant)
		 Map recettes =((Map)jo.get("recettes"));
		 
		 //iterator?
		 Iterator<Map.Entry> itr1 =recettes.entrySet().iterator();
		 while(itr1.hasNext()) {
			 Map.Entry pair = itr1.next();
			 System.out.println(pair.getKey()+ ":" +pair.getValue());
		 }
		 
	 
	 }
	    }

}
