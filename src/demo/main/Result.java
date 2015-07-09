package demo.main;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Result {
	private int id;
	private double latitude;
	private double longtitude;
	private double speed;
	private Date date;
	private double distance;

	public Result(int id, double latitude, double longtitude, double speed,
			Date date, double distance) {
		this.id = id;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.speed = speed;
		this.date = date;
		this.distance = distance;
	}

	public Result() {
		// TODO Auto-generated constructor stub
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", latitude=" + latitude + ", longtitude="
				+ longtitude + ", speed=" + speed + ", date=" + date
				+ ", distance=" + distance + "] " + "\n";
	}

	public long changeMiliToSecond() {
		long secs = date.getTime() / 1000;
		return secs;
	}

}
