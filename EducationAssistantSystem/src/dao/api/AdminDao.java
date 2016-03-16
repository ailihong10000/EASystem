package dao.api;

import pojo.Admin;

public interface AdminDao {
	public Admin login(String username,String password);
	
}
