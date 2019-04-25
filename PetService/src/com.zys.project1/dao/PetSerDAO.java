package com.zys.project1.dao;

import java.util.List;

import com.zys.project1.entity.PetSer;

public interface PetSerDAO {

	// 添加服务
	public int save(PetSer petSer);

	// 修改服务信息
	public int update(PetSer petSer);

	// 删除服务信息
	public int delete(String oddnum);

	// 查询服务，按照订单号查询
	public List<PetSer> findPetSerByOdd(String oddnum);

	// 查询服务，按照客户姓名查询
	public List<PetSer> findPetSerByCusName(String cusname);
	
	//返回所有服务信息
	public List<PetSer> findAll();

	// 统计表中记录有多少条
	public int count();

	// 分页
	public List<PetSer> findAllByPage(int pageSize, int page);

}
