package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Data.FavoritenData;

public class Favorites extends JFrame {

	JFrame frame = new JFrame();
	FavoritenData favData;
	
	private JList list;
	private JLabel logo_label;
	private JPanel data_panel;
	private JPanel logo_panel;
	private JLabel favorites_label;

	public Favorites() {

		// adjust size and set layout
		frame.setPreferredSize(new Dimension(566, 565));
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#26292E"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Weather App");
		frame.setVisible(true);
		frame.pack();

		// construct components
		logo_label = new JLabel(
				new ImageIcon("src\\weather-icon.gif"));
		data_panel = new JPanel();
		logo_panel = new JPanel();
		favorites_label = new JLabel("Favorites:");
		favData = new FavoritenData();
		list = new JList(favData.toArray());
		
		// add components

		frame.add(logo_panel);
		frame.add(data_panel);
		frame.add(favorites_label);

		logo_panel.setLayout(new FlowLayout());
		logo_panel.add(logo_label);

		logo_panel.setBackground(Color.decode("#26292E"));
		
		list.setForeground(Color.white);

		data_panel.setBackground(Color.black);
		data_panel.setBorder(new LineBorder(Color.white));
		data_panel.add(list);
		
		
		
		favorites_label.setForeground(Color.white);
		
		// set component bounds (only needed by Absolute Positioning)
		logo_panel.setBounds(35, 25, 145, 100);
		favorites_label.setBounds(42, 180, 100, 25);
		data_panel.setBounds(40, 205, 480, 250);

	}

}
