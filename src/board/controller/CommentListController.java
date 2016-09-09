package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.Comment;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;


public class CommentListController implements Controller {
	private BoardService service;
	
	public CommentListController(){
		this.service = new BoardServiceImpl();
	}
	
	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new ModelAndView(
				"ajax:"+ new Gson().toJson(
						service.listComment(
								Integer.parseInt(request.getParameter("no"))
						)
				)
		);
	
	}
}











