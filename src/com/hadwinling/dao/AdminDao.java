package com.hadwinling.dao;

import com.hadwinling.entity.Admin;

public interface AdminDao {
	//登陆
	Admin adminLogin(String username,String password);
	//
	int adminRegist(String username,String password);

}
