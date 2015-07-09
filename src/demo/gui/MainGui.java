package demo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.JMapViewerTree;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.OsmTileLoader;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.TileLoader;
import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.BingAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.MapQuestOpenAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.MapQuestOsmTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

import demo.main.Bus;
import demo.main.BusStation;
import demo.main.DataChart;
import demo.main.ManageFile;
import demo.main.ManagerBus;
import demo.main.ManagerTravelBusStation;
import demo.main.Result;
import javax.swing.ScrollPaneConstants;

public class MainGui extends JFrame {

	private JFrame frmBusApplication;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblInputFile;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txt1;
	private JButton btnReadFile;
	private JTable table;
	private ManageFile mnf;
	private JLabel lbl1;
	private ManagerBus mnBus;
	private JButton btnStationBus;
	private JComboBox cbType;

	private List<Bus> idBus;
	private JPanel panelStation;
	private List<Result> listOfResult;
	private List<BusStation> listOfStation;
	private JFileChooser fileChooser1;
	private JFileChooser chooseFolder;
	private File fileToSave1;
	private String director;
	private String directorStation;
	private JPanel panelTabChart;
	private JPanel panel_5;
	private JLabel lblNewLabel;
	private JTextField txtFolder1;
	private DataChart dtChart;
	private JLabel lblFinish;
	private JPanel panelReadFile;
	private JLabel label;
	private int datasetIndex = 0;
	private XYPlot plot;
	private JTextField textStation;
	private ChartPanel chartPanel;
	private List<JCheckBox> cbChart;
	private JPanel panel_7;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenu mnNewMenu;
	private JMenu mnOpenFile;
	private JPanel panelIntroduce;
	private Image bg;
	private JLabel lblBackground;
	private JLabel lblNewLabel_3;
	private JProgressBar progressReadFile;
	private JScrollPane scrollPaneTree;
	private JPanel panel_6;
	private JPanel panel_8;
	private JTabbedPane tabbedReadFile;
	private JPanel panelViewId;
	private JPanel panelViewStation;
	private JLabel lblChooseId;
	private JPanel panelComboId;
	private JButton btnAddData;
	private DefaultMutableTreeNode node_1;
	private DefaultMutableTreeNode node_2;
	private JTable table_1;
	private JPanel panel_9;
	private JToolBar toolBar;
	private int countChart = 0;
	private XYSeriesCollection dataset1;
	private JMapViewer viewer;

	private JMapViewerTree treeMap = null;

	private JLabel zoomLabel = null;
	private JLabel zoomValue = null;

	private JLabel mperpLabelName = null;
	private JLabel mperpLabelValue = null;
	private JPanel panelHelp;
	private JCheckBox chckbxShowTreeLayer;
	private JPanel panel_3;
	private JComboBox cbChangeChart;
	private String typeChart;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frmBusApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
					UIManager.getLookAndFeelDefaults().put(
							"MenuBar[Enabled].backgroundPainter",
							new FillPainter(new Color(0, 0, 128)));
					UIManager.getLookAndFeelDefaults().put(
							"TextField[Enabled].backgroundPainter",
							new FillPainter(new Color(152, 251, 152)));

					break;
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

		// Config main frame
		frmBusApplication = new JFrame();
		frmBusApplication.setBackground(SystemColor.activeCaptionBorder);
		frmBusApplication.setTitle("Bus Application");
		frmBusApplication.setBounds(100, 100, 442, 348);
		frmBusApplication.pack();
		frmBusApplication.setSize(new Dimension(700, 500));
		// frmBusApplication.setLocationRelativeTo(null);
		frmBusApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBusApplication.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Declare Map
		viewer = new JMapViewer();
		new DefaultMapController(viewer) {
			@Override
			public void mouseMoved(MouseEvent e) {
				viewer.setToolTipText(viewer.getPosition(e.getPoint())
						.toString());
			}
		};
		treeMap = new JMapViewerTree("Zones");
		viewer.setBounds(10, 5, 507, 511);

		listOfStation = new ArrayList<BusStation>();
		cbChart = new ArrayList<JCheckBox>();

		director = null;
		directorStation = null;
		mnf = new ManageFile();
		listOfResult = new ArrayList<Result>();
		frmBusApplication.getContentPane().setLayout(null);

