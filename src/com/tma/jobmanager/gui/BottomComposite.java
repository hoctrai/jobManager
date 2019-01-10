package com.tma.jobmanager.gui;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.tma.jobmanager.target.Target;



public class BottomComposite extends Composite {

	LeftComposite m_leftComposite;
	RightComposite m_rightComposite;
	
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public BottomComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2,false));

	}
	
	public void selectView(){
		
		m_leftComposite.m_viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			Target target;
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection() instanceof IStructuredSelection) {
					try{
						IStructuredSelection selection = (IStructuredSelection) event.getSelection();
						String strTarget = selection.getFirstElement().toString();
						target = getTaget(strTarget);
						m_rightComposite.showDataTarget(target);
						m_rightComposite.showRunTarget(target);
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
			
			for(int i = 0 ; i <m_leftComposite.filterFree.getRoot().getChildren().size() ; i++ ){
				
				targetName = m_leftComposite.filterFree.getRoot().getChildren().get(i).getTarget().getName();
				if(strTarget.equals(targetName.substring(4, targetName.length()-5))){
					
					target = m_leftComposite.filterFree.getRoot().getChildren().get(i).getTarget();
					updateRightComposite(target.toString());
					return target;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateRightComposite(String text){
		m_rightComposite.setValueText(text);
		
	}
	
	public void updateLeftComposite(){

			m_leftComposite.getFilter("open");
			m_leftComposite.getTreeCategory("open");

	}
	
	public void addComposite(){
		
		m_leftComposite = new LeftComposite(this, SWT.NONE);
		
		GridData gd_leftComposite = new GridData(GridData.FILL_VERTICAL);
		gd_leftComposite.widthHint = 238;
		gd_leftComposite.heightHint = 447;
		m_leftComposite.setLayoutData(gd_leftComposite);
		m_leftComposite.populateControl();
		
		m_rightComposite = new RightComposite(this, SWT.NONE);
		GridData gd_rightComposite = new GridData(GridData.FILL_BOTH); 
		gd_rightComposite.heightHint = 400;
		m_rightComposite.setLayoutData(gd_rightComposite);
		m_rightComposite.windowExecute(getShell());
		
		selectView();
		
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
