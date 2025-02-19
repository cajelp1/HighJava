package kr.or.ddit.mp.dao.memInfoUpdate;

import java.util.List;

import kr.or.ddit.mp.vo.memInfoUpdate.MemberVO;
import kr.or.ddit.mp.vo.memInfoUpdate.ZiptbVO;

public interface IMemInfoUpdateDao {
	
	
	// 관리 페이지로 들어가기 위한 비밀 번호 입력
	public MemberVO getPw(MemberVO mvo); // 비밀번호값 가져오기
	
	
	// 관리 페이지에서 들어온 후
	public MemberVO getDefaultInfo(MemberVO mvo); // 수정 불가한 기본 정보 가져오기
	public MemberVO getNickCheck(String str); // 닉네임 중복체크
	public List<ZiptbVO> getSearchZipCode(ZiptbVO zvo); // 우편번호 찾기
	public int deleteMember(MemberVO mvo); // 회원 탈퇴 
	public int updateMember(MemberVO mvo); // 회원 정보 수정
	
	
	
	
}
