package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDAO;
import kr.or.ddit.board.dao.BoardDAOImpl;
import kr.or.ddit.borad.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO bodDao;
	
	public BoardServiceImpl() {
		bodDao = new BoardDAOImpl();
	}
	
	
	@Override
	public int registMember(BoardVO mv) {
		
		//주민등록번호 암호화 처리하기
		
		int cnt = memDao.insertMember(mv);
		
		//해당 사용자에 회원정보 등록 완료 메일 발송하기
		
		return cnt;
	}

	@Override
	public int updateMember(BoardVO mv) {
		int cnt = memDao.updateMember(mv);
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = memDao.deleteMember(memId);
		return cnt;
	}

	@Override
	public List<BoardVO> getAllMemberList() {
		List<BoardVO> memList = memDao.getAllMemberList();
		return memList;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean isExist = memDao.checkMember(memId);
		return isExist;
	}
	/**
	 * 주어진 회원정보를 이용하여 해당 회원정보를 검색하는 메서드
	 * @param mv 검색에 사용할 회원정보
	 * @return 검색된 회원 정보를 담은 리스트 
	 */
	public List<BoardVO> searchMember(BoardVO mv) {
		
		List<BoardVO> memList = memDao.searchMember(mv);
		
		return memList;
	}


	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> bodList = bodDao.getAllBoardList();
		return bodList;
		
	}
}
