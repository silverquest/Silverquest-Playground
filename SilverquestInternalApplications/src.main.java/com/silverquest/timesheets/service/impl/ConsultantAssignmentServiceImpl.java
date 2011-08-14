package com.silverquest.timesheets.service.impl;

import org.springframework.beans.factory.InitializingBean;

import com.silverquest.timesheets.dto.AppUserDto;
import com.silverquest.timesheets.dto.CompanyDto;
import com.silverquest.timesheets.dto.ConsultantAssignmentDto;
import com.silverquest.timesheets.dto.TimeSheetTemplate;
import com.silverquest.timesheets.jdo.service.impl.ConsultantAssignmentJdoServiceImpl;
import com.silverquest.timesheets.service.AppUserService;
import com.silverquest.timesheets.service.CompanyService;
import com.silverquest.timesheets.service.ConsultantAssignmentService;


public class ConsultantAssignmentServiceImpl extends ConsultantAssignmentJdoServiceImpl implements ConsultantAssignmentService, InitializingBean{

	private CompanyService companyService;
	private AppUserService appUserService;
	


	@Override
	public TimeSheetTemplate getCurrentAssignmentTimeSheetTemplate(String userId) {
		
		TimeSheetTemplate timeSheetTemplate = new TimeSheetTemplate();
		
		ConsultantAssignmentDto currentAssignment = super.findCurrentConsultantContract(userId);
		
		String clientId = currentAssignment.getClientCompanyId();
		
		CompanyDto companyDto = companyService.getDtoById(clientId);
		
		AppUserDto consultant = appUserService.getDtoById(userId);
		
		if( companyDto == null ){
			System.out.println(" Error - could not find company");
		}
		else{
			timeSheetTemplate.setClientCompany(companyDto);
			
		}
		if( companyDto != null ){
			timeSheetTemplate.setConsultant(consultant);
		}
		
		return timeSheetTemplate;
		
	}

	
	@Override
	public void afterPropertiesSet() throws Exception {
	
		super.afterPropertiesSet();
		
		if( companyService == null ){
			System.out.println("ERROR OCCURED");
		}
		
	}
	
	public AppUserService getAppUserService() {
		return appUserService;
	}

	public void setAppUserService(AppUserService appUserService) {
		this.appUserService = appUserService;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
}
