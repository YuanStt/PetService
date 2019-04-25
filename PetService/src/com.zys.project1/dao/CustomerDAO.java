package com.zys.project1.dao;

import java.util.List;

import com.zys.project1.entity.Customer;

public interface CustomerDAO {
	
	// 添加服务
	public int save(Customer customer);

	// 修改服务信息
	public int update(Customer customer);

	// 删除服务信息
	public int delete(String oddnum);

	// 查询服务，按照订单号查询
	public List<Customer> findPetSerByOdd(String oddnum);

	// 查询服务，按照客户姓名查询
	public List<Customer> findPetSerByCusName(String cusname);

	// 统计表中记录有多少条
	public int count();

	// 分页
	public List<Customer> finAllByPage(int pageSize, int page);

}
