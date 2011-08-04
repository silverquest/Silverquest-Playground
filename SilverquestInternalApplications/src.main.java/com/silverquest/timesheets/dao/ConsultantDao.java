package com.silverquest.timesheets.dao;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.silverquest.timesheets.dto.ConsultantDto;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class ConsultantDao extends EmployeeDao implements Serializable {

	private static final long serialVersionUID = 5034233204705352344L;

	@Persistent
	private Date dateOfBirth;
	
	@Persistent
	private Date dateStarted;
	
	@Persistent
	private String jobTitle;
	
	@Embedded
	@Persistent
	private AddressDao address;


	public ConsultantDao(String userId){
	  super(userId);
	  super.setUserId( userId );
	}
	

	public ConsultantDao(ConsultantDto dto){
	  super();

	  super.setUserId(dto.getUserId());
	  super.setFirstName( dto.getFirstName() );
	  super.setLastName ( dto.getLastName() );
	  super.setMiddleName (  dto.getMiddleName());
	  super.setCompanyType ( dto.getCompanyType());
	  super.setRoles ( dto.getRoles());
	  super.setContactDetails(  dto.getContactDetails());
	  setDateOfBirth (  dto.getDateOfBirth());
	  setJobTitle ( dto.getJobTitle());
	  setDateStarted (  dto.getDateStarted());
	  if( dto.getAddress() != null ){
	    address = new AddressDao(dto.getAddress());
	  }
 
	}
	

	public ConsultantDto toDto(){

		ConsultantDto dto = new ConsultantDto();

		dto.setUserId(super.getUserId());
		dto.setFirstName(super.getFirstName());
		dto.setLastName(super.getLastName());
		dto.setMiddleName(super.getMiddleName());
		dto.setCompanyType(super.getCompanyType());
		dto.setRoles(super.getRoles());
		dto.setContactDetails(super.getContactDetails());
		dto.setDateOfBirth(dateOfBirth);
		dto.setJobTitle(jobTitle);
		dto.setUserId(super.getUserId());
		if( address != null ){
		  dto.setAddress(address.toDto());
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

	public Date getDateStarted() {
		return dateStarted;
	}


	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}
	
	public AddressDao getAddress() {
		return address;
	}

	public void setAddress(AddressDao address) {
		this.address = address;
	}



}
