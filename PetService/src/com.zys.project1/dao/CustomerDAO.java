package com.zys.project1.dao;

import java.util.List;

import com.zys.project1.entity.Customer;

public interface CustomerDAO {
	
	// ��ӷ���
	public int save(Customer customer);

	// �޸ķ�����Ϣ
	public int update(Customer customer);

	// ɾ��������Ϣ
	public int delete(String oddnum);

	// ��ѯ���񣬰��ն����Ų�ѯ
	public List<Customer> findPetSerByOdd(String oddnum);

	// ��ѯ���񣬰��տͻ�������ѯ
	public List<Customer> findPetSerByCusName(String cusname);

	// ͳ�Ʊ��м�¼�ж�����
	public int count();

	// ��ҳ
	public List<Customer> finAllByPage(int pageSize, int page);

}
