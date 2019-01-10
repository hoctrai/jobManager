package com.tma.jobmanager.tree;

import java.util.List;

import com.tma.jobmanager.target.CategoryJob;

public class TreeCategory {
	private TreeNode m_treeCategory = new TreeNode("Category");
	
	private int m_index;
	
	public TreeCategory(){
		
	}
	public TreeNode treeCategory(TreeNode root){
		for(int i = 0; i < root.getChildren().size()-1; i++){
			int j = 0;
			List<CategoryJob> listCategory = root.getChildren().get(i).getTarget().getListCategoryJobs();
			
			while(listCategory.size() > j){
				for(int k = 0; k < 3; k++)
				if(!listCategory.get(j).getState()[k].getStatus().equals("")){
					
					CategoryJob job = listCategory.get(j);
					TreeNode node = root.getChildren().get(i);
					
					if(checkCategory(job) == true)
						m_treeCategory.getChildren().get(m_index).addChild(node);
					
					else {
						m_treeCategory.addChild(new TreeNode(job.getName().substring(4,job.getName().length()-5)));
						m_treeCategory.getChildren().get(m_treeCategory.getChildren().size()-1).addChild(node);
						
					}
				}
				j++;
			}
		}
		return m_treeCategory;
		
	}
	
	public boolean checkCategory(CategoryJob job){
		for(m_index = 0; m_index < m_treeCategory.getChildren().size(); m_index++){
			if(!m_treeCategory.getChildren().isEmpty() && m_treeCategory.getChildren().get(m_index).getName().equals(job.getName().substring(4, job.getName().length()-5))){
				return true;
				
			}
		}
		return false;
		
	}
	
	public TreeNode find(String string){
		
		for( int i = 0; i < m_treeCategory.getChildren().size(); i++){
			if(string.equals(m_treeCategory.getChildren().get(i).getName())){
				
				return m_treeCategory.getChildren().get(i);
			}
		}
		return m_treeCategory;
	}
	
	public TreeNode getCategory() {
		return m_treeCategory;
	}
	public void setCategory(TreeNode Category) {
		this.m_treeCategory = Category;
	}
	
	
}
