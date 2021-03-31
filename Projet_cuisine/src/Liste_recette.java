import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Liste_recette extends Panel{
	
	String id,nom, categorie, souscategorie;
	String[] ingredient;
	
	public static String[] entrees = {"salade", "nem", "tartare"};
	public static String[] plats = {"Margherita", "Oceane", "Magret"};
	public static String[] desserts = {"yaourt", "flan", "ananas"};
	public static String[] boissons = {"coca", "soda", "pepsi"};
	
	public Liste_recette(ItemListener l) {
		
		List lst_recette = new List(29);
		for (int i=0; i<plats.length; i++) {
			lst_recette.add(Liste_recette.plats[i]);
		}
		this.add(lst_recette);
		lst_recette.addItemListener(l);
	}
	
	public Liste_recette(String i, String n,String c, String sc) {
		this.id=i;
		this.nom=n;
		this.categorie=c;
		this.souscategorie=sc;
		
	}
	public Liste_recette(String[] in) {
		this.ingredient=in;
	}
	public static void main(String[] args)throws Exception  {
		//R�cup�ration fichier recette.json
		
		Object obj = new JSONParser().parse(new FileReader("recette.json"));
		JSONObject jo =(JSONObject) obj;
		
		JSONArray ja = (JSONArray) jo.get("recettes");
		
		Map recette = new LinkedHashMap();
		

		for (int i=0;i<ja.size();i++) {
			JSONObject ja2 = (JSONObject)ja.get(i);
			JSONArray ja3 = (JSONArray) ja2.get("ingredients");
			
			String id = (String) ja2.get("id");
			String nom = (String) ja2.get("nom");
			String categorie = (String) ja2.get("categorie");
			String souscategorie = (String) ja2.get("souscategorie");
			
			Liste_recette l = new Liste_recette(id,nom,categorie,souscategorie);
			//recette.put(l, ingredient);
			//System.out.println(id);
			//System.out.println(nom);
			//System.out.println(categorie);
			//System.out.println(souscategorie);
			System.out.println(l);
		
		}
		
		
		
	}
	public String toString() {
		return this.id + " "+this.nom+" "+this.categorie+" "+this.souscategorie;
	}
}
