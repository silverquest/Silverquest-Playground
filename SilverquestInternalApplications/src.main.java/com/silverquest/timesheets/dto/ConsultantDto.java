package com.silverquest.timesheets.dto;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.Persistent;

import com.google.gwt.user.client.rpc.IsSerializable;


public class ConsultantDto extends EmployeeDto implements Serializable, IsSerializable{

	private static final long serialVersionUID = 1141230946485280162L;

	public ConsultantDto() {
	}
	
	@Persistent
	private Date dateOfBirth;
	
	@Persistent
	private Date dateStarted;
	
	@Persistent
	private String jobTitle;
	
	@Embedded
	@Persistent
	private AddressDto address;

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


	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}
	



}
