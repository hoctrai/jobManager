package com.tma.jobmanager.target;

import java.util.List;
import java.util.ArrayList;

public class Planned {

	private List<String> m_strPlan ;
	private String strStatus;
	
	public Planned() {
		this.strStatus = "";
		this.m_strPlan = new ArrayList<>();
		
	}
	
	public String getStatus() {
		return strStatus;
	}
	public void setStatus(String status) {
		this.strStatus = status;
	}

	public List<String> getStrPlan() {
		return m_strPlan;
	}
	public void setStrPlan(String strPlan) {
		this.m_strPlan.add(strPlan);
	}
}
