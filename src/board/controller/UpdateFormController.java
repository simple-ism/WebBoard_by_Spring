package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardDAO;

@WebServlet("/board/updateForm")
public class UpdateFormController extends HttpServlet {

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = new BoardDAO();
		Board board = dao.selectBoardByNo(no);
		request.setAttribute("board", board);
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("updateForm.jsp");
		rd.forward(request, response);
	}
}











