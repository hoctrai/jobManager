package treeView;

public class ArrangementTree {
	private TreeNode m_root;
	public ArrangementTree() {
		m_root = new TreeNode("root");
	}
	
	public void sortTree(TreeNode root){
		TreeNode node = new TreeNode("TreeRoot");
		while(root.getChildren().size()>0){
			node.addChild(root.getChildren().get(0));
			int index = 0;
		
			for(int i = 1; i < root.getChildren().size(); i++){
				if(node.getChildren().get(node.getChildren().size()-1).getId() > root.getChildren().get(i).getId()){
					node.getChildren().remove(node.getChildren().size()-1);
					node.getChildren().add(root.getChildren().get(i));
					index = i;
					
				}
			}
			root.getChildren().remove(index);
			
		}
		m_root = node;
	}

	public TreeNode getRoot() {
		return m_root;
	}

	public void setRoot(TreeNode root) {
		this.m_root = root;
	}
	
}
