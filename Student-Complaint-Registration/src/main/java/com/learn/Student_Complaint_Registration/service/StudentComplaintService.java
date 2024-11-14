package com.learn.Student_Complaint_Registration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.Student_Complaint_Registration.model.ComplaintDetails;
import com.learn.Student_Complaint_Registration.model.LoginDetails;
@Service
public interface StudentComplaintService {

	public List<LoginDetails> validLoginDetails(LoginDetails loginDetails);

	public void saveComplaintDetails(ComplaintDetails complaintDetails);

	public List<ComplaintDetails> getComplaintDetails();

	public void deleteCompalaint(ComplaintDetails complaintDetails);

}
