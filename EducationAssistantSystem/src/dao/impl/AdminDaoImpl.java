package dao.impl;


import java.util.List;

import pojo.Admin;
import dao.api.AdminDao;

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
