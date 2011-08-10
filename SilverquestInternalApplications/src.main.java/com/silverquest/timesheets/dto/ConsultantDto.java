package com.silverquest.timesheets.dto;

import java.io.Serializable;
import java.util.Date;

import com.silverquest.timesheets.dao.AbsenceDetailsDao;
import com.silverquest.timesheets.enums.EmploymentType;



public class ConsultantDto extends AppUserDto implements Serializable{

	private static final long serialVersionUID = 1141230946485280162L;

	public ConsultantDto() {

	}
	
	private Date dateOfBirth;
	private Date dateOfEmployment;
	private EmploymentType employmentType;
	private String jobTitle;
	private AddressDto address;
	private AbsenceDetailsDao absenceDetails;




	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}
	
	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}
	
	public AbsenceDetailsDao getAbsenceDetails() {
		return absenceDetails;
	}

	public void setAbsenceDetails(AbsenceDetailsDao absenceDetails) {
		this.absenceDetails = absenceDetails;
	}

}
