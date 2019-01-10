package com.tma.jobmanager.target;

import java.util.ArrayList;
import java.util.List;

public class Started {
	
	private String strStatus;
	private List<String> m_strStarter;
	
	public Started() {
		this.strStatus = "";
		this.m_strStarter = new ArrayList<>();
	}
	
	public String getStatus() {
		return strStatus;
	}
	public void setStatus(String status) {
		this.strStatus = status;
	}

	public List<String> getStrStarter() {
		return m_strStarter;
	}
	public void setStrStarter(String strStarter) {
		this.m_strStarter.add(strStarter);
	}
}
