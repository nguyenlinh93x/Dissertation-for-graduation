package demo.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BusTest.class,
	ManagerAllTest.class,
	BusStationTest.class
})
public class AllTest {

	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { AllTest.class });
	}

}
