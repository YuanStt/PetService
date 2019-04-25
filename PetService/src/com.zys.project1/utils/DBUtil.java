package com.zys.project1.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DBUtil {

	// 加载数据库驱动 com.mysql.jdbc.Driver
	private static String driverName ;
	// 获取mysql连接地址
	private static String url;
	// 数据名称
	private static String username;
	// 数据库密码
	private static String password;
	// 获取一个数据的连接
	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement prepareStatement = null;
	
	static{
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
		driverName = resourceBundle.getString("drivername");
		url = resourceBundle.getString("url");
		username = resourceBundle.getString("username");
		password = resourceBundle.getString("password");
		
	}

	// 更新数据库操作->insert/update/delete
	public int update(String sql, Object... params) {

		int r = 0;

		try {

			getConnection();
			prepareStatement = connection.prepareStatement(sql);
			// 设置参数
			if (params != null) {
				// 不定参是被当成数组使用
				for (int i = 0; i < params.length; i++) {
					prepareStatement.setObject(i + 1, params[i]);
				}
			}
			// i为受该条sql语句影响的记录条数
			r = prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// 连接资源非常珍贵，一定要关！
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return r;

	}

	public CachedRowSet query(String sql, Object... params) {

		CachedRowSet cachedRowSet = null;

		try {

			getConnection();
			// 不推荐直接用
			// cachedRowSet = new CachedRowSetImpl();

			// 使用新建工厂的方法
			RowSetFactory factory = RowSetProvider.newFactory();
			cachedRowSet = factory.createCachedRowSet();

			prepareStatement = connection.prepareStatement(sql);
			// 设置参数
			if (params != null) {
				// 不定参是被当成数组使用
				for (int i = 0; i < params.length; i++) {
					prepareStatement.setObject(i + 1, params[i]);
				}
			}
			// 设置参数（参数位置，参数值）
			resultSet = prepareStatement.executeQuery();
			cachedRowSet.populate(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cachedRowSet;

	}

	public CachedRowSet queryByPage(String sql, int pageSize, int page, Object... params) {

		getConnection();
		CachedRowSet cachedRowSet = null;
		try {
			prepareStatement = connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					prepareStatement.setObject(i + 1, params[i]);
				}
			}
			resultSet = prepareStatement.executeQuery();
			// RowSet进行分页
			RowSetFactory factory = RowSetProvider.newFactory();
			cachedRowSet = factory.createCachedRowSet();
			// 参数判断
			if (pageSize < 1) {
				pageSize = 1;
			}
			if (page < 1) {
				page = 1;
			}
			cachedRowSet.setPageSize(pageSize);
			// 生成caccheRowSet,然后指定的条数开始。
			cachedRowSet.populate(resultSet, (page - 1) * pageSize + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cachedRowSet;

	}

	public Connection getConnection() {
		// 不要使用单列
		// Connection资源是最宝贵的，一般来说会占用大多数的操作时间，所以Connection一定要关闭回收。
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;

	}

	public void close() {
		// 必须先关闭结果集
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (prepareStatement != null) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 连接资源非常珍贵，一定要关！
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
