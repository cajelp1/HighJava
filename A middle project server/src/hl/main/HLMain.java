package hl.main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import kr.or.ddit.hl.service.cust.CustServiceImpl;
import kr.or.ddit.hl.service.cust.ICustService;
import kr.or.ddit.hl.service.join.IJoinService;
import kr.or.ddit.hl.service.join.ILawJoinService;
import kr.or.ddit.hl.service.join.JoinServiceImpl;
import kr.or.ddit.hl.service.join.LawJoinServiceImpl;
import kr.or.ddit.hl.service.qna.IQnaService;
import kr.or.ddit.hl.service.qna.QnaServiceImpl;
import kr.or.ddit.hl.vo.QnaBoardVO;

public class HLMain {
	
	protected HLMain() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		try {
			
			// 객체를 클라이언트에서 찾을 수 있게 registry 생성. 임의의 포트 사용
			Registry reg = LocateRegistry.createRegistry(7777);
			
			
			
			// RMI 인터페이스를 등록한 객체 생성 & 객체 registry에 등록
			
			//일반 회원가입
			IJoinService join = JoinServiceImpl.getInstance();
			reg.rebind("JoinServer", join);
			
			//변호사 회원가입
			ILawJoinService lawjoin = LawJoinServiceImpl.getInstance();
			reg.rebind("LawJoin", lawjoin);
			
			//QnA 게시판
			IQnaService qna = QnaServiceImpl.getInstance();
			reg.rebind("QnA", qna);
			
			
			//고객센터
			ICustService cust = CustServiceImpl.getInstance();
			reg.rebind("Customer", cust);
			
			
			System.out.println("서버가 준비되었습니다.");
			
		}catch(RemoteException e) {e.printStackTrace();}
		
	}
	
	
	//tcp 채팅 구현
	
}
