package com.learn.Student_Complaint_Registration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Student_Complaint_Registration.Repository.StudentComplaintRepository;
import com.learn.Student_Complaint_Registration.Repository.StudentLoginRepository;
import com.learn.Student_Complaint_Registration.model.ComplaintDetails;
import com.learn.Student_Complaint_Registration.model.LoginDetails;
import com.learn.Student_Complaint_Registration.service.StudentComplaintService;

@Service
public class StudentComplaintImpl implements StudentComplaintService {
	@Autowired
	StudentLoginRepository loginRepo;

	@Autowired
	StudentComplaintRepository complaintRepo;

	@Override
	public List<LoginDetails> validLoginDetails(LoginDetails loginDetails) {
		return loginRepo.findByUsernameandpassword(loginDetails.getEmail(), loginDetails.getPassword(), 1);
	}

	@Override
	public void saveComplaintDetails(ComplaintDetails complaintDetails) {
		complaintRepo.save(complaintDetails);

	}

	@Override
	public List<ComplaintDetails> getComplaintDetails() {

		return complaintRepo.getComplaintDetails();
	}

	@Override
	public void deleteCompalaint(ComplaintDetails complaintDetails) {
		complaintRepo.deleteComplaint(complaintDetails.getId(),0);
	}

}
