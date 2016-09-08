package board.service;

import java.util.List;

import board.Board;
import board.BoardDAO;
import board.BoardFile;
import board.Comment;

public class BoardServiceImpl implements BoardService {
	private BoardDAO dao;
	
	public BoardServiceImpl(){
		dao = new BoardDAO();
	}
	@Override
	public List<Board> list() throws Exception {
			
		return dao.selectBoard();
	}

	@Override
	public void commentDelete(int commentNo) throws Exception {
		
		dao.deleteComment(commentNo);
		
	}
	@Override
	public void commentRegist(Comment comment) throws Exception {
		dao.insertComment(comment);
		
	}
	@Override
	public void commentUpdate(Comment comment) throws Exception {
		
		dao.updateComment(comment);
	}
	@Override
	public void delete(int no) throws Exception {
		
		dao.deleteBoard(no);
		
	}
	@Override
	public Board detailBoard(int findNo) throws Exception {
		
		Board board = dao.selectBoardByNo(findNo);
		return board;
	}
	@Override
	public BoardFile detailBoardFile(int findNo) throws Exception {
		BoardFile file = dao.selectBoardFileByNo(findNo);
		return file;
	}
	@Override
	public List<Comment> detailComment(int findNo) throws Exception {
		List<Comment> commentList = dao.selectCommentByNo(findNo);
		return commentList;
	}
	@Override
	public void update(Board board) throws Exception {
		dao.updateBoard(board);
	}
	@Override
	public Board updateForm(int no) throws Exception {
		Board board =dao.selectBoardByNo(no);
		return board;
	}
	@Override
	public int writeBoard(Board board) throws Exception {
		int no = dao.insertBoard(board);
		return no;
	}
	@Override
	public void writeBoardFile(BoardFile boardFile) throws Exception {
		dao.insertBoardFile(boardFile);
		
	}
	
	
	
	
	
	
	
}
