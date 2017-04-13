import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.*;

public class CriminalDatabase extends JFrame {

	private JPanel contentPane;
	private JTable jTable;

	/**
	 * List of all available Queries
	 */
	private String[] QueryList = {
		"<NONE>",
		"01. All criminals with <NAME> and age UNDER <AGE>",
		"02. All crimes that happened in city <CITY_NAME>",
		"03. All crimes that happened between <START_TIME> and <END_TIME>",
		"04. All arrested criminals that have been given the death penalty",
		"05. All criminals that were arrested in city <CITY_NAME>",
		"06. All jails with <MORE/LESS> than <N> number of criminals",
		"07. All female victims under the age of <AGE>",
		"08. All criminals that haven't been arrested",
		"09. Number of arrested criminals in each city",
		"10. Average age of criminals committing a particular <CRIME_TYPE>",
		"11. City with most number of free criminals",
		"12. Criminal who committed crime in most number of cities",
		"13. Criminal with most number of crimes without getting arrested",
		"14. Average age of victims for a particular <CRIME_TYPE>"
	};
	private JTextField NameTextField;
	private JTextField CityNameTextField;
	private JTextField StartTimeTextField;
	private JTextField AgeTextField;
	private JTextField CrimeTypeTextField;
	private JTextField UnderAgeTextField;
	private JTextField EndTImeTextField;
	private JTextField NumCriminalTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriminalDatabase frame = new CriminalDatabase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CriminalDatabase() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 670);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel IntroPanel = new JPanel();
		IntroPanel.setBackground(Color.DARK_GRAY);
		contentPane.add(IntroPanel, "IntroPanel");
		IntroPanel.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel InvPanel1 = new JPanel();
		InvPanel1.setBackground(Color.DARK_GRAY);
		IntroPanel.add(InvPanel1);
		
		JPanel HeadingPanel = new JPanel();
		HeadingPanel.setBackground(Color.DARK_GRAY);
		IntroPanel.add(HeadingPanel);
		
		JLabel HeadingLabel = new JLabel("Criminal Database");
		HeadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		HeadingLabel.setPreferredSize(new Dimension(600, 100));
		HeadingLabel.setFont(new Font("Cantarell", Font.BOLD, 44));
		HeadingLabel.setForeground(Color.WHITE);
		HeadingPanel.add(HeadingLabel);
		
		JPanel InvPanel2 = new JPanel();
		InvPanel2.setBackground(Color.DARK_GRAY);
		IntroPanel.add(InvPanel2);
		
		JPanel StartButtonPanel = new JPanel();
		StartButtonPanel.setForeground(Color.WHITE);
		StartButtonPanel.setBackground(Color.DARK_GRAY);
		IntroPanel.add(StartButtonPanel);
		
		
		JPanel InvPanel3 = new JPanel();
		InvPanel3.setBackground(Color.DARK_GRAY);
		IntroPanel.add(InvPanel3);
		
		JPanel QueryPanel = new JPanel();
		QueryPanel.setBackground(Color.DARK_GRAY);
		contentPane.add(QueryPanel, "QueryPanel");
		QueryPanel.setLayout(new BoxLayout(QueryPanel, BoxLayout.Y_AXIS));
		
		JPanel QueryDropDownPanel = new JPanel();
		QueryDropDownPanel.setBackground(Color.DARK_GRAY);
		QueryPanel.add(QueryDropDownPanel);
		QueryDropDownPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel ContainerPanel1 = new JPanel();
		ContainerPanel1.setAlignmentX(Component.LEFT_ALIGNMENT);
		ContainerPanel1.setBackground(Color.DARK_GRAY);
		QueryDropDownPanel.add(ContainerPanel1);
		
		JPanel QuerySelectPanel = new JPanel();
		ContainerPanel1.add(QuerySelectPanel);
		QuerySelectPanel.setBackground(Color.DARK_GRAY);
		QuerySelectPanel.setPreferredSize(new Dimension(150, 100));
		QuerySelectPanel.setLayout(new BoxLayout(QuerySelectPanel, BoxLayout.X_AXIS));
		
		JLabel SelectQueryLabel = new JLabel("Select Query : ");
		SelectQueryLabel.setForeground(Color.WHITE);
		SelectQueryLabel.setPreferredSize(new Dimension(200, 100));
		SelectQueryLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		QuerySelectPanel.add(SelectQueryLabel);
		SelectQueryLabel.setBackground(Color.DARK_GRAY);
		SelectQueryLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		SelectQueryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel QueryListCBPanel = new JPanel();
		ContainerPanel1.add(QueryListCBPanel);
		QueryListCBPanel.setBackground(Color.DARK_GRAY);
		QueryListCBPanel.setPreferredSize(new Dimension(700, 100));
		QueryListCBPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel InvPanel1_1 = new JPanel();
		InvPanel1_1.setBackground(Color.DARK_GRAY);
		QueryListCBPanel.add(InvPanel1_1);
		
		JPanel QuerySelectionOutputPanel = new JPanel();
		QuerySelectionOutputPanel.setBackground(Color.DARK_GRAY);
		QueryDropDownPanel.add(QuerySelectionOutputPanel);
		QuerySelectionOutputPanel.setLayout(new GridLayout(4, 1, 0, 2));
		QuerySelectionOutputPanel.setVisible(false);
		
		JPanel ErrorQueryNumberPanel = new JPanel();
		ErrorQueryNumberPanel.setBackground(Color.DARK_GRAY);
		QuerySelectionOutputPanel.add(ErrorQueryNumberPanel);
		ErrorQueryNumberPanel.setLayout(new CardLayout(0, 0));
		
		JPanel ErrorPanel = new JPanel();
		ErrorPanel.setForeground(Color.WHITE);
		ErrorPanel.setBackground(new Color(165, 42, 42));
		ErrorQueryNumberPanel.add(ErrorPanel, "ErrorPanel");
		ErrorPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel ErrorLabel = new JLabel("Error: You might want to select a query mate");
		ErrorLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		ErrorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		ErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorLabel.setForeground(Color.WHITE);
		ErrorPanel.add(ErrorLabel);
		
		JPanel QueryNumberPanel = new JPanel();
		QueryNumberPanel.setBackground(Color.DARK_GRAY);
		ErrorQueryNumberPanel.add(QueryNumberPanel, "QueryNumberPanel");
		
		JLabel QueryNumberLabel = new JLabel("Query number : <INDEX>");
		QueryNumberLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		QueryNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		QueryNumberLabel.setForeground(Color.WHITE);
		QueryNumberLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		QueryNumberPanel.add(QueryNumberLabel);
		
		JPanel OpenErrorPanel = new JPanel();
		OpenErrorPanel.setBackground(new Color(165, 42, 42));
		ErrorQueryNumberPanel.add(OpenErrorPanel, "OpenErrorPanel");
		
		JLabel OpenErrorLabel = new JLabel("<OPEN ERROR>");
		OpenErrorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		OpenErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		OpenErrorLabel.setForeground(Color.WHITE);
		OpenErrorLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		OpenErrorPanel.add(OpenErrorLabel);
		
		JPanel InvPanel1_2 = new JPanel();
		InvPanel1_2.setBackground(Color.DARK_GRAY);
		QuerySelectionOutputPanel.add(InvPanel1_2);
		
		JPanel FormEntry1Panel = new JPanel();
		FormEntry1Panel.setBackground(Color.DARK_GRAY);
		QuerySelectionOutputPanel.add(FormEntry1Panel);
		FormEntry1Panel.setLayout(new CardLayout(0, 0));
		
		JPanel FormEntry2Panel = new JPanel();
		FormEntry2Panel.setBackground(Color.DARK_GRAY);
		QuerySelectionOutputPanel.add(FormEntry2Panel);
		FormEntry2Panel.setLayout(new CardLayout(0, 0));
		
		JPanel SubmitPanel = new JPanel();
		QueryPanel.add(SubmitPanel);
		SubmitPanel.setForeground(Color.WHITE);
		SubmitPanel.setBackground(Color.DARK_GRAY);
		SubmitPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
		
		JPanel NamePanel = new JPanel();
		NamePanel.setBackground(Color.DARK_GRAY);
		FormEntry1Panel.add(NamePanel, "NamePanel");
		NamePanel.setLayout(new BoxLayout(NamePanel, BoxLayout.X_AXIS));
		
		JLabel NameLabel = new JLabel("Enter name: ");
		NameLabel.setForeground(Color.WHITE);
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		NamePanel.add(NameLabel);
		
		NameTextField = new JTextField();
		NameTextField.setMinimumSize(new Dimension(700, 100));
		NameTextField.setBackground(Color.DARK_GRAY);
		NameTextField.setForeground(Color.WHITE);
		NamePanel.add(NameTextField);
		NameTextField.setColumns(10);
		
		JPanel CityNamePanel = new JPanel();
		CityNamePanel.setBackground(Color.DARK_GRAY);
		FormEntry1Panel.add(CityNamePanel, "CityNamePanel");
		CityNamePanel.setLayout(new BoxLayout(CityNamePanel, BoxLayout.X_AXIS));
		
		JLabel CityNameLabel = new JLabel("Enter city name: ");
		CityNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CityNameLabel.setForeground(Color.WHITE);
		CityNameLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		CityNamePanel.add(CityNameLabel);
		
		CityNameTextField = new JTextField();
		CityNameTextField.setMinimumSize(new Dimension(700, 100));
		CityNameTextField.setForeground(Color.WHITE);
		CityNameTextField.setColumns(10);
		CityNameTextField.setBackground(Color.DARK_GRAY);
		CityNamePanel.add(CityNameTextField);
		
		JPanel StartTimePanel = new JPanel();
		StartTimePanel.setBackground(Color.DARK_GRAY);
		FormEntry1Panel.add(StartTimePanel, "StartTimePanel");
		StartTimePanel.setLayout(new BoxLayout(StartTimePanel, BoxLayout.X_AXIS));
		
		JLabel StartTimeLabel = new JLabel("Enter start time : ");
		StartTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StartTimeLabel.setForeground(Color.WHITE);
		StartTimeLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		StartTimePanel.add(StartTimeLabel);
		
		StartTimeTextField = new JTextField();
		StartTimeTextField.setMinimumSize(new Dimension(700, 100));
		StartTimeTextField.setForeground(Color.WHITE);
		StartTimeTextField.setColumns(10);
		StartTimeTextField.setBackground(Color.DARK_GRAY);
		StartTimePanel.add(StartTimeTextField);
		
		JPanel MoreLessPanel = new JPanel();
		MoreLessPanel.setBackground(Color.DARK_GRAY);
		FormEntry1Panel.add(MoreLessPanel, "MoreLessPanel");
		MoreLessPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel MoreLessLabel = new JLabel("Select More/Less : ");
		MoreLessLabel.setForeground(Color.WHITE);
		MoreLessLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		MoreLessPanel.add(MoreLessLabel);
		
		JRadioButton MoreRadioButton = new JRadioButton("MORE");
		MoreRadioButton.setBackground(Color.DARK_GRAY);
		MoreRadioButton.setForeground(Color.WHITE);
		MoreRadioButton.setFont(new Font("Cantarell", Font.BOLD, 20));
		MoreLessPanel.add(MoreRadioButton);
		
		JRadioButton LessRadioButton = new JRadioButton("LESS");
		LessRadioButton.setForeground(Color.WHITE);
		LessRadioButton.setFont(new Font("Cantarell", Font.BOLD, 20));
		LessRadioButton.setBackground(Color.DARK_GRAY);
		MoreLessPanel.add(LessRadioButton);
		
		JPanel AgePanel = new JPanel();
		AgePanel.setBackground(Color.DARK_GRAY);
		FormEntry1Panel.add(AgePanel, "AgePanel");
		AgePanel.setLayout(new BoxLayout(AgePanel, BoxLayout.X_AXIS));
		
		JLabel AgeLabel = new JLabel("Enter age : ");
		AgePanel.add(AgeLabel);
		AgeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AgeLabel.setForeground(Color.WHITE);
		AgeLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		
		AgeTextField = new JTextField();
		AgeTextField.setMinimumSize(new Dimension(700, 100));
		AgeTextField.setForeground(Color.WHITE);
		AgeTextField.setColumns(10);
		AgeTextField.setBackground(Color.DARK_GRAY);
		AgePanel.add(AgeTextField);
		
		JPanel CrimeTypePanel = new JPanel();
		CrimeTypePanel.setBackground(Color.DARK_GRAY);
		FormEntry1Panel.add(CrimeTypePanel, "CrimeTypePanel");
		CrimeTypePanel.setLayout(new BoxLayout(CrimeTypePanel, BoxLayout.X_AXIS));
		
		JLabel CrimTypeLabel = new JLabel("Enter crime type : ");
		CrimTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CrimTypeLabel.setForeground(Color.WHITE);
		CrimTypeLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		CrimeTypePanel.add(CrimTypeLabel);
		
		CrimeTypeTextField = new JTextField();
		CrimeTypeTextField.setMinimumSize(new Dimension(700, 100));
		CrimeTypeTextField.setForeground(Color.WHITE);
		CrimeTypeTextField.setColumns(10);
		CrimeTypeTextField.setBackground(Color.DARK_GRAY);
		CrimeTypePanel.add(CrimeTypeTextField);
		
		JPanel UnderAgePanel = new JPanel();
		UnderAgePanel.setBackground(Color.DARK_GRAY);
		FormEntry2Panel.add(UnderAgePanel, "UnderAgePanel");
		UnderAgePanel.setLayout(new BoxLayout(UnderAgePanel, BoxLayout.X_AXIS));
		
		JLabel UnderAgeLabel = new JLabel("Enter age upper bound :");
		UnderAgeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UnderAgeLabel.setForeground(Color.WHITE);
		UnderAgeLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		UnderAgePanel.add(UnderAgeLabel);
		
		UnderAgeTextField = new JTextField();
		UnderAgeTextField.setMinimumSize(new Dimension(700, 100));
		UnderAgeTextField.setForeground(Color.WHITE);
		UnderAgeTextField.setColumns(10);
		UnderAgeTextField.setBackground(Color.DARK_GRAY);
		UnderAgePanel.add(UnderAgeTextField);
		
		JPanel EndTimePanel = new JPanel();
		EndTimePanel.setBackground(Color.DARK_GRAY);
		FormEntry2Panel.add(EndTimePanel, "EndTimePanel");
		EndTimePanel.setLayout(new BoxLayout(EndTimePanel, BoxLayout.X_AXIS));
		
		JLabel EndTimeLabel = new JLabel("Enter end time : ");
		EndTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EndTimeLabel.setForeground(Color.WHITE);
		EndTimeLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		EndTimePanel.add(EndTimeLabel);
		
		EndTImeTextField = new JTextField();
		EndTImeTextField.setMinimumSize(new Dimension(700, 100));
		EndTImeTextField.setForeground(Color.WHITE);
		EndTImeTextField.setColumns(10);
		EndTImeTextField.setBackground(Color.DARK_GRAY);
		EndTimePanel.add(EndTImeTextField);
		
		JPanel NumCriminalPanel = new JPanel();
		NumCriminalPanel.setBackground(Color.DARK_GRAY);
		FormEntry2Panel.add(NumCriminalPanel, "NumCriminalPanel");
		NumCriminalPanel.setLayout(new BoxLayout(NumCriminalPanel, BoxLayout.X_AXIS));
		
		JLabel NumCriminalLabel = new JLabel("Enter number of criminals (UB) :");
		NumCriminalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NumCriminalLabel.setForeground(Color.WHITE);
		NumCriminalLabel.setFont(new Font("Cantarell", Font.BOLD, 20));
		NumCriminalPanel.add(NumCriminalLabel);
		
		NumCriminalTextField = new JTextField();
		NumCriminalTextField.setMinimumSize(new Dimension(700, 100));
		NumCriminalTextField.setForeground(Color.WHITE);
		NumCriminalTextField.setColumns(10);
		NumCriminalTextField.setBackground(Color.DARK_GRAY);
		NumCriminalPanel.add(NumCriminalTextField);
		
		JPanel NoOptionPanel = new JPanel();
		NoOptionPanel.setBackground(Color.DARK_GRAY);
		FormEntry1Panel.add(NoOptionPanel, "NoOptionPanel");
		
		JPanel NoOptionPanel2 = new JPanel();
		NoOptionPanel2.setBackground(Color.DARK_GRAY);
		FormEntry2Panel.add(NoOptionPanel2, "NoOptionPanel2");
		//ContainerPanel1.add(FormEntry1Panel);
		//ContainerPanel1.add(FormEntry2Panel);
		CardLayout errorQueryNumberBoxLayout = (CardLayout)ErrorQueryNumberPanel.getLayout();
		CardLayout formEntry1BoxLayout = (CardLayout)FormEntry1Panel.getLayout();
		CardLayout formEntry2BoxLayout = (CardLayout)FormEntry2Panel.getLayout();
		
		JComboBox QueryListComboBox = new JComboBox(QueryList);
		QueryListComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedIndex = QueryListComboBox.getSelectedIndex();
				/*CardLayout errorQueryNumberBoxLayout = (CardLayout)ErrorQueryNumberPanel.getLayout();
				CardLayout formEntry1BoxLayout = (CardLayout)FormEntry1Panel.getLayout();
				CardLayout formEntry2BoxLayout = (CardLayout)FormEntry2Panel.getLayout();*/
				
				QuerySelectionOutputPanel.setVisible(true);
				errorQueryNumberBoxLayout.show(ErrorQueryNumberPanel, "QueryNumberPanel");
				
				switch(selectedIndex){
				case 0: // Do nothing
						QueryNumberLabel.setText("Query Number: <NONE>");
						//ErrorPanel.show();
						formEntry1BoxLayout.show(FormEntry1Panel, "NoOptionPanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
						
				case 1: /**Query 1 */
						QueryNumberLabel.setText("Query Number: 1");
						formEntry1BoxLayout.show(FormEntry1Panel, "NamePanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "UnderAgePanel");
						break;
						
				case 2: /**Query 2 */
						QueryNumberLabel.setText("Query Number: 2");
						formEntry1BoxLayout.show(FormEntry1Panel, "CityNamePanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
						
				case 3: /**Query 3 */
						QueryNumberLabel.setText("Query Number: 3");
						formEntry1BoxLayout.show(FormEntry1Panel, "StartTimePanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "EndTimePanel");
						break;
						
				case 4: /**Query 4 */
						QueryNumberLabel.setText("Query Number: 4");
						formEntry1BoxLayout.show(FormEntry1Panel, "NoOptionPanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
						
				case 5: /**Query 5 */
						QueryNumberLabel.setText("Query Number: 5");
						formEntry1BoxLayout.show(FormEntry1Panel, "CityNamePanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
						
				case 6: /**Query 6 */
						QueryNumberLabel.setText("Query Number: 6");
						formEntry1BoxLayout.show(FormEntry1Panel, "MoreLessPanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NumCriminalPanel");
						break;
						
				case 7: /**Query 7 */
						QueryNumberLabel.setText("Query Number: 7");
						formEntry1BoxLayout.show(FormEntry1Panel, "AgePanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
						
				case 8: /**Query 8 */
						QueryNumberLabel.setText("Query Number: 8");
						formEntry1BoxLayout.show(FormEntry1Panel, "NoOptionPanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
						
				case 9: /**Query 9 */
						QueryNumberLabel.setText("Query Number: 9");
						formEntry1BoxLayout.show(FormEntry1Panel, "NoOptionPanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
						
				case 10: /**Query 10 */
						QueryNumberLabel.setText("Query Number: 10");
						formEntry1BoxLayout.show(FormEntry1Panel, "CrimeTypePanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
						
				case 11: /**Query 11 */
						QueryNumberLabel.setText("Query Number:11");
						formEntry1BoxLayout.show(FormEntry1Panel, "NoOptionPanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
						
				case 12: /**Query 12 */
						QueryNumberLabel.setText("Query Number: 12");
						formEntry1BoxLayout.show(FormEntry1Panel, "NoOptionPanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
						
				case 13: /**Query 13 */
						QueryNumberLabel.setText("Query Number: 13");
						formEntry1BoxLayout.show(FormEntry1Panel, "NoOptionPanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
						
				case 14: /**Query 14 */
						QueryNumberLabel.setText("Query Number: 14");
						formEntry1BoxLayout.show(FormEntry1Panel, "CrimeTypePanel");
						formEntry2BoxLayout.show(FormEntry2Panel, "NoOptionPanel2");
						break;
				}
			}
		});
		QueryListComboBox.setSelectedIndex(0);
		QueryListComboBox.setPreferredSize(new Dimension(700, 50));
		QueryListComboBox.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.LIGHT_GRAY));
		QueryListComboBox.setForeground(Color.WHITE);
		QueryListComboBox.setBackground(Color.DARK_GRAY);
		QueryListComboBox.setFont(new Font("Cantarell", Font.BOLD, 20));
		QueryListCBPanel.add(QueryListComboBox);
		
		
		
		JButton SubmitButton = new JButton("SUBMIT");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedIndex = QueryListComboBox.getSelectedIndex();
				String in1,in2,query;
				/*CardLayout errorQueryNumberBoxLayout = (CardLayout)ErrorQueryNumberPanel.getLayout();*/
				
				switch(selectedIndex){
				case 0: // Pop-up box -- ask USER to select some query
						/*errorQueryNumberBoxLayout.show(ErrorPanel, "ErrorPanel");*/
						break;
						
				case 1: /**Query 1 */
						 in1=NameTextField.getText();
			             in2=UnderAgeTextField.getText();
			             if(!in1.equals("") && !in2.equals(""))
			             {
			                query=new String("select * from criminal where Criminal_Name=\""+in1+"\" and Age<\""+in2+"\"");
			                System.out.println("Query="+query);
			                ArrayList<Criminal> data=new ArrayList<Criminal>();
			                Criminal temp;
			                try
			                {   Class.forName("com.mysql.jdbc.Driver");  
			                    Connection con=DriverManager.getConnection(  
			                    "jdbc:mysql://localhost:3306/project_dbms_crime","DBMS","pikachu");  
			                    //here sonoo is database name, root is username and password  
			                    Statement stmt=con.createStatement();  
			                    ResultSet rs=stmt.executeQuery(query);  
			                    while(rs.next())
			                    {
			                        temp=new Criminal(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)); 
			                        data.add(temp);
			                    }
			                    con.close();  
			                }
			                catch(Exception exe)
			                {
			                        System.out.println(exe);
			                }
			               jTable=new JTable(new myTable(data,data.size()));
			             }
						break;
						
				case 2: /**Query 2 */
					 in1=NameTextField.getText();
		             if(!in1.equals(""))
		             {
		                query=new String("select CrimeID,Crime_Time,Crime_Date,Type_of_Crime,Crime_House_Number,Crime_Street_Name,Crime_City_Name from criminal natural join r1 natural join crime where Crime_City_Name=\""+in1+"\"");
		                System.out.println("Query="+query);
		                ArrayList<Crime> data=new ArrayList<Crime>();
		                Crime temp;
		                try
		                {   Class.forName("com.mysql.jdbc.Driver");  
		                    Connection con=DriverManager.getConnection(  
		                    "jdbc:mysql://localhost:3306/project_dbms_crime","DBMS","pikachu");  
		                    //here sonoo is database name, root is username and password  
		                    Statement stmt=con.createStatement();  
		                    ResultSet rs=stmt.executeQuery(query);  
		                    while(rs.next())
		                    {
		                        temp=new Crime(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)); 
		                        data.add(temp);
		                    }
		                    con.close();  
		                }
		                catch(Exception exe)
		                {
		                        System.out.println(exe);
		                }
		               jTable=new JTable(new myTableCrime(data,data.size()));
		             }
						break;
						
				case 3: /**Query 3 */
							 in1=StartTimeTextField.getText();
							 in2=EndTImeTextField.getText();
				             if(!in1.equals("") && !in2.equals(""))
				             {
				                query=new String("select * from crime where Crime_Time > \""+in1+"\" and Crime_Time < \""+in2+"\"");
				                System.out.println("Query="+query);
				                ArrayList<Crime> data=new ArrayList<Crime>();
				                Crime temp;
				                try
				                {   Class.forName("com.mysql.jdbc.Driver");  
				                    Connection con=DriverManager.getConnection(  
				                    "jdbc:mysql://localhost:3306/project_dbms_crime","DBMS","pikachu");  
				                    //here sonoo is database name, root is username and password  
				                    Statement stmt=con.createStatement();  
				                    ResultSet rs=stmt.executeQuery(query);  
				                    while(rs.next())
				                    {
				                        temp=new Crime(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)); 
				                        data.add(temp);
				                    }
				                    con.close();  
				                }
				                catch(Exception exe)
				                {
				                        System.out.println(exe);
				                }
				               jTable=new JTable(new myTableCrime(data,data.size()));
				             }
						break;
						
				case 4: /**Query 4 */
							query=new String("select CriminalID,Criminal_Name,Height,Weight,Age,Criminal_House_Number,Criminal_Street_Name,Criminal_City_Name from criminal natural join r3 natural join arrested_criminals where Action_Taken=\"Death Penalty\"");
			                System.out.println("Query="+query);
			                ArrayList<Criminal> data=new ArrayList<Criminal>();
			                Criminal temp;
			                try
			                {   Class.forName("com.mysql.jdbc.Driver");  
			                    Connection con=DriverManager.getConnection(  
			                    "jdbc:mysql://localhost:3306/project_dbms_crime","DBMS","pikachu");  
			                    //here sonoo is database name, root is username and password  
			                    Statement stmt=con.createStatement();  
			                    ResultSet rs=stmt.executeQuery(query);  
			                    while(rs.next())
			                    {
			                        temp=new Criminal(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)); 
			                        data.add(temp);
			                    }
			                    con.close();  
			                }
			                catch(Exception exe)
			                {
			                        System.out.println(exe);
			                }
			               jTable=new JTable(new myTable(data,data.size()));
						break;
						
				case 5: /**Query 5 */
							 in1=CityNameTextField.getText();
				             if(!in1.equals("") )
				             {
				                query=new String("select CriminalID,Criminal_Name,Height,Weight,Age,Criminal_House_Number,Criminal_Street_Name,Criminal_City_Name from criminal natural join r3 natural join arrested_criminals where Arrest_City_Name=\""+in1+"\"");
				                System.out.println("Query="+query);
				                ArrayList<Criminal> dataq5=new ArrayList<Criminal>();
				                Criminal tempq5;
				                try
				                {   Class.forName("com.mysql.jdbc.Driver");  
				                    Connection con=DriverManager.getConnection(  
				                    "jdbc:mysql://localhost:3306/project_dbms_crime","DBMS","pikachu");  
				                    //here sonoo is database name, root is username and password  
				                    Statement stmt=con.createStatement();  
				                    ResultSet rs=stmt.executeQuery(query);  
				                    while(rs.next())
				                    {
				                        tempq5=new Criminal(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)); 
				                        dataq5.add(tempq5);
				                    }
				                    con.close();  
				                }
				                catch(Exception exe)
				                {
				                        System.out.println(exe);
				                }
				               jTable=new JTable(new myTable(dataq5,dataq5.size()));
				             }
						break;
						
				case 6: /**Query 6 */
							 int m=0;
							 in1=MoreRadioButton.getText();
							 in2=NumCriminalTextField.getText();
							 if(in1.equals(""))
							 {
								 in1=LessRadioButton.getText();
								 m=1;
							 }
				             if(!in1.equals("") && !in2.equals(""))
				             {
				            	if(m==0)
				            	{
				            		query=new String("select * from crime where Crime_Time > \""+in1+"\" and Crime_Time < \""+in2+"\""); //TODO correct the query for this
				            	}
				            	else
				            	{
				            		query=new String("select * from crime where Crime_Time > \""+in1+"\" and Crime_Time < \""+in2+"\"");
				            	}
				                System.out.println("Query="+query);
				                ArrayList<Jail> dataq6=new ArrayList<Jail>();
				                Jail tempq6;
				                try
				                {   Class.forName("com.mysql.jdbc.Driver");  
				                    Connection con=DriverManager.getConnection(  
				                    "jdbc:mysql://localhost:3306/project_dbms_crime","DBMS","pikachu");  
				                    //here sonoo is database name, root is username and password  
				                    Statement stmt=con.createStatement();  
				                    ResultSet rs=stmt.executeQuery(query);  
				                    while(rs.next())
				                    {
				                        tempq6=new Jail(rs.getInt(1),rs.getString(2),rs.getInt(3)); 
				                        dataq6.add(tempq6);
				                    }
				                    con.close();  
				                }
				                catch(Exception exe)
				                {
				                        System.out.println(exe);
				                }
				               jTable=new JTable(new myTableJail(dataq6,dataq6.size()));
				             }
						break;
						
				case 7: /**Query 7 */
						break;
						
				case 8: /**Query 8 */
						break;
						
				case 9: /**Query 9 */
						break;
						
				case 10: /**Query 10 */
						break;
						
				case 11: /**Query 11 */
						break;
						
				case 12: /**Query 12 */
						break;
						
				case 13: /**Query 13 */
						break;
						
				case 14: /**Query 14 */
						break;
				}
			}
		});
		SubmitButton.setPreferredSize(new Dimension(300, 100));
		SubmitButton.setForeground(Color.WHITE);
		SubmitButton.setFont(new Font("Cantarell", Font.BOLD, 20));
		SubmitButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		SubmitButton.setBackground(Color.DARK_GRAY);
		SubmitPanel.add(SubmitButton);
		//SubmitPanel.show();
		SubmitButton.setVisible(true);
		
		JButton StartButton = new JButton("START");
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout)contentPane.getLayout();
				cardLayout.show(contentPane, "QueryPanel");
			}
		});
		StartButton.setForeground(Color.WHITE);
		StartButton.setPreferredSize(new Dimension(300, 100));
		StartButton.setFont(new Font("Cantarell", Font.BOLD, 20));
		StartButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		StartButton.setBackground(Color.DARK_GRAY);
		StartButtonPanel.add(StartButton);
	
	}
}