package com.silverquest.timesheets.dao;

import java.util.Set;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.silverquest.timesheets.dto.CompanyType;
import com.silverquest.timesheets.dto.AppUserDto;
import com.silverquest.timesheets.enums.UserRole;
import com.silverquest.timesheets.enums.UserType;

import javax.jdo.annotations.Inheritance;

@Inheritance(customStrategy = "complete-table")
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class AppUserDao {

	@PrimaryKey
	@Persistent
	private String id;
	@Persistent
	private String firstName;
	@Persistent
	private String lastName;
	@Persistent
	private String middleName;
	@Persistent
	private CompanyType companyType;
	@Persistent
	private Set<UserRole> roles;
	@Persistent
	@Embedded
	private ContactDetailsDao contactDetails;
	@Persistent
	private String clientCompanyId;
	@Persistent
	private UserType userType;



	public AppUserDao(){
		
	}

	public AppUserDao(AppUserDto dto) {
		setId(dto.getId());
		setFirstName(dto.getFirstName());
		setLastName(dto.getLastName());
		setMiddleName(dto.getMiddleName());
		setCompanyType(dto.getCompanyType());
		setRoles(dto.getRoles());
		setContactDetails(dto.getContactDetails());
		setClientCompanyId(dto.getClientCompanyId());
		setUserType(dto.getUserType());


	}



	public AppUserDto toDto() {

		AppUserDto dto = new AppUserDto();
		dto.setId(getUserId());
		dto.setFirstName(getFirstName());
		dto.setLastName(getLastName());
		dto.setMiddleName(getMiddleName());
		dto.setCompanyType(getCompanyType());
		dto.setRoles(roles);
		dto.setContactDetails(getContactDetails());
		dto.setCompanyType(companyType);
		dto.setClientCompanyId(clientCompanyId);
		dto.setPassword(dto.getPassword());
		dto.setUserType(userType);
		return dto;

	}

	public AppUserDao(String id) {
		this.id = id;
	}

	public String getUserId() {
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

    public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
	
	public Set<UserRole> getRoles() {
		return roles;
	}

}
