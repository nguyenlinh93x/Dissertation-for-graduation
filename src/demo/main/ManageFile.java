package demo.main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ManageFile {
	// Use for write csv file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_HEADER = "deviceid,latitude,longtitude,speed(km/h),trktime,distance";

	private ManagerBus mnBus;
	private ManagerBusStation mnStation;

	public ManageFile() {
	}

	public ManagerBus getMnBus() {
		return mnBus;
	}

	public void setMnBus(ManagerBus mnBus) {
		this.mnBus = mnBus;
	}

	public ManagerBusStation getMnStation() {
		return mnStation;
	}

	public void setMnStation(ManagerBusStation mnStation) {
		this.mnStation = mnStation;
	}

	/*
	 * Read file source csv, read and write data into list
	 */
	public boolean readFile(File[] files, String type) {
		BufferedReader reader;

		mnBus = new ManagerBus();
		mnStation = new ManagerBusStation();

		try {
			for (File f : files) {
				if (f.isFile()) {
					String path = f.getAbsolutePath().toString();
					reader = new BufferedReader(new InputStreamReader(
							new FileInputStream(path)));
					String line = null;
					line = reader.readLine();
					while ((line = reader.readLine()) != null) {
						if (type.equals("bus")) {
							// Read file and create new array
							String[] valueCut = line.split("[\"]+");

							Timestamp ts = Timestamp.valueOf(valueCut[13]); // Define
																			// ts
																			// type
																			// timestamp
							long date = ts.getTime(); // type date: millisecond
							Bus bus = new Bus(Integer.parseInt(valueCut[1]),
									Double.parseDouble(valueCut[3]),
									Double.parseDouble(valueCut[5]),
									Double.parseDouble(valueCut[7]),
									Double.parseDouble(valueCut[9]),
									Double.parseDouble(valueCut[11]), date);
							mnBus.addBus(bus); // Add Object bus to Array List
						} else if (type.equals("station")) {
							String[] valueCut = line.split(",");
							BusStation station = new BusStation(
									Integer.parseInt(valueCut[0]),
									Double.parseDouble(valueCut[1]),
									Double.parseDouble(valueCut[2]),
									valueCut[3]);
							mnStation.addList(station);
						}
					}

					reader.close();
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),
					"You choose wrong file, choose again");
			return false;
		}
		System.out.println("OK");
		return true;
	}

	/*
	 * Help us write file csv to computer. In file, we have a list bus with id,
	 * latitude, longtitude, speed and date Every Id bus, we will have a file
	 */
	public boolean writeCsvFile(List<Result> listOfResult, String path) {
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(path);
			fileWriter.append(FILE_HEADER.toString()); // write header file
			fileWriter.append(NEW_LINE_SEPARATOR); // Enter new line

			for (Result result : listOfResult) { // Give data to write
				fileWriter.append(String.valueOf(result.getId()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(result.getLatitude()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(result.getLongtitude()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(result.getSpeed()));
				fileWriter.append(COMMA_DELIMITER);
				DateFormat dateFormat = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss");
				fileWriter.append(String.valueOf(dateFormat.format(result
						.getDate())));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(result.getDistance()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(new JFrame(),
						"You choose wrong file, choose again");
				// TODO: handle exception
			}
		}
		return true;
	}

	public DataChart readMultiFile(String direct) throws IOException,
			ParseException {
		String targer = direct;
		File dir = new File(targer);
		File[] files = dir.listFiles();
		String[] nameChart = new String[files.length];
		int i = 0;
		int count = countNumberObjectInFile(files);
		// Test
		Map<Point, Double> matrix = new HashMap<Point, Double>();
		Map<Point, Result> mapOfChart = new HashMap<Point, Result>();

		// Double[][] dataChart = new Double[count][count];
		// Double[][] distance = new Double[count][count];

		for (File f : files) {
			if (f.isFile()) {
				int j = 0;
				BufferedReader inputStream = null;
				try {
					inputStream = new BufferedReader(new FileReader(f));
					LineNumberReader lnr = new LineNumberReader(new FileReader(
							f));
					lnr.skip(Long.MAX_VALUE);
					String line;
					line = inputStream.readLine();
					lnr.close();
					while ((line = inputStream.readLine()) != null) {
						Result rs = new Result();
						String[] split = line.split(",");
						nameChart[i] = split[0];
						DateFormat dateFormat = new SimpleDateFormat(
								"dd/MM/yyyy HH:mm:ss");

						rs.setId(Integer.parseInt(split[0]));
						rs.setLatitude(Double.parseDouble(split[1]));
						rs.setLongtitude(Double.parseDouble(split[2]));
						rs.setSpeed(Double.parseDouble(split[3]));
						rs.setDate(dateFormat.parse(split[4]));
						rs.setDistance(Double.parseDouble(split[5]));

						mapOfChart.put(new Point(i, j), rs);
						matrix.put(new Point(i, j),
								Double.parseDouble(split[3]));
						// System.out.println(mapOfChart.get(new Point(i, j)));
						// dataChart[i][j] = Double.parseDouble(split[3]);
						// distance[i][j] = Double.parseDouble(split[5]);
						j++;
					}
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(new JFrame(),
							"File isn't right");
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(new JFrame(),
							"File isn't right");
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(new JFrame(),
							"You choose wrong file, choose again");
					// TODO: handle exception
				} finally {
					if (inputStream != null) {
						inputStream.close();
					}
				}
				i++;
			}
		}
		DataChart temp = new DataChart(nameChart, mapOfChart);
		return temp;
	}

	private int countNumberObjectInFile(File[] files) {
		int count = 1;
		for (File f : files) {
			if (f.isFile()) {
				BufferedReader inputStream = null;
				try {
					inputStream = new BufferedReader(new FileReader(f));
					LineNumberReader lnr = new LineNumberReader(new FileReader(
							f));
					lnr.skip(Long.MAX_VALUE);
					String line;
					line = inputStream.readLine();
					lnr.close();
					while ((line = inputStream.readLine()) != null) {
						count++;
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(),
							"File isn't right");
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(),
							"File isn't right");
					e.printStackTrace();
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(new JFrame(),
							"You choose wrong file, choose again");
				} finally {
					if (inputStream != null) {
						try {
							inputStream.close();
						} catch (IOException e) {
							JOptionPane.showMessageDialog(new JFrame(),
									"File isn't right");
							e.printStackTrace();
						}
					}
				}
			}
		}
		return count;
	}

}
