package com.silverquest.timesheets.service.impl;

import com.silverquest.timesheets.dto.CompanyDto;
import com.silverquest.timesheets.dto.ConsultantDto;
import com.silverquest.timesheets.dto.TimeSheetDto;

public class TimeSheetTemplate {

	private CompanyDto clientCompany;
	private ConsultantDto consultant;
	private TimeSheetDto timeSheet;

	public CompanyDto getClientCompany() {
		return clientCompany;
	}

	public void setClientCompany(CompanyDto clientCompany) {
		this.clientCompany = clientCompany;
	}

	public ConsultantDto getConsultant() {
		return consultant;
	}

	public void setConsultant(ConsultantDto consultant) {
		this.consultant = consultant;
	}

	public TimeSheetDto getTimeSheet() {
		return timeSheet;
	}

	public void setTimeSheet(TimeSheetDto timeSheet) {
		this.timeSheet = timeSheet;
	}

}
