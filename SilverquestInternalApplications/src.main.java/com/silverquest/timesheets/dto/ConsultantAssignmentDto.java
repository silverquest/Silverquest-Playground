package com.silverquest.timesheets.dto;

import java.io.Serializable;
import java.util.Date;
import com.google.gwt.user.client.rpc.IsSerializable;

public class ConsultantAssignmentDto implements Serializable,
		IsSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4446920713627581131L;

	private String id;
	private String consultantId;
    private String clientId;
    private Double hourlyRateCharged;
    private String currency;
	private String clientCompanyId;
    private Date dateStarted;
    private Date endDate;
    private boolean isClosed;
    private String projectName;





	public ConsultantAssignmentDto(){
		
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

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
