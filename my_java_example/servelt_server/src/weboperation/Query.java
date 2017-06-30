package weboperation;

import bean.User;
import com.alibaba.fastjson.JSON;
import operating.MysqlQuery;
import util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.*;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class Query extends HttpServlet {
    private String message;
    private JdbcUtil jdbcUtil;


    public void init() throws ServletException {
        // 执行必需的初始化
        message = "Hello World";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        MysqlQuery testMysql = new MysqlQuery();
        List<User> list =  testMysql.queryMysql();
        System.out.println(list);
        PrintWriter out = response.getWriter();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setContentType("application/json;charset=utf8");
        response.setCharacterEncoding("UTF-8");
       String s =  JSON.toJSONString(list);
        System.err.println(s);
        out.print(s);
    }
}
