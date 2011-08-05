package com.silverquest.timesheets.service;

import com.silverquest.timesheets.dto.CompanyDetailsDto;
import com.silverquest.timesheets.dto.CompanyDto;
import com.silverquest.timesheets.jdo.service.CompanyJdoService;

public interface CompanyService extends CompanyJdoService{

  public CompanyDetailsDto getCompanyDetails(String companyId);
  public CompanyDto getDtoById(String companyId);
  
	/**
	 * 
	 * @return
	 */
	public CompanyDetailsDto findParentCompany();
  	
}
