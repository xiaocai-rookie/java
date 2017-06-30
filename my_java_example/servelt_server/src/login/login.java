package login;
// 导入必需的 java 库
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// 扩展 HttpServlet 类
public class login extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // 执行必需的初始化
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //以下为接收数据
                double operator1 = Double.parseDouble(request.getParameter("number1"));
                String operatorSign = request.getParameter("number2");
                double operator2 = Double.parseDouble(request.getParameter("number3"));
              if(operatorSign.equals("+")) {
                          PrintWriter out = response.getWriter();    //设定传参变量
                          out.print(add(operator1, operator2));      //结果传到前端
                     } else if (operatorSign.equals("-")) {
                           PrintWriter out = response.getWriter();
                           out.print(sub(operator1, operator2));
                     } else if (operatorSign.equals("*")) {
                           PrintWriter out = response.getWriter();
                           out.print(mult(operator1, operator2));
                     } else if (operatorSign.equals("/")) {
                             PrintWriter out = response.getWriter();
                             response.setHeader("Content-type", "text/html;charset=UTF-8");
                            // String strRe = new String(request.getParameter("xxx").getBytes("ISO-8859-1"),"UTF-8");
                            response.setContentType("application/json;charset=utf8");
                            response.setCharacterEncoding("UTF-8");
                            double responNmuber = dev(operator1, operator2);
                            //JSONObject json = new JSONObject();
                            String jsonStr = "{\"name\":\"中国\",\"age\":20,\"a\":90}";
                            out.print(jsonStr);
                     }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setContentType("application/json;charset=utf8");
        response.setCharacterEncoding("UTF-8");
        String jsonStr = "中国";
        out.print(jsonStr);
    }
    public double add(double a,double b) {
               return a+b;
             }

                 public double sub(double a,double b) {
                 return a-b;
             }
         public double mult(double a,double b) {
                return a*b;
            }
         public double dev(double a,double b) {
                     return a/b;
             }
    public void destroy()
    {
        // 什么也不做
    }
}