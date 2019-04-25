package com.zys.project1.service.impl;

import java.util.List;

import com.zys.project1.dao.CustomerDAO;
import com.zys.project1.dao.impl.CustomerDAOImpl;
import com.zys.project1.entity.Customer;
import com.zys.project1.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO customerDAO = new CustomerDAOImpl();

	@Override
	public boolean save(Customer customer) {
		int i = customerDAO.save(customer);
		return i == 1 ? true : false;
	}

	@Override
	public boolean update(Customer customer) {

		int i = customerDAO.update(customer);
		return i == 1 ? true : false;
	}

	@Override
	public boolean delete(String oddnum) {

		int i = customerDAO.delete(oddnum);
		return i == 1 ? true : false;
	}

	@Override
	public List<Customer> findPetSerByOdd(String oddnum) {
		List<Customer> list = customerDAO.findPetSerByOdd(oddnum);
		return list;
	}

	@Override
	public List<Customer> findPetSerByName(String cusname) {
		
		List<Customer> list = customerDAO.findPetSerByCusName(cusname);
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

}
