package kr.or.ddit.vo;

import java.io.Serializable;

/**
 * 파일 전송용 VO클래스 
 * @author PC-20
 *
 */

public class FileInfoVO implements Serializable{
	private String fileName;
	private byte[] fileData;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
}
