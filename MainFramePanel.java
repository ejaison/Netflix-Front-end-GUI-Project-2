//Eric Jaison 
//Netflix GUI 
//Java 
//Dr. Doderer
//Oct 18, 2022

package guiIntro;


// All the import files and Java collections
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.AbstractMultiResolutionImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;

import project1.ShowWeek;
import project1.Shows;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JList;

public class MainFramePanel extends JPanel{
	private int count;
	private JLabel label;
	private JTextField movieTitle;
	private JComboBox movies;

	private Shows allData;  //all the list of shows variable 
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public MainFramePanel() {
		Shows allData = new Shows("allData","./project1/netflixAllWeeksGlobalProcessed.txt");
		//System.out.println(allData); //test if read worked, commented out to prevent console overload

		// Color set and size of the frame panel 
		setLayout(null);
		count = 0;
		setBackground(new Color(255, 0, 0));
		setPreferredSize(new Dimension(800, 500));

		//Creating the label for a picture 
		label = new JLabel ("");
		label.setIcon(new ImageIcon(MainFramePanel.class.getResource("/guiIntro/Netflix.png")));
		label.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label.setBounds(300, 0, 208, 105);
		add(label);

		//Creating a JTextfield and naming movieTitle
		movieTitle = new JTextField("2021-07-04");
		movieTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		movieTitle.setBounds(21, 190, 96, 19);
		add(movieTitle);
		movieTitle.setColumns(10);

		//Creating the label for a the JTextField
		JLabel lblNewLabel = new JLabel("Enter a Week:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(21, 167, 105, 13);
		add(lblNewLabel);

		//Adding a scroll for the textArea
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(458, 136, 312, 309);
		add(scrollPane);

		//Creating a TextArea for all the data output
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(allData.toString());

		//Creating a JComboBox and representing the movies that in the same week 
		JComboBox movies = new JComboBox();
		ArrayList<ShowWeek> moviesInWeek = allData.getOneWeek("2021-07-04");

		String [] data = new String[moviesInWeek.size()];
		int index = 0;
		for (ShowWeek sw : moviesInWeek){
			data[index] = sw.getShowTitle();
			index++;

		}

		movies.setModel(new DefaultComboBoxModel(data)); 
		movies.setBounds(21, 300, 145, 21);
		add(movies);

		//Creating a label for the all the movie names
		JLabel lblNewLabel_1 = new JLabel("Movie Names:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(21, 277, 96, 13);
		add(lblNewLabel_1);

		//Adding a button for the get movies from the user input 
		JButton btnNewButton = new JButton("Get Movies");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ShowWeek> moviesInWeek = allData.getOneWeek(movieTitle.getText());
				if (moviesInWeek != null && moviesInWeek.size()>0) {
					String [] data = new String[moviesInWeek.size()];
					int index = 0;
					for (ShowWeek sw : moviesInWeek){
						data[index] = sw.getShowTitle();
						index++;

					}
					movies.setModel(new DefaultComboBoxModel(data));
				}
			}
		});
		btnNewButton.setBounds(21, 219, 105, 21);
		add(btnNewButton);

		//Creating a extra label for the TextArea
		JLabel lblNewLabel_2 = new JLabel("All the Top TV Shows and Movies");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(458, 114, 312, 23);
		add(lblNewLabel_2);

		//creating a menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 61, 24);
		add(menuBar);

		//Naming the file option to the menu
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		//Exiting from the JFrame
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnFile.add(mntmNewMenuItem_1);

		//Creating radio buttons 
		JRadioButton rdbtnNewRadioButton = new JRadioButton("English Movies");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(196, 299, 109, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFromSelectedCategory = new JRadioButton("Non English Movies");
		buttonGroup.add(rdbtnFromSelectedCategory);
		rdbtnFromSelectedCategory.setBounds(307, 299, 148, 23);
		add(rdbtnFromSelectedCategory);

		}
	}


