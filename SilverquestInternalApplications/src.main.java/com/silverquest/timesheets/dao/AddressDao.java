package com.silverquest.timesheets.dao;

import java.io.Serializable;

import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.silverquest.timesheets.dto.AddressDto;

@PersistenceCapable
@EmbeddedOnly
public class AddressDao implements Serializable {

	private static final long serialVersionUID = 7370644221323242586L;

	@Persistent
	private String companyName;
	@Persistent
	private String addressLine1;
	@Persistent
	private String addressLine2;
	@Persistent
	private String addressLine3;
	@Persistent
	private String addressLine4;
	@Persistent
	private String addressLine5;
	@Persistent
	private String state;
	@Persistent
	private String city;
	@Persistent
	private String zipCode;
	@Persistent
	private String country;

	public AddressDao(){
		
	}
	
	public AddressDao (AddressDto addressDto){

	  companyName = addressDto.getCompanyName();
	  addressLine1 = addressDto.getAddressLine1();
	  addressLine2 = addressDto.getAddressLine2();
	  addressLine3 = addressDto.getAddressLine3();
	  addressLine4 = addressDto.getAddressLine4();
	  addressLine5 = addressDto.getAddressLine5();
	  state = addressDto.getState();
	  city = addressDto.getCity();
	  zipCode = addressDto.getZipCode();
	  country = addressDto.getCountry();

	}
	
    public AddressDto toDto(){
    	
    	AddressDto dto = new AddressDto();

    	dto.setCompanyName(companyName);
    	dto.setAddressLine1(addressLine1);
    	dto.setAddressLine2(addressLine2);
    	dto.setAddressLine3(addressLine3);
    	dto.setAddressLine4(addressLine4);
    	dto.setAddressLine5(addressLine5);
    	dto.setState(state);
    	dto.setCity(city);
    	dto.setZipCode(zipCode);
    	dto.setCountry(country);
    	
    	return dto;
    	
    }
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return addressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	public String getAddressLine5() {
		return addressLine5;
	}

	public void setAddressLine5(String addressLine5) {
		this.addressLine5 = addressLine5;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
