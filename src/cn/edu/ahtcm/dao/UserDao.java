package cn.edu.ahtcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
