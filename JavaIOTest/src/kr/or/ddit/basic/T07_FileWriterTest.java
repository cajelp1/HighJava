package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class T07_FileWriterTest {
	public static void main(String[] args) {
		//사용자가 입력한 내용을 그대로 파일로 저장하기
		
		// 콘솔(표준입출력장치)과 연결된 입력용 문자 스트림 생성
		// inputstreamreader 스트림 -> 바이트기반 스트림을 문자기반 스트림으로 변환해주는 보조 스트림
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileWriter fw = null; //파일 출력용 문자 기반 스트림
		
		try {
			//파일 출력용 문자 스트림 객체 생성
			fw = new FileWriter("e:/D_Other/textChar.txt");
			int c;
			
			System.out.println("아무거나 입력하세요");
			
			//콘솔에서 입력할 때 입력의 끝 표시는 ctrl+z 키를 누르면 된다.
			
			//근데 엔터키 안 누르면 그 줄은 그대로 씹히넹... 버그넹
			while((c = isr.read()) != -1) {
				fw.write(c); //콘솔에서 입력받은 값을 파일에 출력하기
			}
			System.out.println("출력 끝");
			
			isr.close();
			fw.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
