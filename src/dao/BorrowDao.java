package dao;

import bean.Admin;
import bean.Borrow;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BorrowDao {
    DbUtil dbUtil=new DbUtil();

    /**
     * Borrow list method
     * @param con
     * @param borrow
     * @param admin
     * @return
     * @throws Exception
     */
    public ResultSet listBorrow (Connection con, Borrow borrow, Admin admin) throws Exception{
        con=dbUtil.getCon();
        PreparedStatement ps=con.prepareStatement("select user_id ,dvd_id , time, now_time from borrow where admin_id=?");
        ps.setInt(1,admin.getaId());
        return  ps.executeQuery();
    }

    // Method for deleting borrow information (delete the borrow information after borrowing, regardless of approval or not)
    public int deleteBorrow(Connection connection,Borrow borrow) throws Exception{
        connection=dbUtil.getCon();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from borrow where admin_id=? and user_id=? and dvd_id =? and time=? and now_time=?");
        preparedStatement.setInt(1,borrow.getaId());
        preparedStatement.setInt(2,borrow.getuId());
        preparedStatement.setInt(3,borrow.getdId());
        preparedStatement.setString(4,borrow.getTime());
        preparedStatement.setString(5,borrow.getDate());
        return preparedStatement.executeUpdate();
    }

    // Add borrow information
    public int addBorrow(Connection connection,Borrow borrow) throws Exception{
        connection=dbUtil.getCon();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into borrow values (?,?,?,?,?)");
        preparedStatement.setInt(1,borrow.getaId());
        preparedStatement.setInt(2,borrow.getuId());
        preparedStatement.setInt(3,borrow.getdId());
        preparedStatement.setString(4,borrow.getTime());
        preparedStatement.setString(5,borrow.getDate());
        return preparedStatement.executeUpdate();
    }
}
