package com.silverquest.timesheets.dao;

import java.util.Date;

import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.silverquest.timesheets.dto.TimeSheetTimeStampsDto;

@PersistenceCapable
@EmbeddedOnly
public class TimeSheetTimeStampsDao {

	@Persistent
	private Date submittedDate;
	@Persistent
	private Date createdDate;
	@Persistent
	private Date rejectedDate;
	@Persistent
	private Date approvedDate;

	public TimeSheetTimeStampsDao(TimeSheetTimeStampsDto dto) {

		submittedDate = dto.getSubmittedDate();
		createdDate = dto.getCreatedDate();
		rejectedDate = dto.getRejectedDate();
		approvedDate = dto.getApprovedDate();

	}

	public TimeSheetTimeStampsDto toDto() {
		
	  TimeSheetTimeStampsDto dto = new TimeSheetTimeStampsDto();
	  dto.setApprovedDate(approvedDate);
	  dto.setCreatedDate(createdDate);
	  dto.setRejectedDate(rejectedDate);
	  dto.setApprovedDate(approvedDate);
	  return dto;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getRejectedDate() {
		return rejectedDate;
	}

	public void setRejectedDate(Date rejectedDate) {
		this.rejectedDate = rejectedDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

}
