package operating;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class MysqlDelete {
    private Connection conn;
    public int deleteData(int id ){
        conn = JdbcUtil.getConnection();
        try {
            PreparedStatement mysql = conn.prepareStatement("delete from practice where id=?");
            mysql.setInt(1,id);
            int result = mysql.executeUpdate();
            System.out.print(result);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
