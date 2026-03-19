package com.ddd.app.dogcare.dto;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CareDTO {
//	CREATE TABLE DDD_CARE (
//			   care_number NUMBER,
//			   user_number NUMBER ,
//			   care_title VARCHAR2(100) NOT NULL,
//			   care_post VARCHAR2(4000) NOT NULL,
//			   care_date DATE NOT NULL,
//			   care_recruit NUMBER,
//			   care_write_date DATE DEFAULT SYSDATE NOT NULL,
//			   care_status varchar2(10) DEFAULT 'open',
	private int careNumber;
	private int userNumber;
	private String careTitle;
	private String carePost;
	private LocalDateTime careDate;
	private int careRecruit;
	private LocalDateTime careWriteDate;
	private String careStatus;
	
	public int getCareNumber() {
		return careNumber;
	}
	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public String getCareTitle() {
		return careTitle;
	}
	public void setCareTitle(String careTitle) {
		this.careTitle = careTitle;
	}
	public String getCarePost() {
		return carePost;
	}
	public void setCarePost(String carePost) {
		this.carePost = carePost;
	}
	public LocalDateTime getCareDate() {
		return careDate;
	}
	public void setCareDate(LocalDateTime careDate) {
		this.careDate = careDate;
	}
	public int getCareRecruit() {
		return careRecruit;
	}
	public void setCareRecruit(int careRecruit) {
		this.careRecruit = careRecruit;
	}
	public LocalDateTime getCareWriteDate() {
		return careWriteDate;
	}
	public void setCareWriteDate(LocalDateTime careWriteDate) {
		this.careWriteDate = careWriteDate;
	}
	public String getCareStatus() {
		return careStatus;
	}
	public void setCareStatus(String careStatus) {
		this.careStatus = careStatus;
	}
	
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public String getCareDateStr() {
        if (careDate == null) return "";
        return careDate.format(DATE_FORMAT);
    }

    public String getCareWriteDateStr() {
        if (careWriteDate == null) return "";
        return careWriteDate.format(DATE_FORMAT);
    }
	
	@Override
	public String toString() {
		return "CareDTO [careNumber=" + careNumber + ", userNumber=" + userNumber + ", careTitle=" + careTitle
				+ ", carePost=" + carePost + ", careDate=" + careDate + ", careRecruit=" + careRecruit
				+ ", careWriteDate=" + careWriteDate + ", careStatus=" + careStatus + "]";
	}
	
}
