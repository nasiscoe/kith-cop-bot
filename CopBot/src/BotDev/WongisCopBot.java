package BotDev;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;

import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.List;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;

public class WongisCopBot{

	// Application Elements
	private JFrame frame;
	private JTextField firstNameTextBox;
	private JTextField emailTextBox;
	private JTextField lastNameTextBox;
	private JTextField addressTextBox;
	private JTextField aptTextBox;
	private JTextField directLinkTextBox;
	private JTextField cityTextBox;
	private JTextField zipTextBox;
	private JTextField phoneTextBox;
	private JTextField cardNumberTextBox;
	private JTextField nameOnCardTextBox;
	private JTextField cardExpirationTextBox;
	private JTextField cvvTextBox;
	
	// Strings
	String website;
	String keyword;
	String size;
	String email;
	String firstName;
	String lastName;
	String address;
	String apt;
	String city;
	String zip;
	String phone;
	String cardNumber;
	String nameOnCard;
	String mmyy;
	String cvv;
	// Identifier to know which bot to launch
	String site;
	// Identifier for direct link or not
	String hasDirectLinkIdentifier;
	// Array for accessing queued cops
	String[] queuedInfo = new String[16];
	
	// Boolean to know if the bot has a direct link to go by or not
	boolean hasDirectLink;
	private JTextField keywordTextBox;

