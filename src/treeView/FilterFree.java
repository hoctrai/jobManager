package treeView;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabItem;

import jobmanager.OpenFile;

public class FilterFree {

	ArrangementTree arrangementTree = new ArrangementTree();
	TreeNode m_root;
	//private TreeViewer viewer;
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
		
		viewer.setInput(getRootNode(shell));
		
		return viewer;
		//return null;
		
	}
	
	private TreeNode getRootNode(Shell shell){
	
		m_root = new TreeNode("rootNode");
		m_openFile.diagogOpenFile(shell);
		if(m_openFile.getM_path()!=null)
			m_root = m_openFile.getTargets();
		System.out.println("FilterFree   at here"+ m_root.getChildren().size());
		return m_root;
		
	}
	public TabItem createTreeViewer( Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}
	public TreeNode getRoot() {
		return m_root;
	}
	public void setRoot(TreeNode root) {
		this.m_root = root;
	}
	

}
