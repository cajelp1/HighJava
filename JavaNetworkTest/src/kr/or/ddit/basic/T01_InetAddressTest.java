package kr.or.ddit.basic;

import java.io.IOException;
import java.net.InetAddress;

public class T01_InetAddressTest {
	public static void main(String[] args) throws IOException {
		
		//InetAddress 클래스 : IP 주소를 다루기 위한 클래스
		
		// naver사이트의 ip주소 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		System.out.println("host name : " + naverIp.getHostName());
		System.out.println("host Address : " + naverIp.getHostAddress());
		System.out.println();
		
		// 자기 자신 컴퓨터의 IP주소 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 host name : " + localIp.getHostName());
		System.out.println("내 컴퓨터의 host Address : " + localIp.getHostAddress());
		System.out.println();
		
		// IP주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for(InetAddress nIp : naverIps) {
			System.out.println(nIp.toString());
		}
		
	}
}
