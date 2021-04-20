import java.util.ArrayList;

public class RecetteModele {

	//public String chemin;
	public int note;
	String id,nom, categorie, souscategorie;
	ArrayList<ArrayList<String>> affichage_ingredients;
	ArrayList<String> ingredients;
	ArrayList<String> consignes;
	
	public RecetteModele(String i, String n,String c, String sc) {
		this.id=i;
		this.nom=n;
		this.categorie=c;
		this.souscategorie=sc;
		this.ingredients = new ArrayList<>();
		this.affichage_ingredients = new ArrayList<>();
		this.consignes = new ArrayList<>();
	}
	public String toString() {
		return this.id + " "+this.nom+" "+this.categorie+" "+this.souscategorie;
	}
}
