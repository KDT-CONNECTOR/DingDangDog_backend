package com.ddd.app.dogcare.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CareListDTO {
	private int careNumber;
	private String careTitle;
	private LocalDateTime careDate;
	private String userNickname;
	private LocalDateTime careWriteDate;
	
	public int getCareNumber() {
		return careNumber;
	}
	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}
	public String getCareTitle() {
		return careTitle;
	}
	public void setCareTitle(String careTitle) {
		this.careTitle = careTitle;
	}
	public LocalDateTime getCareDate() {
		return careDate;
	}
	public void setCareDate(LocalDateTime careDate) {
		this.careDate = careDate;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public LocalDateTime getCareWriteDate() {
		return careWriteDate;
	}
	public void setCareWriteDate(LocalDateTime careWriteDate) {
		this.careWriteDate = careWriteDate;
	}
	
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public String getCareDateStr() {
		if (careDate == null)
			return "";
		return careDate.format(DATE_FORMAT);
	}

	public String getCareWriteDateStr() {
		if (careWriteDate == null)
			return "";
		return careWriteDate.format(DATE_FORMAT);
	}
	
	@Override
	public String toString() {
		return "CareListDTO [careNumber=" + careNumber + ", careTitle=" + careTitle + ", careDate=" + careDate
				+ ", userNickname=" + userNickname + ", careWriteDate=" + careWriteDate + "]";
	}
	
}
