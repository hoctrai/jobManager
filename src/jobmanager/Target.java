package jobmanager;

import java.util.ArrayList;
import java.util.List;

public class Target {
	

	private String m_name;
	private  int m_intTimerTasks;
	private String m_srtTimerTasks;
	private List<CategoryJob> listCategoryJobs;
	private String m_jobsPerJobFamily;
	
	public Target(String name) {
		this.m_name = name;
		listCategoryJobs = new ArrayList<>();
		m_jobsPerJobFamily = "";
	}
	
	public String getName() {
		return m_name;
	}
	public void setName(String name){
		this.m_name = name;
	}
	
	
	public void addListCategoryJobs(CategoryJob categoryJob){
		listCategoryJobs.add(categoryJob);
	}
	
	public List<CategoryJob> getListCategoryJobs() {
		return listCategoryJobs;
	}
	
	public void setListCategoryJobs(List<CategoryJob> listCategoryJobs) {
		this.listCategoryJobs = listCategoryJobs;
	}
	
	public int getTimerTasks() {
		return m_intTimerTasks;
	}

	public void setTimerTasks(int timerTasks) {
		this.m_intTimerTasks = timerTasks;
	}
	public String getStrTimerTasks() {
		return m_srtTimerTasks;
	}

	public void setStrTimerTasks(String timerTasks) {
		this.m_srtTimerTasks = timerTasks;
	}
	
	public String getJobsPerJobFamily() {
		return m_jobsPerJobFamily;
	}

	public void setJobsPerJobFamily(String jobsPerJobFamily) {
		this.m_jobsPerJobFamily = jobsPerJobFamily;
	}
	
	
	public String toString(){
		String strTarget = m_name + ": TimeTasks = " + m_intTimerTasks + "; "  + m_srtTimerTasks;
		return strTarget;
		
	}
	
}
