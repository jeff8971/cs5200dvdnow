package dao;

import bean.User;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User login(Connection con,User user){
        User resultUser =null;
        String sql="select *from user where user_username=? and user_password=?";
        try {

            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,user.getuUsername());
            preparedStatement.setString(2, user.getuPassword());
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                resultUser =new User();
                resultUser.setuId(resultSet.getInt("user_id"));
                resultUser.setuUsername(resultSet.getString("user_username"));
                resultUser.setuPassword(resultSet.getString("user_password"));
                resultUser.setuName(resultSet.getString("user_name"));
                resultUser.setuSex(resultSet.getString("user_sex"));
                resultUser.setuAge(resultSet.getString("user_age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultUser;
    }

    public ResultSet listUser(Connection connection,User user)throws Exception{
        StringBuffer sb=new StringBuffer("select * from user");
        if(user.getuName()!=null){
            sb.append(" and user_name like '%"+user.getuName()+"%'");
        }
        PreparedStatement ps=connection.prepareStatement(sb.toString().replaceFirst("and","where"));
        ResultSet rs=ps.executeQuery();
        return rs;
    }

    //Delete user
    public int deleteUser(Connection connection,User user) throws Exception{
        DbUtil dbUtil=new DbUtil();
        connection=dbUtil.getCon();
        PreparedStatement ps=connection.prepareStatement("delete  from user where user_id=? and user_username=? and user_password=? and user_name=? and user_sex=? and user_age=?");
        ps.setInt(1,user.getuId());
        ps.setString(2,user.getuUsername());
        ps.setString(3, user.getuPassword());
        ps.setString(4, user.getuName());
        ps.setString(5, user.getuSex());
        ps.setString(6, user.getuAge());
        return ps.executeUpdate();
    }

    // Modify user information
    public int changeUser(Connection connection,User user)throws Exception{
        DbUtil dbUtil=new DbUtil();
        connection=dbUtil.getCon();
        PreparedStatement ps=connection.prepareStatement("update user set user_username=? , user_password=? , user_name=? ,user_sex=? , user_age=? where user_id=?");
        ps.setString(1,user.getuUsername());
        ps.setString(2, user.getuPassword());
        ps.setString(3, user.getuName());
        ps.setString(4, user.getuSex());
        ps.setString(5, user.getuAge());
        ps.setInt(6,user.getuId());
        return ps.executeUpdate();
    }

    // Add user
    public int addUser(Connection connection,User user)throws Exception{
        DbUtil dbUtil=new DbUtil();
        connection=dbUtil.getCon();
        PreparedStatement ps=connection.prepareStatement("insert  into user values (?,?,?,?,?,?)");
        ps.setInt(1,user.getuId());
        ps.setString(2,user.getuUsername());
        ps.setString(3, user.getuPassword());
        ps.setString(4, user.getuName());
        ps.setString(5, user.getuSex());
        ps.setString(6, user.getuAge());
        return ps.executeUpdate();
    }

    // Query user information
    public User selectUser(Connection connection,User user ) throws Exception{
        DbUtil dbUtil=new DbUtil();
        connection=dbUtil.getCon();
        PreparedStatement ps=connection.prepareStatement("select user_id ,user_username,user_password,user_name,user_sex,user_age from user where user_id=?");
        ps.setInt(1,user.getuId());
        ResultSet resultSet=ps.executeQuery();
        while (resultSet.next()){
            user.setuId(resultSet.getInt("user_id"));
            user.setuUsername(resultSet.getString("user_username"));
            user.setuPassword(resultSet.getString("user_password"));
            user.setuName(resultSet.getString("user_name"));
            user.setuSex(resultSet.getString("user_sex"));
            user.setuAge(resultSet.getString("user_age"));
        }
        return user;
    }
}
