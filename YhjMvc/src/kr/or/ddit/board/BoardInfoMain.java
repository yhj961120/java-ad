package kr.or.ddit.board;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.borad.vo.BoardVO;


public class BoardInfoMain {
	
	private BoardService bodService;
	
	private Scanner scan = new Scanner(System.in); 
	
	public BoardInfoMain() {
		bodService = new BoardServiceImpl();
	}
	
	
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 회원정보 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		int choice = 0;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 자료 입력
					insertMember();
					break;
				case 2 :  // 자료 삭제
					deleteMember();
					break;
				case 3 :  // 자료 수정
					updateMember();
					break;
				case 4 :  // 전체 자료 출력
					displayMemberAll();
					break;
				case 5 :  // 회원정보 검색
					searchMember();
					break;
				case 6 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice != 6);
	}
	
	/**
	 * 회원정보를 검색하는 메서드
	 */
	private void searchMember() {
	/*
	   검색할 회원ID, 회원이름, 전화번호, 주소 등을 입력하면
	   입력한 정보만 사용하여 검색하는 기능을 구현하시오.
	   주소는 입력한 값이 포함만 되어도 검색 되도록 한다.
	   입력을 하지 않을 자료는 엔터키로 다음 입력으로 넘긴다. 
	*/
		scan.nextLine(); // 입력버퍼 비우기
		System.out.println();
		System.out.println("검색할 정보를 입력하세요.");
		System.out.print("회원ID >> ");
		String memId = scan.nextLine().trim();
		
		System.out.print("회원 이름 >> ");
		String memName = scan.nextLine().trim();
		
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.nextLine().trim();
		
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine().trim();
		
		BoardVO mv = new BoardVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);
		
		// 검색 기능 호출...
		List<BoardVO> memList = memService.searchMember(mv);
		
		System.out.println("-----------------------------------------");
		System.out.println(" ID\t이 름\t전화번호\t\t주  소");
		System.out.println("-----------------------------------------");
		
		if(memList.size() == 0) {
			System.out.println("검색된 회원정보가 없습니다.");
		}else {
			for(BoardVO mv2 : memList) {
				System.out.println(mv2.getMemId() + "\t" + mv2.getMemName() + "\t"
						+ mv2.getMemTel() + "\t\t" + mv2.getMemAddr());
			}
		}
		System.out.println("-----------------------------------------");
		System.out.println("검색 작업 끝...");
		
		
	}


	/**
	 * 회원정보를 삭제하기 위한 메서드
	 */
	private void deleteMember() {
		
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("회원 ID >> ");
		
		String memId = scan.next();
		
		int cnt = memService.deleteMember(memId);
		
		if(cnt > 0) {
			System.out.println(memId + "회원정보 삭제 성공.");
		}else {
			System.out.println(memId + "회원정보 삭제 실패!!!");
		}
	}

	/**
	 * 회원정보를 수정하기 위한 메서드
	 */
	private void updateMember() {
		
		String memId = "";
		boolean isExist = false;  //  중복 체크용
		
		do {
			System.out.println();
			System.out.println("수정할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			
			memId = scan.next();
			
			isExist = checkMember(memId);
			
			if(!isExist) {
				System.out.println("회원ID가 " + memId + "인 회원은 "
						+ "존재하지 않습니다.");
				System.out.println("다시 입력해 주세요.");
			}
			
		}while(!isExist);
		
		System.out.print("회원 이름 >> ");
		String memName = scan.next();
		
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine(); // 입력버퍼 비우기
		
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();
		
		BoardVO mv = new BoardVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);
		
		int cnt = memService.updateMember(mv);
		
		if(cnt > 0) {
			System.out.println(memId + "회원정보 수정 완료.");
		}else {
			System.out.println(memId + "회원정보 수정 실패!!!");
		}
	}

	/**
	 * 전체 회원정보를 출력하는 메서드
	 */
	private void displayMemberAll() {
		System.out.println("-----------------------------------------");
		System.out.println(" ID\t이 름\t전화번호\t\t주  소");
		System.out.println("-----------------------------------------");
		
		List<BoardVO> bodList = bodService.getAllBoardList();
		if(bodList.size() == 0) {
			System.out.println("회원정보가 없습니다.");
		}else {
			for(BoardVO bv : bodList) {
				System.out.println(bv.getBodNo() + "\t" + bv.getBodTitle() + "\t"
						+ bv.getBodWriter() + "\t\t" + bv.getBodContent());
			}
		}
		System.out.println("-----------------------------------------");
		System.out.println("출력 작업 끝...");
	}

	/**
	 * 회원정보 추가 메서드
	 */
	private void insertMember() {
		String memId = "";
		boolean isExist = false;  //  중복 체크용
		
		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			
			memId = scan.next();
			
			isExist = checkMember(memId);
			
			if(isExist) {
				System.out.println("회원ID가 " + memId + "인 회원은 "
						+ "이미 존재합니다.");
				System.out.println("다시 입력해 주세요.");
			}
			
		}while(isExist);
		
		System.out.print("회원 이름 >> ");
		String memName = scan.next();
		
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine(); // 입력버퍼 비우기
		
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();
		
		BoardVO mv = new BoardVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);
		
		int cnt = memService.registMember(mv);
		
		if(cnt > 0) {
			System.out.println(mv.getMemId() + "회원정보 등록 성공");
		}else {
			System.out.println(mv.getMemId() + "회원정보 등록 실패!!!");
		}
	}
	
	/**
	 * 회원이 존재하는지 확인하기 위한 메서드
	 * @param memId 회원ID
	 * @return 존재하면 true, 존재하지 않으면 false 반환함.
	 */
	private boolean checkMember(String memId) {
		
		boolean isExist = memService.checkMember(memId);
		
		return isExist;
	}

	public static void main(String[] args) {
		BoardInfoMain memObj = new BoardInfoMain();
		memObj.start();
	}

}






