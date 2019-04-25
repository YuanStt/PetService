package com.zys.project1.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zys.project1.dao.PetDAO;
import com.zys.project1.entity.Pet;
import com.zys.project1.utils.DBUtil;
import com.zys.project1.utils.Log4jUtil;

public class PetDAOImpl implements PetDAO {
	
	private DBUtil dbUtil = new DBUtil();
	
	Logger logger = Log4jUtil.getInstance(PetSerDAOImpl.class.getName());

	@Override
	public int save(Pet pet) {
		String sql = "insert into tab_pet(pet_kind,pet_name,cus_name,serviceitem,oddnum) values(?,?,?,?,?)";
		int i = dbUtil.update(sql, pet.getPetkind(),pet.getPetname(),pet.getCusname()
				,pet.getServiceitem(),pet.getOddnum());
		logger.info("添加服务sql语句：" + sql);
		return i;
	}

	@Override
	public int update(Pet pet) {
		
		String sql = "update tab_pet set pet_kind=?,pet_name=?,cus_name=?,serviceitem=? where oddnum=?";
		int i = dbUtil.update(sql, pet.getPetkind(),pet.getPetname(),pet.getCusname()
				,pet.getServiceitem(),pet.getOddnum());
		logger.info("修改服务sql语句：" + sql);
		return i;
	}

	@Override
	public int delete(String oddnum) {
		String sql = "delete from tab_pet where oddnum = ?";
		int i = dbUtil.update(sql, oddnum);
		logger.info("修改服务sql语句：" + sql);
		return i;
	}

	@Override
	public List<Pet> findPetSerByOdd(String oddnum) {
		
		List<Pet> list = new ArrayList<Pet>();
		oddnum = "%" + oddnum + "%";
		String sql = "select * from tab_pet where oddnum like ?";
		ResultSet resultSet = dbUtil.query(sql, oddnum);
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
	public List<Pet> findPetSerByCusName(String cusname) {
		List<Pet> list = new ArrayList<Pet>();
		cusname = "%" + cusname + "%";
		String sql = "select * from tab_pet where cus_name like ?";
		ResultSet resultSet = dbUtil.query(sql,cusname);
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
	public List<Pet> finAllByPage(int pageSize, int page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void handleDate(List<Pet> list, ResultSet resultSet) throws SQLException {
		int petid = resultSet.getInt("pet_id");
		String poddnum = resultSet.getString("oddnum");
		String serviceitem = resultSet.getString("serviceitem");
		String cusname = resultSet.getString("cus_name");
		String petkind = resultSet.getString("pet_kind");
		String petname = resultSet.getString("pet_name");
		Pet pet = new Pet(petid,poddnum, serviceitem, cusname, petkind, petname);
		list.add(pet);
	}

}
