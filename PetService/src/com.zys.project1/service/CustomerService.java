package com.zys.project1.service;

import java.util.List;

import com.zys.project1.entity.Customer;

public interface CustomerService {
	
	public boolean save(Customer customer);
	
	public boolean update(Customer customer);
	
	public boolean delete(String oddnum);
	
	public List<Customer> findPetSerByOdd(String oddnum);
	
	public List<Customer> findPetSerByName(String cusname);
	
	public int count();
	
	public List<Customer> finAllByPage(int pageSize, int page);
	

}
