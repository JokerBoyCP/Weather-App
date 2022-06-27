package Data;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class SwitzerlandData {

	public JList<String> list = new JList<>();
	public DefaultListModel<String> flm = new DefaultListModel<>();
	
	
	
	
	public JList<String> getList() {
		return list;
	}
	public void setList(JList<String> list) {
		this.list = list;
	}
	public DefaultListModel<String> getFlm() {
		return flm;
	}
	public void setFlm(DefaultListModel<String> flm) {
		this.flm = flm;
	}

}
