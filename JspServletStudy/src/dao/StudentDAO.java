package dao;

import entity.Student;

import java.util.List;


/**
 * ���ݿ�����Ľӿ�
 * ���Ը�����Ŀ����Ҫ��������ɾ���ӿڷ���
 *
 */
public interface StudentDAO {
	
	//����ѧ��
	public int save(Student student);
	
	//�޸�ѧ��
	public int update(Student student);
	
	//ɾ��ѧ����ͨ��id
	public int delete(Integer id);
	
	//ͨ��ѧ��ɾ��
	public int deleteByStuNo(String stuNo);
	
	//���ص���ѧ����Ϣ
	public Student findById(Integer id);
	
	//ͨ��ѧ����ŷ���ѧ����Ϣ
	public Student findByStuNo(String stuNo);
	
	//��������ѧ����Ϣ
	public List<Student> findAll();
	
	//�������֣�ģ����ң�����ѧ����Ϣ
	public List<Student> findByStuName(String stuName);
	
	//ͳ�Ʊ��м�¼�ж�����
	public int count();
	
	//��ҳ
	public List<Student> finAllByPage(int pageSize, int page);

}
