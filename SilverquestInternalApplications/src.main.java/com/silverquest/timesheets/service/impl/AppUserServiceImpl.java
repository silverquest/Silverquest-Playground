package com.silverquest.timesheets.service.impl;

import java.util.List;

import com.silverquest.timesheets.dao.AppUserDao;
import com.silverquest.timesheets.dto.AppUserDetailsDto;
import com.silverquest.timesheets.dto.AppUserDto;
import com.silverquest.timesheets.dto.CompanyDetailsDto;
import com.silverquest.timesheets.jdo.service.impl.AppUserJdoServiceImpl;
import com.silverquest.timesheets.service.AppUserService;
import com.silverquest.timesheets.service.CompanyService;

public class AppUserServiceImpl extends AppUserJdoServiceImpl implements AppUserService{

	private CompanyService companyService;
	


	@Override
	public AppUserDto getDtoById(String id) {
	  AppUserDao dao = super.getById(id);
	  if( dao != null ){
	    return dao.toDto();
	  }
	  return null;
	  
	}

	@Override
	public List<AppUserDto> findParentEmployees() {
		
		CompanyDetailsDto parentCompany = getCompanyService().findParentCompany();
		
		if( parentCompany != null ){
			
		  return this.findAppUsersByCompanyId(parentCompany.getId());	
			
		}
		return null;
		
	}
	
	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	
	
	
}
