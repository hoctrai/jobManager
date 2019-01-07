package guiProject;


import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import treeView.FilterExecutionWorker;
import treeView.FilterFree;
import treeView.FilterPlanned;
import treeView.FilterWorkedPool;
import treeView.TreeCategory;
import treeView.TreeNode;

public class LeftComposite extends Composite {
	TreeNode m_root;
	
	//FilterPlanned filterPlanned  = new FilterPlanned(getShell());
	FilterFree filterFree = new FilterFree();
	FilterPlanned filterPlanned = new FilterPlanned();
	FilterWorkedPool filterWorkedPool =new FilterWorkedPool();
	FilterExecutionWorker filterExecutionWorker = new FilterExecutionWorker();
	TreeCategory treeCategory = new TreeCategory();
	
	TreeViewer m_viewer;
	
	
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	
	public LeftComposite(Composite parent, int style){
		super(parent, style);
		//populateControl();
	}
	
	public void populateControl() {
	    FillLayout compositeLayout = new FillLayout();
	    setLayout(compositeLayout);
	   // GridData gd_tabFolder = new GridData(GridData.FILL_VERTICAL);
	    
	  
			m_viewer = new TreeViewer(this,0);
			
	 }
	
	public void getFilter(String string){
		if(string.equals("open"))
			filterFree.createTreeViewer(m_viewer, getShell());
		
		else if(string.equals(""))
			m_viewer.setInput(filterFree.getRoot());
		else if(string.equals("Planned")){
			m_viewer.setInput(filterPlanned.filter(filterFree.getRoot()));
			deleteTree(filterPlanned.getRoot());
			
		}else if(string.equals("Execution")){
			m_viewer.setInput(filterExecutionWorker.filter(filterFree.getRoot()));
		deleteTree(filterExecutionWorker.getRoot());
		
		}else if(string.equals("Worked Pool")){
			m_viewer.setInput(filterWorkedPool.filter(filterFree.getRoot()));
			deleteTree(filterWorkedPool.getRoot());
		}

//		tabItem[0].setControl(filterFree.createTreeViewer(m_viewer[0],getShell()).getControl());
//		
//		tabItem[1].setControl(filterPlanned.createTreeViewer(m_viewer[1],filterFree).getControl());
//		
//		tabItem[2].setControl(filterWorkedPool.createTreeViewer(m_viewer[2],filterFree).getControl());
//		
//		//tabItem[3].setControl(filterExecutionWorker.createTreeViewer(m_viewer[3],filterFree).getControl());
//		
//		
//		 tabFolder.setSize(400, 200);
		 
	}
	
	public void deleteTree(TreeNode node){
		for(int i = node.getChildren().size()-1; i >= 0; i--)
			node.getChildren().remove(i);
	}
	
	public void getTreeCategory(String string){
		
		if(string.equals("open")){
			treeCategory.treeCategory(filterFree.getRoot());
		}
		else{
			treeCategory.createTreeViewer(m_viewer, string);
			System.out.println("LeftComposite:  row:  92");
		}
	}
	
	
	
	
}

