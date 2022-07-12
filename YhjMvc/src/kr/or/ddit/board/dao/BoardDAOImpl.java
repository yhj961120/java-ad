package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.borad.vo.BoardVO;
import kr.or.ddit.util.JDBCUtil3;

public class BoardDAOImpl implements BoardDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	

	
	
			
	
	@Override
	public int insertBoard(BoardVO bv) {
		
//		int cnt = 0;
//		
//		try {
//			conn = JDBCUtil3.getConnection();
//			
//			String sql = "INSERT INTO mymember " 
//					+ " ( mem_id, mem_name, mem_tel, mem_addr, reg_dt ) "
//					+ " VALUES (?, ?, ?, ?, sysdate) ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mv.getMemId());
//			pstmt.setString(2, mv.getMemName());
//			pstmt.setString(3, mv.getMemTel());
//			pstmt.setString(4, mv.getMemAddr());
//			
//			cnt = pstmt.executeUpdate();
//			
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//		}finally {
//			JDBCUtil3.close(conn, stmt, pstmt, rs);
//		}
//		
//		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
//int cnt = 0;
//		
//		try {
//			conn = JDBCUtil3.getConnection();
//			
//			String sql = "update mymember "
//					+ " set mem_name = ?, "
//					+ " mem_tel = ?, "
//				    + " mem_addr = ? "
//				   + " where mem_id = ? ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mv.getMemName());
//			pstmt.setString(2, mv.getMemTel());
//			pstmt.setString(3, mv.getMemAddr());
//			pstmt.setString(4, mv.getMemId());
//			
//			cnt = pstmt.executeUpdate();
//			
//			
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//		}finally {
//			JDBCUtil3.close(conn, stmt, pstmt, rs);
//		}
//		
//		return cnt;
	}

	@Override
	public int deleteBoard(String bodNo) {
		
//		int cnt = 0;
//		
//		try {
//			conn = JDBCUtil3.getConnection();
//			
//			String sql = "delete from mymember where mem_id = ? ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memId);
//			
//			cnt = pstmt.executeUpdate();
//			
//			
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//		}finally {
//			JDBCUtil3.close(conn, stmt, pstmt, rs);
//		}
//		
//		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		
		List<BoardVO> bodList = new ArrayList<BoardVO>();
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "select * from jdbc_board";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String bodNo = rs.getString("board_no");
				String bodTitle = rs.getString("board_title");
				String bodWriter = rs.getString("board_writer");
				String bodDate= rs.getString("board_date");
				String bodContent= rs.getString("board_content");
				
				
				BoardVO bv = new BoardVO();
				bv.setBodNo(bodNo);
				bv.setBodTitle(bodTitle);
				bv.setBodWriter(bodWriter);
				bv.setBodDate(bodDate);
				bv.setBodContent(bodContent);
				
				bodList.add(bv);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
		return bodList;
	}

	@Override
	public boolean checkBoard(String bodNo) {
//boolean isExist = false;
//		
//		try {
//			conn = JDBCUtil3.getConnection();
//			
//			String sql = "select count(*) as cnt "
//					+ " from mymember where mem_id = ? ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memId);
//			
//			rs = pstmt.executeQuery();
//			
//			int cnt = 0;
//			if(rs.next()) {
//				cnt = rs.getInt("cnt");
//			}
//			
//			if(cnt > 0) {
//				isExist = true;
//			}else {
//				isExist = false;
//			}
//			
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//		}finally {
//			JDBCUtil3.close(conn, stmt, pstmt, rs);
//		}
//		
//		return isExist;
//	}
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
	
//		List<MemberVO> memList = new ArrayList<MemberVO>();
//		
//		try {
//			conn = JDBCUtil3.getConnection();
//			
//			String sql = "select * from mymember where 1=1 ";
//			if(mv.getMemId() != null && !mv.getMemId().equals("")) {
//				sql += " and mem_id = ? ";
//			}
//			if(mv.getMemName() != null && !mv.getMemName().equals("")) {
//				sql += " and mem_name = ? ";
//			}
//			if(mv.getMemTel() != null && !mv.getMemTel().equals("")) {
//				sql += " and mem_tel = ? ";
//			}
//			if(mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
//				sql += " and mem_addr like '%' || ? || '%' ";
//			}
//			
//			System.out.println("최종 SQL : " + sql);
//			
//			pstmt = conn.prepareStatement(sql);
//			int index = 1;
//			if(mv.getMemId() != null && !mv.getMemId().equals("")) {
//				pstmt.setString(index++, mv.getMemId());
//			}
//			if(mv.getMemName() != null && !mv.getMemName().equals("")) {
//				pstmt.setString(index++, mv.getMemName());
//			}
//			if(mv.getMemTel() != null && !mv.getMemTel().equals("")) {
//				pstmt.setString(index++, mv.getMemTel());
//			}
//			if(mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
//				pstmt.setString(index++, mv.getMemAddr());
//			}
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String memId = rs.getString("mem_id");
//				String memName = rs.getString("mem_name");
//				String memTel = rs.getString("mem_tel");
//				String memAddr = rs.getString("mem_addr");
//				
//				MemberVO mv2 = new MemberVO();
//				mv2.setMemId(memId);
//				mv2.setMemName(memName);
//				mv2.setMemTel(memTel);
//				mv2.setMemAddr(memAddr);
//				
//				memList.add(mv2);
//			}
//			
//			
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//		}finally {
//			JDBCUtil3.close(conn, stmt, pstmt, rs);
//		}
//		
//		return memList;
//	}
	
	}
}
