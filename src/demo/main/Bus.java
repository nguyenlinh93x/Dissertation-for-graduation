package demo.main;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class Bus  {
	private int id;
	private double lat;
	private double longt;
	private double speed;
	private double satellite;
	private double lock;
	private long dateTime;

	public Bus() {}

	public Bus(int id, double lat, double longt, double speed,
			double satellite, double lock, long dateTime) {
		super();
		this.id = id;
		this.lat = lat;
		this.longt = longt;
		this.speed = speed;
		this.satellite = satellite;
		this.lock = lock;
		this.dateTime = dateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLongt() {
		return longt;
	}

	public void setLongt(double longt) {
		this.longt = longt;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getSatellite() {
		return satellite;
	}

	public void setSatellite(double satellite) {
		this.satellite = satellite;
	}

	public double getLock() {
		return lock;
	}

	public void setLock(double lock) {
		this.lock = lock;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	public boolean checkId(int id2) {
		if (this.id == id2) {
			return true;
		}
		return false;
	}

	

	@Override
	public String toString() {
		return "Bus [id=" + id + ", lat=" + lat + ", longt=" + longt
				+ ", speed=" + speed + ", satellite=" + satellite + ", lock="
				+ lock + ", dateTime=" + dateTime + "]";
	}

	public long changeMiliToSecond() {
		return TimeUnit.MILLISECONDS.toSeconds(this.dateTime);
	}


}
