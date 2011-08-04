package com.silverquest.timesheets.dao;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.silverquest.timesheets.dto.AproveeDto;
import com.silverquest.timesheets.dto.CompanyType;


@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class AproveeDao extends UserDao {

	@Persistent
	private CompanyType type;

	public AproveeDao(AproveeDto dto) {
		super();
		type = dto.getType();

		super.setUserId(dto.getUserId());
		super.setFirstName(dto.getFirstName());
		super.setLastName(dto.getLastName());
		super.setMiddleName(dto.getMiddleName());
		super.setCompanyId(dto.getCompanyId());
		super.setCompanyType(dto.getCompanyType());
		super.setRoles(dto.getRoles());
		super.setContactDetails(dto.getContactDetails());

	}

	public AproveeDto toDto() {

		AproveeDto dto = new AproveeDto();

		dto.setUserId(super.getUserId());
		dto.setFirstName(super.getFirstName());
		dto.setLastName(super.getLastName());
		dto.setMiddleName(super.getMiddleName());
		dto.setCompanyId(super.getCompanyId());
		dto.setCompanyType(super.getCompanyType());
		dto.setRoles(super.getRoles());
		dto.setContactDetails(super.getContactDetails());

		dto.setType(type);
		return dto;
	}

	public CompanyType getType() {
		return type;
	}

	public void setType(CompanyType type) {
		this.type = type;
	}

	public AproveeDao(String userId) {
		super(userId);
	}

}
