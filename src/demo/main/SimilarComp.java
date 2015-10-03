package demo.main;

import java.util.Comparator;

public class SimilarComp implements Comparator<Similar> {

	@Override
	public int compare(Similar o1, Similar o2) {
		// TODO Auto-generated method stub
		if(o1.getWarpDistance() < o2.getWarpDistance()) {
			return -1;
		}
		if(o1.getWarpDistance() > o2.getWarpDistance()) {
			return 1;
		}
		return 0;
	}

}
