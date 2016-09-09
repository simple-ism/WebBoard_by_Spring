package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String,Object> detailBoard(int findNo) throws Exception {
		
		Map<String,Object> map = new HashMap<>();
		
		Board board = dao.selectBoardByNo(findNo);
		BoardFile file = dao.selectBoardFileByNo(findNo);
		map.put("board", board);
		map.put("file", file);
		
		
		return map;
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
	public void writeBoard(Board board,BoardFile boardFile) throws Exception {
		
		int no = dao.insertBoard(board);
		if (boardFile != null) {
			boardFile.setNo(no);
			dao.insertBoardFile(boardFile);
	
		}		
	}
	@Override
	public List<Comment> listComment(int no) throws Exception {
		
		return dao.selectCommentByNo(no);
	}
}
	
	
	
	

