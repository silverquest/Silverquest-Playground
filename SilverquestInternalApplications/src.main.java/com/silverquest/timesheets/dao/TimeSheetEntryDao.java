package com.silverquest.timesheets.dao;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.silverquest.timesheets.dto.TimeSheetEntryDto;
import com.silverquest.timesheets.enums.WorkCode;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class TimeSheetEntryDao implements Serializable {

	private static final long serialVersionUID = 4931327666271031893L;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;
	@Persistent
	private Date date;
	@Persistent
	private Integer numberOfHours;
	@Persistent
	private Double portionOfDay;   // ie 1 or 0.5
	@Persistent
	private Long timeSheetId;
	
	@Persistent
	private String description;
	
	@Persistent
	private WorkCode workTypeRef;
	

	public TimeSheetEntryDao(){
		
	}
	
	
	public TimeSheetEntryDao(TimeSheetEntryDto dto){
		id = dto.getId();
		date = dto.getDate();
		numberOfHours = dto.getNumberOfHours();
		portionOfDay = dto.getPortionOfDay();
		timeSheetId = dto.getTimeSheetId();
		description = dto.getDescription();
		workTypeRef = dto.getWorkTypeRef();
	}
	
	public TimeSheetEntryDto toDto(){
		TimeSheetEntryDto dto = new TimeSheetEntryDto();
		dto.setId(id);
		dto.setDate(date);
		dto.setNumberOfHours(numberOfHours);
		dto.setPortionOfDay(portionOfDay);
		dto.setTimeSheetEntry(timeSheetId);
		dto.setDescription(description);
		dto.setWorkTypeRef(workTypeRef);
		return dto;
		
	}

	public Long getTimeSheetId() {
		return timeSheetId;
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

	public Double getPortionOfDay() {
		return portionOfDay;
	}

	public void setPortionOfDay(Double portionOfDay) {
		this.portionOfDay = portionOfDay;
	}

	public String getId() {
		return id;
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

	



}
