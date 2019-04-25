package com.zys.project1.service;

import java.util.List;

import com.zys.project1.entity.PetSer;

public interface PetSerService {
	
	public boolean save(PetSer petSer);
	
	public boolean update(PetSer petSer);
	
	public boolean delete(String oddnum);
	
	public List<PetSer> findPetSerByOdd(String oddnum);
	
	public List<PetSer> findPetSerByName(String cusname);
	
	public List<PetSer> findAll();
	
	public int count();
	
	public List<PetSer> findAllByPage(int pageSize, int page);

}
