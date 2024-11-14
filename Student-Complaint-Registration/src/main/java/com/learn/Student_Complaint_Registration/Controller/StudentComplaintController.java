package com.learn.Student_Complaint_Registration.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.Student_Complaint_Registration.model.ComplaintDetails;
import com.learn.Student_Complaint_Registration.model.LoginDetails;
import com.learn.Student_Complaint_Registration.service.EmailService;
import com.learn.Student_Complaint_Registration.service.StudentComplaintService;

@Controller
public class StudentComplaintController {

	@Autowired
	StudentComplaintService service;
	@Autowired
	EmailService emailService;

	@GetMapping("")
	public String login() {
		return "login";
	}

	@PostMapping("login")
	public String loginDetails(Model model, @ModelAttribute("loginAttribute") LoginDetails loginDetails) {
		System.out.println("loginDetails - " + loginDetails.getEmail() + " : Password - " + loginDetails.getPassword());
		List<LoginDetails> list = service.validLoginDetails(loginDetails);
		if (null != list && !list.isEmpty()) {
			System.out.println(
					"UserTypeDbKey - " + list.get(0).getUserTypeDbKey() + " : Password -" + loginDetails.getPassword());
			if (list.get(0).getUserTypeDbKey() == 1) {

				return "studentComplaint";

			} else {
				List<ComplaintDetails> activeComplaintDetails = new ArrayList<>();
				int activeComplaints = 0;
				int InActiveComplaints = 0;
				List<ComplaintDetails> complaintDetails = service.getComplaintDetails();
				if (complaintDetails != null && !complaintDetails.isEmpty()) {
					for (ComplaintDetails complaint : complaintDetails) {
						if (complaint.getIsActive() == 1) {
							activeComplaintDetails.add(complaint);
							activeComplaints++;
						} else {
							InActiveComplaints++;
						}
					}
					if (activeComplaintDetails != null && !activeComplaintDetails.isEmpty()) {
						model.addAttribute("studentComplaints", activeComplaintDetails);
						model.addAttribute("pendingComplaints", activeComplaints);
						model.addAttribute("solvedComplaints", InActiveComplaints);
						model.addAttribute("complaintCount", complaintDetails.size());
						return "home";
					} else {
						model.addAttribute("message", "No Records");
						return "home";
					}
				}
				model.addAttribute("message", "No Records");
				return "login";
			}

		} else {
			model.addAttribute("message", "Please Enter Valid Email Id and Password");
			return "login";
		}
	}

	@PostMapping("studentComplaint")
	public String saveStudentComplaint(Model model,
			@ModelAttribute("studentAttribute") ComplaintDetails complaintDetails) {
		complaintDetails.setPriority("High");
		complaintDetails.setUserTypeDbKey(1);
		complaintDetails.setIsActive(1);
		service.saveComplaintDetails(complaintDetails);

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(complaintDetails.getEmail());
		mailMessage.setSubject("Complaint Registration!");
		mailMessage.setText("Your Complaint Registered Succesfully.");
		emailService.sendEmail(mailMessage);
		model.addAttribute("message", "Complaint Registered Successfully.And Mail Send to Student");
		return "studentComplaint";
	}

	@PostMapping("deleteComplaint")
	public String deleteComplaint(Model model, @ModelAttribute("deleteAttribute") ComplaintDetails details) {

		service.deleteCompalaint(details);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(details.getEmail());
		mailMessage.setSubject("Complaint Resolved");
		mailMessage.setText("Issue Resolved Succesfully. ");
		emailService.sendEmail(mailMessage);
		List<ComplaintDetails> activeComplaintDetails = new ArrayList<>();
		int activeComplaints = 0;
		int InActiveComplaints = 0;
		List<ComplaintDetails> complaintDetails = service.getComplaintDetails();
		if (null != complaintDetails && !complaintDetails.isEmpty()) {
			for (ComplaintDetails complaint : complaintDetails) {
				if (complaint.getIsActive() == 1) {
					activeComplaintDetails.add(complaint);
					activeComplaints++;
				} else {
					InActiveComplaints++;
				}
			}
			model.addAttribute("studentComplaints", activeComplaintDetails);
			model.addAttribute("pendingComplaints", activeComplaints);
			model.addAttribute("solvedComplaints", InActiveComplaints);
			model.addAttribute("complaintCount", complaintDetails.size());
			model.addAttribute("message", "Complaint deleted Successfully.And Mail Send to Student");
			return "home";
		}
		model.addAttribute("message", "Complaint deleted Successfully.And Mail Send to Student");
		return "login";
	}
}
