package dao.impl;

import java.util.List;

import pojo.Admin;
import pojo.Teacher;
import dao.api.TeacherDao;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {

	@Override
	public Teacher login(String username, String password) {
		// TODO Auto-generated method stub
		String hql="from Teacher as teacher where teacher.username=? and teacher.password=?";
		Object[] parameters=new String[]{username,password};
		List<Teacher> teacherList=(List <Teacher>)getHibernateTemplate().find(hql,parameters);
		if (teacherList.isEmpty()) {
			return null;
		}
		else {
			return teacherList.get(0);
		}
	}

}
