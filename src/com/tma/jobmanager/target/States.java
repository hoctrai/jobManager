package com.tma.jobmanager.target;

import java.util.List;

public abstract class States {

	public abstract String getStatus();
	public abstract void setStatus(String status);
	
	public abstract List<String> getListData();
	public abstract void addData(String str);
	public abstract void  setListData(List<String> listData);
}
