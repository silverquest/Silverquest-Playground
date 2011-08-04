package com.silverquest.timesheets.dao;

import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.silverquest.timesheets.dto.ContactDetailsDto;


@PersistenceCapable
@EmbeddedOnly
public class ContactDetailsDao {
		
	@Persistent
	private String emailAddress;
	@Persistent
	private String faxNumber;
	@Persistent
	private String workPhoneNumber;
	@Persistent
	private String emergencyPhoneNumber;
	
	public ContactDetailsDao(){
		
	}
	
	public ContactDetailsDao(ContactDetailsDto dto){
		
	  emailAddress = dto.getEmailAddress();
	  faxNumber = dto.getFaxNumber();
	  workPhoneNumber = dto.getWorkPhoneNumber();
	  emergencyPhoneNumber = dto.getEmergencyPhoneNumber();
	}
	
	public ContactDetailsDto toDto(){
		
	  ContactDetailsDto dto = new ContactDetailsDto();
	  dto.setEmailAddress(emailAddress);
	  dto.setFaxNumber(faxNumber);
	  dto.setWorkPhoneNumber(workPhoneNumber);
	  dto.setEmergencyPhoneNumber(emergencyPhoneNumber);
	  return dto;
		
	}
	


	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}
	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}
	public String getEmergencyPhoneNumber() {
		return emergencyPhoneNumber;
	}
	public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
		this.emergencyPhoneNumber = emergencyPhoneNumber;
	}

	

}
