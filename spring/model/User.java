package com.project.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
	
	 @Id
	    private String emailId;
	    private String password;
	    private String passwordConfirm;
	    private String userName;
	    private Long mobileNo;
	    
		public User(String emailId, String password, String passwordConfirm, String userName, Long mobileNo) {
			super();
			this.emailId = emailId;
			this.password = password;
			this.passwordConfirm = passwordConfirm;
			this.userName = userName;
			this.mobileNo = mobileNo;
		}

		public User() {
			super();
		}
		
		

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Long getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(Long mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPasswordConfirm() {
			return passwordConfirm;
		}
		public void setPasswordConfirm(String passwordConfirm) {
			this.passwordConfirm = passwordConfirm;
		}

		@Override
		public String toString() {
			return "User [emailId=" + emailId + ", password=" + password + ", passwordConfirm=" + passwordConfirm + "]";
		}
		
	    

}
