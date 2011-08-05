package com.silverquest.timesheets.service.impl;


import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import com.silverquest.timesheets.dao.CompanyDao;
import com.silverquest.timesheets.dto.CompanyDetailsDto;
import com.silverquest.timesheets.dto.CompanyDto;
import com.silverquest.timesheets.dto.CompanyType;

import com.silverquest.timesheets.jdo.service.impl.CompanyJdoServiceImpl;
import com.silverquest.timesheets.service.CompanyService;
import com.silverquest.timesheets.service.AppUserService;

public class CompanyServiceImpl extends CompanyJdoServiceImpl implements CompanyService, InitializingBean {
	
	private AppUserService appUserService;
	
	/**
	 * 
	 * @param companyId
	 * @return
	 */
	public CompanyDto getDtoById(String companyId){
		
	   CompanyDao companyDao = this.getById(companyId);	
	   if( companyDao != null ){
	     return companyDao.toDto();
	   }
	   return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public CompanyDetailsDto findParentCompany(){
		
		List<CompanyDetailsDto> companies = findCompaniesByType(CompanyType.PARENT.toString());
		if( companies != null && companies.size() > 0){
			return companies.get(0);
		}
		return null;
	}
	


	@Override
	public void afterPropertiesSet() throws Exception {
	
	  if( appUserService == null ){
	    System.out.println( "ERROR - appUserService is null");
	  }
	}
	





	@Override
	public CompanyDetailsDto getCompanyDetails(String companyId) {
	  
		CompanyDao companyDao = getById( companyId );
		if( companyDao != null ){
		  return companyDao.toDetailsDto();
		}
		return null;
		
		
	}
	
	public AppUserService getAppUserService() {
		return appUserService;
	}

	public void setAppUserService(AppUserService appUserService) {
		this.appUserService = appUserService;
	}
}
