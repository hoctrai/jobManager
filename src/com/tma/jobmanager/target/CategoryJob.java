package com.tma.jobmanager.target;

public class CategoryJob{
	private String m_name;
	private Planned m_planned;
	private Ongoing m_ongoing;
	private Started m_stared;
	
	public CategoryJob(String name) {
		this.m_name = name;
		this.m_planned = null;
		this.m_ongoing = null;
		this.m_stared = null;
	}
	public String getName() {
		return m_name;
	}
	public void setName(String name) {
		this.m_name = name;
	}
	public Planned getPlanned() {
		return m_planned;
	}
	public void setPlanned(Planned m_planned) {
		this.m_planned = m_planned;
	}
	public Ongoing getOngoing() {
		return m_ongoing;
	}
	public void setOngoing(Ongoing m_ongoing) {
		this.m_ongoing = m_ongoing;
	}
	public Started getStarted() {
		return m_stared;
	}
	public void setStarted(Started m_stared) {
		this.m_stared = m_stared;
	}
	
}
