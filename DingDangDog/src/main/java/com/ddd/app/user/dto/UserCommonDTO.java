package com.ddd.app.user.dto;

public class UserCommonDTO {

//	CREATE TABLE ddd_user_common(
//		user_number NUMBER,
//		common_report_count NUMBER DEFAULT 0 NOT NULL,
//		CONSTRAINT PK_user_common_user_number PRIMARY KEY (user_number),
//		CONSTRAINT FK_user_common_user_number FOREIGN KEY (user_number) REFERENCES ddd_user(user_number) ON DELETE CASCADE
//	);

	private int userNumber;
	private int commonReportCount;

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public int getCommonReportCount() {
		return commonReportCount;
	}

	public void setCommonReportCount(int commonReportCount) {
		this.commonReportCount = commonReportCount;
	}

	@Override
	public String toString() {
		return "UserCommonDTO [userNumber=" + userNumber + ", commonReportCount=" + commonReportCount + "]";
	}

}
