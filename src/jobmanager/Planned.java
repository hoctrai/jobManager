package jobmanager;

import java.util.List;
import java.util.ArrayList;

public class Planned {
	private String m_stringPlan;
	private List<String> m_strPlan ;
	private String m_namePlan;
	public Planned(String Plan) {
		this.m_stringPlan = "";
		this.m_namePlan = Plan;
		this.m_strPlan = new ArrayList<>();
		
	}
	
	public String getStringPlan() {
		return m_stringPlan;
	}
	
	public void setStringPlan(String stringPlan) {
		this.m_stringPlan = stringPlan;
	}

	public String getNamePlan() {
		return m_namePlan;
	}

	public void setNamePlan(String namePlan) {
		this.m_namePlan = namePlan;
	}

	public List<String> getStrPlan() {
		return m_strPlan;
	}

	public void setStrPlan(String strPlan) {
		this.m_strPlan.add(strPlan);
	}
	
	
}
