import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

	public String toString() {
		return this.id + " "+this.nom+" "+this.categorie+" "+this.souscategorie;
	}
	
}
