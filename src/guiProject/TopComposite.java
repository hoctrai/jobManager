package guiProject;

import org.eclipse.swt.SWT;
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
		setLayout(new GridLayout(3, false));
		
		m_comboType = new Combo(this, SWT.NONE);
		GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 101;
		m_comboType.setLayoutData(gd_combo);
		m_comboType.setText("Type");
		new Label(this, SWT.NONE);
		
		m_comboValue = new Combo(this, SWT.NONE);
		GridData gd_combo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_1.widthHint = 103;
		m_comboValue.setLayoutData(gd_combo_1);
		m_comboValue.setText("Value");
		
		String[] itemsType = {"Target: ", "Categoryjob", "States"};
		m_comboType.setItems(itemsType);
		m_comboValue.setEnabled(false);
		
		
	}
	

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
