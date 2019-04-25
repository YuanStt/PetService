package com.zys.project1.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zys.project1.utils.DBUtil;
import com.zys.project1.utils.Log4jUtil;
import com.zys.project1.dao.PetSerDAO;
import com.zys.project1.entity.PetSer;

public class PetSerDAOImpl implements PetSerDAO {
	
	private DBUtil dbUtil = new DBUtil();
	
	Logger logger = Log4jUtil.getInstance(PetSerDAOImpl.class.getName());

	@Override
	public int save(PetSer petSer) {
		
		String sql1 = "insert into tab_customer(cus_name,cus_male,cus_phone,cus_address,ordertime,charge,oddnum)values(?,?,?,?,?,?,?)";
		String sql2 = "insert into tab_pet(pet_kind,pet_name,cus_name,serviceitem,oddnum) values(?,?,?,?,?)";
		int sqlcount1 = dbUtil.update(sql1,petSer.getCusname(),petSer.getCusmale(),petSer.getCusphone(),petSer.getCusaddress()
				,petSer.getOrdertime(),petSer.getCharge(),petSer.getOddnum());
		int sqlcount2 = dbUtil.update(sql2, petSer.getPetkind(),petSer.getPetname(),petSer.getCusname()
				,petSer.getServiceitem(),petSer.getOddnum());
		int i = sqlcount1 + sqlcount2;
		logger.info("添加服务sql语句：" + sql1+sql2);
		return i;
	}

	@Override
	public int update(PetSer petSer) {

		String sql1 = "update tab_customer set cus_name=?,cus_male=?,cus_phone=?,cus_address=?,ordertime=?,charge=? where oddnum=?";
		String sql2 = "update tab_pet set pet_kind=?,pet_name=?,cus_name=?,serviceitem=? where oddnum=?";
		int sqlcount1 = dbUtil.update(sql1, petSer.getCusname(),petSer.getCusmale(),petSer.getCusphone(),petSer.getCusaddress()
				,petSer.getOrdertime(),petSer.getCharge(),petSer.getOddnum());
		int sqlcount2 = dbUtil.update(sql2, petSer.getPetkind(),petSer.getPetname(),petSer.getCusname()
				,petSer.getServiceitem(),petSer.getOddnum());
		int i = sqlcount1 + sqlcount2;
		logger.info("修改服务sql语句：" + sql1+sql2);
		return i;
	}

	@Override
	public int delete(String oddnum) {

		String sql1 = "delete from tab_customer where oddnum = ?";
		String sql2 = "delete from tab_pet where oddnum = ?";
		int sqlcount1 = dbUtil.update(sql1, oddnum);
		int sqlcount2 = dbUtil.update(sql2, oddnum);
		int i = sqlcount1 + sqlcount2;
		logger.info("修改服务sql语句：" + sql1+sql2);
		return i;
	}

	@Override
	public List<PetSer> findPetSerByOdd(String oddnum) {

		List<PetSer> list = new ArrayList<PetSer>();
		oddnum = "%" + oddnum + "%";
		String sql = "select * from tab_customer,tab_pet where tab_customer.oddnum like ? and tab_pet.oddnum like ?";
		ResultSet resultSet = dbUtil.query(sql, oddnum,oddnum);
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
	public List<PetSer> findPetSerByCusName(String cusname) {

		List<PetSer> list = new ArrayList<PetSer>();
		cusname = "%" + cusname + "%";
		String sql = "select * from tab_customer,tab_pet where tab_customer.cus_name like ? and tab_pet.cus_name like ?";
		ResultSet resultSet = dbUtil.query(sql, cusname, cusname);
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
		int allCount = 0;
		String sql = "select count(*) from tab_customer,tab_pet where tab_customer.oddnum=tab_pet.oddnum"; // 别名 在count(*)写成
															// count(*) c

		ResultSet resultSet = dbUtil.query(sql);
		try {
			while (resultSet.next()) {
				allCount = resultSet.getInt(1); // 这里写成allCount =
												// resultSet.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			logger.info("服务信息总条数：" + allCount + "查询的sql语句：" + sql);
		}

		return allCount;
	}

	@Override
	public List<PetSer> findAllByPage(int pageSize, int page) {
		List<PetSer> list = new ArrayList<PetSer>();
		String sql = "select * from tab_customer,tab_pet where tab_customer.oddnum=tab_pet.oddnum";
		ResultSet resultSet = dbUtil.queryByPage(sql, pageSize, page);
		try {
			while (resultSet.next()) {
				handleDate(list, resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<PetSer> findAll() {
		
		List<PetSer> list = new ArrayList<PetSer>();
		ResultSet resultSet = dbUtil.query("select * from tab_customer,tab_pet where tab_customer.oddnum=tab_pet.oddnum");
		try {
			while (resultSet.next()) {
				// 读取记录
				handleDate(list, resultSet);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			logger.info("查找的服务信息：" + list);
		}
		return list;
	}
	
	private void handleDate(List<PetSer> list, ResultSet resultSet) throws SQLException {
		String poddnum = resultSet.getString("oddnum");
		String serviceitem = resultSet.getString("serviceitem");
		String cusname = resultSet.getString("cus_name");
		String cusmale = resultSet.getString("cus_male");
		String cusphone = resultSet.getString("cus_phone");
		String cusaddress = resultSet.getString("cus_address");
		String ordertime = resultSet.getString("ordertime");
		String charge = resultSet.getString("charge");
		String petkind = resultSet.getString("pet_kind");
		String petname = resultSet.getString("pet_name");
		PetSer petSer = new PetSer(poddnum, serviceitem, cusname, cusmale, cusphone, cusaddress, ordertime, charge, petkind, petname);
		list.add(petSer);
	}

	

}
