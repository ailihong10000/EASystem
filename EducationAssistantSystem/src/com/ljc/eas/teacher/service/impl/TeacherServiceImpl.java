package com.ljc.eas.teacher.service.impl;

import com.ljc.eas.teacher.dao.TeacherDao;
import com.ljc.eas.teacher.service.TeacherService;



public class TeacherServiceImpl implements TeacherService {
	TeacherDao teacherDao;

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if (!username.isEmpty()&&!password.isEmpty()) {
			if (teacherDao.login(username, password)!=null) {
				return true;
			}
			else{
				return false;
			}
			
		}
		return false;
	}

}
