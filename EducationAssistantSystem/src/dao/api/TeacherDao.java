package dao.api;

import pojo.Admin;
import pojo.Teacher;

public interface TeacherDao {
	public Teacher login(String username,String password);

}
