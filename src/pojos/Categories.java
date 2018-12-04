package pojos;

public class Categories {
	
	int catid;
	String catname;
	
	public Categories() {
		this.catid = 0;
		this.catname = new String();
	}
	
	public Categories(int catid, String catname) {
		super();
		this.catid = catid;
		this.catname = catname;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

}
