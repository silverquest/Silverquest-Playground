package com.silverquest.timesheets.dto;

import java.util.Set;

import com.silverquest.timesheets.dao.ContactDetailsDao;
import com.silverquest.timesheets.enums.UserRole;
import com.silverquest.timesheets.enums.UserType;

public class AppUserDto {

	private String id;
	private String firstName;
	private String lastName;
	private String middleName;
	private CompanyType companyType;
	private Set<UserRole> roles;
	private String clientCompanyId;
	private UserType userType;

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;



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


	public Set<UserRole> getRoles() {
		return roles;
	}


	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
	
	public ContactDetailsDao getContactDetails() {
		return contactDetails;
	}


	public void setContactDetails(ContactDetailsDao contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getClientCompanyId() {
		return clientCompanyId;
	}

	public void setClientCompanyId(String clientCompanyId) {
		this.clientCompanyId = clientCompanyId;
	}



	
}
