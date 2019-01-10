package com.tma.jobmanager.tree;

import java.util.List;

import com.tma.jobmanager.target.CategoryJob;
import com.tma.jobmanager.target.Target;

public class FilterWorkedPool implements FilterStates{
	
	private TreeNode m_root = new TreeNode("root");
	
	public FilterWorkedPool(){
		
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
					String status = categoryJob.getState()[1].getStatus();
					if (status.equals("ongoing")) {
						
						node = root.getChildren().get(i);
						this.m_root.addChild(node);
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m_root;
		
	}

	public TreeNode getRoot() {
		return m_root;
	}
	
	
}
