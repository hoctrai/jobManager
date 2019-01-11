package com.tma.jobmanager.gui;


import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.tma.jobmanager.tree.TreeNode;
import com.tma.jobmanager.target.Target;
import com.tma.jobmanager.tree.FilterExecutionWorker;
import com.tma.jobmanager.tree.FilterFree;
import com.tma.jobmanager.tree.FilterPlanned;
import com.tma.jobmanager.tree.FilterStates;
import com.tma.jobmanager.tree.FilterWorkedPool;
import com.tma.jobmanager.tree.TreeCategory;


public class LeftComposite extends Composite {
	TreeNode m_root;
	
	
	FilterFree filterFree = new FilterFree();
	FilterStates statets;
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
			statets = new FilterPlanned();
			m_viewer.setInput(statets.filter(filterFree.getRoot()));
			deleteTree(statets.getRoot());
			
		}else if(string.equals("Execution")){
			statets = new FilterExecutionWorker();
			m_viewer.setInput(statets.filter(filterFree.getRoot()));
		deleteTree(statets.getRoot());
		
		}else if(string.equals("Worked Pool")){
			statets = new FilterWorkedPool();
			m_viewer.setInput(statets.filter(filterFree.getRoot()));
			deleteTree(statets.getRoot());
			
		}
	}
	
	public void deleteTree(TreeNode node){
		for(int i = node.getChildren().size()-1; i >= 0; i--)
			node.getChildren().remove(i);
	}
	
	public void getTreeCategory(String string){
		
		if(string.equals("open")){
			treeCategory.treeCategory(filterFree.getRoot());
			
		}else{
			m_viewer.setInput(treeCategory.find(string));
			System.out.println("LeftComposite:  row:  92");
			
		}
	}
	
	public void selectView(RightComposite rightComposite){
		
		m_viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			Target target;
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection() instanceof IStructuredSelection) {
					try{
						
						IStructuredSelection selection = (IStructuredSelection) event.getSelection();
						String strTarget = selection.getFirstElement().toString();
						target = getTaget(strTarget);
						rightComposite.showDataTarget(target);
						rightComposite.showRunTarget(target);
						System.out.println("\n");
						
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public  Target getTaget(String strTarget) {
		Target target ;
		try{
			
			String targetName;
			
			for(int i = 0 ; i < filterFree.getRoot().getChildren().size() ; i++ ){
				
				targetName = filterFree.getRoot().getChildren().get(i).getTarget().getName();
				if(strTarget.equals(targetName.substring(4, targetName.length()-5))){
					
					target = filterFree.getRoot().getChildren().get(i).getTarget();
					//updateRightComposite(target.toString());
					return target;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}

