package dao;

import bean.Admin;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    public Admin login(Connection con,Admin admin){
        Admin resultAdmin=null;
        String sql="select * from admin where admin_username =? and admin_password=?";
        try {
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,admin.getaUsername());
            preparedStatement.setString(2,admin.getaPassword());
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                resultAdmin =new Admin();
                resultAdmin.setaId(resultSet.getInt("admin_id"));
                resultAdmin.setaUsername(resultSet.getString("admin_username"));
                resultAdmin.setaPassword(resultSet.getString("admin_password"));
                resultAdmin.setaNmae(resultSet.getString("admin_name"));
                resultAdmin.setaSex(resultSet.getString("admin_sex"));
                resultAdmin.setaAge(resultSet.getString("admin_age"));
                return resultAdmin;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return resultAdmin;
    }

    // Update user information
    public int updateAdmin(Connection connection,Admin admin) throws Exception{
        DbUtil dbUtil=new DbUtil();
        connection=dbUtil.getCon();
        PreparedStatement ps=connection.prepareStatement("update admin set admin_username=? ,admin_password=? ,admin_name=? ,admin_sex=? ,admin_age=? where admin_id=?");
        ps.setString(1,admin.getaUsername());
        ps.setString(2,admin.getaPassword());
        ps.setString(3,admin.getaNmae());
        ps.setString(4,admin.getaSex());
        ps.setString(5,admin.getaAge());
        ps.setInt(6,admin.getaId());
        return ps.executeUpdate();
    }

    // Search Admin and return
    public Admin selectAdmin(Connection connection,Admin admin) throws Exception{
        DbUtil dbUtil=new DbUtil();
        connection=dbUtil.getCon();
        PreparedStatement ps=connection.prepareStatement("select admin_id,admin_username,admin_password,admin_name,admin_sex,admin_age from admin where admin_id=?");
        ps.setString(1,String.valueOf(admin.getaId()));
        ResultSet resultSet=ps.executeQuery();
        if(resultSet.next()){
            Admin admin1=new Admin();
            admin1.setaId(resultSet.getInt("admin_id"));
            admin1.setaUsername(resultSet.getString("admin_username"));
            admin1.setaPassword(resultSet.getString("admin_password"));
            admin1.setaNmae(resultSet.getString("admin_name"));
            admin1.setaSex(resultSet.getString("admin_sex"));
            admin1.setaAge(resultSet.getString("admin_age"));
            return admin1;
        }
        return null;
    }

    // Query all the data in the Admin table and return the result set.
    public ResultSet listAdminId(Connection connection)throws Exception{
        connection=new DbUtil().getCon();
        PreparedStatement ps=connection.prepareStatement("select admin_id from admin");
        return ps.executeQuery();
    }
}
