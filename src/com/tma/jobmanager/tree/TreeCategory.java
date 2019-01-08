package com.tma.jobmanager.tree;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import com.tma.jobmanager.target.CategoryJob;



public class TreeCategory {
	TreeNode m_Category = new TreeNode("Category");
	TreeNode m_node;
	int m_index;
	
	public TreeCategory(){
		
	}
	public TreeNode treeCategory(TreeNode root){
		for(int i = 0; i < root.getChildren().size()-1; i++){
			int j = 0;
			while(root.getChildren().get(i).getTarget().getListCategoryJobs().size() > j){
				if(root.getChildren().get(i).getTarget().getListCategoryJobs().get(j).getPlanned().getStrPlan().size() > 0 | root.getChildren().get(i).
						getTarget().getListCategoryJobs().get(j).getOngoing().getStrOngoing().size()>0 | root.getChildren().get(i).getTarget().getListCategoryJobs().
						get(j).getStared().getStrStarter().size()>0){
					CategoryJob job = root.getChildren().get(i).getTarget().getListCategoryJobs().get(j);
					m_node = root.getChildren().get(i);
					if(checkCategory(job) == true)
						m_Category.getChildren().get(m_index).addChild(m_node);
					else {
						m_Category.addChild(new TreeNode(job.getName().substring(4,job.getName().length()-5)));
						m_Category.getChildren().get(m_Category.getChildren().size()-1).addChild(m_node);
					}
						
					
				}
				j++;
			}
		}
		return m_Category;
		
	}
	
	public boolean checkCategory(CategoryJob job){
		for(m_index = 0; m_index < m_Category.getChildren().size(); m_index++){
			if(!m_Category.getChildren().isEmpty() && m_Category.getChildren().get(m_index).getName().equals(job.getName().substring(4, job.getName().length()-5))){
				return true;
			}
		}
		return false;
	}
	
	public  TreeViewer createTreeViewer(TreeViewer viewer, String string) {
		
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
		viewer.setInput(find(string));
		return viewer;
	}
	
	public TreeNode find(String string){
		System.out.println("TreeCategory row 78 	" + m_Category.getChildren().size());
		for( int i = 0; i < m_Category.getChildren().size(); i++){
			System.out.println("TreeCategory row:	 80 	");
			if(string.equals(m_Category.getChildren().get(i).getName())){
				return m_Category.getChildren().get(i);
			}
		}
		return m_Category;
	}
	public TreeNode getCategory() {
		return m_Category;
	}
	public void setCategory(TreeNode Category) {
		this.m_Category = Category;
	}
	
	
}
