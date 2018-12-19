package com.shop.service;

import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.AdminUserDao;
import com.shop.domain.AdminUser;


@Transactional
public class AdminUserService {
	// 注入Dao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
