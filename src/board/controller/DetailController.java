package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardDAO;
import board.BoardFile;
import board.Comment;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;


public class DetailController implements Controller {
	BoardService service;
	
	
	
	public DetailController() {
		service = new BoardServiceImpl();
	}



	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("detail.jsp");
		int findNo = Integer.parseInt(request.getParameter("no"));
		try {
			mav.addAttribute(
					"commentNo", Integer.parseInt(
							request.getParameter("commentNo")));	
		} catch (NumberFormatException e) { }
		
		
				
		Board board = service.detailBoard(findNo);
		BoardFile file =service.detailBoardFile(findNo);
		List<Comment> commentList = service.detailComment(findNo);
		
	

		mav.addAttribute("board", board);
		mav.addAttribute("file", file);
		mav.addAttribute("commentList", commentList);
		
		
		return mav;
		
	}
	
}











