package service;


import entity.User;

public interface UserService {

	public boolean register(User user);
	
	public boolean auth(String username, String password);
	
	public User findByUsername(String username);

	public boolean countByUsername(String username);
	
}
