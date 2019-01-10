package com.tma.jobmanager.target;

import java.util.ArrayList;
import java.util.List;

public class Started extends States{
	
	private String strStatus;
	private List<String> m_strData;

	public Started() {
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
	public void addData(String strStarter) {
		this.m_strData.add(strStarter);
	}
	@Override
	public void setListData(List<String> listData){
		this.m_strData = listData;
	}
}
