package pojos;

import java.util.ArrayList;

import daos.HiphopDao;
import daos.JazzDao;
import daos.PopDao;
import daos.RockDao;
import com.google.gson.Gson;

public class Music {
	int mid;
	String mname;
	String artist;
	String location;
	String format;
	
	public Music() {
		this.mid = 0;
		this.mname = new String();
		this.artist = new String();
		this.location = new String();
		this.format = new String();
	}
	public Music(int mid, String mname, String artist, String location, String format) {
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
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	@Override
	public String toString() {
		return "Music [mid=" + mid + ", mname=" + mname + ", artist=" + artist + ", location=" + location + ", format="
				+ format + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + mid;
		result = prime * result + ((mname == null) ? 0 : mname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (mid != other.mid)
			return false;
		if (mname == null) {
			if (other.mname != null)
				return false;
		} else if (!mname.equals(other.mname))
			return false;
		return true;
	}
	
	
	public String getRecords() {
		ArrayList<Music> musicList = new ArrayList<Music>();
		musicList.addAll(new RockDao().findAll());
		musicList.addAll(new HiphopDao().findAll());
		musicList.addAll(new PopDao().findAll());
		musicList.addAll(new JazzDao().findAll());
		
		Gson gson = new Gson();
		String rows = gson.toJson(musicList);
		return rows;
	}
	
	
	
}
