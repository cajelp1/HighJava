package kr.or.ddit.basic;

/*
	3개(명)의 쓰레드가 각각 알파벳 대문자를 출력하는데 출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성
 */

public class T11_DisplayCharacterTest {
	static String strRank = "";
	
	public static void main(String[] args) {
		
		DisplayCharacter[] disChars = new DisplayCharacter[] {
				new DisplayCharacter("가"),
				new DisplayCharacter("나"),
				new DisplayCharacter("다"),
		};
		
		for(int i = 0; i <disChars.length; i++) {
			disChars[i].start();
		}
		
		for(DisplayCharacter dc : disChars) {
			try {
				dc.join();
			}catch(InterruptedException e) { e.printStackTrace();}
		}
		
		System.out.println("경기 끝");
		System.out.println("------------------------------------------");
		System.out.println("순위 : "+strRank);
	}
}

class DisplayCharacter extends Thread {
	private String name;
	
	public DisplayCharacter(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(char ch='A'; ch <='Z'; ch++) {
			System.out.println(name + "의 출력문자 : " + ch);
			
			try {
				// sleep() 메서드의 값을 200~500 사이의 난수로 한다.
				Thread.sleep((int)(Math.random()*301+200));
			}catch(InterruptedException e) {e.printStackTrace();}
		}
		System.out.println(name + " 출력 끝 ...");
		T11_DisplayCharacterTest.strRank += name + " ";
	}
}


