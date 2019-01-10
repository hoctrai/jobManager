package com.tma.jobmanager.target;

public class CategoryJob{
	private String m_name;
	private States[] m_state = {new Planned(), new Ongoing(), new Started()};
	
	public CategoryJob(String name) {
		this.m_name = name;
	}
	public String getName() {
		return m_name;
	}
	public void setName(String name) {
		this.m_name = name;
	}
	public States[] getState() {
		return m_state;
	}
	public void setArrState(States[] state) {
		this.m_state = state;
	}
	public void addState(States state,int i){
		this.m_state[i]=state;
	}

	public void test(Planned planned){
		this.m_state[0] = planned;
	}
}
