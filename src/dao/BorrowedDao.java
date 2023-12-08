package dao;

import bean.ALog;
import bean.Borrowed;
import bean.ULog;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BorrowedDao {

    DbUtil dbUtil=new DbUtil();
    // Insert data of borrowed dvds
    public int add(Connection con, Borrowed borrowed)throws Exception{
        con=dbUtil.getCon();
        PreparedStatement ps=con.prepareStatement("insert  into borrowed values (?,?,?,?,?,?)");
        ps.setInt(1,borrowed.getaId());
        ps.setInt(2,borrowed.getuId());
        ps.setInt(3,borrowed.getdId());
        ps.setString(4,borrowed.getTime());
        ps.setString(5,borrowed.getnTime());
        ps.setString(6,borrowed.getdTime());
        return ps.executeUpdate();
    }

    // Query borrowed dvds
    public ResultSet listBorrowed(Connection connection,Borrowed borrowed)throws Exception{
        DbUtil dbUtil=new DbUtil();
        connection=dbUtil.getCon();
        ALog aLog=new ALog();
        ALogDao aLogDao=new ALogDao();
        aLog=aLogDao.readAdmin(connection);
        PreparedStatement ps=connection.prepareStatement("select user_id,dvd_id,time,now_time,back_time from borrowed where admin_id=?");
        ps.setInt(1,aLog.getaId());
        ResultSet resultSet=ps.executeQuery();
        return resultSet;
    }

    // User query for borrowed dvds
    public ResultSet listBorrowedUser(Connection connection, Borrowed borrowed)throws Exception{
        DbUtil dbUtil=new DbUtil();
        connection=dbUtil.getCon();
        ULog uLog=new ULog();
        ULogDao uLogDao=new ULogDao();
        uLog=uLogDao.readUser(connection);
        PreparedStatement ps=connection.prepareStatement("select admin_id,dvd_id,time,now_time,back_time from borrowed where user_id=?");
        ps.setInt(1,uLog.getuId());
        ResultSet resultSet=ps.executeQuery();
        return resultSet;
    }

    // Delete borrowing information (delete after successful dvd return)
    public int deleteBorrowed(Connection connection,Borrowed borrowed) throws Exception{
        DbUtil dbUtil=new DbUtil();
        connection=dbUtil.getCon();
        PreparedStatement ps=connection.prepareStatement("delete from borrowed where admin_id=? and user_id=? and dvd_id=? and time=? and now_time=? and back_time=?");
        ps.setInt(1,borrowed.getaId());
        ps.setInt(2,borrowed.getuId());
        ps.setInt(3,borrowed.getdId());
        ps.setString(4,borrowed.getTime());
        ps.setString(5,borrowed.getnTime());
        ps.setString(6,borrowed.getdTime());
        return ps.executeUpdate();
    }
}
