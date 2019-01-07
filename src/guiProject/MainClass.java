package guiProject;


import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MainClass {
	
	static MainClass m_mainClass = new MainClass();
	static MenuMain m_menuMain = new MenuMain();
	
	private TopComposite m_topComposite;
	private BottomComposite m_bottomComposite;


	public MainClass() {

	}
	

	
	
	public void clickType() {
		m_topComposite.m_comboType.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if(m_topComposite.m_comboType.getText().equals("Target: ")){
					String [] id = new String[m_bottomComposite.m_leftComposite.filterFree.getRoot().getChildren().size()+1];
					id[0] = ""; 
					for(int i = 0; i < m_bottomComposite.m_leftComposite.filterFree.getRoot().getChildren().size(); i++){
						id[i+1] = String.valueOf(m_bottomComposite.m_leftComposite.filterFree.getRoot().getChildren().get(i).getId());
						//m_topComposite.m_comboValue.setText(string);
					}
					m_topComposite.m_comboValue.setItems(id);
					m_topComposite.m_comboValue.setEnabled(true);
					
					
					
				}
				else if(m_topComposite.m_comboType.getText().equals("Categoryjob")){
					
					String[] itemCategory = new String[m_bottomComposite.m_leftComposite.treeCategory.getCategory().getChildren().size()+1];
					itemCategory[0] = "";
					for(int i = 0; i < m_bottomComposite.m_leftComposite.treeCategory.getCategory().getChildren().size(); i++ ){
						itemCategory[i+1] = m_bottomComposite.m_leftComposite.treeCategory.getCategory().getChildren().get(i).getName();
					}
					
					m_topComposite.m_comboValue.setItems(itemCategory);
					
					m_topComposite.m_comboValue.setEnabled(true);
					
					m_topComposite.m_comboValue.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e){
							m_bottomComposite.m_leftComposite.getTreeCategory(m_topComposite.m_comboValue.getText());
						}
					});
					
					
				}else if(m_topComposite.m_comboType.getText().equals("States")){
					String [] itemStates = {"","Planned", "Worked Pool", "Execution"};
					m_topComposite.m_comboValue.setItems(itemStates);
					m_topComposite.m_comboValue.setEnabled(true);
					
					m_topComposite.m_comboValue.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e){
							m_bottomComposite.m_leftComposite.getFilter(m_topComposite.m_comboValue.getText());
								
						}
					});
				}
			}
		});
		
		
	}
	public void clickOpen(){
		m_menuMain.openItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_bottomComposite.updateLeftComposite();
			
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
	}

//	public void addCategory(List<String> strings, String[] strings2 ){
//		for (int i = 0; i <strings.size(); i++){
//			strings2[strings2.length]=strings.get(i);
//		}
//	}
	

	
	public static void main(String[] arg){
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(690, 319);
		shell.setLayout(new GridLayout(1, false));
		
		/* call menu */
		m_menuMain.menu(shell);
		
		Composite parent = new Composite(shell, SWT.BORDER);
		
		GridData gd_parent = new GridData(GridData.FILL_BOTH);
		parent.setLayoutData(gd_parent);
		parent.setLayout(new GridLayout(1, false));
		
		m_mainClass.m_topComposite = new TopComposite(parent, SWT.NONE);
		//m_mainClass.m_topComposite.Filter();
		
		/*call LeftComposite*/
		
		
		m_mainClass.m_bottomComposite = new BottomComposite(parent, SWT.NONE);
		m_mainClass.m_bottomComposite.addComposite();
		System.out.println("MainClass:   row: 199");
		
		
		/*call event*/
		m_mainClass.clickOpen();
		
		m_mainClass.clickType();
		
		/*show GUI*/
		shell.open();
		while (!shell.isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
		
		
		
		
 
	}
}
