package com.learn.Student_Complaint_Registration.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Complaint_Details")
public class ComplaintDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL_ID")
	private String email;
	@Column(name = "COMPLAINT")
	private String complaint;
	@Column(name = "BRANCH_ID")
	private String branch;
	@Column(name = "COLLEGE_ID")
	private String collegeId;
	@Column(name = "IS_ACTIVE")
	private int isActive;
	@Column(name = "DATE_CREATED_ON", updatable = false)
	private LocalDate dateCreated;
	@Column(name = "PRIORITY") 
	private String priority;
	@Column(name = "USER_TYPE_DB_KEY")
	private int userTypeDbKey;
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;
	
	
	
}
