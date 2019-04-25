package com.zys.project1.service;

import java.util.List;

import com.zys.project1.entity.Pet;

public interface PetService {
	
	public boolean save(Pet pet);
	
	public boolean update(Pet pet);
	
	public boolean delete(String oddnum);
	
	public List<Pet> findPetSerByOdd(String oddnum);
	
	public List<Pet> findPetSerByName(String cusname);
	
	public int count();
	
	public List<Pet> finAllByPage(int pageSize, int page);

}
