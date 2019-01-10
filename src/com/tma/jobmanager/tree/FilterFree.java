package com.tma.jobmanager.tree;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabItem;

import com.tma.jobmanager.target.OpenFile;

public class FilterFree {

	ArrangementTree arrangementTree = new ArrangementTree();
	TreeNode m_root;
	OpenFile m_openFile = new OpenFile();
	
	public FilterFree() {
	
	}
	public TreeViewer createTreeViewer(TreeViewer viewer,Shell shell) {
		
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
		m_root = arrangementTree.sortTree(getRootNode(shell));
		
		viewer.setInput(m_root);
		
		return viewer;
		
	}
	
	private TreeNode getRootNode(Shell shell){
	
		TreeNode root = new TreeNode("");
		m_openFile.diagogOpenFile(shell);
		if(m_openFile.getPath()!=null)
			root = m_openFile.getTargets();
		return root;
		
	}
	public TabItem createTreeViewer( Shell shell) {
		return null;
	}
	public TreeNode getRoot() {
		return m_root;
	}
	public void setRoot(TreeNode root) {
		this.m_root = root;
	}
	

}
