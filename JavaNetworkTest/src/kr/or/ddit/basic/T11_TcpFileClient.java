package kr.or.ddit.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class T11_TcpFileClient {
	
	//클라이언트는 서버에 접속하여 서버가 보내주는 파일을 E드라이브 C_Lib폴더에 저장한다.
	private Socket socket;
	private InputStream is;
	private FileOutputStream fos;
	
	public void clientStart() {
		File file = new File("e:/C_Lib/Tulips.jpg");
		
		try {
			socket = new Socket("localhost", 7777);
			System.out.println("파일 다운로드 시작...");
			
			fos = new FileOutputStream(file);
			is = socket.getInputStream();
			
			byte[] tmp = new byte[1024];
			int length = 0;
			while((length = is.read(tmp)) != -1) {
				fos.write(tmp, 0, length);
			}
			fos.flush();
			System.out.println("파일 다운로드 완료");
		}catch(IOException e) {
			
		}finally {
			if(is != null) {
				try {is.close();} catch(IOException e) {}
			}
			if(fos != null) {
				try {is.close();} catch(IOException e) {}
			}
			if(socket != null) {
				try {is.close();} catch(IOException e) {}
			}
		}
	}
	
	public static void main(String[] args) {
		new T11_TcpFileClient().clientStart();
	}
}
