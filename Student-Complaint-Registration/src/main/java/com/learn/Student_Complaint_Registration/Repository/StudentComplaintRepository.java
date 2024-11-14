package com.learn.Student_Complaint_Registration.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.learn.Student_Complaint_Registration.model.ComplaintDetails;

public interface StudentComplaintRepository extends JpaRepository<ComplaintDetails, Integer> {

	@Query(value = "select id,name,email_Id,complaint,COLLEGE_ID,BRANCH_ID,IS_ACTIVE,"
			+ "DATE_CREATED_ON,PRIORITY,USER_TYPE_DB_KEY,CONTACT_NUMBER from complaint_details ORDER BY CASE "
			+ "WHEN priority = 'High' THEN 1 " + "WHEN priority = 'Low' THEN 2 END, id ASC", nativeQuery = true)
	List<ComplaintDetails> getComplaintDetails();

	@Modifying
	@Transactional
	@Query(value = "UPDATE complaint_details  SET IS_ACTIVE =:isActive  WHERE id=:id", nativeQuery = true)
	int deleteComplaint(@Param("id") Long id, @Param("isActive") int isActive);

}
