package com.silverquest.timesheets.dao;

import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.silverquest.timesheets.dto.AbsenceDetailsDto;


@PersistenceCapable
@EmbeddedOnly
public class AbsenceDetailsDao {

	@Persistent
	private Double sickDaysAccrued;
	@Persistent
	private Double leaveDaysAccured;
	@Persistent
	private Double sickDaysTaken;
	@Persistent
	private Double leaveDaysTaken;
	@Persistent
	private Double totalLeaveDaysAllowedPerYear;
	@Persistent
	private Double totalSickDaysAllowedPerYear;
	@Persistent
	private Double daysInLieuEarned;
	@Persistent
	private Double daysInLieuUsed;
	
	public AbsenceDetailsDao(){
		
	}
	
	public AbsenceDetailsDao(AbsenceDetailsDto dto){
		sickDaysAccrued = dto.getSickDaysAccrued();
        leaveDaysAccured = dto.getLeaveDaysAccured();
        sickDaysTaken = dto.getSickDaysTaken();
        leaveDaysTaken = dto.getLeaveDaysTaken();
        totalLeaveDaysAllowedPerYear = dto.getTotalLeaveDaysAllowedPerYear();
        totalSickDaysAllowedPerYear = dto.getTotalSickDaysAllowedPerYear();
	}
	
	
	public Double getSickDaysAccrued() {
		return sickDaysAccrued;
	}
	public void setSickDaysAccrued(Double sickDaysAccrued) {
		this.sickDaysAccrued = sickDaysAccrued;
	}
	public Double getLeaveDaysAccured() {
		return leaveDaysAccured;
	}
	public void setLeaveDaysAccured(Double leaveDaysAccured) {
		this.leaveDaysAccured = leaveDaysAccured;
	}
	public Double getSickDaysTaken() {
		return sickDaysTaken;
	}
	public void setSickDaysTaken(Double sickDaysTaken) {
		this.sickDaysTaken = sickDaysTaken;
	}
	public Double getLeaveDaysTaken() {
		return leaveDaysTaken;
	}
	public void setLeaveDaysTaken(Double leaveDaysTaken) {
		this.leaveDaysTaken = leaveDaysTaken;
	}
	public Double getTotalLeaveDaysAllowedPerYear() {
		return totalLeaveDaysAllowedPerYear;
	}
	public void setTotalLeaveDaysAllowedPerYear(Double totalLeaveDaysAllowedPerYear) {
		this.totalLeaveDaysAllowedPerYear = totalLeaveDaysAllowedPerYear;
	}
	public Double getTotalSickDaysAllowedPerYear() {
		return totalSickDaysAllowedPerYear;
	}
	public void setTotalSickDaysAllowedPerYear(Double totalSickDaysAllowedPerYear) {
		this.totalSickDaysAllowedPerYear = totalSickDaysAllowedPerYear;
	}
	
	public Double getDaysInLieuEarned() {
		return daysInLieuEarned;
	}

	public void setDaysInLieuEarned(Double daysInLieuEarned) {
		this.daysInLieuEarned = daysInLieuEarned;
	}
	
	public Double getDaysInLieuUsed() {
		return daysInLieuUsed;
	}

	public void setDaysInLieuUsed(Double daysInLieuUsed) {
		this.daysInLieuUsed = daysInLieuUsed;
	}
	
}
