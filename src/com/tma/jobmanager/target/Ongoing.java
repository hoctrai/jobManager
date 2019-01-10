package com.tma.jobmanager.target;

import java.util.ArrayList;
import java.util.List;

public class Ongoing extends States {
	private String strStatus;
	private List<String> m_strData;
	
	public Ongoing() {
		strStatus="";
		m_strData = new ArrayList<>();
	}
	
	@Override
	public String getStatus() {
		return strStatus;
	}
	@Override
	public void setStatus(String status) {
		this.strStatus = status;
	}

	@Override
	public List<String> getListData() {
		return m_strData;
	}
	@Override
	public void addData(String strOngoing) {
		this.m_strData.add(strOngoing);
	}
	@Override
	public void  setListData(List<String> listData){
		this.m_strData = listData;
	}

}
