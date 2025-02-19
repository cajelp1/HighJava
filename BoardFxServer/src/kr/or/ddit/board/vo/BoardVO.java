package kr.or.ddit.board.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int board_no;
	private String board_title;
	private String board_writer;
	private String board_content;
	private String board_date;
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String toString = format.format(board_date);
		this.board_date = toString;
	}
	
}
