package demo.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import demo.main.BusStation;

public class BusStationTest {
	private BusStation busStation;
	private static final double DELTA = 1e-15;
	
	@Before
	public void setUp() throws Exception {
		busStation = new BusStation(1, 2, 3, "no name");
	}

	@Test
	public void testGetId() {
		assertEquals(1, busStation.getId());
	}

	@Test
	public void testSetId() {
		busStation.setId(2);
		assertEquals(2, busStation.getId());
	}

	@Test
	public void testGetLatitude() {
		assertEquals(2, busStation.getLatitude(), DELTA);
	}

	@Test
	public void testSetLatitude() {
		busStation.setLatitude(3);
		assertEquals(3, busStation.getLatitude(), DELTA);
	}

	@Test
	public void testGetLongtitude() {
		assertEquals(3, busStation.getLongtitude(), DELTA);
	}

	@Test
	public void testSetLongtitude() {
		busStation.setLongtitude(4);
		assertEquals(4, busStation.getLongtitude(), DELTA);
	}

	@Test
	public void testGetNameStation() {
		assertEquals("no name", busStation.getNameStation());
	}

	@Test
	public void testSetNameStation() {
		busStation.setNameStation("Minions");
		assertEquals("Minions", busStation.getNameStation());
	}

	@Test
	public void testToString() {
		System.out.println(busStation);
	}

}
