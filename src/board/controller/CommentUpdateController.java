package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.Comment;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;


public class CommentUpdateController implements Controller {
	BoardService service;
	
	
	
	public CommentUpdateController() {
		service = new BoardServiceImpl();
	}



	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		Comment comment = new Comment();
		comment.setContent(request.getParameter("content"));
		comment.setCommentNo(commentNo);
		
		service.commentUpdate(comment);
		
		return new ModelAndView("redirect:detail.do?no=" + no);
				
	
		
		}
}











