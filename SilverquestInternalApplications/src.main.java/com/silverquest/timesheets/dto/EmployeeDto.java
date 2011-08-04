package com.silverquest.timesheets.dto;

import java.util.Set;
import com.silverquest.timesheets.dao.ContactDetailsDao;

public class EmployeeDto {

	private String userId;
	
	private String firstName;

	private String lastName;
	
	private String middleName;
	
	private String companyId;
	
	private CompanyType companyType;
	
	private Set<String> roles;
	

	private ContactDetailsDao contactDetails;
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public CompanyType getCompanyType() {
		return companyType;
	}


	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}


	public Set<String> getRoles() {
		return roles;
	}


	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}


	public ContactDetailsDao getContactDetails() {
		return contactDetails;
	}


	public void setContactDetails(ContactDetailsDao contactDetails) {
		this.contactDetails = contactDetails;
	}


	
}
