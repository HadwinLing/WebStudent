package com.hadwinling.dao;

import java.util.List;

import com.hadwinling.entity.Student;

public interface StudentDao {
	//查找所有学生
	List<Student> findStudents();
	//查询
	List<Student> findStudentByName(String sname);
	//添加
	int addStudent(Student student);
	//删除
	int deleteStudent(int id);
	//修改
	int updateStudent(Student student);
	//
	Student findStudentById(int id);

}
