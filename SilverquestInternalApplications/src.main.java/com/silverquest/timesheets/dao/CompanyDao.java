package com.silverquest.timesheets.dao;

import java.io.Serializable;
import java.util.Set;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.silverquest.timesheets.dto.CompanyDetailsDto;
import com.silverquest.timesheets.dto.CompanyDto;
import com.silverquest.timesheets.dto.CompanyType;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class CompanyDao implements Serializable {

	private static final long serialVersionUID = 1612864297007772421L;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;
	@Persistent
	private String companyName;
	@Embedded
	@Persistent
	private AddressDao address;
	@Persistent
	private CompanyType type;


	public CompanyDao(CompanyDto dto) {
		id = dto.getId();
		companyName = dto.getCompanyName();
		address = new AddressDao(dto.getAddress());
		type = dto.getType();

	}

	public CompanyDto toDto() {
		CompanyDto clientDto = new CompanyDto();
		clientDto.setId(id);
		clientDto.setCompanyName(companyName);
		clientDto.setAddress(address.toDto());
		clientDto.setType(type);
		return clientDto;

	}

	public CompanyDetailsDto toDetailsDto() {
		CompanyDetailsDto companyDto = new CompanyDetailsDto();
		companyDto.setId(id);
		companyDto.setCompanyName(companyName);
		return companyDto;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public AddressDao getAddress() {
		return address;
	}

	public void setAddress(AddressDao address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public CompanyType getType() {
		return type;
	}

	public void setType(CompanyType type) {
		this.type = type;
	}

	public CompanyDao() {
		address = new AddressDao();
	}

}
