package com.learn.Student_Complaint_Registration.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learn.Student_Complaint_Registration.model.ComplaintDetails;
import com.learn.Student_Complaint_Registration.model.LoginDetails;
@Repository
public interface StudentLoginRepository extends JpaRepository<LoginDetails, Integer> {
	@Query(value = "select * from Login_Master where EMAIL_ID=:emailId and USER_PASSWORD=:userPassword and IS_ACTIVE=:isActive ", nativeQuery = true)
	public List<LoginDetails> findByUsernameandpassword(@Param("emailId") String email, @Param("userPassword") String password, @Param("isActive") int isActive);


}


