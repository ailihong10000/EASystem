package service.impl;

import dao.api.TeacherDao;
import service.api.TeacherService;

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
