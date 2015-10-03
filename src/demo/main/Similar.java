package demo.main;

import com.dtw.WarpPath;

public class Similar {
	private String name;
	private double warpDistance;
	private WarpPath warpPath;
	
	public Similar(String name, double value, WarpPath warp) {
		this.name = name;
		this.warpDistance = value;
		this.warpPath = warp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public double getWarpDistance() {
		return warpDistance;
	}

	public void setWarpDistance(double warpDistance) {
		this.warpDistance = warpDistance;
	}

	public WarpPath getWarpPath() {
		return warpPath;
	}

	public void setWarpPath(WarpPath warpPath) {
		this.warpPath = warpPath;
	}

	@Override
	public String toString() {
		return "Similar [name=" + name + ", warpDistance=" + warpDistance
				+ ", warpPath=" + warpPath + "]" + "\n";
	}
	
	


	
	
	
	
	
}