		// Tab index 0, 1, 2
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 26, 1362, 658);
		frmBusApplication.getContentPane().add(tabbedPane);

		panelIntroduce = new BgPanel();
		tabbedPane.addTab("Home", null, panelIntroduce, null);
		panelIntroduce.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel(" Bus App");
		lblNewLabel_2.setBounds(466, 122, 881, 273);
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 50));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		Image background = new ImageIcon(this.getClass().getResource(
				"/station.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(background));
		panelIntroduce.add(lblNewLabel_2);

		ClassLoader cldr = this.getClass().getClassLoader();
		URL imageUrl = this.getClass().getResource("/bus11.gif");
		ImageIcon imageIcon = new ImageIcon(imageUrl);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(459, 390, 613, 178);
		panelIntroduce.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(imageIcon);
		imageIcon.setImageObserver(lblNewLabel_3);

		panel = new JPanel();

		tabbedPane.addTab("Read file", null, panel, null);
		panel.setLayout(new BorderLayout());

		panelTabChart = new JPanel();
		tabbedPane.addTab("Evaluate data", null, panelTabChart, null);
		panelTabChart.setLayout(null);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(55, 44, 294, 20);

		final JPanel panelContentChart = new JPanel();
		panelContentChart.setBounds(22, 54, 663, 403);
		panelTabChart.add(panelContentChart);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(695, 54, 77, 403);
		panelTabChart.add(scrollPane);

		final JPanel panelCheck = new JPanel();
		panelCheck.setBorder(new LineBorder(SystemColor.controlLtHighlight));
		scrollPane.setViewportView(panelCheck);
		panelCheck.setBackground(Color.WHITE);
		panelCheck.setLayout(new GridLayout(0, 1));

		JPanel panelMap = new JPanel();
		panelMap.setBounds(808, 54, 527, 565);
		panelTabChart.add(panelMap);
		panelMap.setLayout(null);
		panelMap.add(viewer);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 527, 507, 27);
		panelMap.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_4 = new JLabel(
				"Red: Bus station || Green: First point || Green: Last point");
		lblNewLabel_4.setBounds(10, 0, 487, 27);
		panel_1.add(lblNewLabel_4);

		JPanel panelMapTest1 = new JPanel();
		panelMapTest1
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"), "ACTION",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(
								0, 0, 0)));
		panelMapTest1.setBackground(SystemColor.controlHighlight);
		panelMapTest1.setBounds(10, 485, 779, 122);
		panelTabChart.add(panelMapTest1);
		panelMapTest1.setLayout(null);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "MAP", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panel_10.setBackground(SystemColor.activeCaption);
		panel_10.setBounds(424, 11, 319, 100);
		panelMapTest1.add(panel_10);
		panel_10.setLayout(null);

		JLabel lblChangeMap = new JLabel("Change map:");
		lblChangeMap.setBounds(10, 24, 93, 14);
		panel_10.add(lblChangeMap);

		JButton btnFitMarker = new JButton("Fit map");
		btnFitMarker.setBounds(64, 49, 89, 23);
		panel_10.add(btnFitMarker);

		// JComboBox<TileLoader> cbTileLoader = new JComboBox<TileLoader>();
		// cbTileLoader.setBounds(145, 11, 89, 20);
		// cbTileLoader.addItem(new OsmTileLoader(viewer));
		// cbTileLoader.addItemListener(new ItemListener() {
		// public void itemStateChanged(ItemEvent e) {
		// viewer.setTileLoader((TileLoader) e.getItem());
		// }
		// });
		// viewer.setTileLoader(((TileLoader) cbTileLoader.getSelectedItem()));

		// panelMapTest1.add(cbTileLoader);

		// Check Box show marker
		final JCheckBox chckbxShowMarker = new JCheckBox("Show marker");
		chckbxShowMarker.setBounds(178, 49, 97, 23);
		panel_10.add(chckbxShowMarker);
		chckbxShowMarker.setSelected(viewer.getMapMarkersVisible());

		JComboBox<TileSource> cbTileSource = new JComboBox<TileSource>();
		cbTileSource.setBounds(82, 21, 196, 20);
		panel_10.add(cbTileSource);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Other function",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_11.setBackground(SystemColor.activeCaption);
		panel_11.setBounds(79, 11, 260, 100);
		panelMapTest1.add(panel_11);
		panel_11.setLayout(null);

		JLabel lblComingSoon = new JLabel("Coming soon!");
		lblComingSoon.setFont(new Font("Tempus Sans ITC", Font.BOLD
				| Font.ITALIC, 13));
		lblComingSoon.setBounds(80, 41, 103, 14);
		panel_11.add(lblComingSoon);
		cbTileSource.addItem(new OsmTileSource.Mapnik());
		cbTileSource.addItem(new OsmTileSource.CycleMap());
		cbTileSource.addItem(new MapQuestOsmTileSource());

		cbTileSource.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				viewer.setTileSource((TileSource) e.getItem());
			}
		});
		chckbxShowMarker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				viewer.setMapMarkerVisible(chckbxShowMarker.isSelected());
			}
		});

		// Fit Marker view when you clicked
		btnFitMarker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewer.setDisplayToFitMapMarkers();
			}
		});

		// // Show tree layer
		// chckbxShowTreeLayer = new JCheckBox("Show tree");
		// chckbxShowTreeLayer.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// treeMap.setTreeVisible(chckbxShowTreeLayer.isSelected());
		// }
		// });
		//
		// chckbxShowTreeLayer.setBounds(137, 54, 97, 23);
		// panelMapTest1.add(chckbxShowTreeLayer);

		panelHelp = new JPanel();
		panelHelp.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panelHelp.setBackground(SystemColor.activeCaption);
		panelHelp.setBounds(815, 8, 514, 35);
		panelTabChart.add(panelHelp);
		panelHelp.setLayout(null);

		JLabel labelHelp = new JLabel("Use right mouse button to move,\n "
				+ "left double click or mouse wheel to zoom.");
		labelHelp.setBounds(10, 11, 418, 14);
		panelHelp.add(labelHelp);

		final JComboBox cbViewMapBus = new JComboBox();
		cbViewMapBus.setBounds(430, 8, 74, 20);
		panelHelp.add(cbViewMapBus);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, SystemColor.controlLtHighlight));
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(10, 8, 779, 466);
		panelTabChart.add(panel_3);

		// Change polyline and marker when change id bus
		cbViewMapBus.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// if combobox change value
				if (e.getStateChange() == ItemEvent.SELECTED) {

					// Get id bus
					String[] name = dtChart.getNameChart();
					// Get item selected in checkbox
					int id = Integer.parseInt(e.getItem().toString());
					// Get data of bus
					Map<Point, Result> mapOfChart = new HashMap<Point, Result>(
							dtChart.getMapOfChart());
					// Set first point show on map
					List<Coordinate> coordinates = new ArrayList<Coordinate>();
					for (int i = 0; i < name.length; i++) {
						for (int j = 0; j < mapOfChart.size(); j++) {
							Result data = mapOfChart.get(new Point(i, j));

							// Check data is not null and have id equal id cbx
							if (data != null && id == (data.getId())) {

								Coordinate indexPoint = new Coordinate(data
										.getLatitude(), data.getLongtitude());
								// Show first position show on map
								if (data.getDistance() == 0) {
									MapMarkerDot mapDot = new MapMarkerDot(data
											.getLatitude(), data
											.getLongtitude());
									mapDot.setBackColor(Color.RED);
									viewer.setDisplayPosition(indexPoint, 16);
									viewer.addMapMarker(mapDot);
								} else {
									if (j == 0) {
										MapMarkerDot mapDot = new MapMarkerDot(
												data.getLatitude(), data
														.getLongtitude());
										mapDot.setBackColor(Color.GREEN);
										viewer.addMapMarker(mapDot);
									} else {

										MapMarkerDot mapDot = new MapMarkerDot(
												data.getLatitude(), data
														.getLongtitude());
										viewer.addMapMarker(mapDot);
									}

								}

								// Add marker and polyline
								coordinates.add(new Coordinate(data
										.getLatitude(), data.getLongtitude()));

							} else {
								break;
							}
						}
					}
					List mapMarkers = viewer.getMapMarkerList();
					MapMarkerDot dot = (MapMarkerDot) mapMarkers.get(mapMarkers
							.size() - 1);
					dot.setBackColor(Color.ORANGE);
					MapPolyLine polyLine = new MapPolyLine(coordinates);
					viewer.addMapPolygon(polyLine);
				} else {
					viewer.removeAllMapMarkers();
					viewer.removeAllMapPolygons();
				}
			}
		});

		mperpLabelName = new JLabel("Meters/Pixels: ");
		mperpLabelValue = new JLabel(String.format("%s",
				viewer.getMeterPerPixel()));

		zoomLabel = new JLabel("Zoom: ");
		zoomValue = new JLabel(String.format("%s", viewer.getZoom()));

		panelReadFile = new JPanel();
		panelReadFile.setToolTipText("");
		panelReadFile.setBounds(10, 237, 405, 44);
		panel.add(panelReadFile);
		panelReadFile.setLayout(null);

		label = new JLabel();

		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Chart", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panel_5.setBackground(SystemColor.activeCaption);
		panelReadFile.add(panel_5);

		panel_5.setBounds(21, 509, 404, 101);
		panel_5.setLayout(null);

		lblNewLabel = new JLabel("Link:");
		lblNewLabel.setBounds(10, 34, 25, 15);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_5.add(lblNewLabel);

		txtFolder1 = new JTextField();
		txtFolder1.setBounds(51, 32, 241, 20);
		txtFolder1.setColumns(10);
		panel_5.add(txtFolder1);

		final JLabel lbIcon = new JLabel("");
		lbIcon.setBounds(435, 522, 78, 88);
		Image imgNext = new ImageIcon(this.getClass().getResource(
				"/next-icon.png")).getImage();

		lbIcon.setIcon(new ImageIcon(imgNext));
		panelReadFile.add(lbIcon);
		lbIcon.hide();

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(SystemColor.activeCaption);
		panel_12.setBounds(543, 509, 771, 101);
		panelReadFile.add(panel_12);
		panel_12.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 30, 751, 46);
		panel_12.add(scrollPane_1);

		final JLabel lbInfo = new JLabel(
				" Use chart panel to read a data folder and view map and chart on another tab.\r\n If you don't have data folder, you should use function of main panel");
		scrollPane_1.setViewportView(lbInfo);
		lbInfo.setBackground(new Color(153, 204, 204));
		lbInfo.setFont(new Font("Trebuchet MS", Font.BOLD, 14));

		final JButton btnNewButton_2 = new JButton("Choose");
		btnNewButton_2.setBounds(302, 31, 91, 23);
		/*
		 * Read folder and draw chart
		 */
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result;

				chooseFolder = new JFileChooser();
				chooseFolder.setDialogTitle("Choose a folder");
				chooseFolder
						.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooseFolder.setApproveButtonText("Select");
				// Disable file option
				chooseFolder.setAcceptAllFileFilterUsed(false);
				result = chooseFolder.showOpenDialog(btnNewButton_2);
				if (result == JFileChooser.APPROVE_OPTION) {
					lbIcon.show();

					txtFolder1.setText(chooseFolder.getSelectedFile()
							.toString());
					// Call function read folder
					try {
						String showIdInfo = " Id will be showed on chart contains: ";
						dtChart = mnf.readMultiFile(chooseFolder
								.getSelectedFile().toString());
						String[] name = dtChart.getNameChart();
						for (int i = 0; i < name.length; i++) {
							if (i == name.length - 1) {
								showIdInfo += name[i]
										+ ".Click show button to start view!";
							} else {
								showIdInfo += name[i] + ", ";
							}

						}
						lbInfo.setText(showIdInfo);

						JOptionPane.showMessageDialog(new JFrame(), "Success");
						// Get items that were selected

					} catch (IOException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					System.out.println("No select");
				}
			}

		});
		panel_5.add(btnNewButton_2);

		final JButton btnShow = new JButton("Show");
		btnShow.setBounds(51, 62, 123, 23);
		panel_5.add(btnShow);

		cbChangeChart = new JComboBox();
		cbChangeChart.setBounds(184, 63, 108, 20);
		panel_5.add(cbChangeChart);
		cbChangeChart.addItem("Distance");
		cbChangeChart.addItem("Time");

		scrollPaneTree = new JScrollPane();
		scrollPaneTree.setBounds(538, 53, 188, 402);
		panelReadFile.add(scrollPaneTree);

		final JTree tree = new JTree();

		// When click node of tree, a event will begin
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				DefaultTableModel modelTable = (DefaultTableModel) table_1
						.getModel();
				int rowCount = modelTable.getRowCount();
				// Remove rows one by one from the end of the table
				if (rowCount > 0) {
					for (int i = rowCount - 1; i >= 0; i--) {
						modelTable.removeRow(i);
					}
				}

				// Get Model tree
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

				// Get root of tree
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) model
						.getRoot();

				// Get child node 1st
				DefaultMutableTreeNode subChild = (DefaultMutableTreeNode) model
						.getChild(selectedNode, 0);

				// Get node which was selected
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();

				// If node haven't choosen, we won't do nothing
				if (node == null) {
					return;
				}

				// Add data into table
				for (int i = 1; i < subChild.getChildCount(); i++) {

					// If node was selected equal child node of first node
					if ((DefaultMutableTreeNode) model.getChild(subChild, i) == node) {

						// Get node string
						String nodeInfo = node.getUserObject().toString();

						tree.getSelectionModel().setSelectionMode(
								TreeSelectionModel.SINGLE_TREE_SELECTION);

						listOfResult = mnBus.findSpeedBus(Integer
								.parseInt(nodeInfo));
						for (Result rs : listOfResult) {
							// Add data
							DateFormat dateFormat = new SimpleDateFormat(
									"dd/MM/yyyy HH:mm:ss");

							modelTable.addRow(new Object[] { rs.getId(),
									rs.getLatitude(), rs.getLongtitude(),
									rs.getSpeed(),
									dateFormat.format(rs.getDate()) });

						}

					}
				}
				listOfResult.clear();

			}
		});

		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(
				"Bus Manager") {
			/**
					 * 
					 */

			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("View bus");
				node_1.add(new DefaultMutableTreeNode(""));
				super.add(node_1);

				// node_1 = new DefaultMutableTreeNode("View station + bus");
				// node_1.add(new DefaultMutableTreeNode(""));
				// super.add(node_1);
			}
		}));
		scrollPaneTree.setViewportView(tree);

		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(10, 47, 415, 408);
		panelReadFile.add(panel_6);
		panel_6.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 8, 395, 87);
		panel_6.add(panel_2);
		panel_2.setBorder(new LineBorder(Color.WHITE, 3, true));
		panel_2.setLayout(null);

		lblInputFile = new JLabel("Name:");
		lblInputFile.setBounds(10, 40, 55, 15);
		panel_2.add(lblInputFile);
		lblInputFile.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txt1 = new JTextField();
		txt1.setBackground(new Color(152, 251, 152));
		txt1.setBounds(62, 36, 209, 29);
		panel_2.add(txt1);
		txt1.setColumns(10);

		btnReadFile = new JButton("Open");
		btnReadFile.setBounds(281, 36, 92, 30);
		Image imgReadFile = new ImageIcon(this.getClass().getResource(
				"/openfile.png")).getImage();
		btnReadFile.setIcon(new ImageIcon(imgReadFile));

		panel_2.add(btnReadFile);

		JLabel lblInputData = new JLabel("Progress:");
		lblInputData.setBounds(10, 11, 85, 14);
		panel_2.add(lblInputData);
		lblInputData.setFont(new Font("Tahoma", Font.PLAIN, 10));

		final JProgressBar progressBar = new JProgressBar(0, 100);
		progressBar.setBounds(62, 13, 209, 14);
		panel_2.add(progressBar);
		progressBar.setStringPainted(true);

		lbl1 = new JLabel("New label");
		lbl1.setBounds(281, 11, 99, 16);
		panel_2.add(lbl1);
		lbl1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl1.hide();

		panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.controlHighlight);
		panel_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_8.setBounds(10, 106, 395, 280);
		panel_6.add(panel_8);
		panel_8.setLayout(null);

		tabbedReadFile = new JTabbedPane(JTabbedPane.TOP);
		tabbedReadFile.setBackground(Color.LIGHT_GRAY);
		tabbedReadFile.setBounds(0, 0, 395, 280);
		panel_8.add(tabbedReadFile);

		JPanel panelGuild = new JPanel();
		panelGuild.setBackground(SystemColor.activeCaption);
		tabbedReadFile.addTab("How to use", null, panelGuild, null);
		panelGuild.setLayout(null);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 11, 370, 230);

		panelGuild.add(scroll);

		JTextArea txtrNoNo = new JTextArea();
		txtrNoNo.setWrapStyleWord(true);
		txtrNoNo.setLineWrap(true);
		scroll.setViewportView(txtrNoNo);
		txtrNoNo.setEditable(false);
		txtrNoNo.setText("To use this applition, first:\r\n- Open a file or multifile by using OPEN button. a SUCCESS message will show if open file suceess. After, 2 tab will enable for you use.\r\n-Tab \"view file id bus\", help you calculate speed  with every bus id and export them to computer.\r\n-View buses have station direction tab,you need choose a file station and it'll help you find  buses which run to this station and export data to a folder contains file .csv.(Because we have many bus run to station, so we will choose a folder and save files to it)\r\n-To view data to table on appication, select a id bus in tree, and view this.  ");

		panelViewId = new JPanel();

		panelViewId
				.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		panelViewId.setBackground(SystemColor.activeCaption);
		tabbedReadFile.addTab("View bus", null, panelViewId, null);
		panelViewId.setLayout(null);

		panelComboId = new JPanel();
		panelComboId.setBackground(Color.WHITE);
		panelComboId.setBounds(10, 11, 370, 230);
		panelComboId.hide();
		panelViewId.add(panelComboId);

		panelComboId.setLayout(null);

		lblChooseId = new JLabel("Bus id:");
		lblChooseId.setBounds(10, 47, 66, 14);
		panelComboId.add(lblChooseId);

		panelComboId.add(comboBox);

		final JButton btnWriteFileTo = new JButton("Export file");
		Image saveIcon = new ImageIcon(this.getClass().getResource(
				"/save-icon.png")).getImage();
		btnWriteFileTo.setIcon(new ImageIcon(saveIcon));
		btnWriteFileTo.setBounds(124, 86, 130, 26);
		panelComboId.add(btnWriteFileTo);

		JLabel lblNewLabel_5 = new JLabel(
				" Click image button beside this panel to view on table!");
		lblNewLabel_5.setFont(new Font("Yu Mincho Demibold", Font.ITALIC, 12));
		lblNewLabel_5.setBounds(10, 151, 339, 14);
		panelComboId.add(lblNewLabel_5);
		btnWriteFileTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Get item was choosen in Combobox
				int index = (Integer) comboBox.getSelectedItem();

				// Find speed bus with id and add into list
				listOfResult = mnBus.findSpeedBus(index);

				// Config a form chooser
				fileChooser1 = new JFileChooser();

				// Remember Director when click button again
				if (director != null) {
					fileChooser1.setCurrentDirectory(new File(director));
				}

				fileChooser1.setDialogTitle("Save file to my computer");

				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						".csv", "csv");
				fileChooser1.setFileFilter(filter);

				int userSelection = fileChooser1.showSaveDialog(btnWriteFileTo);
				// If Open was clicked
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					// Get path of file
					fileToSave1 = fileChooser1.getSelectedFile();
					if (!fileChooser1.getSelectedFile().getAbsolutePath()
							.endsWith(".csv")) {
						fileToSave1 = new File(fileChooser1.getSelectedFile()
								+ ".csv");
					}
					director = fileToSave1.getAbsolutePath();

					// Write file
					mnf.writeCsvFile(listOfResult,
							fileToSave1.getAbsolutePath());
					System.out.println("Before clear: " + listOfResult.size());
					listOfResult.clear();
					comboBox.setSelectedIndex(-1);
					System.out.println("After clear: " + listOfResult.size());
					// Test
				}
			}
		});

		panelViewStation = new JPanel();
		panelViewStation.setBackground(SystemColor.activeCaption);
		panelViewStation.setBorder(new LineBorder(new Color(255, 255, 255), 0,
				true));
		tabbedReadFile.addTab("Extract data bus station", null,
				panelViewStation, null);
		panelViewStation.setLayout(null);

		// Station

		panelStation = new JPanel();
		panelStation.setBounds(10, 11, 370, 230);
		panelViewStation.add(panelStation);
		panelStation.setLayout(null);
		panelStation.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(
				192, 192, 192), new Color(192, 192, 192), new Color(192, 192,
				192), new Color(192, 192, 192)));
		panelStation.setBorder(BorderFactory
				.createTitledBorder("Input station and save file"));

		btnStationBus = new JButton("Export file");
		btnStationBus.setBounds(112, 85, 137, 26);
		btnStationBus.setIcon(new ImageIcon(saveIcon));
		panelStation.add(btnStationBus);

		JLabel lblNewLabel_1 = new JLabel("Your station:");
		lblNewLabel_1.setBounds(10, 57, 97, 14);
		panelStation.add(lblNewLabel_1);

		textStation = new JTextField();
		textStation.setBounds(83, 54, 277, 20);
		panelStation.add(textStation);
		textStation.setColumns(10);

		JLabel lblType = new JLabel("Find by:");
		lblType.setBounds(163, 29, 74, 14);
		panelStation.add(lblType);

		cbType = new JComboBox();
		cbType.setBounds(223, 26, 137, 20);
		panelStation.add(cbType);

		lblFinish = new JLabel("New label");
		lblFinish.setBounds(134, 136, 164, 20);
		panelStation.add(lblFinish);
		lblFinish.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblFinish.hide();

		btnStationBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Choose a file bus station");
				// Create a chooser form
				JFileChooser jfile = new JFileChooser();

				// We can choose multiple file
				jfile.setMultiSelectionEnabled(true);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						".csv", "csv");
				jfile.setFileFilter(filter);
				int result = jfile.showOpenDialog(null);
				int lengthOfStation = 0;

				// If Open button was clicked
				if (result == JFileChooser.APPROVE_OPTION) {
					// Save file
					File[] files = jfile.getSelectedFiles();
					mnf.readFile(files, "station");
				}

				// Get list station include: id, latitude and longtitude
				listOfStation = mnf.getMnStation().getListOfStation();
				lengthOfStation = listOfStation.size();
				// Each line in station.csv , we will write a file
				for (BusStation station : listOfStation) {
					// Show message after read success
					JOptionPane
							.showMessageDialog(
									new JFrame(),
									"Begin write result of station "
											+ station.getNameStation()
											+ ". Create new a folder or choose a folder to save it. Remaining stations: "
											+ lengthOfStation);
					lblFinish.hide();
					lblFinish.setText(" ");

					// Begin write result file
					ManageFile mnFileBus = new ManageFile();
					List<Result> listOfResult = null;

					// Calculate speed follow distance/time
					String type = (String) cbType.getSelectedItem();

					// Open a new File Chooser
					JFileChooser fileChooser = new JFileChooser();
					// Remember Director when click button again
					if (director != null) {
						fileChooser.setCurrentDirectory(new File(director));
					}
					// Title of dialog
					fileChooser.setDialogTitle("Save result as folder: "
							+ "latitude: [" + station.getLatitude() + "]"
							+ " longtitude: [" + station.getLongtitude() + "]");

					// Only choose Folder
					fileChooser
							.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					// No choose file
					fileChooser.setAcceptAllFileFilterUsed(false);

					int userSelection = fileChooser
							.showSaveDialog(btnStationBus);
					int count = 0;
					if (userSelection == JFileChooser.APPROVE_OPTION) {
						for (Bus b : idBus) {
							// Get id bus to calculate
							int index = b.getId();

							// Calculate speed with id
							listOfResult = mnBus.findSpeedBus(index);

							ManagerTravelBusStation busStation = new ManagerTravelBusStation();

							// Declare a BusStation object
							BusStation stt = new BusStation(station.getId(),
									station.getLatitude(), station
											.getLongtitude(), station
											.getNameStation());
							// Find bus have latitude and longtitude near with
							// station
							busStation.findBusTravel(listOfResult, stt, type);
							Collections.sort(busStation.getListOfTravel(),
									new Comparator<Result>() {
										public int compare(Result o1, Result o2) {
											return o1.getDate().compareTo(
													o2.getDate());
										}
									});

							// Check exist of list
							if (busStation.getListOfTravel().size() > 0) {
								// If count increase, we will have file output
								count++;
								File fileToSave = new File(fileChooser
										.getSelectedFile()
										+ "\\"
										+ Integer.toString(b.getId()) + ".csv");
								File fileToReturn = fileChooser
										.getCurrentDirectory();
								director = fileToReturn.getAbsolutePath();
								System.out.println(director);
								directorStation = fileToSave.getAbsolutePath();
								// busStation.refreshSpeedBus();
								if (true == checkOverSpeed(busStation
										.getListOfTravel())) {
									System.out.println("kaka");
								} else {
									mnFileBus.writeCsvFile(
											busStation.getListOfTravel(),
											fileToSave.getAbsolutePath());
								}

								// System.out.println(listOfResult);
								lblFinish.show();
								lblFinish.setText("Write file finished");

							}
							// System.out.println("Result size: "
							// + listOfResult);
							listOfResult.clear();
						}
						if (count <= 0) {
							// No file is written
							JOptionPane.showMessageDialog(
									new JFrame(),
									station.getNameStation()
											+ " don't have bus which go over it");
							lblFinish.show();
							lblFinish.setText("Don't have result");
						}
					}
					lengthOfStation--;
				}
				JOptionPane.showMessageDialog(new JFrame(), "Ending");

			}

			private boolean checkOverSpeed(List<Result> listOfTravel) {
				for (Result result : listOfTravel) {
					if (result.getSpeed() > 50) {
						return true;
					}
				}
				return false;
			}

		});

		tabbedReadFile.setEnabledAt(1, false);
		tabbedReadFile.setEnabledAt(2, false);

		btnAddData = new JButton("");

		// Add data to tree
		btnAddData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) model
						.getRoot();
				DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) model
						.getChild(selectedNode, 0);
				for (int i = 0; i < idBus.size(); i++) {
					DefaultMutableTreeNode newId = new DefaultMutableTreeNode(
							idBus.get(i).getId());
					model.insertNodeInto(newId, childNode,
							childNode.getChildCount());

				}
				if (childNode.getChildCount() > 1) {
					JOptionPane.showMessageDialog(new JFrame(),
							"Add data success, open view bus folder to view!");
					btnAddData.setEnabled(false);
				}

			}
		});
		btnAddData.setBounds(435, 195, 97, 101);
		Image addData = new ImageIcon(this.getClass().getResource(
				"/add-data.png")).getImage();
		btnAddData.setIcon(new ImageIcon(addData));
		btnAddData.setEnabled(false);
		panelReadFile.add(btnAddData);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(736, 53, 594, 402);
		panelReadFile.add(scrollPane_2);

		table_1 = new JTable();
		table_1.setCellSelectionEnabled(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"ID", "Latitude", "Longtitude", "Speed(Km/h)", "Time" }));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(45);
		table_1.getColumnModel().getColumn(0).setMinWidth(5);

		scrollPane_2.setViewportView(table_1);

		panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "MAIN", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panel_9.setBounds(0, 24, 1347, 461);
		panelReadFile.add(panel_9);

		JPanel panelChartMap = new JPanel();
		panelChartMap.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Chart & Map",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelChartMap.setBounds(10, 485, 1320, 134);
		panelReadFile.add(panelChartMap);

		toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setBounds(0, 0, 1362, 22);
		toolBar.setMargin(new Insets(0, 0, 0, 10));

		frmBusApplication.getContentPane().add(toolBar);

		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton
				.setIcon(new ImageIcon(
						MainGui.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")));

		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		toolBar.add(btnNewButton);

		JButton btnPreMenu = new JButton();
		btnPreMenu.setToolTipText("Previous tab");
		Image imagePreMenu = new ImageIcon(this.getClass().getResource(
				"/previous-menu.png")).getImage();
		btnPreMenu.setIcon(new ImageIcon(imagePreMenu));
		toolBar.add(btnPreMenu);

		JButton btnNextMenu = new JButton();
		btnNextMenu.setToolTipText("Next tab");
		Image imageNextMenu = new ImageIcon(this.getClass().getResource(
				"/next-menu.png")).getImage();
		btnNextMenu.setIcon(new ImageIcon(imageNextMenu));
		toolBar.add(btnNextMenu);

		btnReadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				removeNodeTree();
				// Avoid douple id if choose file again
				progressBar.setValue(0);
				lblFinish.hide();
				comboBox.removeAllItems();
				txt1.setText("");

				// Create a chooser form
				JFileChooser jfile = new JFileChooser();
				jfile.setDialogTitle("Choose File");
				jfile.setMultiSelectionEnabled(true);
				jfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						".csv", "csv");
				jfile.setFileFilter(filter);
				int result = jfile.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					String temp = "";
					btnAddData.setEnabled(true);
					progressBar.setValue(50);
					File[] files = jfile.getSelectedFiles();
					for (int i = 0; i < files.length; i++) {
						if (i == files.length - 1) {
							temp += files[i].getAbsoluteFile().getName();
						} else {
							temp += files[i].getAbsoluteFile().getName() + ", ";
						}
					}
					txt1.setText(temp);

					boolean checkReadFile = mnf.readFile(files, "bus");
					if (checkReadFile == false) {
						lbl1.setText("Failed");
						progressBar.setValue(0);
						lblFinish.hide();
						comboBox.removeAllItems();
						tabbedReadFile.setEnabledAt(1, false);
						tabbedReadFile.setEnabledAt(2, false);
						tabbedReadFile.setSelectedIndex(0);
						btnAddData.setEnabled(false);

					} else {
						lbl1.setText("Success");
						lbl1.show();
						mnBus = new ManagerBus(mnf.getMnBus());

						idBus = mnBus.findIdBus(); // Get id of all bus
						progressBar.setValue(50);
						cbType.addItem("Time");
						cbType.addItem("Distance");
						// From id which we find, show it to comboBox
						for (Bus bus : idBus) {
							comboBox.addItem(bus.getId());
						}

						progressBar.setValue(100);
						progressBar.setString("Finish");
						tabbedReadFile.setEnabledAt(1, true);
						tabbedReadFile.setEnabledAt(2, true);

						panelComboId.show();
					}

				} else {
					System.out.println("File not found");
				}

			}

			private void removeNodeTree() {
				if (!btnAddData.isEnabled()) {
					DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
					DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) model
							.getRoot();
					DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) model
							.getChild(selectedNode, 0);

					childNode.removeAllChildren();
					childNode.add(new DefaultMutableTreeNode(null));
					model.reload();
				}

			}
		});

		menuBar = new JMenuBar();

		menuBar.setSize(new Dimension(200, 200));
		frmBusApplication.setJMenuBar(menuBar);

		mnNewMenu = new JMenu("");
		mnNewMenu
				.setIcon(new ImageIcon(
						MainGui.class
								.getResource("/com/sun/java/swing/plaf/windows/icons/TreeLeaf.gif")));

		menuBar.add(mnNewMenu);

		mnFile = new JMenu("File");
		mnFile.setForeground(Color.WHITE);

		mnFile.setBackground(Color.WHITE);
		mnFile.setBorder(BorderFactory.createCompoundBorder(mnFile.getBorder(),
				BorderFactory.createEmptyBorder(0, 0, 0, 10)));
		mnFile.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnFile);

		mnOpenFile = new JMenu("Open file");
		mnOpenFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblFinish.hide();
				comboBox.removeAllItems();

				// Create a chooser form
				JFileChooser jfile = new JFileChooser();
				jfile.setDialogTitle("Choose File");
				jfile.setMultiSelectionEnabled(true);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						".csv", "csv");
				jfile.setFileFilter(filter);
				int result = jfile.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File[] files = jfile.getSelectedFiles();
					// txt1.setText(file);
					boolean checkReadFile = mnf.readFile(files, "bus");
					System.out.println(checkReadFile);
					if (checkReadFile == false) {
						lbl1.setText("Failed");
						lblFinish.hide();
						comboBox.removeAllItems();
					}
					mnBus = new ManagerBus(mnf.getMnBus());
					lbl1.setText("Success");
					lbl1.show();

					idBus = mnBus.findIdBus(); // Get id of all bus
					cbType.addItem("Time");
					cbType.addItem("Distance");
					// From id which we find, show it to comboBox
					for (Bus bus : idBus) {
						comboBox.addItem(bus.getId());
					}
				} else {
					System.out.println("File not found");
				}

			}
		});
		mnOpenFile.setSelectedIcon(null);
		mnFile.add(mnOpenFile);
		Image img = new ImageIcon(this.getClass().getResource("/openfile.png"))
				.getImage();
		mnOpenFile.setIcon(new ImageIcon(img));
		mnHelp = new JMenu("Help");
		mnHelp.setForeground(Color.WHITE);
		mnHelp.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnHelp);

		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbViewMapBus.removeAllItems();
				String[] name = dtChart.getNameChart();
				typeChart = cbChangeChart.getSelectedItem().toString();

				dataset1 = new XYSeriesCollection();
				for (int i = 0; i < name.length; i++) {
					dataset1.addSeries(createDataset(name[i]));
				}

				JFreeChart chart = createChartDistance(dataset1, typeChart);

				if (countChart == 0) {

					chartPanel = new ChartPanel(chart);
					chartPanel.setPreferredSize(new Dimension(647, 395));
					panelContentChart.add(chartPanel, BorderLayout.CENTER);
				} else {
					datasetIndex = 0;
					panelContentChart.removeAll();
					panelContentChart.revalidate();
					panelCheck.removeAll();
					chartPanel = new ChartPanel(chart);
					plot = chart.getXYPlot();
					cbChart.clear();

					chartPanel.setPreferredSize(new Dimension(650, 360));
					panelContentChart.add(chartPanel, BorderLayout.CENTER);
					panelContentChart.repaint();
				}

				createCheckBox(name);
				createViewMapBus(name);

				countChart++;
				JOptionPane.showMessageDialog(new JFrame(),
						"Your chart is showed on tab Evaluate data");
				tabbedPane.setSelectedIndex(2);
			}

			private void createViewMapBus(String[] name) {
				Map<Point, Result> mapOfChart = new HashMap<Point, Result>(
						dtChart.getMapOfChart());
				for (int i = 0; i < name.length; i++) {
					cbViewMapBus.addItem(name[i]);
				}

			}

			private JFreeChart createChartDistance(XYDataset dataset,
					String typeChart) {
				String typeShow = typeChart;
				if (typeChart.equals("Time")) {
					typeShow = "Time(Seconds)";
				}
				final JFreeChart chart = ChartFactory.createXYLineChart(
						"Bus chart", // chart title
						typeShow, // domain axis label
						"Speed", // range axis label
						dataset, // data
						PlotOrientation.VERTICAL, // orientation
						true, // include legend
						true, // tooltips
						false // urls
						);
				// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
				chart.setBackgroundPaint(Color.white);

				// final StandardLegend legend = (StandardLegend)
				// chart.getLegend();
				// legend.setDisplaySeriesShapes(true);

				// get a reference to the plot for further customisation...
				plot = chart.getXYPlot();

				plot.setBackgroundPaint(Color.lightGray);
				// plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0,
				// 5.0));
				plot.setDomainGridlinePaint(Color.white);

				plot.setRangeGridlinePaint(Color.white);

				// change the auto tick unit selection to integer units only...
				final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
				rangeAxis.setStandardTickUnits(NumberAxis
						.createIntegerTickUnits());

				final ValueAxis axis = plot.getDomainAxis();
				axis.setAutoRange(true);
				if (typeChart.equals("Time")) {
					axis.setRangeWithMargins(-350, 350);
				} else {
					axis.setRangeWithMargins(-500, 500);
				}

				// OPTIONAL CUSTOMISATION COMPLETED.
				XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
				renderer.setSeriesLinesVisible(0, true);

				plot.setRenderer(renderer);

				return chart;

			}

			private XYSeries createDataset(String id) {
				String[] name = dtChart.getNameChart();
				Map<Point, Result> mapOfChart = new HashMap<Point, Result>(
						dtChart.getMapOfChart());
				int positionBus = 0;

				positionBus = findPositionBus(name, id);

				int mapId = Integer.parseInt(id);

				XYSeries seri = new XYSeries(name[positionBus]);

				for (int i = 0; i < name.length; i++) {
					for (int j = 0; j < mapOfChart.size(); j++) {
						if (mapOfChart.get(new Point(i, j)) != null
								&& mapId == (mapOfChart.get(new Point(i, j))
										.getId())) {
							seri.add(mapOfChart.get(new Point(i, j))
									.getDistance(),
									mapOfChart.get(new Point(i, j)).getSpeed());

						} else {
							break;
						}
					}

				}

				return seri;
			}

			// Find position which id bus have in array
			private int findPositionBus(String[] name, String id) {
				int positionBus = 0;
				for (int i = 0; i < name.length; i++) {
					if (id.equals(name[i])) {
						positionBus = i;
					}
				}
				return positionBus;
			}

			private void createCheckBox(final String[] name) {
				final ItemListener checkBoxListener = new ItemListener() {

					public void itemStateChanged(ItemEvent e) {
						int number = 0;

						if (e.getStateChange() == 2) {
							removePlotChart(
									((JCheckBox) e.getItem()).getText(),
									dataset1);
						} else {
							addPlotChart(((JCheckBox) e.getItem()).getText(),
									dataset1);
						}
						//
					}

				};

				final ItemListener checkAllListener = new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if (cbChart.get(0).isSelected()) {
							for (int i = 0; i < cbChart.size(); i++) {
								if (!cbChart.get(i).isSelected()) {

									cbChart.get(i).setSelected(true);
									// addPlotChart(cbChart.get(i).getName(),
									// dataset1);
								}
							}
						} else if (!cbChart.get(0).isSelected()) {
							for (int i = 0; i < cbChart.size(); i++) {
								if (cbChart.get(i).isSelected()) {
									cbChart.get(i).setSelected(false);
									// removePlotChart(cbChart.get(i).getName(),
									// dataset1);
								}
							}
						}
					}

				};

				for (int i = 0; i < name.length + 1; i++) {
					JCheckBox cb;
					if (i == 0) {
						cb = new JCheckBox("All");
						cb.setSelected(true);
						cb.addItemListener(checkAllListener);
					} else {
						cb = new JCheckBox(name[i - 1]);
						cb.setSelected(true);
						cb.addItemListener(checkBoxListener);
					}

					cbChart.add(cb);
					panelCheck.add(cb);
				}

			}

			private void removePlotChart(String string,
					XYSeriesCollection dataset1) {
				for (int i = 0; i < dataset1.getSeriesCount(); i++) {

					if (string.equals(dataset1.getSeriesKey(i))) {
						dataset1.removeSeries(dataset1.getSeries(i));
					}
				}

			}

			private void addPlotChart(String string, XYSeriesCollection dataset1) {
				dataset1.addSeries(createDataset(string));
			}

			// private JFreeChart createChart(XYDataset dataset) {
			// // create the chart...
			// final JFreeChart chart = ChartFactory.createTimeSeriesChart(
			// "Time Series Bus", "Minute", "Speed", dataset);
			//
			// // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
			// chart.setBackgroundPaint(Color.white);
			//
			// // final StandardLegend legend = (StandardLegend)
			// // chart.getLegend();
			// // legend.setDisplaySeriesShapes(true);
			//
			// // get a reference to the plot for further customisation...
			// plot = chart.getXYPlot();
			// plot.setBackgroundPaint(Color.lightGray);
			// // plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0,
			// // 5.0));
			// plot.setDomainGridlinePaint(Color.white);
			// plot.setRangeGridlinePaint(Color.white);
			//
			// final ValueAxis axis = plot.getDomainAxis();
			// axis.setAutoRange(true);
			// axis.setTickLabelsVisible(false);
			//
			// final NumberAxis rangeAxis2 = new NumberAxis("Range Axis 2");
			// rangeAxis2.setAutoRangeIncludesZero(false);
			//
			// return chart;
			//
			// }

		});

	}
}
