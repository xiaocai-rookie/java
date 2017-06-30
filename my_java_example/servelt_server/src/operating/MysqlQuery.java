package operating;

import bean.User;
import util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class MysqlQuery {
    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/rookie_lify";
    private String name = "rookie";
    private  String password = "";

    public List<User> queryMysql(){
        List<User> list = new ArrayList<>();
        try {
           // Class.forName(driver);//加载驱动
            //conn = DriverManager.getConnection(url,name,password);//建立建立连接
            conn = JdbcUtil.getConnection();
            // PreparedStatement mysql = conn.prepareStatement("select * from practice WHERE id = ?");//执行sql
                PreparedStatement mysql = conn.prepareStatement("select * from practice");//执行sql
           // mysql.setInt(1,1);
            //Statement sql = conn.createStatement();
            ResultSet result = mysql.executeQuery();//获得执行sql 之后的结果集
            while(result.next()){
//                System.out.println(result.getString("description"));
//                System.out.println(result.getString("name"));
                String name = result.getString("name");
                String des = result.getString("description");
                int id = result.getInt("id");
                Date date = result.getDate("insert_time");
                User u = new User();
                u.setName(name);
                u.setDescription(des);
                u.setId(id);
                u.setInsertTime(date);
                list.add(u);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
        }
        return null;
    }

/*    public static void main(String[] args) {
        MysqlQuery testMysql = new MysqlQuery();
       List<User> list =  testMysql.queryMysql();
        for (User user : list) {
            System.out.println(user);
        }
    }*/
}
