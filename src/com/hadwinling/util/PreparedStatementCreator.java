package com.hadwinling.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementCreator {
	/**
	 * 通过连接对象获取预编译对象
	 * 
	 * @param conn 连接对象
	 * @return 预编译语句对象
	 * @throws SQLException 抛出SQL异常
	 */
	PreparedStatement create(Connection conn) throws SQLException;
}
