package service.impl;

import dao.api.StudentDao;
import service.api.StudentService;

public class StudentServiceImpl implements StudentService {
	StudentDao studentDao;
	

	public StudentDao getStudentDao() {
		return studentDao;
	}


	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if (!username.isEmpty()&&!password.isEmpty()) {
			if (studentDao.login(username, password)!=null) {
				return true;
			}
			else{
				return false;
			}
			
		}
		return false;
	}

}
