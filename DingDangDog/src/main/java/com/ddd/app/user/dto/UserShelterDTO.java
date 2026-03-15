package com.ddd.app.user.dto;

public class UserShelterDTO {

//	CREATE TABLE ddd_user_shelter(
//	user_number NUMBER,
//	shelter_name varchar2(100) NOT NULL,
//	shelter_business_number varchar2(100) NOT NULL,
//	shelter_address varchar2(100) NOT NULL,
//	shelter_certification varchar2(20) DEFAULT 'N',
//	CONSTRAINT PK_user_shelter_user_number PRIMARY KEY (user_number),
//	CONSTRAINT FK_user_shelter_user_number FOREIGN KEY (user_number) REFERENCES ddd_user(user_number) ON DELETE CASCADE,
//	CONSTRAINT CK_user_shelter_certification CHECK(shelter_certification IN ('N', 'Y'))
//	);

	private int userNumber;
	private String shelterName;
	private String shelterBusinessNumber;
	private String shelterAddress;
	private String shelterCertification;

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getShelterName() {
		return shelterName;
	}

	public void setShelterName(String shelterName) {
		this.shelterName = shelterName;
	}

	public String getShelterBusinessNumber() {
		return shelterBusinessNumber;
	}

	public void setShelterBusinessNumber(String shelterBusinessNumber) {
		this.shelterBusinessNumber = shelterBusinessNumber;
	}

	public String getShelterAddress() {
		return shelterAddress;
	}

	public void setShelterAddress(String shelterAddress) {
		this.shelterAddress = shelterAddress;
	}

	public String getShelterCertification() {
		return shelterCertification;
	}

	public void setShelterCertification(String shelterCertification) {
		this.shelterCertification = shelterCertification;
	}

	@Override
	public String toString() {
		return "UserShelterDTO [userNumber=" + userNumber + ", shelterName=" + shelterName + ", shelterBusinessNumber="
				+ shelterBusinessNumber + ", shelterAddress=" + shelterAddress + ", shelterCertification="
				+ shelterCertification + "]";
	}

}
