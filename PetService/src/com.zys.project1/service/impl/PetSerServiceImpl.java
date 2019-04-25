package com.zys.project1.service.impl;

import java.util.List;

import com.zys.project1.dao.PetSerDAO;
import com.zys.project1.dao.impl.PetSerDAOImpl;
import com.zys.project1.entity.PetSer;
import com.zys.project1.service.PetSerService;

public class PetSerServiceImpl implements PetSerService {
	private PetSerDAO petSerDAO = new PetSerDAOImpl();

	@Override
	public boolean save(PetSer petSer) {
		
		int i = petSerDAO.save(petSer);
		return i == 2 ? true : false;
	}

	@Override
	public boolean update(PetSer petSer) {
		
		int i = petSerDAO.update(petSer);
		return i == 2 ? true : false;
	}

	@Override
	public boolean delete(String oddnum) {
		
		int i =petSerDAO.delete(oddnum);
		return i == 2 ? true : false;
	}

	@Override
	public List<PetSer> findPetSerByOdd(String oddnum) {
		
		List<PetSer> list = petSerDAO.findPetSerByOdd(oddnum);
		return list;
	}

	@Override
	public List<PetSer> findPetSerByName(String cusname) {
		
		List<PetSer> list = petSerDAO.findPetSerByCusName(cusname);
		return list;
	}

	@Override
	public int count() {
		return petSerDAO.count();
	}

	@Override
	public List<PetSer> findAllByPage(int pageSize, int page) {
		List<PetSer> list = petSerDAO.findAllByPage(pageSize,page);
		return list;
	}

	@Override
	public List<PetSer> findAll() {

		List<PetSer> list = petSerDAO.findAll();
		return list;
	}

}
