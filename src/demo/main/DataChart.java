package demo.main;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataChart {
	private String[] nameChart;
	private Double[][] dataChart;
	private Double[][] distance;
	private Map<Point, Result> mapOfChart;

	public DataChart(String[] name, Double[][] data, Double[][] distance) {
		this.nameChart = name;
		this.dataChart = data;
		this.distance = distance;
	}

	public DataChart(String[] nameChart2, Map<Point, Result> mapOfChart) {
		this.mapOfChart = new HashMap<Point, Result>();
		this.nameChart = nameChart2;
		this.mapOfChart = mapOfChart;
		
	}

	public String[] getNameChart() {
		return nameChart;
	}

	public void setNameChart(String[] nameChart) {
		this.nameChart = nameChart;
	}

	public Double[][] getDataChart() {
		return dataChart;
	}

	public void setDataChart(Double[][] dataChart) {
		this.dataChart = dataChart;
	}

	public Double[][] getDistance() {
		return distance;
	}

	public void setDistance(Double[][] distance) {
		this.distance = distance;
	}
	
	

	public Map<Point, Result> getMapOfChart() {
		return mapOfChart;
	}

	public void setMapOfChart(Map<Point, Result> mapOfChart) {
		this.mapOfChart = mapOfChart;
	}

	@Override
	public String toString() {
		return "DataChart [nameChart=" + Arrays.toString(nameChart)
				+ ", dataChart=" + Arrays.toString(dataChart) + ", distance="
				+ Arrays.toString(distance) + "]";
	}

}
