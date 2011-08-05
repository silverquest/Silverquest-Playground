package com.silverquest.timesheets.dto;

import java.io.Serializable;
import java.util.Set;

import com.google.gwt.user.client.rpc.IsSerializable;


public class CompanyDto implements Serializable, IsSerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4885313878013244619L;

	private String id;
	private String companyName;
	private AddressDto address;
	private CompanyType type;
	private Set<String> appUserIds;
	
	public CompanyDto(){
		
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id){
	   this.id = id;
	}
	
	public CompanyType getType() {
		return type;
	}

	public void setType(CompanyType type) {
		this.type = type;
	}
	
	public Set<String> getAppUserIds() {
		return appUserIds;
	}

	public void setAppUserIds(Set<String> appUserIds) {
		this.appUserIds = appUserIds;
	}
	


}
