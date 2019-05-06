package utils;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DBUtil {

	/*// �������ݿ����� com.mysql.jdbc.Driver
	private static String driverName ;
	// ��ȡmysql���ӵ�ַ
	private static String url;
	// ��������
	private static String username;
	// ���ݿ�����
	private static String password;
	// ��ȡһ�����ݵ�����*/
	private Connection connection = null;
	private ResultSet resultSet = null;
	private PreparedStatement prepareStatement = null;
	
	/*static{
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
		driverName = resourceBundle.getString("drivername");
		url = resourceBundle.getString("url");
		username = resourceBundle.getString("username");
		password = resourceBundle.getString("password");
		
	}*/

	// �������ݿ����->insert/update/delete
	public int update(String sql, Object... params) {

		int r = 0;

		try {

			getConnection();
			prepareStatement = connection.prepareStatement(sql);
			// ���ò���
			if (params != null) {
				// �������Ǳ���������ʹ��
				for (int i = 0; i < params.length; i++) {
					prepareStatement.setObject(i + 1, params[i]);
				}
			}
			// iΪ�ܸ���sql���Ӱ��ļ�¼����
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
			// ������Դ�ǳ����һ��Ҫ�أ�
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
			// ���Ƽ�ֱ����
			// cachedRowSet = new CachedRowSetImpl();

			// ʹ���½������ķ���
			RowSetFactory factory = RowSetProvider.newFactory();
			cachedRowSet = factory.createCachedRowSet();

			prepareStatement = connection.prepareStatement(sql);
			// ���ò���
			if (params != null) {
				// �������Ǳ���������ʹ��
				for (int i = 0; i < params.length; i++) {
					prepareStatement.setObject(i + 1, params[i]);
				}
			}
			// ���ò���������λ�ã�����ֵ��
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
			// RowSet���з�ҳ
			RowSetFactory factory = RowSetProvider.newFactory();
			cachedRowSet = factory.createCachedRowSet();
			// �����ж�
			if (pageSize < 1) {
				pageSize = 1;
			}
			if (page < 1) {
				page = 1;
			}
			cachedRowSet.setPageSize(pageSize);
			// ����caccheRowSet,Ȼ��ָ����������ʼ��
			cachedRowSet.populate(resultSet, (page - 1) * pageSize + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return cachedRowSet;

	}

	public Connection getConnection() {
		// ��Ҫʹ�õ���
		// Connection��Դ�����ģ�һ����˵��ռ�ô�����Ĳ���ʱ�䣬����Connectionһ��Ҫ�رջ��ա�
		try {
			/*Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);*/
			//采用数据库连接池技术
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/mysqlDataSource");
			connection = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;

	}

	public void close() {
		// �����ȹرս����
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
		// ������Դ�ǳ����һ��Ҫ�أ�
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
