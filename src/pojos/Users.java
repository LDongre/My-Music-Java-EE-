package pojos;

public class Users {
	int uid;
	String username;
	String password;
	String name;
	String address;
	String mobile;
	String email;
	String pictureLocation;
	String pictureFormat;
	public Users() {
		super();
	}
	public Users(int uid, String username, String password, String name, String address, String mobile, String email, String pictureLocation, String pictureFormat) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.pictureLocation = pictureLocation;
		this.pictureFormat = pictureFormat;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPictureLocation() {
		return pictureLocation;
	}
	public void setPictureLocation(String pictureLocation) {
		this.pictureLocation = pictureLocation;
	}
	public String getPictureFormat() {
		return pictureFormat;
	}
	public void setPictureFormat(String pictureFormat) {
		this.pictureFormat = pictureFormat;
	}
	
	
}
