package com.silverquest.timesheets.dao;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.silverquest.timesheets.dto.AprovalDto;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class AprovalDao {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	//Aprovee's user Id
	@Persistent
	private Set<String> aproveeUserIds;

	@Persistent
	private String contractId;
	
	public AprovalDao(){
	  aproveeUserIds = new HashSet<String>();
	}
	
	public AprovalDao(AprovalDto dto){
	
		id = dto.getId();
		aproveeUserIds = dto.getAproveeUserIds();
		contractId = dto.getContractId();

	}
	
	public AprovalDto getDto(){
		
	  AprovalDto dto = new AprovalDto();
	  dto.setId(id);
	  dto.setAproveeUserIds(aproveeUserIds);
	  dto.setContractId(contractId);
	  return dto;
		
	}

	public Long getId() {
		return id;
	}

	public Set<String> getAproveeUserIds() {
		return aproveeUserIds;
	}

	public void setAproveeUserIds(Set<String> aproveeUserIds) {
		this.aproveeUserIds = aproveeUserIds;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}



}
