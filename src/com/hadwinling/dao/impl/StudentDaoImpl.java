package com.hadwinling.dao.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.hadwinling.dao.StudentDao;
import com.hadwinling.entity.Student;
import com.hadwinling.util.JDBCTemplate;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> findStudents() {
		// TODO Auto-generated method stub
		return (List<Student>) JDBCTemplate.query(connection->{
			String sql = "select * from student";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			return preparedStatement;
		}, resultSet->{
			List<Student>students = new ArrayList<Student>();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String sno = resultSet.getString(2);
				String sname = resultSet.getString(3);
				String sex = resultSet.getString(4);
				String address = resultSet.getString(5);
				Student student = new Student(id, sno, sname, sex, address);
				students.add(student);
			}
			return students;
			
		});
	}

	@Override
	public List<Student> findStudentByName(String sname) {
		// TODO Auto-generated method stub
		return (List<Student>) JDBCTemplate.query(connection->{
			String sql = "select * from student where sname like?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+sname+"%");
			return preparedStatement;
		}, resultSet->{
			List<Student>students = new ArrayList<Student>();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String sno = resultSet.getString(2);
				String sname1 = resultSet.getString(3);
				String sex = resultSet.getString(4);
				String address = resultSet.getString(5);
				Student student = new Student(id, sno, sname1, sex, address);
				students.add(student);
			}
			return students;
		});
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return JDBCTemplate.update(connection->{
			String sql = "insert into student(sno,sname,sex,address) values (?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(1, student.getSno());
			preparedStatement.setString(2, student.getSname());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setString(4, student.getAddress());
			return preparedStatement;
		});
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		return JDBCTemplate.update(connection->{
			String sql = "delete from student where id= ?";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			return preparedStatement;
		});
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return JDBCTemplate.update(connection -> {
			String sql ="update student set sno = ?,sname = ?,sex= ?,address= ? where id= ?";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getSno());
			preparedStatement.setString(2, student.getSname());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setInt(5, student.getId());
			return preparedStatement;
		});
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return (Student) JDBCTemplate.query(connection->{
			String sql = "select * from student where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			return preparedStatement;
		}, resultSet->{
			Student student = null;
			if (resultSet.next()) {
				int id1 = resultSet.getInt(1);
				String sno = resultSet.getString(2);
				String sname1 = resultSet.getString(3);
				String sex = resultSet.getString(4);
				String address = resultSet.getString(5);
				student = new Student(id1, sno, sname1, sex, address);
			}
			return student;
		});
	}

}
