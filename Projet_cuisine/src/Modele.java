import java.io.File;
import java.util.ArrayList;
import java.util.Observable;



public class Modele  extends Observable{
	
	public ArrayList<ImagesModele> images;
	
public Modele(String dir) {
		
		File repImages = new File(dir);
		File[] imagesListe = repImages.listFiles();
		this.images = new ArrayList<>();
		for (File file : imagesListe) {
			String nomImage = file.getName().split("\\.")[0];
			this.images.add(new ImagesModele(nomImage, "images/"+file.getName()));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
