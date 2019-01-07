package jobmanager;

import java.util.ArrayList;
import java.util.List;

public class Ongoing {
	private String stringOngoing;
	private List<String> strOngoing;
	public Ongoing() {
		this.stringOngoing = "";
		strOngoing = new ArrayList<>();
	}
	
	public String getStringOngoing() {
		return stringOngoing;
	}
	
	public void setStringOngoing(String stringOngoing) {
		this.stringOngoing = stringOngoing;
	}

	public List<String> getStrOngoing() {
		return strOngoing;
	}

	public void setStrOngoing(String strOngoing) {
		this.strOngoing.add(strOngoing);
	}
	
}
