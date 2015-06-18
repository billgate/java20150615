package net.bitacademy.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.spring.service.BoardService;
import net.bitacademy.spring.vo.Board;
import net.bitacademy.spring.vo.BoardLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
  @Autowired BoardService boardService;
  
  @RequestMapping("/list") 
  public String list(Model model) throws Exception {
    model.addAttribute("list", boardService.list());
    return "board/list";
  }
  
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String add(Board board, HttpServletRequest request) throws Exception {
    boardService.add(board, request.getRemoteAddr());
    return "redirect:list.do";
  }

  @RequestMapping(value="/change", method=RequestMethod.POST)
  public String change(Board board, HttpServletRequest request) throws Exception {
    boardService.change(board, request.getRemoteAddr());
    return "redirect:list.do";
  }
  
  @RequestMapping("/remove")
  public String remove(int no, HttpServletRequest request) throws Exception {
    boardDao.delete(no);
    logAction(no, request.getRemoteAddr(), BoardLog.CMD_DELETE);
    return "redirect:list.do";
  }
  
  @RequestMapping("/detail")
  public String detail(int no, Model model, HttpServletRequest request) throws Exception {
    Board board = boardDao.selectOne(no);
    model.addAttribute("board", board);
    logAction(no, request.getRemoteAddr(), BoardLog.CMD_SELECT);
    return "board/detail";
  }
}









