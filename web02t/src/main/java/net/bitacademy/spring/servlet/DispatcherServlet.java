package net.bitacademy.spring.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.controller.BoardListController;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    resp.setContentType("text/html;charset=UTF-8");
    
    try {
      //http://localhost:9999/web02t/board/list.do?pageNo=2&size=5
      //-getServletPath() ==> /board/list.do
      
      String viewUrl = null;
      if (req.getServletPath().equals("/board/list.do")) {
        BoardListController controller = new BoardListController();
        viewUrl = controller.execute(req, resp);
      }
      
      RequestDispatcher rd = req.getRequestDispatcher(viewUrl);
      rd.include(req, resp);
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.include(req, resp);
    }
  }
}















