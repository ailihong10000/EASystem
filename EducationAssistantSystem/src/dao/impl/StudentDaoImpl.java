package dao.impl;

import java.util.List;

import pojo.Admin;
import pojo.Student;
import dao.api.StudentDao;

public class StudentDaoImpl extends BaseDao implements StudentDao {

	@Override
	public Student login(String username, String password) {
		// TODO Auto-generated method stub
		String hql="from Student as student where student.number=? and student.password=?";
		Object[] parameters=new String[]{username,password};
		List<Student> studentList=(List <Student>)getHibernateTemplate().find(hql,parameters);
		if (studentList.isEmpty()) {
			return null;
		}
		else {
			return studentList.get(0);
		}
	}

}
