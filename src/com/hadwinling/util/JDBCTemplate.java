package com.hadwinling.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
	/**
	 * 封装更新操作
	 * 
	 * @param psmtCreator 获取PreparedStatement对象
	 * @return
	 */
	public static final int update(PreparedStatementCreator psmtCreator) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int result = -1;
		try {
			// 使用数据库连接池获取连接
			conn = Dbcp.getInstance().getConnection();
			conn.setAutoCommit(false);
			psmt = psmtCreator.create(conn);
			result = psmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			Dbcp.getInstance().close(conn, psmt);
		}

		return result;
	}

	/**
	 * 封装查询操作
	 * 
	 * @param psmtCreator 获取PreparedStatement对象
	 * @param rsExtractor 解析结果集，获取解析后的对象
	 * @return 返回解析后的查询结果
	 */
	public static final Object query(PreparedStatementCreator psmtCreator, ResultSetExtractor rsExtractor) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Object result = null;
		try {
			conn = Dbcp.getInstance().getConnection();
			conn.setAutoCommit(false);
			psmt = psmtCreator.create(conn);
			rs = psmt.executeQuery();
			result = rsExtractor.extractor(rs);
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			Dbcp.getInstance().close(conn, psmt, rs);
		}

		return result;
	}
}
