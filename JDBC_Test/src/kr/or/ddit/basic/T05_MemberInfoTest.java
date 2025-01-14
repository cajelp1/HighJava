package kr.or.ddit.basic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;

/*
	회원정보를 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력	---> select
		5. 작업 끝.
	----------------------
	 
	   
// 회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128)    -- 주소
);

*/

public class T05_MemberInfoTest {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement prstm;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in); 
	
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
		System.out.println("  5. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		int choice;
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
					displayMemeberAll();
					break;
				case 5 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=5);
	}

	public static void main(String[] args) {
		T05_MemberInfoTest memObj = new T05_MemberInfoTest();
		memObj.start();
	}
	
	
	/**
	 * 회원 정보를 삭제하는 메서드
	 */
	private void deleteMember() {
		
		System.out.println();
		System.out.print("삭제할 회원ID를 입력하세요 : ");
		String memId = scan.next();
		
		try {
			
			conn = DBUtil.getConnection();
			String sql = "delete from mymember where mem_id = ?";
			
			prstm = conn.prepareStatement(sql);
			prstm.setString(1, memId);
			
			int cnt = prstm.executeUpdate();
			if(cnt > 0) {
				System.out.println("회원 삭제 성공 ------");
			}else {System.out.println("회원 삭제 실패 ---!!!");}
			
		}catch(SQLException e) {
			System.out.println("회원 삭제 실패 ---!!!");
			e.printStackTrace();
		}finally {disconnect();}
	}
	
	
	/**
	 * 회원 정보를 수정하는 메서드
	 */
	private void updateMember() {
		System.out.println();
		String memId = "";
		boolean chk = true;
		
		do {
			System.out.print("수정할 회원ID를 입력하세요 : ");
			memId = scan.next();
			
			chk = getMember(memId);
			
			if(chk == false) {
				System.out.println(memId+"인 회원은 없는 회원입니다.");
				System.out.println("수정할 자료가 없으니 다시 입력하세요.");
			}
		}while(chk == false);
		
		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 회원 이름 : ");
		String memName = scan.next();
		
		System.out.println("새로운 회원 전화번호 : ");
		String memTel = scan.next();
		
		scan.nextLine(); //버퍼비우기
		System.out.println("새로운 회원 주소 : ");
		String memAddr = scan.next();
		
		try {
			
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set "
					+ " mem_name = ?, "
					+ " mem_tel = ?, "
					+ " mem_addr = ? "
					+ " where mem_id = ?";
			
			prstm = conn.prepareStatement(sql);
			prstm.setString(1, memName);
			prstm.setString(2, memTel);
			prstm.setString(3, memAddr);
			prstm.setString(4, memId);
			
			int cnt = prstm.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(memId+"의 회원정보를 수정했습니다.");
			}else {System.out.println(memId+"의 회원정보 수정 실패 -----");}
			
		}catch(SQLException e) {
			System.out.println(memId+"의 회원정보 수정 실패 -----");
			e.printStackTrace();
		}finally {disconnect();}
		
		
	}

	
	/**
	 * 전체 회원을 출력하는 메서드
	 */

	private void displayMemeberAll() {
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("ID\t이름\t전화번호\t주소");
		System.out.println("-----------------------------------");
		
		try {
			conn = DBUtil2.getConnection();
			
			String sql = "select * from mymember";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				
				System.out.println(memId+"\t"+memName+"\t"+memTel+"\t"+memAddr);
			}
			System.out.println("-----------------------------------");
			System.out.println("출력 작업 끝 ----------");
		}catch(SQLException e ) {
			System.out.println("회원자료 가져오기 실패 ---------");
		}finally {disconnect();} //자원반납
	}
	
	
	/**
	 * 회원 추가 메서드
	 */
	private void insertMember() {
		
		boolean chk = false;//중복체크
		
		String memId = "";
		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요");
			System.out.print("회원ID : ");
			memId = scan.next();
			
			chk = getMember(memId);
			if(chk) {
				System.out.println("회원 ID가 "+memId+"인 회원은 이미 존재합니다.");
				System.out.println("다시 입력해주세요.");
			}
			
		}while(chk == true);
		
		System.out.print("회원 이름  : ");
		String memName = scan.next();
		
		System.out.println("회원 전화번호 : ");
		String memTel = scan.next();
		
		scan.nextLine();
		System.out.println("회원 주소 : ");
		String memAddr = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr) "+
						" values (?, ?, ?, ?)";
			
			prstm = conn.prepareStatement(sql);
			prstm.setString(1, memId);
			prstm.setString(2, memName);
			prstm.setString(3, memTel);
			prstm.setString(4, memAddr);
			
			int cnt = prstm.executeUpdate();
			
			if(cnt > 0) {System.out.println(memId + "회원추가 완료 ------");
			}else {System.out.println(memId + "회원추가 실패 ---!!!");}
			
		}catch(SQLException e) {System.out.println(memId + "회원추가 실패 ---!!!");
								e.printStackTrace();
		}finally {disconnect();} //자원반납
	}
	
	
	/**
	 * 회원 ID를 이용하여 회원이 있는지 알려주는 메서드
	 * @param memId
	 * @return
	 */
	private boolean getMember(String memId) {
		
		boolean chk = false;
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) from mymember where mem_id = ?";
			
			prstm = conn.prepareStatement(sql);
			prstm.setString(1, memId);
			
			rs = prstm.executeQuery();
			
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
			if(cnt > 0) { chk = true;}
		}catch(SQLException e) {e.printStackTrace(); chk = false;}
		finally {disconnect();}
		return chk;
	}
	
	
	/**
	 * 자원반납 메서드
	 */
	private void disconnect() {
		if(rs!=null)try{ rs.close(); }catch(SQLException ee){}
		if(stmt!=null)try{ stmt.close(); }catch(SQLException ee){}
		if(prstm!=null)try{ prstm.close(); }catch(SQLException ee){}
		if(conn!=null)try{ conn.close(); }catch(SQLException ee){}
	}
	
	
}






