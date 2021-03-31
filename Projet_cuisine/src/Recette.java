import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Recette extends Panel{
	
	String id,nom, categorie, souscategorie;
	ArrayList<String> ingredients;
	ArrayList<String> consignes;
	
	public static String[] entrees = {"salade", "nem", "tartare"};
	public static String[] plats = {"Margherita", "Oceane", "Magret"};
	public static String[] desserts = {"yaourt", "flan", "ananas"};
	public static String[] boissons = {"coca", "soda", "pepsi"};
	
	public Recette(ItemListener l) {
		
		List lst_recette = new List(29);
		for (int i=0; i<plats.length; i++) {
			lst_recette.add(Recette.plats[i]);
		}
		this.add(lst_recette);
		lst_recette.addItemListener(l);
	}
	
	public Recette(String i, String n,String c, String sc) {
		this.id=i;
		this.nom=n;
		this.categorie=c;
		this.souscategorie=sc;
		this.ingredients = new ArrayList<>();
		this.consignes = new ArrayList<>();
	}

	public static void main(String[] args)throws Exception  {
		Object obj = new JSONParser().parse(new FileReader("recette.json"));
		JSONObject jo =(JSONObject) obj;
		
		JSONArray ja = (JSONArray) jo.get("recettes");
		
		Map<String,Recette> dicoRecettes = new HashMap<String,Recette>();
		

		for (int i=0;i<ja.size();i++) {
			JSONObject ja2 = (JSONObject)ja.get(i);
			
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
		
		}
		System.out.println(dicoRecettes);
		
		
		
	}
	public String toString() {
		return this.id + " "+this.nom+" "+this.categorie+" "+this.souscategorie;
	}
}
