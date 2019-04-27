package service.impl;

import dao.StudentDAO;
import dao.impl.StudentDAOImpl;
import entity.Student;
import service.StudentService;

import java.util.List;


public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO = new StudentDAOImpl();

	@Override
	public boolean save(Student student) {

		int i = studentDAO.save(student);

		return i == 1 ? true : false;
	}

	@Override
	public boolean update(Student student) {
		int i = studentDAO.update(student);
		return i == 1 ? true : false;
	}

	@Override
	public boolean delete(Integer id) {
		int i = studentDAO.delete(id);
		return i == 1 ? true : false;
	}

	@Override
	public List<Student> findAll() {
		List<Student> list = studentDAO.findAll();
		return list;
	}

	@Override
	public List<Student> findByName(String stuName) {
		List<Student> list = studentDAO.findByStuName(stuName);
		return list;
	}

	@Override
	public int count() {

		return studentDAO.count();
	}

	@Override
	public Student findById(Integer id) {
		Student student = studentDAO.findById(id);
		return student;
	}

}
