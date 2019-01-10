package com.tma.jobmanager.tree;

import java.util.List;

import com.tma.jobmanager.target.CategoryJob;
import com.tma.jobmanager.target.Target;

public class FilterExecutionWorker implements FilterStates {

	private TreeNode m_root = new TreeNode("root");
	public FilterExecutionWorker(){
		
	}
	
	@Override
	public TreeNode filter(TreeNode root) {
		TreeNode node = new TreeNode("");
		try {
			for (int i = 0; i < root.getChildren().size() - 1; i++) {
				Target target = root.getChildren().get(i).getTarget();
				
				List<CategoryJob> listCategoryJobs = target.getListCategoryJobs();
				for (int j = 0; j < listCategoryJobs.size() ; j++) {
					
					CategoryJob categoryJob = listCategoryJobs.get(j);
					String status = categoryJob.getState()[2].getStatus();
					if (status.equalsIgnoreCase("started")) {
						
						node = root.getChildren().get(i);
						this.m_root.addChild(node);
						break;
					}
				}
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
		return m_root;
	}

	public TreeNode getRoot() {
		return m_root;
	}

	public void setM_root(TreeNode root) {
		this.m_root = root;
	}
	
}
