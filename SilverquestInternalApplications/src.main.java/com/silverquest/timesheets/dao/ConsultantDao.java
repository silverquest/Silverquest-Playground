package com.silverquest.timesheets.dao;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.silverquest.timesheets.dto.ConsultantDto;
import com.silverquest.timesheets.enums.EmploymentType;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class ConsultantDao extends AppUserDao implements Serializable {

	private static final long serialVersionUID = 5034233204705352344L;

	@Persistent
	private Date dateOfBirth;

	@Persistent
	private Date dateOfEmployment;
	
	@Persistent
	private String jobTitle;
	
	@Persistent
	private EmploymentType employmentType;

	@Embedded
	@Persistent
	private AddressDao address;
	
	@Embedded
	@Persistent
	private AbsenceDetailsDao absenceDetails;



	public ConsultantDao(String userId) {
		super(userId);
		super.setId(userId);
	}

	public ConsultantDao(ConsultantDto dto) {
		super();

		super.setId(dto.getId());
		super.setFirstName(dto.getFirstName());
		super.setLastName(dto.getLastName());
		super.setMiddleName(dto.getMiddleName());
		super.setCompanyType(dto.getCompanyType());
		if( dto.getRoles() != null ){
	  	super.setRoles(dto.getRoles());
		}
		if( dto.getContactDetails() != null ){
		  super.setContactDetails(dto.getContactDetails());
		}
		setDateOfBirth(dto.getDateOfBirth());
		setJobTitle(dto.getJobTitle());
		setDateOfEmployment(dto.getDateOfEmployment());
		setEmploymentType(dto.getEmploymentType());
		super.setClientCompanyId(dto.getClientCompanyId());
		
		if (dto.getAddress() != null) {
			address = new AddressDao(dto.getAddress());
		}
		if( dto.getAbsenceDetails() != null ){
			absenceDetails = dto.getAbsenceDetails();
		}
	

	}

	public ConsultantDto toDto() {

		ConsultantDto dto = new ConsultantDto();

		dto.setId(super.getUserId());
		dto.setFirstName(super.getFirstName());
		dto.setLastName(super.getLastName());
		dto.setMiddleName(super.getMiddleName());
		dto.setCompanyType(super.getCompanyType());
		dto.setRoles(super.getRoles());
		dto.setContactDetails(super.getContactDetails());
		dto.setDateOfBirth(dateOfBirth);
		dto.setJobTitle(jobTitle);
		dto.setEmploymentType(employmentType);

		if (address != null) {
			dto.setAddress(address.toDto());
		}
		if( absenceDetails != null ){
			dto.setAbsenceDetails(absenceDetails);
		}

		return dto;

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


	public AddressDao getAddress() {
		return address;
	}

	public void setAddress(AddressDao address) {
		this.address = address;
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
