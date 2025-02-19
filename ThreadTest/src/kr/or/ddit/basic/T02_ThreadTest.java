package kr.or.ddit.basic;

public class T02_ThreadTest {
	
	public static void main(String[] args) {
		//멀티 쓰레드 프로그램 방식
		// 방법1. Thread클래스를 상속한 class의 인스턴스를 생성한 후 이 인스턴스의 start()메서드 호출
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		// 방법2. Runnable 인스턴스를 구현한 class의 인스턴스를 생성 후 이 인스턴스를 Thread객체의
		// 인스턴스를 생성할 때 매개변수로 남겨준다.
		// 이띠 생성된 Thread객체의 인스턴스의 start()메서드를 호출하낟.
		MyThread2 r1 = new MyThread2();
		Thread th2 = new Thread(r1);
		th2.start();
		
		// 방법3. 익명클래스를 이용하는 방법
		// Runnable 인터페이스를 구현한 익명클래스를 Thread인스턴스를 생성할 때 매개변수로 넘겨준다.
		Thread th3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i= 1; i<=200; i++) {
					System.out.print("@");
					
					try {
						//Thread.sleep(시간) -> 주어진 시간동안 작업을 잠시 멈춘다. 시간은 밀리세컨 단위를 사용
						// 1000이 1초를 의미함.
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		th3.start();
		
	}
}

class MyThread1 extends Thread{
	@Override
	public void run() {
		for(int i= 1; i<=200; i++) {
			System.out.print("*");
			
			try {
				//Thread.sleep(시간) -> 주어진 시간동안 작업을 잠시 멈춘다. 시간은 밀리세컨 단위를 사용
				// 1000이 1초를 의미함.
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread2 implements Runnable{
	@Override
	public void run() {
		for(int i= 1; i<=200; i++) {
			System.out.print("$");
			
			try {
				//Thread.sleep(시간) -> 주어진 시간동안 작업을 잠시 멈춘다. 시간은 밀리세컨 단위를 사용
				// 1000이 1초를 의미함.
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



