package com.zys.project1.dao;

import java.util.List;

import com.zys.project1.entity.PetSer;

public interface PetSerDAO {

	// ��ӷ���
	public int save(PetSer petSer);

	// �޸ķ�����Ϣ
	public int update(PetSer petSer);

	// ɾ��������Ϣ
	public int delete(String oddnum);

	// ��ѯ���񣬰��ն����Ų�ѯ
	public List<PetSer> findPetSerByOdd(String oddnum);

	// ��ѯ���񣬰��տͻ�������ѯ
	public List<PetSer> findPetSerByCusName(String cusname);
	
	//�������з�����Ϣ
	public List<PetSer> findAll();

	// ͳ�Ʊ��м�¼�ж�����
	public int count();

	// ��ҳ
	public List<PetSer> findAllByPage(int pageSize, int page);

}
