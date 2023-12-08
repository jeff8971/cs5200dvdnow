package dao;

import bean.Dvd;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DvdDao {
    DbUtil dbUtil=new DbUtil();
    public int addDvd(Connection con, Dvd dvd){

        int result = 0;
        String sql="insert into dvd (dvd_id,dvd_name,dvd_price) values (?,?,?)";
        try {
            con =dbUtil.getCon();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,dvd.getdId());
            ps.setString(2,dvd.getdName());
            ps.setString(3,dvd.getdPrice());
            result=ps.executeUpdate();
            dbUtil.closeCon(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet listDvd(Connection con,Dvd dvd) throws Exception{
       StringBuffer sb=new StringBuffer("select * from dvd");
       if(dvd.getdName()!=null){
           sb.append(" and dvd_name like '%"+dvd.getdName()+"%'");  //看不懂
       }
        PreparedStatement ps=con.prepareStatement(sb.toString().replaceFirst("and","where"));
        ResultSet rs=ps.executeQuery();
        return rs;
    }

    /**
     * Delete Dvds
     * @param con
     * @param dvd
     * @return
     */
    public int deleteDvd(Connection con,Dvd dvd) throws Exception{
        String sql="delete from dvd where dvd_id=? and dvd_name=? and dvd_price =?";
        con=dbUtil.getCon();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,dvd.getdId());
        ps.setString(2,dvd.getdName());
        ps.setString(3,dvd.getdPrice());
        return ps.executeUpdate();
    }

    /**
     * Change Dvds information
     * @param con
     * @param dvd
     * @return
     */
    public int changeDvd(Connection con,Dvd dvd) throws  Exception{
        con=dbUtil.getCon();
        PreparedStatement ps=con.prepareStatement("update dvd set dvd_name=? ,dvd_price=? where dvd_id=?");
        ps.setString(1,dvd.getdName());
        ps.setString(2,dvd.getdPrice());
        ps.setInt(3,dvd.getdId());
        return ps.executeUpdate();
    }
}
