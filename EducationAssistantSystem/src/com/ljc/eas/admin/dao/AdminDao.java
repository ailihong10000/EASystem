package com.ljc.eas.admin.dao;

import com.ljc.eas.admin.pojo.Admin;

public interface AdminDao {
	public Admin login(String username,String password);
	
}
