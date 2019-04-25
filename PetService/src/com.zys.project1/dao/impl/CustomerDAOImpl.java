package com.zys.project1.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zys.project1.dao.CustomerDAO;
import com.zys.project1.entity.Customer;
import com.zys.project1.utils.DBUtil;
import com.zys.project1.utils.Log4jUtil;

public class CustomerDAOImpl implements CustomerDAO {
	
	private DBUtil dbUtil = new DBUtil();
	
	Logger logger = Log4jUtil.getInstance(PetSerDAOImpl.class.getName());

	@Override
	public int save(Customer customer) {

		String sql = "insert into tab_customer(cus_name,cus_male,cus_phone,cus_address,ordertime,charge,oddnum)values(?,?,?,?,?,?,?)";
		int i = dbUtil.update(sql,customer.getCusname(),customer.getCusmale(),customer.getCusphone(),customer.getCusaddress()
				,customer.getOrdertime(),customer.getCharge(),customer.getOddnum());
		logger.info("添加服务sql语句：" + sql);
		return i;
	}

	@Override
	public int update(Customer customer) {
		
		String sql = "update tab_customer set cus_name=?,cus_male=?,cus_phone=?,cus_address=?,ordertime=?,charge=? where oddnum=?";
		int i = dbUtil.update(sql, customer.getCusname(),customer.getCusmale(),customer.getCusphone(),customer.getCusaddress()
				,customer.getOrdertime(),customer.getCharge(),customer.getOddnum());
		logger.info("修改服务sql语句：" + sql);
		return i;
	}

	@Override
	public int delete(String oddnum) {
		String sql = "delete from tab_customer where oddnum = ?";
		int i = dbUtil.update(sql, oddnum);
		logger.info("修改服务sql语句：" + sql);
		return i;
	}

	@Override
	public List<Customer> findPetSerByOdd(String oddnum) {
		List<Customer> list = new ArrayList<Customer>();
		oddnum = "%" + oddnum + "%";
		String sql = "select * from tab_customer where oddnum like ?";
		ResultSet resultSet = dbUtil.query(sql,oddnum);
		try {
			while (resultSet.next()) {
				
				handleDate(list, resultSet);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			logger.info("按订单号"+oddnum+"查找的服务信息：" + list);
		}
		return list;
	}

	@Override
	public List<Customer> findPetSerByCusName(String cusname) {
		List<Customer> list = new ArrayList<Customer>();
		cusname = "%" + cusname + "%";
		String sql = "select * from tab_customer where cus_name like ? ";
		ResultSet resultSet = dbUtil.query(sql, cusname);
		try {
			while (resultSet.next()) {
				
				handleDate(list, resultSet);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			logger.info("按姓名"+cusname+"查找的服务信息：" + list);
		}
		return list;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customer> finAllByPage(int pageSize, int page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void handleDate(List<Customer> list, ResultSet resultSet) throws SQLException {
		int cusid = resultSet.getInt("cus_id");
		String poddnum = resultSet.getString("oddnum");
		String cusname = resultSet.getString("cus_name");
		String cusmale = resultSet.getString("cus_male");
		String cusphone = resultSet.getString("cus_phone");
		String cusaddress = resultSet.getString("cus_address");
		String ordertime = resultSet.getString("ordertime");
		String charge = resultSet.getString("charge");
		Customer customer = new Customer(cusid,poddnum, cusname, cusmale, cusphone, cusaddress, ordertime, charge);
		list.add(customer);
	}

}
