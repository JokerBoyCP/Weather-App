package Logik;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Map extends JPanel {

	String destinationFile;

	public Map (double lat, double lon) {

		

		try {
			String latitude = String.valueOf(lat);
			String longitude = String.valueOf(lon);

			String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" + latitude + "," + longitude
					+ "&zoom=10&size=200x150&scale=2&key=AIzaSyCNTWV2mOf9M9iHrHLs-R5G4JCaiRMYons";
			String destinationFile = "image.jpg";

			// Liest das Kartenbild von Google und
			// speichert es in einer lokalen Datei : image.jpg
			//
			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(destinationFile);
			
			
			
			byte[] b = new byte[2048];
			int length;

			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}

			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		// ein GUI-Komponent wird erstellt, welcher das Bild lädt: image.jpg
		//
		
		ImageIcon imageIcon = new ImageIcon(
				(new ImageIcon("image.jpg")).getImage().getScaledInstance(200, 150, WHEN_FOCUSED));
		add(new JLabel(imageIcon));
		

	
	}
}
