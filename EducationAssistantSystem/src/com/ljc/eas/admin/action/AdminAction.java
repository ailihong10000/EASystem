package com.ljc.eas.admin.action;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}