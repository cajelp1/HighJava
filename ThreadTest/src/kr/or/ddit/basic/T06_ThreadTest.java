package kr.or.ddit.basic;

import javax.swing.JOptionPane;

// 멀티쓰레드에서 사용자 입력 처리

public class T06_ThreadTest {
	// 입력 여부를 확인하기 위한 변수
	// 모든 클래스에서 공통으로 사용함.
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();
	}
}

/**
 * 데이터 입력을 위한 쓰레드
 */
class DataInput extends Thread{
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		
		// 입력이 완료되면 inputCheck 변수를 true로 변경
		T06_ThreadTest.inputCheck = true;
		
		System.out.println("입력한 값 : "+str);
	}
}

/**
 * 카운트다운을 처리하는 쓰레드
 */
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i = 10; i >=1; i--) {
			// 입력이 완료되었는지 여부를 검사하고 입력이 완료되면 run()메서드를 종료.
			if(T06_ThreadTest.inputCheck) {return;}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000); //1초동안 멈추기
			}catch(InterruptedException e) {e.printStackTrace();}
		}
		//10초 경과후에도 입력이 없으면 프로그램 종료
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}
}

