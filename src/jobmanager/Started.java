package jobmanager;

import java.util.ArrayList;
import java.util.List;

public class Started {
	private String stringStarter;
	private List<String> strStarter;
	public Started() {
		this.stringStarter = "";
		this.strStarter = new ArrayList<>();
	}
	
	public String getStringStarter() {
		return stringStarter;
	}
	
	public void setStringStarter(String stringStarter) {
		this.stringStarter = stringStarter;
	}

	public List<String> getStrStarter() {
		return strStarter;
	}

	public void setStrStarter(String strStarter) {
		this.strStarter.add(strStarter);
	}

	
}
