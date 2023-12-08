package dao;

import bean.ReturnDvd;
import bean.ULog;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnDvdDao {

    public int addRenturnDvd(Connection connection, ReturnDvd returnDvd)throws Exception{
        DbUtil dbUtil=new DbUtil();
        connection=dbUtil.getCon();
        PreparedStatement ps=connection.prepareStatement("insert  into returndvd values (?,?,?,?,?,?,?)");
        ps.setInt(1,returnDvd.getaId());
        ps.setInt(2,returnDvd.getuId());
        ps.setInt(3,returnDvd.getdId());
        ps.setString(4,returnDvd.getBorrowTime());
        ps.setString(5,returnDvd.getTime());
        ps.setString(6,returnDvd.getDdl());
        ps.setString(7,returnDvd.getBackTime());
        return ps.executeUpdate();
    }

    // List of returned dvds
    public ResultSet listReturnDvd(Connection connection) throws Exception{
        DbUtil dbUtil=new DbUtil();
        ULog uLog=new ULog();
        ULogDao uLogDao=new ULogDao();
        uLog =uLogDao.readUser(connection);
        connection=dbUtil.getCon();
        PreparedStatement ps=connection.prepareStatement("select * from returndvd where user_id=?");
        ps.setInt(1,uLog.getuId());
        return ps.executeQuery();
    }
}
