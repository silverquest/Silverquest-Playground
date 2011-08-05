package com.silverquest.timesheets.jdo.service;

import java.util.List;

import com.silverquest.timesheets.dao.CompanyDao;
import com.silverquest.timesheets.dto.CompanyDetailsDto;
import com.silverquest.timesheets.dto.CompanyDto;

public interface CompanyJdoService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public CompanyDao getById(String id);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CompanyDto save(CompanyDto dto) ;
	
	/**
	 * 
	 * @param companyType
	 * @return
	 */
	public List<CompanyDetailsDto> findCompaniesByType(String companyType);
	


}
