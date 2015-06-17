package net.bitacademy.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/list.do")
public class BoardListController {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping
  public String list(HttpServletRequest req, HttpServletResponse resp)
      throws Exception {
    List<Board> boards = boardDao.selectList();
    
    req.setAttribute("list", boards);
    return "/board/list.jsp";
  }

}









