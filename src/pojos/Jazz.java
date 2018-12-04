package pojos;

public class Jazz extends Music {
	int mid;
	String mname;
	String artist;
	String location;
	String format;
	
	public Jazz() {
		this.mid = 0;
		this.mname = new String();
		this.artist = new String();
		this.location = new String();
		this.format = new String();
	}
	
	public Jazz(int mid, String mname, String artist, String location, String format) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.artist = artist;
		this.location = location;
		this.format = format;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return format;
	}

	@Override
	public String toString() {
		return "Jazz [mid=" + mid + ", mname=" + mname + ", artist=" + artist + ", location=" + location + ", format="
				+ format + "]";
	}
	
	

}
