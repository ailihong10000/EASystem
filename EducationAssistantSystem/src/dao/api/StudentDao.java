package dao.api;

import pojo.Admin;
import pojo.Student;

public interface StudentDao {
	public Student login(String username,String password);

}
