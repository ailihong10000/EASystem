package com.ljc.eas.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljc.eas.admin.dao.AdminDao;
import com.ljc.eas.admin.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if (!username.isEmpty()&&!password.isEmpty()) {
			if (adminDao.login(username, password)!=null) {
				return true;
			}
			else{
				return false;
			}
			
		}
		return false;
	}

}
