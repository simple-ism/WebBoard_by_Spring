package board.service;

import java.util.List;
import java.util.Map;

import board.Board;
import board.BoardFile;
import board.Comment;

public interface BoardService {
	/** 게시물의 목록 정보를 조회하는 기능*/
	public List<Board> list() throws Exception;
	/** 댓글 삭제 처리 */
	public void commentDelete(int commentNo) throws Exception;
	
	public void commentRegist(Comment comment) throws Exception;
	
	public void commentUpdate(Comment comment) throws Exception;
	
	public void delete(int no) throws Exception;
	
	public Map<String,Object> detailBoard (int findNo) throws Exception;

	
	
	public void update(Board board) throws Exception;
	
	public Board updateForm(int no) throws Exception;
	
	public void writeBoard(Board board,BoardFile boardFile) throws Exception;
	
	
	
	
	
}
