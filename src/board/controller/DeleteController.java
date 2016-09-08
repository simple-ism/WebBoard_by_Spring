package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import framework.Controller;
import framework.ModelAndView;


public class DeleteController implements Controller {

	
	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(no);
		
		ModelAndView mav = new ModelAndView();
		mav.setView("redirect:list.do");
		
		return mav;
//		response.sendRedirect("list.do");
//		return "redirect:list.do";
	}
}











