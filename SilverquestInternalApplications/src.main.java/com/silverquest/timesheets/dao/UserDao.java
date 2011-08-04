package com.silverquest.timesheets.dao;

import java.util.Set;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.silverquest.timesheets.dto.CompanyType;


import javax.jdo.annotations.Inheritance;


@Inheritance(customStrategy = "complete-table")
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public abstract class UserDao {

	@PrimaryKey
	@Persistent
	private String userId;
	@Persistent
	private String firstName;
	@Persistent
	private String lastName;
	@Persistent
	private String middleName;
	@Persistent
	private String companyId;
	@Persistent
	private CompanyType companyType;
	@Persistent
	private Set<String> roles;
	@Persistent
	@Embedded
	private ContactDetailsDao contactDetails;
	
	public UserDao(){
		
	}
	
	public UserDao(String userId){
	  this.userId = userId;
	}
	
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
