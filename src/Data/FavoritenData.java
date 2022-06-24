package Data;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class FavoritenData {

	
	public DefaultListModel<String> flm = new DefaultListModel<String>();
    public JList<String> list = new JList<>(flm);
	
	

}
