package demo.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import demo.main.Bus;
import demo.main.ManagerBus;

public class BusTest {
	private Bus bus;
	private static final double DELTA = 1e-15;

	@Before
	public void setUp() throws Exception {
		bus = new Bus();
		bus = new Bus(112, 10.577, 106.2342, 15, 0, 0, 10000);
		
	}

	@Test
	public void testGetId() {
		assertEquals(112, bus.getId());
	}

	@Test
	public void testSetId() {
		bus.setId(115);
		assertEquals(115, bus.getId());
	}

	@Test
	public void testGetLat() {
		double compare = 10.577;
		assertEquals(compare, bus.getLat(), DELTA);
	}

	@Test
	public void testSetLat() {
		bus.setLat(12);
		assertEquals(12, bus.getLat(), DELTA);
	}

	@Test
	public void testGetLongt() {
		double compare = 106.2342;
		assertEquals(compare, bus.getLongt(), DELTA);
	}

	@Test
	public void testSetLongt() {
		bus.setLongt(104.23);
		assertEquals(104.23, bus.getLongt(), DELTA);
	}

	@Test
	public void testGetSpeed() {
		assertEquals(15, bus.getSpeed(), DELTA);
	}

	@Test
	public void testSetSpeed() {
		bus.setSpeed(30);
		assertEquals(30, bus.getSpeed(), DELTA);
	}

	@Test
	public void testGetSatellite() {
		assertEquals(0, bus.getSatellite(), DELTA);
	}

	@Test
	public void testSetSatellite() {
		bus.setSatellite(1);
		assertEquals(1, bus.getSatellite(), DELTA);
	}

	@Test
	public void testGetLock() {
		assertEquals(0, bus.getLock(), DELTA);
	}

	@Test
	public void testSetLock() {
		bus.setLock(1);
		assertEquals(1, bus.getLock(), DELTA);
	}

	 @Test
	 public void testGetDateTime() {
		 assertEquals(10000, bus.getDateTime(), DELTA);
	 }
	
	 @Test
	 public void testSetDateTime() {
		 bus.setDateTime(15000);;
		assertEquals(15000, bus.getDateTime(), DELTA);
	 }
	
	 @Test
	 public void testCheckId() {
		 assertTrue(bus.checkId(112));
		 assertFalse(bus.checkId(111));
	 }
	
	 @Test
	 public void testToString() {
	 	System.out.println(bus);
	 }
	
	 @Test
	 public void testChangeMiliToSecond() {
		 long temp = bus.changeMiliToSecond();
		 assertEquals(10, temp);
	 }

}
