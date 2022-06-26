package GUI;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Logik.API_objects;
import Logik.Root;
import Logik.api_call;
import interfaces.WeatherApp;

public class Menu implements ActionListener {

	// JFrame wird initialisiert.
	JFrame frame = new JFrame();

	// Variablen werden instaziert.
	private JLabel logo_label;
	private JTextField txt_input;
	private JButton search_button;
	private JButton favorite_button;
	private JButton switzerland_button;
	private JLabel search_label;
	private JPanel logo_panel;

	public Menu() {

		// Variablen werden initialisiert.
		logo_label = new JLabel(new ImageIcon("src\\weather-icon.gif"));
		txt_input = new JTextField();
		search_button = new JButton("Search");
		favorite_button = new JButton("Favorites List");
		switzerland_button = new JButton("Switzerland List");
		search_label = new JLabel("Search for a city:");
		logo_panel = new JPanel();

		// JFrame Eingenschaften werden angepasst z.Bs. Grösse, Breite, Titel usw..
		frame.setPreferredSize(new Dimension(566, 565));
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#26292E"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Weather App");
		frame.setVisible(true);
		frame.pack();

		// Komponenten werden zum Frame hinzugefügt.
		frame.add(logo_panel);
		frame.add(txt_input);
		frame.add(search_button);
		frame.add(favorite_button);
		frame.add(switzerland_button);
		frame.add(search_label);

		// Die Eigenschaften der Komponenten werden angepasst.
		logo_panel.setBounds(35, 25, 145, 100);
		logo_panel.setForeground(Color.white);

		txt_input.setBounds(40, 185, 375, 25);
		txt_input.setBorder(new LineBorder(Color.white));

		search_button.setBackground(Color.decode("#E68947"));
		search_button.setBorder(new LineBorder(Color.decode("#E68947")));
		search_button.setBounds(425, 185, 90, 25);
		search_button.addActionListener(this);
		search_button.setFont(new Font("SansSerif", Font.BOLD, 12));
		search_button.setForeground(Color.white);

		favorite_button.setBackground(Color.decode("#616161"));
		favorite_button.setBorder(new LineBorder(Color.decode("#E68947")));
		favorite_button.setBounds(55, 280, 200, 175);
		favorite_button.setFont(new Font("SansSerif", Font.BOLD, 22));
		favorite_button.setForeground(Color.white);
		favorite_button.addActionListener(this);

		switzerland_button.setBackground(Color.decode("#616161"));
		switzerland_button.setBorder(new LineBorder(Color.decode("#E68947")));
		switzerland_button.setBounds(305, 280, 200, 175);
		switzerland_button.setFont(new Font("SansSerif", Font.BOLD, 22));
		switzerland_button.setForeground(Color.white);
		switzerland_button.addActionListener(this);

		search_label.setBounds(40, 155, 100, 25);
		search_label.setForeground(Color.white);

		logo_panel.setLayout(new FlowLayout());
		logo_panel.setBackground(Color.decode("#26292E"));
		logo_panel.add(logo_label);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Aktion bei Button klick.
		if (e.getSource() == search_button) {
			/*City GUI Objekt wird instanziert und WeatherApp Interface wird aufgerufen auf die API_objects Klasse wo
			wo die Methoden hinterlegt sind. */
			City city;
			WeatherApp wa = new API_objects();
			/* Die getWeather Methode holt die Infos vom API und speichert diese in die rootVariable.
			 * Die Root Klasse wird als Haptklasse für die verarbeitung der Daten benützt. Da drin 
			 * befinden sich Objekte von den anderen Klassen wie z.Bs. Coord, Weather oder Wind.*/
			Root rootVariable = wa.getWeather(txt_input.getText());
			
			//überprüft ob man den Namen zurück bekommt.
			if (rootVariable.getName() == null) {
				JOptionPane.showMessageDialog(frame, "The City you are searching for, could not be found. ",
						"Search error", JOptionPane.WARNING_MESSAGE);
			} else
				
				/*City Objekt wird initialisiert und als Parameter werden die Daten von der der rootVariable mitgegeben.*/
				city = new City(rootVariable.getName(), rootVariable.getWeather().get(0).getDescription(),
						rootVariable.getMain().getTemp(), rootVariable.getMain().getHumidity(),
						rootVariable.getWind().getSpeed(), rootVariable.getCoord().getLat(),
						rootVariable.getCoord().getLon());

		} else if (e.getSource() == favorite_button) {
			Favorites fav = new Favorites();
		} else if (e.getSource() == switzerland_button) {
			Switzerland sw = new Switzerland();
		}
	}

}