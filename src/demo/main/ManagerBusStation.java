package demo.main;

import java.util.ArrayList;
import java.util.List;

public class ManagerBusStation {
	private List<BusStation> listOfStation;
	
	public ManagerBusStation(List<BusStation> list) {
		this.listOfStation = list;
	}
	
	public ManagerBusStation() {
		this.listOfStation = new ArrayList<BusStation>();
	}
	
	public boolean addList(BusStation station) {
		if (null != station) {
			listOfStation.add(station);
			return true;
		}
		return false;
	}

	public List<BusStation> getListOfStation() {
		return listOfStation;
	}

	public void setListOfStation(List<BusStation> listOfStation) {
		this.listOfStation = listOfStation;
	}
	
	
}
