package com.zys.project1.dao;

import java.util.List;

import com.zys.project1.entity.Pet;

public interface PetDAO {

	// ��ӷ���
	public int save(Pet pet);

	// �޸ķ�����Ϣ
	public int update(Pet pet);

	// ɾ��������Ϣ
	public int delete(String oddnum);

	// ��ѯ���񣬰��ն����Ų�ѯ
	public List<Pet> findPetSerByOdd(String oddnum);

	// ��ѯ���񣬰��տͻ�������ѯ
	public List<Pet> findPetSerByCusName(String cusname);

	// ͳ�Ʊ��м�¼�ж�����
	public int count();

	// ��ҳ
	public List<Pet> finAllByPage(int pageSize, int page);

}
