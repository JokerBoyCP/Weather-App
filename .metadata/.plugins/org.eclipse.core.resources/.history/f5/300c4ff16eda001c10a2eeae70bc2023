package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Switzerland extends JFrame {

	JFrame frame = new JFrame();
	
	
	
	private JLabel logo_label;
	private JPanel data_panel;
	private JPanel logo_panel;
	private JLabel switzerland_label;

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
				new ImageIcon("C:\\Users\\PACHECOC\\Desktop\\Java\\Weather App\\src\\weather-icon.png"));
		data_panel = new JPanel();
		logo_panel = new JPanel();
		switzerland_label = new JLabel("Switzerland list:");
		
		
		// add components

		frame.add(logo_panel);
		frame.add(data_panel);
		frame.add(switzerland_label);
		
		

		logo_panel.setLayout(new FlowLayout());
		logo_panel.add(logo_label);

		logo_panel.setBackground(Color.decode("#26292E"));

		data_panel.setBackground(Color.black);
		data_panel.setBorder(new LineBorder(Color.white));
		
		switzerland_label.setForeground(Color.white);
		
		// set component bounds (only needed by Absolute Positioning)
		logo_panel.setBounds(35, 25, 145, 100);
		switzerland_label.setBounds(42, 180, 100, 25);
		data_panel.setBounds(40, 205, 480, 250);

	}

}
