package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class T05_FileStreamTest {
	public static void main(String[] args) {
		
		//FileInputStream객체를 이용한 파일 내용 읽기
		FileInputStream fin = null; //선언
		
		try {
			//방법1 파일정보를 문자열로 지정하기
			fin = new FileInputStream("e:/D_Other/text2.txt"); //생성. 파일 생성이 아니라 인풋스트림 생성..
			//방법2 
//			File file = new File("e:/D_Other/text2.txt");
//			fin = new  FileInputStream(file);
			
			int c; //읽어온 데이터를 저장할 변수
			
			//읽어온 값이 -1이면 파일의 끝까지 읽었다는 의미임.
			while((c = fin.read())!=-1) {
				//읽어온 자료 출력하기
				System.out.print((char)c);
			}
			fin.close(); //작업 완료 후 스트림 닫기
		} catch (FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("알 수 없는 입출력 오류입니다.");
			e.printStackTrace();
		}
		
	}
}
