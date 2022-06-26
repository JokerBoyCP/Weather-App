package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import Data.FavoritenData;

public class Favorites extends JFrame implements ActionListener{

	JFrame frame1 = new JFrame();
	FavoritenData favData;
	
	
	private JLabel logo_label;
	private JPanel data_panel;
	private JPanel logo_panel;
	private JLabel favorites_label;
	
	private JButton back_button;
    private JButton remove_button;
    private JButton open_button;

	public Favorites() {

		// adjust size and set layout
		frame1.setPreferredSize(new Dimension(566, 565));
		frame1.setLayout(null);
		frame1.getContentPane().setBackground(Color.decode("#26292E"));
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setTitle("Weather App");
		frame1.setVisible(true);
		frame1.pack();

		// construct components
		logo_label = new JLabel(
		new ImageIcon("src\\weather-icon.gif"));
		data_panel = new JPanel();
		logo_panel = new JPanel();
		favorites_label = new JLabel("Favorites:");
		
		favData = new FavoritenData();
		
		back_button = new JButton("Back");
		remove_button = new JButton("Remove");
		open_button = new JButton("Open");
		
		
		// add components

		frame1.add(logo_panel);
		frame1.add(data_panel);
		frame1.add(favorites_label);
		
		frame1.add(back_button);
		frame1.add(remove_button);
		frame1.add(open_button);

		logo_panel.setLayout(new FlowLayout());
		logo_panel.add(logo_label);

		logo_panel.setBackground(Color.decode("#26292E"));
		
		favData.list.setModel(favData.flm);
		
		favData.flm.addElement("Basel");
		
		data_panel.setBorder(new LineBorder(Color.white));
		data_panel.setLayout(new BorderLayout());
		data_panel.add(favData.list, BorderLayout.CENTER);
		favData.list.setForeground(Color.black);
		favData.list.setBackground(Color.blue);
		
		
		back_button.setBackground(Color.decode("#E68947"));
		back_button.setBorder(new LineBorder(Color.decode("#E68947")));
		back_button.addActionListener(this);
		back_button.setFont(new Font("SansSerif", Font.BOLD, 12));
		back_button.setForeground(Color.white);
		
		remove_button.setBackground(Color.decode("#E68947"));
		remove_button.setBorder(new LineBorder(Color.decode("#E68947")));
		remove_button.addActionListener(this);
		remove_button.setFont(new Font("SansSerif", Font.BOLD, 12));
		remove_button.setForeground(Color.white);
		
		open_button.setBackground(Color.decode("#E68947"));
		open_button.setBorder(new LineBorder(Color.decode("#E68947")));
		open_button.addActionListener(this);
		open_button.setFont(new Font("SansSerif", Font.BOLD, 12));
		open_button.setForeground(Color.white);
		
		
		
		favorites_label.setForeground(Color.white);
		
		// set component bounds (only needed by Absolute Positioning)
		logo_panel.setBounds(35, 25, 145, 100);
		favorites_label.setBounds(42, 180, 100, 25);
		data_panel.setBounds(40, 205, 480, 250);
		back_button.setBounds (50, 470, 95, 25);
	    remove_button.setBounds(160, 470, 98, 25);
	    open_button.setBounds(425, 470, 95, 25);

	    
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== back_button) {
			frame1.dispose();
	}
	}

}
