package com.tma.jobmanager.tree;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class ReadStates {
	private String submit, start, timeout, server;
	public ReadStates() {
		// TODO Auto-generated constructor stub
		submit = start = timeout = server ="";
	}
	
	public String getSubmit() {
		return submit;
	}
	
	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	
	public void read(String[] strParent) {
		for(int k = 1; k < strParent.length; k++){
			Optional<String> opt = Optional.ofNullable(strParent[k]);
			
			if(k==1)
				submit = opt.filter(x->x.contains("submitTime")).get();
			else if(k==2)
				start = opt.filter(x->x.contains("start")).get().replaceAll("startTime","");
			else if(k==3)
				timeout = opt.filter(x->x.contains("timeout")).get().replaceAll("timeout:","");
			else if(k==4)
				server = opt.filter(x->x.contains("Server")).get().replaceAll("Server:", "");
			
		}
		//System.out.println(submit.substring(6).replaceAll(" CST", ""));
		
		
		
//		DateFormat sdf = new SimpleDateFormat("MM dd'T'HH:mm:ss.SSSZ CST yyyy");
//		String pattern ="MM dd'T'HH:mm:ss.SSSZ CST yyyy";
//		DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
//		DateTime dateTime = dtf.parseDateTime(submit.substring(2, 21));
	//System.out.println(date);
	}
	
	public boolean checkFilter(String submit, String start) {
		SimpleDateFormat formatter1=new SimpleDateFormat("MMM dd HH:mm:ss.Z yyyy");
		Date dateNow, dateStart;
		try {
//		dateSubmit = formatter1.parse(submit.substring(6).replaceAll(" CST", ".+0600"));
		dateNow = new Date();
		dateStart = formatter1.parse(submit.substring(6).replaceAll(" CST", ".+0600"));
		//compare = formatter1.parse("");
		if(dateStart.after(dateNow)) {
			return true;
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		//System.out.println("aaaaaaaaa:	"+date);
		
		
		
		return false;
	}

}
