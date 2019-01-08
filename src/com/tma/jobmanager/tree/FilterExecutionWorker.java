package com.tma.jobmanager.tree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import com.tma.jobmanager.target.CategoryJob;

public class FilterExecutionWorker {
	List<String> m_categoryJobs = new ArrayList<>();
	private TreeNode m_root = new TreeNode("root");
	public FilterExecutionWorker(){
		
	}
	
	public TreeViewer createTreeViewer(TreeViewer viewer, FilterFree  filterFree) {
		
		viewer.setContentProvider(new ITreeContentProvider() {
			public Object[] getChildren(Object parentElement) {
				return ((TreeNode) parentElement).getChildren().toArray();
			}
			public Object getParent(Object element) {
		    	return ((TreeNode) element).getParent();
			}
			public boolean hasChildren(Object element) {
				return ((TreeNode) element).getChildren().size() > 0;
			}
			public Object[] getElements(Object inputElement) {
				return ((TreeNode) inputElement).getChildren().toArray();
			}
			public void dispose() {
			}
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
		      }
	    });
		filter(filterFree.m_root);
		viewer.setInput(m_root);
		return viewer;
		
	}

	public TreeNode filter(TreeNode root) {
		TreeNode node = new TreeNode("");
		try{
			for(int i = 0; i < root.getChildren().size()-1; i++) {
				int n = root.getChildren().get(i).getTarget().getListCategoryJobs().size();
				if(n > 0) {
					for(int j = 0; j < n; j++) {
						CategoryJob categoryJob = root.getChildren().get(i).getTarget()
								.getListCategoryJobs().get(j);
						if(categoryJob.getStared().getStrStarter().size()>0) {
							System.out.println("FilterExecutionWorker   "+ categoryJob.getStared().getStrStarter().get(0));
							node = root.getChildren().get(i);
							this.m_root.addChild(node);
							
						}
					}
				}
			}
		}catch (Exception e) {
			
		}
		return m_root;
	}

	public TreeNode getRoot() {
		return m_root;
	}

	public TreeNode getM_root() {
		return m_root;
	}

	public void setM_root(TreeNode m_root) {
		this.m_root = m_root;
	}
	
}
