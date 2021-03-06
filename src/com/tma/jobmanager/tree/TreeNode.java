package com.tma.jobmanager.tree;

import java.util.ArrayList;
import java.util.List;

import com.tma.jobmanager.target.Target;




public class TreeNode {
	
	private Target m_target;
	private String m_name;
	private int m_id;
	private String m_strParameters;
	private List<TreeNode> m_children = new ArrayList<TreeNode>();
	private TreeNode m_parent;
	private List<String> m_strJobs = new ArrayList<>();

	public TreeNode( String name) {

		this.m_name = name;
		this.m_strParameters = "";

	}

	public Target getTarget() {
		return m_target;
	}

	public void setTarget(Target target) {
		this.m_target = new Target("");
		this.m_target = target;
	}

	public int getId() {
		return m_id;
	}

	public void setId(int m_id) {
		this.m_id = m_id;
	}

	public String getStrParameters() {
		return m_strParameters;
	}
	
	public void setStrParameters(String strParameters) {
		this.m_strParameters = strParameters;
	}
	
	public Object getParent() {
		  return m_parent;
	}
	
	public void setParent(TreeNode treeNode) {
		this.m_parent = treeNode;
	}
	
	public TreeNode addChild(TreeNode child) {
		
		m_children.add(child);
		child.m_parent = this;
		return this;
	}
	
	public List<TreeNode> getChildren() {
		return m_children;
	}
	
	public String getName(){
		return m_name;
		
	}
	
	public String toString() {
		return m_name;
	}

	public List<String> getStrJobs() {
		return m_strJobs;
	}

	public void setStrJobs(List<String> strJobs) {
		this.m_strJobs = strJobs;
	}
	public void addStrJobs(String strJob){
		this.m_strJobs.add(strJob);
	}
	
}
