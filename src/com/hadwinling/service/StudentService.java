package com.hadwinling.service;

import java.util.List;

import com.hadwinling.entity.Student;

public interface StudentService {
	// 查找所有学生
	List<Student> findStudents();

	// 查询
	List<Student> findStudentByName(String sname);

	// 添加
	boolean addStudent(Student student);

	// 删除
	boolean deleteStudent(int id);

	// 修改
	boolean updateStudent(Student student);
	
	//通过id查找
	Student findStudentById(int id);
}
