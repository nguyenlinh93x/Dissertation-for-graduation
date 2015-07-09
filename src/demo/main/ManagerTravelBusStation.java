package demo.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ManagerTravelBusStation {
	private List<Result> listOfTravel; // List bus has minimum distance with
										// station

	public ManagerTravelBusStation() {
		listOfTravel = new ArrayList<Result>();
	}

	public List<Result> getListOfTravel() {
		return listOfTravel;
	}

	public void setListOfTravel(List<Result> listOfTravel) {
		this.listOfTravel = listOfTravel;
	}

	public boolean findBusTravel(List<Result> listOfBusId, BusStation station,
			String type) {
		Result result = new Result();
		result = findMinimumBus(listOfBusId, station);
		if (result != null) {
			for (int i = 0; i < listOfBusId.size(); i++) {
				if (result.getDate().equals(listOfBusId.get(i).getDate())) {
					if (type.equals("Time")) {
						addBeforeBus(listOfBusId, i, result);
						addAfterBus(listOfBusId, i, result);
						return true;
					} else if (type.equals("Distance")) {
						addDistanceBeforeBus(listOfBusId, i);
						addDistanceAfterBus(listOfBusId, i);
						return true;
					}
				}
			}

		} else {
			listOfTravel.clear();
			return false;
		}

		// Sort list follow date

		return true;
	}

	private boolean addDistanceAfterBus(List<Result> result, int i) {
		BusStation bs = new BusStation(1, result.get(i).getLatitude(), result
				.get(i).getLongtitude(), null);
		Calendar calMain = Calendar.getInstance();
		calMain.setTime(result.get(i).getDate());
		int day = calMain.get(Calendar.DAY_OF_MONTH);

		// System.out.println("Tram: " + bs);

		if (i + 1 >= result.size()) {
			return false;
		}
		for (int j = i; j < result.size(); j++) {
			double distance = this
					.findDistanceBusWithStation(result.get(j), bs);
			Calendar cal = Calendar.getInstance();
			cal.setTime(result.get(j).getDate());
			int dayCompare = cal.get(Calendar.DAY_OF_MONTH);
			if (null == result.get(j)) { // Kiem tra list co null khong
				return false;
			} else {
				if (distance <= 500 && day == dayCompare) {
					result.get(j).setDistance(distance);
					listOfTravel.add(result.get(j));
				} else {
					return false;
				}
			}
		}

		return true;

	}

	private boolean addDistanceBeforeBus(List<Result> result, int i) {
		BusStation bs = new BusStation(1, result.get(i).getLatitude(), result
				.get(i).getLongtitude(), null);
		Calendar calMain = Calendar.getInstance();
		calMain.setTime(result.get(i).getDate());
		int day = calMain.get(Calendar.DAY_OF_MONTH);

		if (i - 1 < 0) {
			return false;
		}

		for (int j = i - 1; j > 0; j--) {
			double distance = this
					.findDistanceBusWithStation(result.get(j), bs);
			Calendar cal = Calendar.getInstance();
			cal.setTime(result.get(j).getDate());
			int dayCompare = cal.get(Calendar.DAY_OF_MONTH);

			if (null == result.get(j)) {
				return false;
			} else {
				if (distance <= 500 && day == dayCompare) {
					result.get(j).setDistance(distance);
					Result tempResult = result.get(j);
					tempResult.setDistance(-tempResult.getDistance());
					listOfTravel.add(tempResult);
				} else {
					return false;
				}
			}
		}

		// if (i > 100) {
		// for (int j = i - 100; j < i; j++) {
		// double distance = this.findDistanceBusWithStation(
		// result.get(j), bs);
		// Calendar cal = Calendar.getInstance();
		// cal.setTime(result.get(j).getDate());
		// int dayCompare = cal.get(Calendar.DAY_OF_MONTH);
		//
		// if (null == result.get(j)) {
		// return false;
		// } else {
		// if (distance <= 500 && day == dayCompare) {
		// result.get(j).setDistance(distance);
		//
		// listOfTravel.add(result.get(j));
		// }
		// }
		// }
		// }
		return true;

	}

	/*
	 * Sau ket qua vi tri i tim duoc, ta lay them mot so phan tu voi so phut cho
	 * truoc
	 */
	private boolean addAfterBus(List<Result> result, int i, Result destination) {
		int timeChange = 5;
		int size = i + 100;
		if (i + 1 >= result.size()) {
			return false;
		}
		Date date = result.get(i).getDate();
		Calendar cal1 = Calendar.getInstance(); // Thoi gian thay doi
		Calendar cal2 = Calendar.getInstance(); // Thoi gian cua tung doi tuong
												// khi chay dong for
		Calendar nowTime = Calendar.getInstance(); // Thoi gian hien tai cua
													// result
		nowTime.setTime(date);
		cal1.setTime(date);
		cal1.add(Calendar.MINUTE, timeChange); // Them so phut bang voi
												// timeChange

		// System.out.println("Date " + date);
		// System.out.println(i);
		for (int j = i; j < size; j++) {
			if (j > result.size() || null == result.get(j)) { // Kiem tra list
																// co null khong
				return false;
			} else {
				cal2.setTime(result.get(j).getDate()); // Lay thoi gian cua doi
														// tuong dang xet
				// Kiem tra xem khi cong voi timeChange co qua 60 phut khong
				if (cal1.get(Calendar.MINUTE) < timeChange) {
					if (nowTime.get(Calendar.HOUR) == cal2.get(Calendar.HOUR)
							&& cal2.get(Calendar.MINUTE) >= nowTime
									.get(Calendar.MINUTE)) {
						double resultAddTime = calDistanceTimeAfter(cal2,
								destination);
						result.get(j).setDistance(resultAddTime);
						listOfTravel.add(result.get(j));
					} else if (cal2.get(Calendar.HOUR) == cal1
							.get(Calendar.HOUR)
							&& cal2.get(Calendar.MINUTE) <= cal1
									.get(Calendar.MINUTE)) {
						double resultAddTime = calDistanceTimeAfter(cal2,
								destination);
						result.get(j).setDistance(resultAddTime);
						listOfTravel.add(result.get(j));
					}
					// Neu cong voi time change khong qua 60 phut thi lam
				} else {
					if (cal2.get(Calendar.HOUR) == cal1.get(Calendar.HOUR)
							&& cal2.get(Calendar.MINUTE) <= cal1
									.get(Calendar.MINUTE)) {
						double resultAddTime = calDistanceTimeAfter(cal2,
								destination);
						result.get(j).setDistance(resultAddTime);
						listOfTravel.add(result.get(j));
					} else {
						return false;
					}
				}
			}
		}

		return true;
	}

	/*
	 * Tinh do chenh lecnh giua bus time va station time
	 */
	private double calDistanceTimeAfter(Calendar cal2, Result destination) {
		Calendar timeDes = Calendar.getInstance();
		timeDes.setTime(destination.getDate());
		int compare = cal2.compareTo(timeDes);

		if (compare == 1) {
			double finalResult = (cal2.getTimeInMillis() - timeDes
					.getTimeInMillis()) * 0.001;
			return finalResult;
		}
		return 0;
	}

	/*
	 * Lay phan tu truoc phan tu i tim duoc
	 */
	private boolean addBeforeBus(List<Result> result, int i, Result destination) {
		if (i - 1 < 0) {
			return false;
		}
		int timeChange = -5;
		Date date = result.get(i).getDate();
		Calendar cal1 = Calendar.getInstance(); // Thoi gian doi tuong vong` lap
		Calendar cal2 = Calendar.getInstance(); // Thoi gian thay doi voi
												// timeChange
		Calendar nowTime = Calendar.getInstance(); // Thoi gian cua doi tuong
													// hien tai(co vi tri bang
													// i)
		nowTime.setTime(date);
		cal1.setTime(date);
		cal1.add(Calendar.MINUTE, timeChange);

		// System.out.println("now time: " + cal1.getTime());
		for (int j = i - 100; j < i; j++) {
			if (j < 0 || null == result.get(j)) {
				return false;
			} else {
				cal2.setTime(result.get(j).getDate());
				// Kiem tra khi tru voi timeChange co < 0 khong
				if (nowTime.get(Calendar.MINUTE) < Math.abs(timeChange)) {
					if (cal2.get(Calendar.HOUR) == cal1.get(Calendar.HOUR)
							&& cal2.get(Calendar.MINUTE) >= cal1
									.get(Calendar.MINUTE)) {
						double resultAddTime = calDistanceTimeBefore(cal2,
								destination);
						result.get(j).setDistance(-resultAddTime);
						listOfTravel.add(result.get(j));
					} else if (cal2.get(Calendar.HOUR) == (nowTime
							.get(Calendar.HOUR) - 1)
							&& cal2.get(Calendar.MINUTE) <= nowTime
									.get(Calendar.MINUTE)) {
						double resultAddTime = calDistanceTimeBefore(cal2,
								destination);
						result.get(j).setDistance(-resultAddTime);
						listOfTravel.add(result.get(j));
					}
				} else {
					// Neu khong be hon khong thi tiep tuc lam
					if (cal2.get(Calendar.HOUR) == nowTime.get(Calendar.HOUR)
							&& cal2.get(Calendar.MINUTE) >= cal1
									.get(Calendar.MINUTE)
							&& cal2.get(Calendar.MINUTE) <= nowTime
									.get(Calendar.MINUTE)) {
						double resultAddTime = calDistanceTimeBefore(cal2,
								destination);
						result.get(j).setDistance(-resultAddTime);
						listOfTravel.add(result.get(j));
					}
				}

			}
		}
		return true;
	}

	private double calDistanceTimeBefore(Calendar cal2, Result destination) {
		Calendar timeDes = Calendar.getInstance();
		timeDes.setTime(destination.getDate());

		double finalResult = (cal2.getTimeInMillis() - timeDes
				.getTimeInMillis()) * 0.001;

		return Math.abs(finalResult);
	}

	/*
	 * find bus has position minimum than bus station.
	 */
	private Result findMinimumBus(List<Result> listOfBusId, BusStation station) {

		for (int i = 0; i < listOfBusId.size(); i++) {
			if (conditionLat(listOfBusId.get(i), station) == true
					&& conditionLong(listOfBusId.get(i), station) == true
					&& listOfBusId.get(i).getSpeed() == 0) {
				return listOfBusId.get(i);
			}
		}
		return null;
	}

	private boolean conditionLong(Result result, BusStation station) {
		if (result.getLongtitude() >= (station.getLongtitude() - 0.0001)
				&& result.getLongtitude() <= (station.getLongtitude() + 0.0001)) {
			return true;
		}
		return false;
	}

	private boolean conditionLat(Result result, BusStation station) {
		if (result.getLatitude() >= (station.getLatitude() - 0.0001)
				&& result.getLatitude() <= (station.getLatitude() + 0.0001)) {
			return true;
		}
		return false;
	}

	private double findDistanceBusWithStation(Result bus, BusStation station) {

		double r = 6378137; // Radian of earth
		double dLat = (station.getLatitude() - bus.getLatitude()) * Math.PI
				/ 180;
		double dLng = (station.getLongtitude() - bus.getLongtitude()) * Math.PI
				/ 180;
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(bus.getLatitude() * Math.PI / 180)
				* Math.cos(station.getLatitude() * Math.PI / 180)
				* Math.sin(dLng / 2) * Math.sin(dLng / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = r * c; // Meter

		return Math.abs(dist);

	}

	private double radToDeg(double dist) {
		return (dist * 180 / Math.PI);
	}

	private double degToRad(double value) {
		return (value * Math.PI / 180.0);
	}

//	public void refreshSpeedBus() {
//		long time = 0;
//		double speed = 0;
//		for (int i = 1; i < listOfTravel.size(); i++) {
//			double r = 6378137; // Radian of earth
//			double dLat = (listOfTravel.get(i).getLatitude() - listOfTravel
//					.get(i - 1).getLatitude()) * Math.PI / 180;
//			double dLng = (listOfTravel.get(i).getLongtitude() - listOfTravel
//					.get(i - 1).getLongtitude()) * Math.PI / 180;
//			double a = Math.sin(dLat / 2)
//					* Math.sin(dLat / 2)
//					+ Math.cos(listOfTravel.get(i - 1).getLatitude() * Math.PI
//							/ 180)
//					* Math.cos(listOfTravel.get(i).getLatitude() * Math.PI
//							/ 180) * Math.sin(dLng / 2) * Math.sin(dLng / 2);
//			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//			double distance = r * c; // Meter
//
//			// Time to seconds
//			time = listOfTravel.get(i).changeMiliToSecond()
//					- listOfTravel.get(i - 1).changeMiliToSecond();
//			speed = (Math.abs(distance / time)) * 3.6; // Km/h
//
//			if (!(Double.isNaN(speed) || Double.isInfinite(speed))) {
//				listOfTravel.get(i).setSpeed(speed);
//			}
//
//		}
//
//	}

}
