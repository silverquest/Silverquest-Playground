package com.silverquest.timesheets.dto;


public class AbsenceDetailsDto {

	private Double sickDaysAccrued;
	private Double leaveDaysAccured;
	private Double sickDaysTaken;
	private Double leaveDaysTaken;
	private Double totalLeaveDaysAllowedPerYear;
	private Double totalSickDaysAllowedPerYear;
	private Double daysInLieuEarned;
	private Double daysInLieuUsed;
	

	public Double getDaysInLieuUsed() {
		return daysInLieuUsed;
	}
	public void setDaysInLieuUsed(Double daysInLieuUsed) {
		this.daysInLieuUsed = daysInLieuUsed;
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
	
	
}
