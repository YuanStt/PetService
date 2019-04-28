package service.impl;


import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	@Override
	public boolean register(User user) {

		userDAO=new UserDAOImpl();
		int i=userDAO.save(user);
		return i==1?true:false;
	}

	@Override
	public boolean auth(String username, String password) {
		userDAO=new UserDAOImpl();
		int i=userDAO.countByUsernameAndPassword(username, password);
		return i==1?true:false;
	}

	@Override
	public User findByUsername(String username) {
		userDAO=new UserDAOImpl();
		User user = userDAO.findByUsername(username);
		return user;
	}

}
