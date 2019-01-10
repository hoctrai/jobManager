package com.tma.jobmanager.gui;


import org.eclipse.swt.SWT;
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
	
	public static void main(String[] arg){
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(861, 540);
		shell.setLayout(new GridLayout(1, false));
		
		/* Call menu */
		m_menuMain.menu(shell);
		
		Composite parent = new Composite(shell, SWT.BORDER);
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));
		parent.setLayout(new GridLayout(1, false));
		
		/*Call TopComposite*/
		m_mainClass.m_topComposite = new TopComposite(parent, SWT.NONE);
		
		/*Call BottomComposite*/
		m_mainClass.m_bottomComposite = new BottomComposite(parent, SWT.NONE);
		GridData gd_bottomComposite = new GridData(GridData.FILL_BOTH);
		m_mainClass.m_bottomComposite.setLayoutData(gd_bottomComposite);
		m_mainClass.m_bottomComposite.addComposite();
	
		
		System.out.println("MainClass:   row: 199");
		
		
		/*Call event*/
		m_menuMain.selectFile(m_mainClass.m_bottomComposite);
		m_mainClass.m_topComposite.selectView(m_mainClass.m_bottomComposite);
		
		/*show GUI*/
		shell.open();
		while (!shell.isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
