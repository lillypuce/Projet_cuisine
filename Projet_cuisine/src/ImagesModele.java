
public class ImagesModele {
	public String id;
	public String chemin;
	public int note;
	
	
	public ImagesModele() {}
	
	public ImagesModele(String id, String p, int r) {
		this.id = id;
		this.chemin = p;
		this.note=r;
	}
	
	public String toString() {
		String out=this.id+" ";
		for (int i=0;i<=this.note;i++) {
			out+="*";
		}
		return out;
	}

}
