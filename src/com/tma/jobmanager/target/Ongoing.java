package com.tma.jobmanager.target;

import java.util.ArrayList;
import java.util.List;

public class Ongoing {
	private List<String> strOngoing;
	public Ongoing() {
		strOngoing = new ArrayList<>();
	}
	
	public List<String> getStrOngoing() {
		return strOngoing;
	}

	public void setStrOngoing(String strOngoing) {
		this.strOngoing.add(strOngoing);
	}
	
}
