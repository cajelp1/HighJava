package kr.or.ddit.basic;

public class Service {
	
	@PrintAnnotation()
	public void method1() {
		System.out.println("메서드 1에서 출력되었습니다.");
	}
	
	@PrintAnnotation("%")
	public void method2() {
		System.out.println("메서드 2에서 출력되었습니다.");
	}
	
	@PrintAnnotation(value="#", count=25)
	public void method3() {
		System.out.println("메서드 3에서 출력되었습니다.");
	}
	
	
}
