package com.tma.jobmanager.tree;

public class ArrangementTree {
	//
	public ArrangementTree() {
		
	}
	
	public TreeNode sortTree(TreeNode root){
		TreeNode node = new TreeNode("TreeRoot");
		while(root.getChildren().size()>0){
			node.addChild(root.getChildren().get(0));
			int index = 0;
			
			for(int i = 1; i < root.getChildren().size()-1; i++){
				if(node.getChildren().get(node.getChildren().size()-1).getId() > root.getChildren().get(i).getId()){
					node.getChildren().remove(node.getChildren().size()-1);
					node.getChildren().add(root.getChildren().get(i));
					index = i;
					
				}
			}
			root.getChildren().remove(index);
			
		}
		return node;
	}

}