	/**
	 * Launch the app.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WongisCopBot window = new WongisCopBot();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WongisCopBot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 691, 817);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel txtpnWongisCopBot = new JLabel();
		txtpnWongisCopBot.setHorizontalAlignment(SwingConstants.CENTER);
		txtpnWongisCopBot.setForeground(Color.WHITE);
		txtpnWongisCopBot.setBackground(Color.DARK_GRAY);
		txtpnWongisCopBot.setFont(new Font("Verlag Black", Font.PLAIN, 30));
		txtpnWongisCopBot.setText("WIP SHOE BOT");
		txtpnWongisCopBot.setBounds(197, 11, 282, 44);
		frame.getContentPane().add(txtpnWongisCopBot);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.RED);
		separator.setForeground(Color.RED);
		separator.setBounds(21, 56, 633, 15);
		frame.getContentPane().add(separator);
		
		JLabel txtpnWebsite = new JLabel();
		txtpnWebsite.setForeground(Color.WHITE);
		txtpnWebsite.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnWebsite.setBackground(SystemColor.menu);
		txtpnWebsite.setText("Site:");
		txtpnWebsite.setBounds(21, 71, 63, 20);
		frame.getContentPane().add(txtpnWebsite);
		
		JLabel txtpnFindProductBy = new JLabel();
		txtpnFindProductBy.setHorizontalAlignment(SwingConstants.LEFT);
		txtpnFindProductBy.setForeground(Color.WHITE);
		txtpnFindProductBy.setBackground(SystemColor.menu);
		txtpnFindProductBy.setText("Have Direct Link?");
		txtpnFindProductBy.setBounds(21, 102, 96, 20);
		frame.getContentPane().add(txtpnFindProductBy);
		
		JLabel txtpnDirectLink = new JLabel();
		txtpnDirectLink.setForeground(Color.WHITE);
		txtpnDirectLink.setText("Item URL:");
		txtpnDirectLink.setBackground(SystemColor.menu);
		txtpnDirectLink.setBounds(21, 133, 63, 20);
		frame.getContentPane().add(txtpnDirectLink);
		txtpnDirectLink.setVisible(false);
		
		JLabel txtpnKeyword = new JLabel();
		txtpnKeyword.setForeground(Color.WHITE);
		txtpnKeyword.setBackground(SystemColor.menu);
		txtpnKeyword.setText("Keyword:");
		txtpnKeyword.setBounds(21, 164, 63, 20);
		frame.getContentPane().add(txtpnKeyword);
		
		JLabel txtpnSize = new JLabel();
		txtpnSize.setForeground(Color.WHITE);
		txtpnSize.setBackground(SystemColor.menu);
		txtpnSize.setText("Size:");
		txtpnSize.setBounds(21, 195, 63, 20);
		frame.getContentPane().add(txtpnSize);
		
		JLabel txtpnEmail = new JLabel();
		txtpnEmail.setForeground(Color.WHITE);
		txtpnEmail.setBackground(SystemColor.menu);
		txtpnEmail.setText("Email:");
		txtpnEmail.setBounds(21, 226, 63, 20);
		frame.getContentPane().add(txtpnEmail);
		
		JLabel txtpnFirstName = new JLabel();
		txtpnFirstName.setForeground(Color.WHITE);
		txtpnFirstName.setBackground(SystemColor.menu);
		txtpnFirstName.setText("First Name:");
		txtpnFirstName.setBounds(21, 257, 63, 20);
		frame.getContentPane().add(txtpnFirstName);
		
		JLabel txtpnLastName = new JLabel();
		txtpnLastName.setForeground(Color.WHITE);
		txtpnLastName.setBackground(SystemColor.menu);
		txtpnLastName.setText("Last Name:");
		txtpnLastName.setBounds(21, 288, 63, 20);
		frame.getContentPane().add(txtpnLastName);
		
		JLabel txtpnAddressline = new JLabel();
		txtpnAddressline.setForeground(Color.WHITE);
		txtpnAddressline.setBackground(SystemColor.menu);
		txtpnAddressline.setText("Address (Line 1):");
		txtpnAddressline.setBounds(21, 319, 125, 20);
		frame.getContentPane().add(txtpnAddressline);
		
		JLabel txtpnAptSuiteEtc = new JLabel();
		txtpnAptSuiteEtc.setForeground(Color.WHITE);
		txtpnAptSuiteEtc.setBackground(SystemColor.menu);
		txtpnAptSuiteEtc.setText("Apt, suite, etc. (optional):");
		txtpnAptSuiteEtc.setBounds(21, 375, 144, 20);
		frame.getContentPane().add(txtpnAptSuiteEtc);
		
		JLabel txtpnCity = new JLabel();
		txtpnCity.setForeground(Color.WHITE);
		txtpnCity.setBackground(SystemColor.menu);
		txtpnCity.setText("City:");
		txtpnCity.setBounds(21, 431, 63, 20);
		frame.getContentPane().add(txtpnCity);
		
		JLabel txtpnZipCode = new JLabel();
		txtpnZipCode.setForeground(Color.WHITE);
		txtpnZipCode.setBackground(SystemColor.menu);
		txtpnZipCode.setText("ZIP Code:");
		txtpnZipCode.setBounds(21, 462, 63, 20);
		frame.getContentPane().add(txtpnZipCode);
		
		JLabel txtpnPhone = new JLabel();
		txtpnPhone.setForeground(Color.WHITE);
		txtpnPhone.setBackground(SystemColor.menu);
		txtpnPhone.setText("Phone:");
		txtpnPhone.setBounds(21, 493, 63, 20);
		frame.getContentPane().add(txtpnPhone);
		
		JLabel txtpnCardNumber = new JLabel();
		txtpnCardNumber.setForeground(Color.WHITE);
		txtpnCardNumber.setBackground(SystemColor.menu);
		txtpnCardNumber.setText("Card Number:");
		txtpnCardNumber.setBounds(21, 524, 96, 20);
		frame.getContentPane().add(txtpnCardNumber);
		
		JLabel txtpnNameOnCard = new JLabel();
		txtpnNameOnCard.setForeground(Color.WHITE);
		txtpnNameOnCard.setBackground(SystemColor.menu);
		txtpnNameOnCard.setText("Name on Card:");
		txtpnNameOnCard.setBounds(21, 580, 96, 20);
		frame.getContentPane().add(txtpnNameOnCard);
		
		JLabel txtpnMmyy = new JLabel();
		txtpnMmyy.setForeground(Color.WHITE);
		txtpnMmyy.setBackground(SystemColor.menu);
		txtpnMmyy.setText("MM/YY:");
		txtpnMmyy.setBounds(21, 636, 63, 20);
		frame.getContentPane().add(txtpnMmyy);
		
		JLabel txtpnCvv = new JLabel();
		txtpnCvv.setForeground(Color.WHITE);
		txtpnCvv.setBackground(SystemColor.menu);
		txtpnCvv.setText("CVV:");
		txtpnCvv.setBounds(21, 667, 63, 20);
		frame.getContentPane().add(txtpnCvv);
		
		JComboBox siteSelector = new JComboBox();
		siteSelector.setBounds(94, 71, 96, 20);
		frame.getContentPane().add(siteSelector);
		siteSelector.addItem("Kith");
		
		JCheckBox directLinkSelector = new JCheckBox("Direct Link");
		directLinkSelector.setForeground(Color.WHITE);
		directLinkSelector.setBackground(Color.DARK_GRAY);
		directLinkSelector.setBounds(115, 101, 75, 23);
		frame.getContentPane().add(directLinkSelector);
		directLinkSelector.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		          if (directLinkSelector.isSelected() == true) {
		        	  txtpnDirectLink.setVisible(true);
		        	  directLinkTextBox.setVisible(true);
		        	  hasDirectLink = true;
		          } else {
		        	  txtpnDirectLink.setVisible(false);
		        	  directLinkTextBox.setVisible(false);
		        	  directLinkTextBox.setText("");
		        	  hasDirectLink = false;
		          }
			}
		});
		
		directLinkTextBox = new JTextField();
		directLinkTextBox.setBounds(94, 133, 96, 20);
		frame.getContentPane().add(directLinkTextBox);
		directLinkTextBox.setColumns(10);
		directLinkTextBox.setVisible(false);
		
		keywordTextBox = new JTextField();
		keywordTextBox.setBounds(94, 164, 96, 20);
		frame.getContentPane().add(keywordTextBox);
		keywordTextBox.setColumns(10);
		
		JComboBox<String> sizeSelector = new JComboBox<String>();
		sizeSelector.setBounds(94, 195, 96, 20);
		frame.getContentPane().add(sizeSelector);
		sizeSelector.addItem("No Preference");
		sizeSelector.addItem("8");
		sizeSelector.addItem("9");
		sizeSelector.addItem("10");
		sizeSelector.addItem("11");
		sizeSelector.addItem("12");
		sizeSelector.addItem("13");
		sizeSelector.addItem("S");
		sizeSelector.addItem("M");
		sizeSelector.addItem("L");
		sizeSelector.addItem("XL");
		sizeSelector.addItem("30");
		sizeSelector.addItem("31");
		sizeSelector.addItem("32");
		sizeSelector.addItem("33");
		sizeSelector.addItem("34");
		sizeSelector.addItem("35");
		sizeSelector.addItem("36");
		
		firstNameTextBox = new JTextField();
		firstNameTextBox.setBounds(94, 257, 96, 20);
		frame.getContentPane().add(firstNameTextBox);
		firstNameTextBox.setColumns(10);
		
		emailTextBox = new JTextField();
		emailTextBox.setBounds(94, 226, 96, 20);
		frame.getContentPane().add(emailTextBox);
		emailTextBox.setColumns(10);
		
		lastNameTextBox = new JTextField();
		lastNameTextBox.setBounds(94, 288, 96, 20);
		frame.getContentPane().add(lastNameTextBox);
		lastNameTextBox.setColumns(10);
		
		addressTextBox = new JTextField();
		addressTextBox.setBounds(21, 344, 169, 20);
		frame.getContentPane().add(addressTextBox);
		addressTextBox.setColumns(10);
		
		aptTextBox = new JTextField();
		aptTextBox.setBounds(21, 400, 169, 20);
		frame.getContentPane().add(aptTextBox);
		aptTextBox.setColumns(10);
		
		cityTextBox = new JTextField();
		cityTextBox.setBounds(94, 431, 96, 20);
		frame.getContentPane().add(cityTextBox);
		cityTextBox.setColumns(10);
		
		zipTextBox = new JTextField();
		zipTextBox.setBounds(94, 462, 96, 20);
		frame.getContentPane().add(zipTextBox);
		zipTextBox.setColumns(10);
		
		phoneTextBox = new JTextField();
		phoneTextBox.setBounds(94, 493, 96, 20);
		frame.getContentPane().add(phoneTextBox);
		phoneTextBox.setColumns(10);
		
		cardNumberTextBox = new JTextField();
		cardNumberTextBox.setBounds(21, 549, 169, 20);
		frame.getContentPane().add(cardNumberTextBox);
		cardNumberTextBox.setColumns(10);
		
		nameOnCardTextBox = new JTextField();
		nameOnCardTextBox.setBounds(21, 605, 169, 20);
		frame.getContentPane().add(nameOnCardTextBox);
		nameOnCardTextBox.setColumns(10);
		
		cardExpirationTextBox = new JTextField();
		cardExpirationTextBox.setBounds(94, 636, 96, 20);
		frame.getContentPane().add(cardExpirationTextBox);
		cardExpirationTextBox.setColumns(10);
		
		cvvTextBox = new JTextField();
		cvvTextBox.setBounds(94, 667, 96, 20);
		frame.getContentPane().add(cvvTextBox);
		cvvTextBox.setColumns(10);
		
		List queueList = new List();
		queueList.setBounds(209, 71, 445, 616);
		frame.getContentPane().add(queueList);
		
		JButton addToQueueButton = new JButton("Add to Queued Tasks");
		addToQueueButton.setBounds(21, 698, 169, 56);
		frame.getContentPane().add(addToQueueButton);
		addToQueueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (hasDirectLink == true) {
					website = directLinkTextBox.getText();
					hasDirectLinkIdentifier = "true";
				} else {
					// Default store page for every available store bot
					switch (siteSelector.getSelectedItem().toString()) {
					case "Kith":
						website = "https://kith.com/collections/r13/mens";
						break;
					}
					hasDirectLinkIdentifier = "false";
				}
				keyword = keywordTextBox.getText();
				size = sizeSelector.getSelectedItem().toString();
				email = emailTextBox.getText();
				firstName = firstNameTextBox.getText();
				lastName = lastNameTextBox.getText();
				address = addressTextBox.getText();
				apt = aptTextBox.getText();
				city = cityTextBox.getText();
				zip = zipTextBox.getText();
				phone = phoneTextBox.getText();
				cardNumber = cardNumberTextBox.getText();
				nameOnCard = nameOnCardTextBox.getText();
				mmyy = cardExpirationTextBox.getText();
				cvv = cvvTextBox.getText();
				site = siteSelector.getSelectedItem().toString();
				queueList.add(website + " : " + keyword + " : " + size + " : " + email + " : " + firstName + " : " + lastName + " : " + address + " : " + apt + " : " + city + " : " + zip + " : " + phone + " : " + cardNumber + " : " + nameOnCard + " : " + mmyy + " : " + cvv + " : " + site + " : " + hasDirectLinkIdentifier);
			}
		});
		
		JButton removeFromQueueButton = new JButton("Remove Selected From Queue");
		removeFromQueueButton.setBounds(209, 710, 217, 20);
		frame.getContentPane().add(removeFromQueueButton);
		removeFromQueueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				queueList.remove(queueList.getSelectedIndex());
			}
		});
		
		JButton runAllButton = new JButton("RUN ALL TASKS");
		runAllButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		runAllButton.setBounds(436, 734, 218, 20);
		frame.getContentPane().add(runAllButton);
		runAllButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// Loop through each queued cop
				for (int i = 0; i < queueList.getItemCount(); i++) {
					queuedInfo = queueList.getItem(i).split(" : ");
					runTask(queuedInfo);
				}
			}
		});
		
		JButton runSelectedTaskButton = new JButton("Run Selected Task");
		runSelectedTaskButton.setBounds(436, 710, 218, 20);
		frame.getContentPane().add(runSelectedTaskButton);
		runSelectedTaskButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				queuedInfo = queueList.getSelectedItem().split(" : ");
				runTask(queuedInfo);
			}
		});
		
		JButton duplicateTaskButton = new JButton("Duplicate Selected Task");
		duplicateTaskButton.setBounds(209, 734, 217, 20);
		frame.getContentPane().add(duplicateTaskButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.RED);
		separator_1.setBackground(Color.RED);
		separator_1.setBounds(209, 698, 445, 15);
		frame.getContentPane().add(separator_1);
		duplicateTaskButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				queueList.add(queueList.getSelectedItem().toString());
			}
		});
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	// Launches whatever bot is needed to do the queued task
	public void runTask(String[] queuedInfo) {
		// Gather individual strings for the selected queued cop
		website = queuedInfo[0];
		keyword = queuedInfo[1];
		size = queuedInfo[2];
		email = queuedInfo[3];
		firstName = queuedInfo[4];
		lastName = queuedInfo[5];
		address = queuedInfo[6];
		apt = queuedInfo[7];
		city = queuedInfo[8];
		zip = queuedInfo[9];
		phone = queuedInfo[10];
		cardNumber = queuedInfo[11];
		nameOnCard = queuedInfo[12];
		mmyy = queuedInfo[13];
		cvv = queuedInfo[14];
		site = queuedInfo[15];
		hasDirectLinkIdentifier = queuedInfo[16];
		System.out.println("Executing queued cop:");
		System.out.println(website + " : " + keyword + " : " + size + " : " + email + " : " + firstName + " : " + lastName + " : " + address + " : " + apt + " : " + city + " : " + zip + " : " + phone + " : " + cardNumber + " : " + nameOnCard + " : " + mmyy + " : " + cvv + " : " + site + " : " + hasDirectLinkIdentifier);
		// Launch bot to execute cop with those strings
		switch (site) {
		case "Kith":
			System.out.println("^ Launching Kith bot!");
			KithCheckoutBot.main(website, keyword, size, email, firstName, lastName, address, apt, city, zip, phone, cardNumber, nameOnCard, mmyy, cvv, hasDirectLinkIdentifier);
			break;
		}
	}
}
