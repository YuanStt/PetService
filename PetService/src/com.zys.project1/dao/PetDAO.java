package com.zys.project1.dao;

import java.util.List;

import com.zys.project1.entity.Pet;

public interface PetDAO {

	// 添加服务
	public int save(Pet pet);

	// 修改服务信息
	public int update(Pet pet);

	// 删除服务信息
	public int delete(String oddnum);

	// 查询服务，按照订单号查询
	public List<Pet> findPetSerByOdd(String oddnum);

	// 查询服务，按照客户姓名查询
	public List<Pet> findPetSerByCusName(String cusname);

	// 统计表中记录有多少条
	public int count();

	// 分页
	public List<Pet> finAllByPage(int pageSize, int page);

}
