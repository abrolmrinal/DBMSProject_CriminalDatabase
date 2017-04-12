import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class CriminalDatabase extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 997, 567);
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
		
		JComboBox QueryListComboBox = new JComboBox(QueryList);
		QueryListComboBox.setSelectedIndex(0);
		QueryListComboBox.setPreferredSize(new Dimension(700, 50));
		QueryListComboBox.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.LIGHT_GRAY));
		QueryListComboBox.setForeground(Color.WHITE);
		QueryListComboBox.setBackground(Color.DARK_GRAY);
		QueryListComboBox.setFont(new Font("Cantarell", Font.BOLD, 20));
		QueryListCBPanel.add(QueryListComboBox);
		
		JPanel QuerySelectionOutputPanel = new JPanel();
		QuerySelectionOutputPanel.setBackground(Color.DARK_GRAY);
		QueryDropDownPanel.add(QuerySelectionOutputPanel);
		QuerySelectionOutputPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
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
		SubmitPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton SubmitButton = new JButton("SUBMIT");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedIndex = QueryListComboBox.getSelectedIndex();
				CardLayout errorQueryNumberBoxLayout = (CardLayout)ErrorQueryNumberPanel.getLayout();
				
				switch(selectedIndex){
				case 0: // Pop-up box -- ask USER to select some query
						errorQueryNumberBoxLayout.show(ErrorPanel, "ErrorPanel");
						break;
						
				case 1: /**Query 1 */
						break;
						
				case 2: /**Query 2 */
						break;
						
				case 3: /**Query 3 */
						break;
						
				case 4: /**Query 4 */
						break;
						
				case 5: /**Query 5 */
						break;
						
				case 6: /**Query 6 */
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
