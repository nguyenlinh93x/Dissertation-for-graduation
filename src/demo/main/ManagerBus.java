package demo.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ManagerBus implements Comparator<Bus> {
	private List<Bus> listOfBus; // List bus of file csv
	private List<Bus> listFindBus; // List of bus was found with id which we
									// inputed
	private List<Result> listOfResult; // List of bus find speed
	private ManagerFile mnFile;

	public ManagerBus(List<Bus> listOfBus) {
		this.listOfBus = listOfBus;
	}

	// Constructer with no parameter
	public ManagerBus() {
		this.listOfBus = new ArrayList<Bus>();
		this.listFindBus = new ArrayList<Bus>();
		this.listOfResult = new ArrayList<Result>();
	}

	// Copy Object
	public ManagerBus(ManagerBus bus) {
		this.listOfBus = bus.listOfBus;
		this.listFindBus = bus.listFindBus;
		this.listOfResult = bus.listOfResult;
	}

	// Add new list with id
	public boolean addListBusWithId(int id) {
		if (!this.listFindBus.isEmpty()) {
			this.listFindBus.clear();
		}
		for (Bus b : this.listOfBus) {
			if (b.checkId(id)) {
				this.listFindBus.add(b);
			}
		}
		// Sort list follow date
		Collections.sort(this.listFindBus, new Comparator<Bus>() {
			public int compare(Bus o1, Bus o2) {
				return (o1.getDateTime() > o2.getDateTime() ? 1 : (o1
						.getDateTime() == o2.getDateTime() ? 0 : -1));
			}
		});

		return true;
	}

	// Add bus input from csv file
	public boolean addBus(Bus bus) {
		if (null != bus) {
			listOfBus.add(bus);
			return true;
		}
		return false;
	}

	public List<Result> getListOfResult() {
		return listOfResult;
	}

	public void setListOfResult(List<Result> listOfResult) {
		this.listOfResult = listOfResult;
	}

	public List<Bus> getListOfBus() {
		return listOfBus;
	}

	public List<Bus> getListFindBus() {
		return listFindBus;
	}

	public void setListOfBus(List<Bus> listOfBus) {
		this.listOfBus = listOfBus;
	}

	public void setListFindBus(List<Bus> listFindBus) {
		this.listFindBus = listFindBus;
	}

	/*
	 * We find speed of bus follow km/h. Source:
	 * http://www.geodatasource.com/developers/java This function will give a
	 * list<Result> to write file.
	 */
	public List<Result> findSpeedBus(int id) {
		double speed = 0;
		double time = 0;
		this.addListBusWithId(id);
		if (this.listFindBus.isEmpty()) { // Check list empty
			return null;
		} else {
			// Add first line of bus with speed 0.
			Date date0 = new Date(this.getListFindBus().get(0).getDateTime());
			this.listOfResult.add(new Result(this.listFindBus.get(0).getId(),
					this.listFindBus.get(0).getLat(), this.listFindBus.get(0)
							.getLongt(), 0, date0, 0));

			// Find and Add next line of bus
			for (int i = 1; i < this.listFindBus.size(); i++) {
				double r = 6378137; // Radian of earth
				double dLat = (this.listFindBus.get(i).getLat() - this.listFindBus
						.get(i - 1).getLat()) * Math.PI / 180;
				double dLng = (this.listFindBus.get(i).getLongt() - this.listFindBus
						.get(i - 1).getLongt()) * Math.PI / 180;
				double a = Math.sin(dLat / 2)
						* Math.sin(dLat / 2)
						+ Math.cos(this.listFindBus.get(i - 1).getLat()
								* Math.PI / 180)
						* Math.cos(this.listFindBus.get(i).getLat() * Math.PI
								/ 180) * Math.sin(dLng / 2)
						* Math.sin(dLng / 2);
				double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
				double distance = r * c; // Meter
				time = this.listFindBus.get(i).changeMiliToSecond() // Change
																	// time from
																	// hour to
																	// second
						- this.listFindBus.get(i - 1).changeMiliToSecond();
				speed = (Math.abs(distance / time)) * 3.6; // Km/h

				Date date = new Date(this.getListFindBus().get(i).getDateTime());
				double latt = this.getListFindBus().get(i).getLat();
				double longtt = this.getListFindBus().get(i).getLongt();
				if (!(Double.isNaN(speed) || Double.isInfinite(speed))) {
					this.listOfResult.add(new Result(id, latt, longtt, speed,
							date, 0));
				}

			}
		}
		return listOfResult;
	}


	// Show arrayList
	@Override
	public String toString() {
		String result = "";
		for (Bus b1 : listFindBus) {
			result += b1.getId() + " " + b1.getLat() + " " + b1.getLongt()
					+ "\n";
		}
		return result;
	}

	public int compare(Bus arg0, Bus arg1) {
		// TODO Auto-generated method stub
		return Integer.compare(arg0.getId(), arg1.getId());
	}

	public List<Bus> findIdBus() {
		List<Bus> result = new ArrayList<Bus>();
		Set<Bus> busSet = new TreeSet<Bus>(new ManagerBus());
		for (Bus b : this.listOfBus) {
			if (busSet.add(b)) {
				result.add(b);
			}
		}
		return result;
	}

}
