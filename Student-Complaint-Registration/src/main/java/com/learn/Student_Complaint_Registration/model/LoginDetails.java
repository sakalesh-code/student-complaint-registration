package com.learn.Student_Complaint_Registration.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Login_Master")
public class LoginDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOGIN_DB_KEY")
	private int loginDbId;
	@Column(name = "EMAIL_ID")
	private String email;

	@Column(name = "USER_PASSWORD")
	private String password;

	@Column(name = "CREATED_BY")
	private String createdByUser;

	@Column(name = "UPDATED_BY")
	private String updatedByUser;

	@Column(name = "IS_ACTIVE")
	private int isActive;

	@Column(name = "USER_TYPE_DB_KEY")
	private int userTypeDbKey;

	@Column(name = "DATE_CREATED_ON", insertable = false, updatable = false)
	private LocalDate dateCreatedOn;

	@Column(name = "DATE_UPDATED_ON", insertable = false, updatable = false)
	private LocalDate dateUpdatedOn;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_TYPE_DB_KEY", referencedColumnName = "USER_TYPE_DB_KEY", insertable = false, updatable = false)
	private UserTypes userTypes;

	public int getLoginDbId() {
		return loginDbId;
	}

	public void setLoginDbId(int loginDbId) {
		this.loginDbId = loginDbId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public String getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getUserTypeDbKey() {
		return userTypeDbKey;
	}

	public void setUserTypeDbKey(int userTypeDbKey) {
		this.userTypeDbKey = userTypeDbKey;
	}

	public LocalDate getDateCreatedOn() {
		return dateCreatedOn;
	}

	public void setDateCreatedOn(LocalDate dateCreatedOn) {
		this.dateCreatedOn = dateCreatedOn;
	}

	public LocalDate getDateUpdatedOn() {
		return dateUpdatedOn;
	}

	public void setDateUpdatedOn(LocalDate dateUpdatedOn) {
		this.dateUpdatedOn = dateUpdatedOn;
	}

	public UserTypes getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(UserTypes userTypes) {
		this.userTypes = userTypes;
	}

	@Override
	public String toString() {
		return "LoginDetails [loginDbId=" + loginDbId + ", email=" + email + ", password=" + password
				+ ", createdByUser=" + createdByUser + ", updatedByUser=" + updatedByUser + ", isActive=" + isActive
				+ ", userTypeDbKey=" + userTypeDbKey + ", dateCreatedOn=" + dateCreatedOn + ", dateUpdatedOn="
				+ dateUpdatedOn + ", userTypes=" + userTypes + "]";
	}

}
