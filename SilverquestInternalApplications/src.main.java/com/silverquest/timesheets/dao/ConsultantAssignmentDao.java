package com.silverquest.timesheets.dao;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.silverquest.timesheets.dto.ConsultantAssignmentDto;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class ConsultantAssignmentDao implements Serializable {

	private static final long serialVersionUID = -3042566807271541471L;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;

	@Persistent
	private String consultantId;
	@Persistent
	private String clientCompanyId;

	@Persistent
	private Date dateStarted;

	@Persistent
	private Date endDate;
	@Persistent
	private boolean isClosed;

	@Persistent
	private Double hourlyRateCharged;
	@Persistent
	private String currency;
	@Persistent
	private String projectName;


	public ConsultantAssignmentDao() {

	}

	public ConsultantAssignmentDao(ConsultantAssignmentDto dto) {
		
		id = dto.getId();
		consultantId = dto.getConsultantId();
		clientCompanyId = dto.getClientCompanyId();
		dateStarted = dto.getDateStarted();
		endDate = dto.getEndDate();
		isClosed = dto.isClosed();
		hourlyRateCharged = dto.getHourlyRateCharged();
		currency = dto.getCurrency();
		projectName = dto.getProjectName();

	}

	public ConsultantAssignmentDto toDto() {
		ConsultantAssignmentDto dto = new ConsultantAssignmentDto();
		dto.setId(id);
		dto.setConsultantId(consultantId);
		dto.setClientCompanyId(clientCompanyId);
		dto.setDateStarted(dateStarted);
		dto.setEndDate(endDate);
		dto.setClosed(isClosed);
		dto.setHourlyRateCharged(hourlyRateCharged);
		dto.setCurrency(currency);
		dto.setProjectName(projectName);

		return dto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

	public Double getHourlyRateCharged() {
		return hourlyRateCharged;
	}

	public void setHourlyRateCharged(Double hourlyRateCharged) {
		this.hourlyRateCharged = hourlyRateCharged;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getClientCompanyId() {
		return clientCompanyId;
	}

	public void setClientCompanyId(String clientCompanyId) {
		this.clientCompanyId = clientCompanyId;
	}

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


}
