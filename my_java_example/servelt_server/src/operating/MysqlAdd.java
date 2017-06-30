package operating;

import util.JdbcUtil;

import java.sql.*;
import java.sql.Date;
import java.util.*;


/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class MysqlAdd {
    private Connection conn;
    public int addData(int id ,String name,String description,Date date){
        conn = JdbcUtil.getConnection();
        try {
            PreparedStatement mysql = conn.prepareStatement("insert into practice(id,name,description,insert_time)values(?,?,?,?)");
            mysql.setInt(1,id);
            mysql.setString(2,name);
            mysql.setString(3,description);
            mysql.setDate(4,date);
            int result = mysql.executeUpdate();
            System.out.print(result);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
