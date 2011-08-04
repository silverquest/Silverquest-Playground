package com.silverquest.timesheets.jdo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.silverquest.timesheets.PMF;
import com.silverquest.timesheets.dao.CompanyDao;
import com.silverquest.timesheets.dto.CompanyDetailsDto;
import com.silverquest.timesheets.dto.CompanyDto;
import com.silverquest.timesheets.jdo.service.CompanyJdoService;
//import  org.apache.log4j.Logger;


public class CompanyJdoServiceImpl implements CompanyJdoService {
	
	
	private final static String SELECT_COMPANIES_BY_TYPE = "SELECT from " + CompanyDao.class.getName() + " WHERE type==:companyType";

	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CompanyDto save(CompanyDto dto) {

		CompanyDao companyDao = new CompanyDao(dto);

		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			companyDao = pm.makePersistent(companyDao);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
		if (companyDao != null) {
			return companyDao.toDto();
		}
		return null;

	}
	
	@SuppressWarnings("unchecked")
	public List<CompanyDetailsDto> getListOfCompanies(String companyType){
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<CompanyDetailsDto> companyDetails = new ArrayList<CompanyDetailsDto>();

		try {
		  
		   Query query = pm.newQuery(SELECT_COMPANIES_BY_TYPE);
		   List<CompanyDao> daos = ( List<CompanyDao> ) query.execute(companyType);
		   
		   if( daos != null ){
			   for( CompanyDao dao : daos ){
				 companyDetails.add(dao.toDetailsDto());
			   }
		   }

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
		
		return companyDetails;	
		
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public CompanyDto getById(String id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try{

			Object idInstance = pm.newObjectIdInstance(CompanyDao.class, id);
			CompanyDao attachedCompany = (CompanyDao) pm.getObjectById(idInstance);
			if( attachedCompany != null ){
			  return attachedCompany.toDto();
			}
		
		}
		finally{
			pm.close();
		}
	  	
		return null;
		
	}

	/**
	 * 
	 * @param dto
	 */
	public void delete(Object dto) {
		// TODO Auto-generated method stub

	}

}
