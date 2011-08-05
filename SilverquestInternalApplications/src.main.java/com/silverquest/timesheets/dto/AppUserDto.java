package com.silverquest.timesheets.dto;

import java.util.Set;
import com.silverquest.timesheets.dao.ContactDetailsDao;

public class AppUserDto {

	private String id;
	private String firstName;
	private String lastName;
	private String middleName;
	private CompanyType companyType;
	private Set<String> roles;
	private String companyId;


	private ContactDetailsDao contactDetails;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	


	
}
