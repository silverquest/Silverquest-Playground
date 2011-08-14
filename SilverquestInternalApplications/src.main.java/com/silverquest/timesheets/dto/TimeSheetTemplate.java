package com.silverquest.timesheets.dto;

import java.util.ArrayList;
import java.util.List;

public class TimeSheetTemplate {

	private CompanyDto clientCompany;
	private AppUserDto consultant;
	private TimeSheetDto timeSheet;

	public TimeSheetTemplate() {
		
	  clientCompany = new CompanyDto();
	  consultant = new AppUserDto();
	  timeSheet = new TimeSheetDto();
	  // Fill the time sheet template with dummy entries for every day of the week
	  List<TimeSheetEntryDto> timeSheetEntries = new ArrayList<TimeSheetEntryDto>();

	  for (int i = 0; i <= 7; i++) {
		timeSheetEntries.add(new TimeSheetEntryDto());
	  }
      timeSheet.setTimeSheetEntries(timeSheetEntries);

	}

	public CompanyDto getClientCompany() {
		return clientCompany;
	}

	public void setClientCompany(CompanyDto clientCompany) {
		this.clientCompany = clientCompany;
	}

	public AppUserDto getConsultant() {
		return consultant;
	}

	public void setConsultant(AppUserDto consultant) {
		this.consultant = consultant;
	}

	public TimeSheetDto getTimeSheet() {
		return timeSheet;
	}

	public void setTimeSheet(TimeSheetDto timeSheet) {
		this.timeSheet = timeSheet;
	}

}
