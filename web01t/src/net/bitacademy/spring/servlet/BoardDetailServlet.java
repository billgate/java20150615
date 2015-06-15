package net.bitacademy.spring.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/detail.do")
public class BoardDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>Insert title here</title>");
    out.println("</head>");
    out.println("<body>");
    
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb", "study", "study");
    
      stmt = con.createStatement();
      rs = stmt.executeQuery(
          "select bno, title, content, cre_dt, views"
          + " from board"
          + " where bno=" + req.getParameter("no"));
      
      out.println("<h1>게시물 상세정보</h1>");
      out.println("<table border='1'>");
      out.println("<tr>");
      out.println("  <th>번호</th>"
          + "<td><input type='text' readonly value='" + rs.getInt("bno")
          + "'></td>");
      out.println("</tr>");
      
      out.println("<tr>");
      out.println("  <th>제목</th><td><input type='text' value=''></td>");
      out.println("</tr>");
      
      out.println("<tr>");
      out.println("  <th>등록일</th><td></td>");
      out.println("</tr>");
      
      out.println("<tr>");
      out.println("  <th>조회수</th><td></td>");
      out.println("</tr>");
      
      out.println("</table>");
      
    } catch (Exception e) {
      out.println("예외 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");

    } finally {
      try { rs.close(); } catch (Exception ex) {}
      try { stmt.close(); } catch (Exception ex) {}
      try { con.close(); } catch (Exception ex) {}
    }
    
    out.println("</body>");
    out.println("</html>");
  }

}









