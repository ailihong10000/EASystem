package com.ljc.eas.teacher.dao;

import com.ljc.eas.teacher.pojo.Teacher;

public interface TeacherDao {
	public Teacher login(String username, String password);

}
