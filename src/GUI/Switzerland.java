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
import javax.swing.border.LineBorder;

import Data.FavoritenData;
import Logik.API_objects;
import Logik.Root;
import interfaces.WeatherApp;

@SuppressWarnings("serial")
public class Switzerland extends JFrame  implements ActionListener {

	JFrame frame = new JFrame();
	
	FavoritenData favData;
	
	private JLabel logo_label;
	private JPanel data_panel;
	private JPanel logo_panel;
	private JLabel switzerland_label;
	
	private JButton back_button;
    private JButton remove_button;
    private JButton open_button;
    

	public Switzerland() {

		// adjust size and set layout
		frame.setPreferredSize(new Dimension(567, 565));
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#26292E"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Weather App");
		frame.setVisible(true);
		frame.pack();

		// construct components
		logo_label = new JLabel(
				new ImageIcon("src\\\\weather-icon.gif"));
		data_panel = new JPanel();
		logo_panel = new JPanel();
		switzerland_label = new JLabel("Switzerland list:");
		
		back_button = new JButton("Back");
		remove_button = new JButton("Remove");
		open_button = new JButton("Open");
		
		favData = new FavoritenData();
		
		
		// add components

		frame.add(logo_panel);
		frame.add(data_panel);
		frame.add(switzerland_label);
		frame.add(back_button);
		frame.add(remove_button);
		frame.add(open_button);
		
		

		logo_panel.setLayout(new FlowLayout());
		logo_panel.add(logo_label);

		logo_panel.setBackground(Color.decode("#26292E"));

		favData.list.setModel(favData.flm);
		
		favData.flm.addElement("Basel");
		favData.flm.addElement("Lausanne");
		favData.flm.addElement("Zürich");
		favData.flm.addElement("Luzern");
		favData.flm.addElement("Genf");
		favData.flm.addElement("Bern");
		favData.flm.addElement("Sion");
		favData.flm.addElement("Ticino");
		favData.flm.addElement("Biel");
		favData.flm.addElement("Thun");
		
		data_panel.setBorder(new LineBorder(Color.white));
		data_panel.setLayout(new BorderLayout());
		data_panel.add(favData.list, BorderLayout.CENTER);
		favData.list.setForeground(Color.black);
		
		
		switzerland_label.setForeground(Color.white);
		
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
		
		
		// set component bounds (only needed by Absolute Positioning)
		logo_panel.setBounds(35, 25, 145, 100);
		switzerland_label.setBounds(42, 180, 100, 25);
		data_panel.setBounds(40, 205, 480, 250);
		back_button.setBounds (50, 470, 95, 25);
	    remove_button.setBounds(160, 470, 98, 25);
	    open_button.setBounds(425, 470, 95, 25);
	    

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== back_button) {
			frame.dispose();
	} else if (e.getSource() == open_button) {
		/*City GUI Objekt wird instanziert und WeatherApp Interface wird aufgerufen auf die API_objects Klasse wo
		wo die Methoden hinterlegt sind. */
		City city;
		int index = favData.list.getSelectedIndex();
		WeatherApp wa1 = new API_objects();
		/* Die getWeather Methode holt die Infos vom API und speichert diese in die rootVariable.
		 * Die Root Klasse wird als Haptklasse für die verarbeitung der Daten benützt. Da drin 
		 * befinden sich Objekte von den anderen Klassen wie z.Bs. Coord, Weather oder Wind.*/
		Root rootVariable = wa1.getWeather(favData.flm.get(index));
		city = new City(rootVariable.getName(), rootVariable.getWeather().get(0).getDescription(),
				rootVariable.getMain().getTemp(), rootVariable.getMain().getHumidity(),
				rootVariable.getWind().getSpeed(), rootVariable.getCoord().getLat(),
				rootVariable.getCoord().getLon());

	}
	}
}
