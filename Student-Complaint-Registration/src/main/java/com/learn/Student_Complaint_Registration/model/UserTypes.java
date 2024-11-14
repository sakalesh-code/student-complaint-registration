package com.learn.Student_Complaint_Registration.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="login_user_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_TYPE_DB_KEY")
	private int userTypeDbId;
	@Column(name = "USER_TYPE_NAME")
	private String userTypeName;

	@Column(name = "IS_ACTIVE")
	private int isActive;
	@Column(name = "CREATED_DATETIME")
	@Temporal(TemporalType.DATE)
	private Date dateTime;
}
