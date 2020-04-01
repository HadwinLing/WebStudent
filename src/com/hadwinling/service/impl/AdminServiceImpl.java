package com.hadwinling.service.impl;

import com.hadwinling.dao.AdminDao;
import com.hadwinling.dao.impl.AdminDaoImpl;
import com.hadwinling.entity.Admin;
import com.hadwinling.service.AdminService;

public class AdminServiceImpl implements AdminService{
	private AdminDao adminDao = new AdminDaoImpl();
	@Override
	public Admin adminLogin(String username, String password) {
		// TODO Auto-generated method stub
		return adminDao.adminLogin(username, password);
	}
	@Override
	public boolean adminRegist(String username, String password) {
		// TODO Auto-generated method stub
		return adminDao.adminRegist(username, password)>0?true:false;
	}

}
