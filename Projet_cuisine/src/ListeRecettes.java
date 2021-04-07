import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ListeRecettes extends Panel{
	
	
	Modele m;
	
	public ListeRecettes(ItemListener l, Modele m) {	
		List plats = new List(29);
		
		Iterator<RecetteModele> i = m.dicoRecettes.values().iterator();
		while (i.hasNext()) {
			plats.add(i.next().nom);
		}
		
		this.add(plats);
		plats.addItemListener(l);
	}
}