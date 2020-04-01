package com.hadwinling.service.impl;

import java.util.List;

import com.hadwinling.dao.StudentDao;
import com.hadwinling.dao.impl.StudentDaoImpl;
import com.hadwinling.entity.Student;
import com.hadwinling.service.StudentService;

public class StudentServiceImpl implements StudentService{
	private StudentDao studentDao =new StudentDaoImpl(); 

	@Override
	public List<Student> findStudents() {
		// TODO Auto-generated method stub
		return studentDao.findStudents();
	}

	@Override
	public List<Student> findStudentByName(String sname) {
		// TODO Auto-generated method stub
		return studentDao.findStudentByName(sname);
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.addStudent(student)>0?true:false;
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudent(id)>0?true:false;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(student)>0?true:false;
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDao.findStudentById(id);
	}

}
