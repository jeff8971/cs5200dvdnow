package dao;

import bean.ULog;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ULogDao {
    DbUtil dbUtil=new DbUtil();
    public void addUser(Connection con, ULog uLog) throws Exception{
        con=dbUtil.getCon();
        PreparedStatement ps=con.prepareStatement("update ulog set user_id=?,user_username=?,user_password=?,user_name=?,user_sex=?,user_age=? where id=1");
        ps.setInt(1,uLog.getuId());
        ps.setString(2,uLog.getuUsername());
        ps.setString(3,uLog.getuPassword());
        ps.setString(4,uLog.getuName());
        ps.setString(5,uLog.getuSex());
        ps.setString(6,uLog.getuSex());
        ps.executeUpdate();
    }

    // Get user ID, return a ULog object with a single ID
    public ULog readUser(Connection con) throws Exception{
        con=dbUtil.getCon();
        PreparedStatement ps=con.prepareStatement("select user_id from ulog where id=1;");
        ResultSet rs=ps.executeQuery();
        if (rs.next()){
            ULog uLog=new ULog();
            uLog.setuId(rs.getInt("user_id"));
            return uLog;
        }
        return null;
    }
}
