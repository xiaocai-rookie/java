package weboperation;

import bean.User;
import operating.MysqlAdd;
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
public class Add extends HttpServlet {
    private String message;
    private JdbcUtil jdbcUtil;


    public void init() throws ServletException {
        // 执行必需的初始化
        message = "Hello World";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        MysqlAdd add = new MysqlAdd();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String data = request.getParameter("date");
        Date  date = Date.valueOf(request.getParameter("date"));
        int number = add.addData(id,name,description,date);
        System.out.print(number);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=utf8");
        response.setCharacterEncoding("UTF-8");
        if(number == 0){
            out.print("{code:0}");
        }else{
            out.print("{code:1}");
        }
    }
}
