package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;


public class DeleteController implements Controller {
	BoardService service;
	
	
	public DeleteController() {
		service = new BoardServiceImpl();
	}


	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
	
		service.delete(no);
		return new ModelAndView("redirect:list.do");
//		response.sendRedirect("list.do");
//		return "redirect:list.do";
	}
}











