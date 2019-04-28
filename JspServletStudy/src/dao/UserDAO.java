package dao;

import entity.User;

public interface UserDAO {
    public int save(User user);

    //通过用户名和密码 进行统计
    public int countByUsernameAndPassword(String username, String password);

    //通过用户名读取用户
    public User findByUsername(String username);
}
