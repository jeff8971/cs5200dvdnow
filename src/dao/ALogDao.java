package dao;

import bean.ALog;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ALogDao {
    DbUtil dbUtil=new DbUtil();
    public void addAdmin(Connection con, ALog aLog) throws Exception{
        con=dbUtil.getCon();
        PreparedStatement ps=con.prepareStatement("update alog set admin_id=?,admin_username=?,admin_password=?,admin_name=?,admin_sex=?,admin_age=? where id=1");
        ps.setInt(1,aLog.getaId());
        ps.setString(2,aLog.getaUsername());
        ps.setString(3,aLog.getaPassword());
        ps.setString(4,aLog.getaNmae());
        ps.setString(5,aLog.getaSex());
        ps.setString(6,aLog.getaAge());
        ps.executeUpdate();
    }

    // Get the admin ID and return an ALog object with a single ID
    public ALog readAdmin(Connection con) throws Exception{
        con=dbUtil.getCon();
        PreparedStatement ps=con.prepareStatement("select admin_id from alog where id=1;");
        ResultSet rs=ps.executeQuery();
        if (rs.next()){
            ALog aLog=new ALog();
            aLog.setaId(rs.getInt("admin_id"));
            return aLog;
        }
        return null;
    }


}
