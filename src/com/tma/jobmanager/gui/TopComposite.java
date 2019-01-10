package com.tma.jobmanager.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class TopComposite extends Composite {


	Combo m_comboType;
	Combo m_comboValue;


	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TopComposite(Composite parent, int style) {
		super(parent, style);
		
		filter();

	}
	
	public void filter(){
		setLayout(new GridLayout(9, false));
		new Label(this, SWT.NONE);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setText("Style: ");
//		new Label(this, SWT.NONE);
		
		String[] itemsType = {"Target: ", "Categoryjob", "States"};
		
		m_comboType = new Combo(this, SWT.NONE);
		GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 101;
		m_comboType.setLayoutData(gd_combo);
		m_comboType.setItems(itemsType);
		
		new Label(this, SWT.NONE);
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setText("Value: ");
		
		new Label(this, SWT.NONE);
		
		m_comboValue = new Combo(this, SWT.NONE);
		GridData gd_combo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_1.widthHint = 103;
		m_comboValue.setLayoutData(gd_combo_1);
		m_comboValue.setEnabled(false);
		
		
	}
	
	public void selectView(BottomComposite m_bottomComposite){
		m_comboType.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if(m_comboType.getText().equals("Target: ")){
					String [] id = new String[m_bottomComposite.m_leftComposite.filterFree.getRoot().getChildren().size()];
					id[0] = ""; 
					for(int i = 0; i < m_bottomComposite.m_leftComposite.filterFree.getRoot().getChildren().size(); i++){
						id[i+1] = String.valueOf(m_bottomComposite.m_leftComposite.filterFree.getRoot().getChildren().get(i).getId());
						
					}
					m_comboValue.setItems(id);
					m_comboValue.setEnabled(true);
					
				}
				else if(m_comboType.getText().equals("Categoryjob")){
					
					String[] itemCategory = new String[m_bottomComposite.m_leftComposite.treeCategory.getCategory().getChildren().size()+1];
					itemCategory[0] = "";
					for(int i = 0; i < m_bottomComposite.m_leftComposite.treeCategory.getCategory().getChildren().size(); i++ ){
						itemCategory[i+1] = m_bottomComposite.m_leftComposite.treeCategory.getCategory().getChildren().get(i).getName();
					}
					
					m_comboValue.setItems(itemCategory);
					
					m_comboValue.setEnabled(true);
					
					m_comboValue.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e){
							m_bottomComposite.m_leftComposite.getTreeCategory(m_comboValue.getText());
							
						}
					});
				}else if(m_comboType.getText().equals("States")){
					String [] itemStates = {"","Planned", "Worked Pool", "Execution"};
					m_comboValue.setItems(itemStates);
					m_comboValue.setEnabled(true);
					
					m_comboValue.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e){
							m_bottomComposite.m_leftComposite.getFilter(m_comboValue.getText());
								
						}
					});
				}
			}
		});
	}
	

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
