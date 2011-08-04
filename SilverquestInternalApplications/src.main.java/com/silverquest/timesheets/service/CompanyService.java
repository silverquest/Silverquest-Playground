package com.silverquest.timesheets.service;

import com.silverquest.timesheets.dto.CompanyDto;
import com.silverquest.timesheets.jdo.service.CompanyJdoService;

public interface CompanyService extends CompanyJdoService{

  public CompanyDto getCompanyDetails(String companyId);
	
}
