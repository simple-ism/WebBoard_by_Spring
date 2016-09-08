package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardDAO;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;


public class UpdateController implements Controller {
	BoardService service;
	
	
	
	public UpdateController() {
		service = new BoardServiceImpl();
	}



	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 필터 적용함
//		request.setCharacterEncoding("utf-8");
		
		Board board = new Board();
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));

		service.update(board);
			
		return new ModelAndView("redirect:list.do");
	}
}











