package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {
	
	// 글 전부 가져오기
	public List<BoardVO> getAllBoardList();

	// 글 찾기 (보드넘버)
	public boolean getBoard(int board_no);
	
	// 글 추가
	public int insertBoard(BoardVO bv);
	
	// 글 수정
	public int updateBoard(BoardVO bv);
	
	// 글 삭제 (보드넘버)
	public int deletBoard(int board_no);
	
	// 글 검색
	public List<BoardVO> getSearchBoard(BoardVO bv);
	
}
