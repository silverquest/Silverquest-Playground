package com.silverquest.timesheets.dto;

import java.util.Set;


public class AprovalDto {

	private Long id;
	private Set<String> approveeUserIds;
	private String contractId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<String> getAproveeUserIds() {
		return approveeUserIds;
	}
	public void setAproveeUserIds(Set<String> approveeUserIds) {
		this.approveeUserIds = approveeUserIds;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractIds) {
		this.contractId = contractIds;
	}

	

	
}
