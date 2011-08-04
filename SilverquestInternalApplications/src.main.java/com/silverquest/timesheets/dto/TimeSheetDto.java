package com.silverquest.timesheets.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.silverquest.timesheets.enums.TimeSheetStatus;


public class TimeSheetDto implements Serializable, IsSerializable {

	private static final long serialVersionUID = -2042703707862236886L;

	private Long id;
	private Date date;
	private Integer numberOfHours;
	private String approvedBy;
	private Double totalDaysWorked;
	private String rejectReason; 
    private Date weekStarting;
    private String owner;
    private Double totalHoursWorked;
	private List<TimeSheetEntryDto> timeSheetEntries;
	private TimeSheetStatus status;
	private TimeSheetTimeStampsDto timeStamps;
	


	public TimeSheetDto(){
		
	}
	
	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Double getTotalDaysWorked() {
		return totalDaysWorked;
	}

	public void setTotalDaysWorked(Double totalDaysWorked) {
		this.totalDaysWorked = totalDaysWorked;
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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TimeSheetEntryDto> getTimeSheetEntries() {
		return timeSheetEntries;
	}

	public void setTimeSheetEntries(List<TimeSheetEntryDto> timeSheetEntries) {
		this.timeSheetEntries = timeSheetEntries;
	}
	
	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public Date getWeekStarting() {
		return weekStarting;
	}

	public void setWeekStarting(Date weekStarting) {
		this.weekStarting = weekStarting;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}


	public Double getTotalHoursWorked() {
		return totalHoursWorked;
	}

	public void setTotalHoursWorked(Double totalHoursWorked) {
		this.totalHoursWorked = totalHoursWorked;
	}
	
	public TimeSheetStatus getStatus() {
		return status;
	}

	public void setStatus(TimeSheetStatus status) {
		this.status = status;
	}
	
	public TimeSheetTimeStampsDto getTimeStamps() {
		return timeStamps;
	}

	public void setTimeStamps(TimeSheetTimeStampsDto timeStamps) {
		this.timeStamps = timeStamps;
	}

}
