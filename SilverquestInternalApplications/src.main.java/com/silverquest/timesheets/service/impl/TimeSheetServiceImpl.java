package com.silverquest.timesheets.service.impl;

import org.springframework.beans.factory.InitializingBean;
import com.silverquest.timesheets.dto.CompanyDto;
import com.silverquest.timesheets.dto.ConsultantAssignmentDto;
import com.silverquest.timesheets.dto.ConsultantDto;
import com.silverquest.timesheets.dto.TimeSheetDto;
import com.silverquest.timesheets.jdo.service.impl.TimeSheetJdoServiceImpl;
import com.silverquest.timesheets.service.CompanyService;
import com.silverquest.timesheets.service.ConsultantService;
import com.silverquest.timesheets.service.TimeSheetService;

public class TimeSheetServiceImpl extends TimeSheetJdoServiceImpl implements TimeSheetService, InitializingBean  {


	private ConsultantService consultantService;

	private CompanyService companyService;

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public TimeSheetTemplate getTimeSheetTemplate(String userId) {

		TimeSheetTemplate template = new TimeSheetTemplate();

		ConsultantAssignmentDto consultantContract = getConsultantService()
				.findCurrentConsultantContract(userId);
		
		if( consultantContract == null ){
		  return null;
		}

		String clientCompanyId = consultantContract.getClientCompanyId();

		ConsultantDto consultantDetails = getConsultantService()
				.getConsultantDetails(userId);

		CompanyDto company = getCompanyService().getDtoById( clientCompanyId );

		template.setClientCompany(company );
		template.setConsultant(consultantDetails);

		return template;

	}
	


	public TimeSheetTemplate getTimeSheetForUpdate(String timeSheetId, String userId) {

		// Gets company and consultant details
		TimeSheetTemplate template = getTimeSheetTemplate(userId);

		// Get Time Sheet details and entry details
		TimeSheetDto timeSheet = getTimeSheetById(timeSheetId, userId);
		
		template.setTimeSheet(timeSheet);
		
		return template;
		

	}

	public ConsultantService getConsultantService() {
		return consultantService;
	}

	public void setConsultantService(ConsultantService consultantService) {
		this.consultantService = consultantService;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}



	@Override
	public void afterPropertiesSet() throws Exception {
	
	  if( consultantService == null ){
	    System.out.println( "ConsultantService is null from TimeSheetServiceImpl");
	  }
	  else{
		  System.out.println( "ConsultantService is fine from TimeSheetServiceImpl"); 
	  }
	  if( companyService == null ){
		System.out.println( "CompanyService is null from TimeSheetServiceImpl");
	  }
	  else{
		System.out.println( "CompanyService is fine from TimeSheetServiceImpl");
	  }
		
	}



}
