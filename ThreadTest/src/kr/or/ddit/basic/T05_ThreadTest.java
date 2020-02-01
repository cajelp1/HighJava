package kr.or.ddit.basic;

import javax.swing.JOptionPane;

//단일 쓰레드에서의 사용자 입력 처리

public class T05_ThreadTest {
	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		System.out.println("입력한 값 : "+str);
		
		for(int i = 10; i >=1; i--) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000); //1초동안 멈추기
			}catch(InterruptedException e) {e.printStackTrace();}
		}
	}
}
