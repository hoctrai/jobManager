package com.tma.jobmanager.target;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.tma.jobmanager.tree.TreeNode;

public class OpenFile {
	
	private String m_path=null;
	
	private FileInputStream m_in;
	private BufferedReader m_inp;
	
	private Queue<String> m_stringQueue;
	private TreeNode m_targets;
	
	public void diagogOpenFile(Shell shell){
		FileDialog dialog= new FileDialog(shell);
		 m_path=dialog.open();
		 if(m_path!=null)
			 readFile( );
	}
	
	public String getPath() {
		return m_path;
	}
	
	public void setPath(String path){
		this.m_path = path;
	}
	
	public Queue<String> getM_stringQueue() {
		return m_stringQueue;
	}

	public void setM_stringQueue(Queue<String> stringQueue) {
		this.m_stringQueue = stringQueue;
	}
	
	public TreeNode getTargets() {
		return m_targets;
	}

	public void setTargets(TreeNode targets) {
		this.m_targets = targets;
	}

	/*Read file return value Node*/
	public void readFile(){
		
		String line;
		m_stringQueue = new LinkedList<String>();
		try {
			 m_in = new FileInputStream(m_path);
			 m_inp = new BufferedReader(new InputStreamReader(m_in));
			try {
				m_targets = new TreeNode("Targets:");
				while((line = m_inp.readLine()) != null){
					
					addQueue(line);
					m_targets.addChild(Branch( ));
				}
			m_in.close();
			m_inp.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*add Strings in tail of Queue*/
	private void addQueue (String line){
		while(!line.equals("")){
			m_stringQueue.add(line);
			try {
				line = m_inp.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**Convert from Queue to Tree
	 * Model is:
	 * 	<h1>...</h1>
	 * 		<h2>...</h2>
	 * 			<h3>...</h3>
	 * 		<h2>...</h2>
	 *			<h3>...</h3>*/
	private TreeNode Branch (  ) {
		TreeNode parent = null;
		
		while(!m_stringQueue.isEmpty()){
			
			if(m_stringQueue.peek().substring(0, 4).equals("<h1>")) {
				Target target = new Target(m_stringQueue.peek());
				String strParent = m_stringQueue.peek().substring(4, m_stringQueue.peek().length()-5);
				parent = new TreeNode(strParent);
				parent.setTarget(target);
				parent.setId(Integer.parseInt(strParent.replaceAll("Target: ", "")));
				m_stringQueue.remove();
				
			}else if(m_stringQueue.peek().substring(0, 4).equals("<h2>")) {
				
				if(parent!=null){
					if(m_stringQueue.peek().substring(4, 20).equals("jobsPerJobFamily")){
						m_stringQueue.remove();
						parent.getTarget().setJobsPerJobFamily(m_stringQueue.peek());
						
					}
					else
					parent.getTarget().addListCategoryJobs(new CategoryJob(m_stringQueue.peek()));
					
				}
				else{
					parent = new TreeNode(m_stringQueue.peek().substring(4, m_stringQueue.peek().length()-5));
				}
				
				m_stringQueue.remove();
				
			}else if(m_stringQueue.peek().substring(0, 4).equals("<h3>") && parent!=null) {
				
				if(m_stringQueue.peek().substring(4, m_stringQueue.peek().length()-5).equals("Planned")){
					Planned planned = new Planned();
//					parent.getTarget().getListCategoryJobs().get(parent.getTarget().getListCategoryJobs().size()-1).setPlanned(planned);
					m_stringQueue.remove();
					
					while(!m_stringQueue.peek().substring(0, 4).equals("<h3>")){
						planned.setStatus("Planned");
						//parent.getTarget().getListCategoryJobs().get(parent.getTarget().getListCategoryJobs().size()-1).getPlanned().setStrPlan(m_stringQueue.peek());
						planned.setStrPlan(m_stringQueue.peek());
						m_stringQueue.remove();
							
					}
					parent.getTarget().getListCategoryJobs().get(parent.getTarget().getListCategoryJobs().size()-1).setPlanned(planned);
				}
				
				else if(m_stringQueue.peek().substring(4, m_stringQueue.peek().length()-5).equals("Ongoing")) {
					Ongoing ongoing = new Ongoing();
					//parent.getTarget().getListCategoryJobs().get(parent.getTarget().getListCategoryJobs().size()-1).setOngoing(ongoing);
					m_stringQueue.remove();
					
					while(!m_stringQueue.peek().substring(0, 4).equals("<h3>")) {
						ongoing.setStatus("ongoing");
						ongoing.setStrOngoing(m_stringQueue.peek());
						//parent.getTarget().getListCategoryJobs().get(parent.getTarget().getListCategoryJobs().size()-1).getOngoing().setStrOngoing(m_stringQueue.peek());
						m_stringQueue.remove();
					}
					parent.getTarget().getListCategoryJobs().get(parent.getTarget().getListCategoryJobs().size()-1).setOngoing(ongoing);
				}
				
				else if(m_stringQueue.peek().substring(4, m_stringQueue.peek().length()-5).equals("Started")) {
					Started started = new Started();
					parent.getTarget().getListCategoryJobs().get(parent.getTarget().getListCategoryJobs().size()-1).setStarted(started);
					m_stringQueue.remove();

				}
				
				
			}else {				
				if(m_stringQueue.peek().substring(0,5).equals("Timer")){
					
					try {
						parent.getTarget().setTimerTasks(Integer.parseInt(m_stringQueue.peek().substring(13,m_stringQueue.peek().length())));
					} catch (NumberFormatException e) {
						parent.getTarget().setStrTimerTasks(m_stringQueue.peek().substring(13,m_stringQueue.peek().length()));
					}
					m_stringQueue.remove();
				
				}else if(m_stringQueue.peek().substring(0,7).equals("Managed")){
					try{
						parent.addStrJobs(m_stringQueue.peek());
					}catch (Exception e) {
						e.printStackTrace();
					}
					m_stringQueue.remove();
				}
				else{
					try{
						
						int i = parent.getTarget().getListCategoryJobs().size()-1;
						parent.getTarget().getListCategoryJobs().get(i).getStarted().setStrStarter(m_stringQueue.peek());
						parent.getTarget().getListCategoryJobs().get(i).getStarted().setStatus("started");
						
					}catch(Exception e){
						e.printStackTrace();
					}
					m_stringQueue.remove();}
//				
				}
			}
		return parent;
		
	}
	/*add branch in root of main Tree*/
	public void addBranch(TreeNode root ){
		root.addChild(m_targets);
	}
	
}



