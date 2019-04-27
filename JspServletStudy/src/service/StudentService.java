package service;

import entity.Student;

import java.util.List;

/*
 * service�ӿڣ����Ը��������Զ���ӿ�
 */
public interface StudentService {
	
	public boolean save(Student student);
	
	public boolean update(Student student);
	
	public boolean delete(Integer id);
	
	public List<Student> findAll();
	
	public List<Student> findByName(String stuName);
	
	public int count();
	
	public Student findById(Integer id);

}
