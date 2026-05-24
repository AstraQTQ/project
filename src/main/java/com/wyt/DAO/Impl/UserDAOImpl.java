package com.wyt.DAO.Impl;

import com.wyt.DAO.UserDAO;
import com.wyt.entity.AdminUser;
import com.wyt.entity.Status;
import com.wyt.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//用于处理用户数据表的操作
public class UserDAOImpl implements UserDAO {

     // 根据用户名和密码查询匹配的记录数
    @Override
    public int selectByUserNameAndPassword(String username, String password) {
        String sql = "select count(*) from user where username = ? and password = ?";
        int result = 0;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

 //插入新用户
    @Override
    public int insertUser(AdminUser adminUser) {
        String sql = "insert into user(username,password,phone,email,status,createTime) " +
                "values(?,?,?,?,?,now())";
        int result = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // 关闭事务的自动提交，手动控制事务
            c.setAutoCommit(false);
            ps.setString(1, adminUser.getUsername());
            ps.setString(2, adminUser.getPassword());
            ps.setString(3, adminUser.getPhone());
            ps.setString(4, adminUser.getEmail());
            ps.setObject(5, adminUser.getStatus());
            result = ps.executeUpdate();
            if (result > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    adminUser.setId(id.longValue());
                }
            }
            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // 发生异常时回滚事务
            try {
                if (c != null) {
                    c.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // 关闭资源
            try {
                rs.close();
                ps.close();
                c.setAutoCommit(true);
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

   //根据用户名查询匹配的记录数
    @Override
    public int selectByUsername(String username) {
        String sql = "select count(*) from user where username = ?";
        int result = 0;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    result = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

   //更新用户信息
    @Override
    public int updateUser(AdminUser adminUser) {
        String sql = "update user set username = ? ,password = ?,phone=? ,email=? ,createTime=now() where id = ? ";
        int result = 0;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, adminUser.getUsername());
            ps.setString(2, adminUser.getPassword());
            ps.setString(3, adminUser.getPhone());
            ps.setString(4, adminUser.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

  //根据用户ID查询用户信息
    @Override
    public AdminUser selectById(Long id) {
        String sql = "select * from user where id = ?";
        AdminUser adminUser = null;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    adminUser = new AdminUser();
                    adminUser.setId(rs.getLong("id"));
                    adminUser.setUsername(rs.getString("username"));
                    adminUser.setPassword(rs.getString("password"));
                    adminUser.setPhone(rs.getString("phone"));
                    adminUser.setEmail(rs.getString("email"));
                    adminUser.setStatus(Status.valueOf(rs.getString("status")));
                    adminUser.setCreateTime(rs.getTimestamp("gmt_create"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminUser;
    }
}
