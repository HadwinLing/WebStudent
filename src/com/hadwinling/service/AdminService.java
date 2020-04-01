package com.hadwinling.service;

import com.hadwinling.entity.Admin;

public interface AdminService {
	//登陆
	Admin adminLogin(String username,String password);
	//
	boolean adminRegist(String username,String password);

}
