package com.silverquest.timesheets.dto;

import java.io.Serializable;
import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.silverquest.timesheets.enums.WorkCode;

public class TimeSheetEntryDto implements Serializable, IsSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8799325633025950653L;

	private String id;
	private Date date;
	private Integer numberOfHours;
	private Double portionOfDay;
	private Long timeSheetId;
	private String description;
	private WorkCode workTypeRef;

	public TimeSheetEntryDto() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WorkCode getWorkTypeRef() {
		return workTypeRef;
	}

	public void setWorkTypeRef(WorkCode workTypeRef) {
		this.workTypeRef = workTypeRef;
	}

	public void setTimeSheetId(Long timeSheetId) {
		this.timeSheetId = timeSheetId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(Integer numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getTimeSheetId() {
		return timeSheetId;
	}

	public void setTimeSheetEntry(Long timeSheetId) {
		this.timeSheetId = timeSheetId;
	}
	
	public Double getPortionOfDay() {
		return portionOfDay;
	}

	public void setPortionOfDay(Double portionOfDay) {
		this.portionOfDay = portionOfDay;
	}

}
