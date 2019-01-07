package treeView;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import jobmanager.CategoryJob;

public class FilterExecutionWorker {
	List<String> m_categoryJobs = new ArrayList<>();
	TreeNode m_root = new TreeNode("root");
	public FilterExecutionWorker(){
		
	}
	
	public TreeViewer createTreeViewer(TreeViewer viewer, FilterFree  filterFree) {
		//viewer = new TreeViewer(parent);
		
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
		//System.out.println("root.size=  " + root.getChildren().size());
		return viewer;
		
	}
	int k=0;

	public TreeNode filter(TreeNode root) {
		TreeNode node = new TreeNode("");
		try{
			for(int i = 0; i < root.getChildren().size()-1; i++) {
				//System.out.println("a	"+root.getChildren().get(i).getName()+"  "+root.getChildren().get(i).getTarget().getListCategoryJobs().size());
				int n = root.getChildren().get(i).getTarget().getListCategoryJobs().size();
				if(n > 0) {
					for(int j = 0; j < n; j++) {
						
						CategoryJob categoryJob = root.getChildren().get(i).getTarget()
								.getListCategoryJobs().get(j);
						if(categoryJob.getStared().getStrStarter().size()>0) {
							System.out.println("FilterExecutionWorker   "+ categoryJob.getStared().getStrStarter().get(0));
							node = root.getChildren().get(i);
							this.m_root.addChild(node);
							
//							if(setCategory(categoryJob.getName())==true);
//							m_categoryJobs.add(categoryJob.getName());
						}
					}
				}
			}
		}catch (Exception e) {
			
		}
		
		return m_root;
	}
//	public boolean setCategory(String categoryJob){
//		for(int i = 0; i < m_categoryJobs.size(); i++){
//			if(m_categoryJobs.get(i).equals(categoryJob))
//				return false;
//		}
//			
//		return true;
//		
//	}

	public TreeNode getRoot() {
		// TODO Auto-generated method stub
		return m_root;
	}
}