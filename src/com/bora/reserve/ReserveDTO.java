package com.bora.reserve;

import java.sql.Date;

public class ReserveDTO {
	private int num;
	private String title;
	private String contents;
	private String fname;
	private String oname;
	private Date selectDate;
	private String dtKind;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public Date getSelectDate() {
		return selectDate;
	}
	public void setSelectDate(Date selectDate) {
		this.selectDate = selectDate;
	}
	public String getDtKind() {
		return dtKind;
	}
	public void setDtKind(String dtKind) {
		this.dtKind = dtKind;
	}

}
