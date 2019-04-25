package com.zys.project1.service.impl;

import java.util.List;

import com.zys.project1.dao.PetDAO;
import com.zys.project1.dao.impl.PetDAOImpl;
import com.zys.project1.entity.Pet;
import com.zys.project1.service.PetService;

public class PetServiceImpl implements PetService {

	private PetDAO petDAO = new PetDAOImpl();
	
	@Override
	public boolean save(Pet pet) {

		int i = petDAO.save(pet);
		return i == 1 ? true : false;
	}

	@Override
	public boolean update(Pet pet) {

		int i = petDAO.update(pet);
		return i == 1 ? true : false;
	}

	@Override
	public boolean delete(String oddnum) {

		int i = petDAO.delete(oddnum);
		return i == 1 ? true : false;
	}

	@Override
	public List<Pet> findPetSerByOdd(String oddnum) {
		List<Pet> list = petDAO.findPetSerByOdd(oddnum);
		return list;
	}

	@Override
	public List<Pet> findPetSerByName(String cusname) {

		List<Pet> list = petDAO.findPetSerByCusName(cusname);
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

}
