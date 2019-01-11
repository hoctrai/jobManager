package com.tma.jobmanager.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;



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
	
//	public void updateRightComposite(String text){
//		m_rightComposite.setValueText(text);
//		
//	}
	
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
		
		m_leftComposite.selectView(m_rightComposite);
		
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
