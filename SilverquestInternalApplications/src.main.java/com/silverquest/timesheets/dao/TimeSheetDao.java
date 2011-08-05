package com.silverquest.timesheets.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Order;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.silverquest.timesheets.dto.TimeSheetDto;
import com.silverquest.timesheets.dto.TimeSheetEntryDto;
import com.silverquest.timesheets.enums.TimeSheetStatus;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class TimeSheetDao implements Serializable {

	private static final long serialVersionUID = -4550184321600861157L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String contractId;

	@Persistent
	private String owner;

	@Persistent
	private TimeSheetStatus status;
	
	@Persistent
	private String approvedBy;
	
	@Persistent
	private String rejectReason;

	@Persistent
	private Date weekStarting;

	@Persistent
	private Double totalDaysWorked;
	@Persistent
	private Double totalHoursWorked;
	
	@Embedded
	@Persistent
	private TimeSheetTimeStampsDao timeStamps;
	
	@Persistent
	@Order(extensions = @Extension(vendorName = "datanucleus", key = "list-ordering", value = "date asc"))
	private List<TimeSheetEntryDao> timeSheetEntries;

	public TimeSheetDao() {

	}

	public TimeSheetDao(TimeSheetDto dto) {
		if (dto.getTimeSheetEntries() != null) {
			for (TimeSheetEntryDto entry : dto.getTimeSheetEntries()) {
				if (timeSheetEntries == null) {
					timeSheetEntries = new ArrayList<TimeSheetEntryDao>();
				}
				timeSheetEntries.add(new TimeSheetEntryDao(entry));
			}
		}
		contractId = dto.getAssignmentId();
		status = dto.getStatus();
		approvedBy = dto.getApprovedBy();
		totalDaysWorked = dto.getTotalDaysWorked();
		rejectReason = dto.getRejectReason();
		weekStarting = dto.getWeekStarting();
		owner = dto.getOwner();
		totalHoursWorked = dto.getTotalHoursWorked();
		if( dto.getTimeStamps() != null ){
		  timeStamps = new TimeSheetTimeStampsDao( dto.getTimeStamps() );
		}

	}

	public TimeSheetDto toDto() {
		TimeSheetDto dto = new TimeSheetDto();
		dto.setId(id);

		List<TimeSheetEntryDto> entries = new ArrayList<TimeSheetEntryDto>();
		if (timeSheetEntries != null) {
			for (TimeSheetEntryDao entry : timeSheetEntries) {
				entries.add(entry.toDto());
			}
		}
		dto.setAssignmentId(contractId);
		dto.setTimeStamps(timeStamps.toDto());
		dto.setStatus(status);
		dto.setTimeSheetEntries(entries);
		dto.setApprovedBy(approvedBy);

		dto.setTotalDaysWorked(totalDaysWorked);
		dto.setRejectReason(rejectReason);
		dto.setWeekStarting(weekStarting);
		dto.setOwner(owner);

		dto.setTotalHoursWorked(totalHoursWorked);
		
		return dto;

	}

	public Long getId() {
		return id;
	}

	public List<TimeSheetEntryDao> getTimeSheetEntries() {
		return timeSheetEntries;
	}

	public void setTimeSheetEntries(List<TimeSheetEntryDao> timeSheetEntries) {
		this.timeSheetEntries = timeSheetEntries;
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

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
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
	
	public TimeSheetTimeStampsDao getTimeStamps() {
		return timeStamps;
	}

	public void setTimeStamps(TimeSheetTimeStampsDao timeStamps) {
		this.timeStamps = timeStamps;
	}

}
