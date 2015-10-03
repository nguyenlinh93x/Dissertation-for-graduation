package demo.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import demo.main.ManagerBus;
import demo.main.ManagerBusStation;
import demo.main.ManagerFile;
import demo.main.ManagerTravelBusStation;
import demo.main.Result;

public class ManagerAllTest {
	ManagerFile mnFile;
	File[] files;
	ManagerBus mnBus;
	ManagerTravelBusStation mnStation;
	ManagerBusStation station;

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Before
	public void setUp() throws Exception {
		files = new File[1];
		mnFile = new ManagerFile();
		mnStation = new ManagerTravelBusStation();
		URL url = getClass().getResource("/testfile/02.csv");
		files[0] = new File(url.getFile());

	}

	@Test
	public void testReadFileBus() {
		assertTrue(mnFile.readFile(files, "bus"));

	}

	@Test
	public void testFindSpeedBus() {
		assertTrue(mnFile.readFile(files, "bus"));
		mnBus = new ManagerBus(mnFile.getMnBus());
		assertNotNull(mnBus.findSpeedBus(121));
	}

	@Test
	public void testFindSpeedStation() {
		assertTrue(mnFile.readFile(files, "bus"));
		mnBus = new ManagerBus(mnFile.getMnBus());
		mnBus.findSpeedBus(121);
		URL url = getClass().getResource("/testfile/station1.csv");
		files[0] = new File(url.getFile());
		mnFile.readFile(files, "station");
		assertTrue(mnStation.findBusTravel(mnBus.getListOfResult(), mnFile
				.getMnStation().getListOfStation().get(0), "Distance"));
		assertTrue(mnStation.findBusTravel(mnBus.getListOfResult(), mnFile
				.getMnStation().getListOfStation().get(0), "Time"));
		System.out.println(mnBus);
		assertNotNull(mnBus.findIdBus());
	}

	@Test
	public void testReadFileNotFound() {
		URL url = getClass().getResource("/03.csv");
		assertNull(url);
		File fileCheck[] = new File[1];
		assertFalse(mnFile.readFile(fileCheck, "bus"));

	}

	@Test
	public void testReadFileStation() {
		URL url = getClass().getResource("/testfile/station1.csv");
		files[0] = new File(url.getFile());
		assertTrue(mnFile.readFile(files, "station"));
	}

	@Test
	public void testWriteCsvFile() {
		Result rs = new Result(118, 10.75122, 106.65237, 0.0, new Date(2012,
				11, 9, 00, 00, 17), 0.0);
		List<Result> listOfResult = new ArrayList<Result>();

		listOfResult.add(rs);
		try {
			File tempFile = tempFolder.newFile("temp.txt");
			System.out.println(tempFile.getAbsolutePath());
			assertTrue(mnFile.writeCsvFile(listOfResult,
					tempFile.getAbsolutePath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testReadMultiFile() {
		String direct = getClass().getResource("/testchart").getFile();
		System.out.println(direct);
		try {
			mnFile.readMultiFile(direct);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
