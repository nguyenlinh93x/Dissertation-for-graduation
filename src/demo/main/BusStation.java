package demo.main;

public class BusStation {
	private int id;
	private double latitude;
	private double longtitude;
	private String nameStation;
	
	public BusStation(int id, double latitude, double longtitude, String nameStation) {
		this.id = id;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.nameStation = nameStation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public String getNameStation() {
		return nameStation;
	}

	public void setNameStation(String nameStation) {
		this.nameStation = nameStation;
	}

	@Override
	public String toString() {
		return "BusStation [id=" + id + ", latitude=" + latitude
				+ ", longtitude=" + longtitude + ", nameStation=" + nameStation
				+ "]";
	}

	
	
	
	
	
	
}
