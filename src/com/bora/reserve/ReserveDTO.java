package com.bora.reserve;

import java.sql.Date;

public class ReserveDTO {
	private int num;
	private String title;
	private String selectDate;
	private int person;
	private int onePrice;
	
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
	public String getSelectDate() {
		return selectDate;
	}
	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public int getOnePrice() {
		return onePrice;
	}
	public void setOnePrice(int onePrice) {
		this.onePrice = onePrice;
	}
	
	
	

}
