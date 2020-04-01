package com.hadwinling.dao.impl;

import java.sql.PreparedStatement;

import com.hadwinling.dao.AdminDao;
import com.hadwinling.entity.Admin;
import com.hadwinling.util.JDBCTemplate;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin adminLogin(String username, String password) {
		// TODO Auto-generated method stub
		return (Admin) JDBCTemplate.query(connection->{
			String sql = "select * from admin where username= ? and password =?";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			return preparedStatement;
		}, resultSet->{
			Admin admin = null;
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String username1 = resultSet.getString(2);
				String password1 = resultSet.getString(3);
				admin = new Admin(id, username1, password1);
			}
			return admin;
		});
	}

	@Override
	public int adminRegist(String username, String password) {
		// TODO Auto-generated method stub
		return JDBCTemplate.update(connection->{
			String sql = "insert into admin(username,password) values(?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			return preparedStatement;
		});
	}

}
