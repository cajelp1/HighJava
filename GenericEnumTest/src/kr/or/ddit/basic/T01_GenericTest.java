package kr.or.ddit.basic;

/*

	generic class를 만드는 방법
	
형식) class 클래스명 <generictype 글자>{
		generictype글자 변수명; //변수 선언에 generic을 사용할 경우
		...
		generictype글자 메서드명(){ // 반환값이 있는 메서드에서 사용
			...
			
			return 값;
		}
		...
	}
--- generic type 글자 ---
T - Type
K - Key
V - Value
E - Element (자료구조에 들어가는 것들을 나타낼 때 사용)


 */

class NonGenericClass{
	private Object val;
	
	public Object getVal() {
		return val;
	}
	
	public void setVal(Object val) {
		this.val = val;
	}

}


class MyGeneric<T>{
	private T val;
	
	public T getVal() {
		return val;
	}
	
	public void setVal(T val) {
		this.val = val;
	}
	
}



public class T01_GenericTest {
	public static void main(String[] args) {
		
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("가나다라마바사");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		
		String rtnNg1 = (String)ng1.getVal();
		System.out.println("문자열 반환값 rtnNg1 : "+ rtnNg1);
		
		Integer intNg2 = (Integer) ng2.getVal();
		System.out.println("정수 반환값 intNg1 : "+ intNg2);
		System.out.println();
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		
		mg1.setVal("우리나라");
		mg2.setVal(500);
		
		rtnNg1 = mg1.getVal();
		intNg2 = mg2.getVal();
		
		System.out.println("제너릭 문자열 반환값 : "+rtnNg1);
		System.out.println("제너릭 정수형 반환값 : "+intNg2);
		
	}
}
