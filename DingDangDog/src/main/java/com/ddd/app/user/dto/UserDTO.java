package com.ddd.app.user.dto;

public class UserDTO {

//	CREATE TABLE ddd_user(
//	user_number NUMBER,
//	user_type char(1) NOT NULL, 
//	user_id varchar2(100) NOT NULL,
//	user_password varchar2(100) NOT NULL,
//	user_name varchar2(100) NOT NULL,
//	user_nickname varchar2(50) NOT NULL,
//	user_gender char(1) NOT NULL,
//	user_birth varchar2(50) NOT NULL,
//	user_phone varchar2(20) NOT NULL,
//	user_email varchar2(100) NOT NULL,
//	user_status varchar2(10) DEFAULT 'kind',
//	CONSTRAINT PK_user_user_number PRIMARY KEY (user_number),
//	CONSTRAINT CK_user_user_type CHECK(user_type IN('C', 'S')),
//	CONSTRAINT UK_user_user_id UNIQUE (user_id),
//	CONSTRAINT UK_user_user_nickname UNIQUE (user_nickname),
//	CONSTRAINT CK_user_user_gender CHECK(user_gender in('F', 'M')),
//	CONSTRAINT UK_user_user_phone UNIQUE (user_phone),
//	CONSTRAINT UK_user_user_email UNIQUE (user_email),
//	CONSTRAINT CK_user_status CHECK(user_status in('kind', 'black', 'withdraw'))
//	);

	private int userNumber;
	private String userType;
	private String userId;
	private String userPassword;
	private String userName;
	private String userNickname;
	private String userGender;
	private String userBirth;
	private String userPhone;
	private String userEmail;
	private String userStatus;

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "UserDTO [userNumber=" + userNumber + ", userType=" + userType + ", userId=" + userId + ", userPassword="
				+ userPassword + ", userName=" + userName + ", userNickname=" + userNickname + ", userGender="
				+ userGender + ", userBirth=" + userBirth + ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ ", userStatus=" + userStatus + "]";
	}

}
