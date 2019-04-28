package dao.impl;

import dao.UserDAO;
import entity.User;
import utils.DBUtil;

import javax.sql.rowset.CachedRowSet;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private DBUtil dbUtil;

    @Override
    public int save(User user) {

        String sql="insert into tbl_user(username,password,realname,phone) values(?,?,?,?)";
        dbUtil=new DBUtil();
        int i = dbUtil.update(sql, user.getUsername(),user.getPassword(),user.getRealname(),user.getPhone());
        return i;

    }

    @Override
    public int countByUsernameAndPassword(String username, String password) {

        String sql="select count(*) from tbl_user where username=? and password=?";
        dbUtil=new DBUtil();
        ResultSet resultSet=dbUtil.query(sql, username, password);
        int count=0;
        try {
            while(resultSet.next()){
                count=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if(resultSet!=null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return count;

    }

    @Override
    public User findByUsername(String username) {

        String sql="select * from tbl_user where username=?";
        User user=null;
        dbUtil=new DBUtil();
        CachedRowSet rowSet = dbUtil.query(sql,username);
        try {
            while(rowSet.next()){
                int id=rowSet.getInt("id");
                String username1=rowSet.getString("username");
                String password=rowSet.getString("password");
                String realname=rowSet.getString("realname");
                String phone=rowSet.getString("phone");
                user=new User(id,username,password,realname,phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if(rowSet!=null)
                try {
                    rowSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

        return user;

    }
}
