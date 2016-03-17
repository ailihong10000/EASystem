package com.ljc.eas.admin.dao.impl;


import java.util.List;

import com.ljc.eas.admin.dao.AdminDao;
import com.ljc.eas.admin.pojo.Admin;
import com.ljc.eas.base.BaseDao;


public class AdminDaoImpl extends BaseDao implements AdminDao {
	
	@Override
	public Admin login(String username, String password) {
		// TODO Auto-generated method stub
		String hql="from Admin as admin where admin.username=? and admin.password=?";
		Object[] parameters=new String[]{username,password};
		List<Admin> adminList=(List <Admin>)getHibernateTemplate().find(hql,parameters);
		if (adminList.isEmpty()) {
			return null;
		}
		else {
			return adminList.get(0);
		}
	}

}
