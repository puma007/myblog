package cn.edu.ahtcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.ahtcm.bean.User;

public class UserDao {

    /*
     * 用户注册
     */
    public void saveUser(User user) {
        Connection conn = DBManager.getConnection();
        String sql = "insert into users(name,password) values(?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
    }
    
  //登陆
    public User existUser(String name, String password) {
        User user = null;
        Connection conn = DBManager.getConnection();
        String sql = "select * from users where name=? and password=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            //执行查询
            ResultSet rs = ps.executeQuery();
            System.out.println("执行查询");
            //判断结果集是否有效
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
            // 释放此 ResultSet 对象的数据库和 JDBC 资源
            rs.close();
            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            DBManager.closeConnection(conn);
        }
        return user;
    }
    
    /*
     * 通过name判断用户名是否存在
     */
    
}
