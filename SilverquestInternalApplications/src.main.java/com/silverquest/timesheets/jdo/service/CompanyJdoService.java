package com.silverquest.timesheets.jdo.service;

import java.util.List;

import com.silverquest.timesheets.dto.CompanyDetailsDto;
import com.silverquest.timesheets.dto.CompanyDto;

public interface CompanyJdoService {

	public CompanyDto getById(String id);
	
	public CompanyDto save(CompanyDto dto) ;
	
	public List<CompanyDetailsDto> getListOfCompanies(String companyType);
	
}
