package com.hadwinling.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtractor {
	/**
	 * 
	 * 处理结果集封装目标对象
	 * 
	 * @param rs 结果集对象
	 * @return 封装好的Object对象
	 * @throws SQLException 抛出SQL异常
	 */
	Object extractor(ResultSet resultSet) throws SQLException;
}
