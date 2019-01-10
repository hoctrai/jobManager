package com.tma.jobmanager.target;

import java.util.List;
import java.util.ArrayList;

public class Planned extends States {

	private List<String> m_strData ;
	private String strStatus;
	
	public Planned() {
		this.strStatus = "";
		this.m_strData = new ArrayList<>();
		
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
