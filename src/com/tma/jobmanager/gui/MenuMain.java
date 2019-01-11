package com.tma.jobmanager.gui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MenuMain {
	protected static final BottomComposite m_bottomComposite = null;
	MenuItem openItem;
	
	public MenuMain() {
		
	}
	
	public void menu(Shell shell){
		
		final Menu menu = new Menu(shell, SWT.BAR);
		
		final MenuItem file =  new MenuItem(menu, SWT.CASCADE);
		file.setText("File");
		
		final Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		file.setMenu(fileMenu);
		
		openItem = new MenuItem(fileMenu, SWT.PUSH);
		openItem.setText("Open");
		
		final MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
		exitItem.setText("Exit");
		
		/* create menu window */
		final MenuItem window = new MenuItem(menu, SWT.CASCADE);
		window.setText("Window");
		final Menu windowmenu = new Menu(shell, SWT.DROP_DOWN);
		window.setMenu(windowmenu);
		final MenuItem maxItem = new MenuItem(windowmenu, SWT.PUSH);
		maxItem.setText("Maximize");
		final MenuItem minItem = new MenuItem(windowmenu, SWT.PUSH);
		minItem.setText("Minimize");
		
		final MenuItem helpItem = new MenuItem(menu, SWT.PUSH);
		helpItem.setText("Help");
		
		
		
		/*Call exit GUI*/
		exitItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(MessageDialog.openConfirm(shell, 
						"Confirmation", "Do you want exit")){
					System.exit(0);
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		/*Call max GUI*/
		maxItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell parent = (Shell) maxItem.getParent().getParent();
				parent.setMaximized(true);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});

		/*Call min GUI*/
		minItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell parent = (Shell) minItem.getParent().getParent();
				parent.setMaximized(false);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		/*Call Help*/
		helpItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell parent = (Shell) minItem.getParent().getParent();
				parent.setMaximized(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		shell.setMenuBar(menu);
		

	}
	public void selectFile(BottomComposite bottomComposite){
		openItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				bottomComposite.updateLeftComposite();
			
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
	}
}
