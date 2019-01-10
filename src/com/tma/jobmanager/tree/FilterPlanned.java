package com.tma.jobmanager.tree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;

import com.tma.jobmanager.target.CategoryJob;
import com.tma.jobmanager.target.Target;

public class FilterPlanned implements FilterStates{
	TreeViewer viewer;
	List<String> m_categoryJobs = new ArrayList<>();
	TreeNode m_root = new TreeNode("root");
	
	public FilterPlanned(){
		
	}
	
	public TreeNode filter(TreeNode root) {
		TreeNode node = new TreeNode("");
		try {
			for (int i = 0; i < root.getChildren().size() - 1; i++) {
				Target target = root.getChildren().get(i).getTarget();
				
				List<CategoryJob> listCategoryJobs = target.getListCategoryJobs();
				for (int j = 0; j < listCategoryJobs.size() ; j++) {
					
					CategoryJob categoryJob = listCategoryJobs.get(j);
					String status = categoryJob.getPlanned().getStatus();
					if (status.equals("Planned")) {
						
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
	
	public TreeNode getRoot(){
		return m_root;
	}
	
	public void setRoot(TreeNode root) {
		this.m_root = root;
	}
}
