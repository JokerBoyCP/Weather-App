package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Data.FavoritenData;
import Logik.Map;

public class City extends JFrame implements ActionListener{

	JFrame frame = new JFrame();
	Map mpp;
	FavoritenData favData ;
	
	private JLabel logo_label;
	private JLabel city_label;
	private JLabel city_name;
	private JPanel data_panel;
	private JPanel map_panel;
	private JPanel logo_panel;
	
	private JButton back_button;
    private JButton fav_button;
	
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JLabel lb4;
	
	private JLabel description;
	private JLabel temp;
	private JLabel humidity;
	private JLabel wind_speed;

	public City(String city, String description, double temp, long humidity, double wind_speed, double lat,
			double lon) {

		// adjust size and set layout
		frame.setPreferredSize(new Dimension(566, 565));
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#26292E"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Weather App");
		frame.setVisible(true);
		frame.pack();

		// construct components
		logo_label = new JLabel(new ImageIcon("C:\\Users\\PACHECOC\\Desktop\\Java\\Weather App\\src\\weather-icon.png"));
		city_label = new JLabel("City:");
		city_name = new JLabel(" " +city);
		data_panel = new JPanel();
		map_panel = new JPanel();
		logo_panel = new JPanel();
		back_button = new JButton("Back");
		fav_button = new JButton("Add to favorites");
		favData = new FavoritenData();
		
		lb1 = new JLabel("   Description:");
		lb1.setForeground(Color.white);
		
		lb2 = new JLabel("   Temperatur:");
		lb2.setForeground(Color.white);
		
		lb3 = new JLabel("   Humidity:");
		lb3.setForeground(Color.white);
		
		lb4 = new JLabel("   Wind speed:");
		lb4.setForeground(Color.white);
		
		this.description = new JLabel();
		this.description.setForeground(Color.white);
		
		this.temp = new JLabel();
		this.temp.setForeground(Color.white);
		
		this.humidity = new JLabel();
		this.humidity.setForeground(Color.white);
		
		this.wind_speed = new JLabel();
		this.wind_speed.setForeground(Color.white);
		
		
		this.description.setText(description);
		this.temp.setText(temp + " °C" );
		this.humidity.setText(humidity + "%");
		this.wind_speed.setText(wind_speed + "m/h");

		// add components
		
		frame.add(logo_panel);
		frame.add(city_label);
		frame.add(city_name);
		frame.add(data_panel);
		frame.add(map_panel);
		frame.add(back_button);
		frame.add(fav_button);
		map_panel.add(mpp = new Map(lat, lon));
		
		logo_panel.setLayout(new FlowLayout());
		logo_panel.add(logo_label);
		
		logo_panel.setBackground(Color.decode("#26292E"));
		
		city_name.setFont(new Font("SansSerif", Font.BOLD, 30));
		city_name.setForeground(Color.white);
		
		city_label.setForeground(Color.white);
		
		city_name.setBorder(new LineBorder(Color.white));
		
		back_button.setBackground(Color.decode("#E68947"));
		back_button.setBorder(new LineBorder(Color.decode("#E68947")));
		back_button.addActionListener(this);
		back_button.setFont(new Font("SansSerif", Font.BOLD, 12));
		back_button.setForeground(Color.white);
		
		fav_button.setBackground(Color.decode("#E68947"));
		fav_button.setBorder(new LineBorder(Color.decode("#E68947")));
		fav_button.addActionListener(this);
		fav_button.setFont(new Font("SansSerif", Font.BOLD, 12));
		fav_button.setForeground(Color.white);
		
		data_panel.setLayout(new GridLayout(6,2));
		data_panel.setBackground(Color.black);
		data_panel.setBorder(new LineBorder(Color.white));
		
		data_panel.add(lb1);
		data_panel.add(this.description);
		data_panel.add(lb2);
		data_panel.add(this.temp);
		data_panel.add(lb3);
		data_panel.add(this.humidity);
		data_panel.add(lb4);
		data_panel.add(this.wind_speed);
		
		map_panel.setBorder(new LineBorder(Color.white));
		
		

		// set component bounds (only needed by Absolute Positioning)
		city_label.setBounds(42, 170, 100, 25);
		logo_panel.setBounds(35, 25, 145, 100);
		city_name.setBounds(40, 195, 480, 55);
		data_panel.setBounds(40, 260, 480, 195);
		map_panel.setBounds(340, 30, 180, 150);
		back_button.setBounds (50, 470, 95, 25);
	    fav_button.setBounds(160, 470, 95, 25);
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back_button) {
			frame.dispose();
		}else if (e.getSource() == fav_button) {
			
		}
	}

}
