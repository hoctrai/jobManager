package com.tma.jobmanager.target;

import java.util.ArrayList;
import java.util.List;

public class Ongoing {
	private String strStatus;
	private List<String> m_strOngoing;
	
	public Ongoing() {
		strStatus="";
		m_strOngoing = new ArrayList<>();
	}
	
	public String getStatus() {
		return strStatus;
	}
	public void setStatus(String status) {
		this.strStatus = status;
	}

	public List<String> getStrOngoing() {
		return m_strOngoing;
	}
	public void setStrOngoing(String strOngoing) {
		this.m_strOngoing.add(strOngoing);
	}
}
