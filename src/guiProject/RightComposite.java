package guiProject;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import jobmanager.Ongoing;
import jobmanager.Planned;
import jobmanager.Started;
import jobmanager.Target;
import treeView.ReadStates;


public class RightComposite extends Composite {
	private Table m_table;
	private Text m_text;
	List<TableItem> m_item = new ArrayList<>();
	private ReadStates states = new ReadStates();
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public RightComposite(Composite parent, int style) {
		super(parent, style);
		//windowExecute(getShell());
	}
	
	
//	public Text getText() {
//		return text;
//	}
//
//	
//	public void setText(String text) {
//		
//		this.text.setText(text);
//	}

	public void gridText(){
		
	}
	
	public void windowExecute(Shell shell){
		
		setLayout(new GridLayout(1, false));
		
		m_table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_table = new GridData(GridData.FILL_HORIZONTAL);
		gd_table.heightHint = 68;
		m_table.setLayoutData(gd_table);
		m_table.setHeaderVisible(true);
		m_table.setLinesVisible(true);
		
//		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
//		GridData gd_table = new GridData(GridData.FILL_BOTH);
//		//gd_table.widthHint = 236;
//		table.setLayoutData(gd_table);
		
//		table.setHeaderVisible(true);
//		table.setLinesVisible(true);
		
		TableColumn columnName = new TableColumn(m_table, SWT.CENTER);
		columnName.setWidth(50);
		columnName.setText("Name");
		
		TableColumn columnCategory = new TableColumn(m_table, SWT.CENTER);
		columnCategory.setWidth(87);
		columnCategory.setText("Category Job");
		
		TableColumn columnIdJob = new TableColumn(m_table, SWT.CENTER);
		columnIdJob.setWidth(50);
		columnIdJob.setText("Id Job");
		
		TableColumn columnJobType = new TableColumn(m_table, SWT.CENTER);
		columnJobType.setWidth(65);
		columnJobType.setText("Job Type");
		
		TableColumn columnSubmitTime = new TableColumn(m_table, SWT.CENTER);
		columnSubmitTime.setWidth(90);
		columnSubmitTime.setText("Submit Time");
		
		TableColumn columnStartTime = new TableColumn(m_table, SWT.CENTER);
		columnStartTime.setWidth(81);
		columnStartTime.setText("Start Time");
		
		TableColumn columnTimeOut = new TableColumn(m_table, SWT.CENTER);
		columnTimeOut.setWidth(77);
		columnTimeOut.setText("Time Out");
		
		TableColumn columnServer = new TableColumn(m_table, SWT.CENTER);
		columnServer.setWidth(70);
		columnServer.setText("Server");
		
		m_text = new Text(this, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		GridData gd_text = new GridData(GridData.FILL_BOTH);
		gd_text.heightHint = 200;
		m_text.setLayoutData(gd_text);
		
		m_item.add( new TableItem(m_table, SWT.NONE));
		m_item.add( new TableItem(m_table, SWT.NONE));
		
		
	}
	/*-------------------------------------------------------------------------------------------------------------*/
	
	public void showDataTarget(Target target){
		
		Planned planned;
		Started started;
		Ongoing ongoing;
		int n = 0;
		String s = target.getName();
		String NameTarget =  s.substring(4,s.length()-5);
		String nameCategory="", id="", type="";
		//String submit="", start="", timeout="", server="";
		//m_item.get(0).setText(new String[] {"", "", "", "", "", "", "", ""});
		for (int i = 0; i<target.getListCategoryJobs().size(); i++){
			
			int j = 0;
			n=target.getListCategoryJobs().get(i).getPlanned().getStrPlan().size();
			if(n>0){
				s = target.getListCategoryJobs().get(i).getName();
				planned = target.getListCategoryJobs().get(i).getPlanned();
				nameCategory = s.substring(4, s.length()-5);
//				for(int j = 0; j <n; j++
				int t = 0;
				while(j < n){
					
					s= planned.getStrPlan().get(t);
					String[] strParent = s.split(",");
					String[] strChild = strParent[0].split(":");
					id = strChild [0];
					type = strChild[2];
					
					states.read(strParent);
					
					m_item.get(j).setText(new String[] {NameTarget,nameCategory, id, type,  states.getSubmit(), states.getStart(), states.getTimeout(), states.getServer()});
					System.out.println("rightComposite:    row:  	155   " + j+ "	id:		"+ id);
					t++;
					j++;
				}
				
				//m_item.get(n).setText(new String[] {"", "", "", "", "", "", "", ""});
				
			}
			n = n + target.getListCategoryJobs().get(i).getOngoing().getStrOngoing().size();
			if(n > j){
				s = target.getListCategoryJobs().get(i).getName();
				ongoing = target.getListCategoryJobs().get(i).getOngoing();
				nameCategory = s.substring(4, s.length()-5);
				int t = 0;
				while(j<n){
					s= ongoing.getStrOngoing().get(t);
					String[] strParent = s.split(",");
					String[] strChild = strParent[0].split(":");
					id = strChild [0];
					type = strChild[2];
					
					states.read(strParent);
					m_item.get(j).setText(new String[] {NameTarget,nameCategory, id, type,  states.getSubmit(), states.getStart(), states.getTimeout(), states.getServer()});
					
					j++;
					t++;
				}
				
				//m_item.get(n).setText(new String[] {"", "", "", "", "", "", "", ""});
				
			}
			
			n = n + target.getListCategoryJobs().get(i).getStared().getStrStarter().size();
			if(n > j){
				s = target.getListCategoryJobs().get(i).getName();
				started = target.getListCategoryJobs().get(i).getStared();
				nameCategory = s.substring(4, s.length()-5);
				int t = 0;
				while(j < n){
					s= started.getStrStarter().get(t);
					String[] strParent = s.split(",");
					String[] strChild = strParent[0].split(":");
					id = strChild [0];
					type = strChild[2];
					
					states.read(strParent);
					m_item.get(j).setText(new String[] {NameTarget,nameCategory, id, type,  states.getSubmit(), states.getStart(), states.getTimeout(), states.getServer()});
					
					j++;
					t++;
				}
				
			}
			
		}
		try{
			//m_item.get(n).setText(new String[] {"", "", "", "", "", "", "", ""});
		}catch (Exception e) {
			
		}
	}
	
	public void showRunTarget(Target target){
		
		String ongoing = "<h3>Moved to worker pool</h3>";
		String started = "<h3>Execution started by worker thread</h3>";
		int n;
		String nameTarget = target.getName();
		String str = nameTarget ;
		
		for(int i = 0; i < target.getListCategoryJobs().size(); i++ ){
			String nameCategory = target.getListCategoryJobs().get(i).getName();
			String namePlan = target.getListCategoryJobs().get(i).getPlanned().getNamePlan();
			str = str + "\n" + nameCategory + "\n" + namePlan;
			//**************************************************************/
			n = target.getListCategoryJobs().get(i).getPlanned().getStrPlan().size();
			for(int j = 0; j < n; j++){
				String planned = target.getListCategoryJobs().get(i).getPlanned().getStrPlan().get(j);
				str = str + "\n" + planned;
			}
			
			str = str +  "\n" + ongoing;
			n = target.getListCategoryJobs().get(i).getOngoing().getStrOngoing().size();
			for(int j = 0; j < n; j++)
				str = str + "\n" + target.getListCategoryJobs().get(i).getOngoing().getStrOngoing().get(j);
			
			str = str + "\n" + started;
			n = target.getListCategoryJobs().get(i).getStared().getStrStarter().size();
			for(int j = 0; j < n; j++)
				str = str + "\n" + target.getListCategoryJobs().get(i).getStared().getStrStarter().get(j);
			
			
		}
		String strJobPerFamily = "<h2>Executing jobs per Family</h2>";
		str = str + "\n" + strJobPerFamily +"\n"+ target.getJobsPerJobFamily();
		
		
		m_text.setText(str);
	}
	

	@Override
	protected void checkSubclass() {
		
	}


	public Text getText() {
		return m_text;
	}


	public void setValueText(String text) {
		this.m_text.setText(text);
	}
}