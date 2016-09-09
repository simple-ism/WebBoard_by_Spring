package board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
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
		
		
				
		Map<String,Object> map = service.detailBoard(findNo);
		
		Board board = (Board)map.get("board");
		BoardFile file =(BoardFile)map.get("file");
		@SuppressWarnings("unchecked")
		List<Comment> commentList = (List<Comment>) map.get("commentList");
		
	

		mav.addAttribute("board", board);
		mav.addAttribute("file", file);
		
		
		
		return mav;
		
	}
	
}











