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
import com.silverquest.timesheets.jdo.service.AppUserJdoService;

public class CompanyJdoServiceImpl implements CompanyJdoService {

	// Find all companies by type
	private final static String SELECT_COMPANIES_BY_TYPE = "SELECT from "
			+ CompanyDao.class.getName() + " WHERE type==:companyType";

	//
	private AppUserJdoService appUserJdoService;

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

	/**
	 * 
	 */


	@SuppressWarnings("unchecked")
	public List<CompanyDetailsDto> findCompaniesByType(String companyType) {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		List<CompanyDetailsDto> companyDetails = new ArrayList<CompanyDetailsDto>();

		try {

			Query query = pm.newQuery(SELECT_COMPANIES_BY_TYPE);
			List<CompanyDao> daos = (List<CompanyDao>) query
					.execute(companyType);

			if (daos != null) {
				for (CompanyDao dao : daos) {
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

	public CompanyDao getById(String id) {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		return getById(id, pm, true);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	private CompanyDao getById(String id, PersistenceManager pm, boolean closePM) {
		CompanyDao companyDao = null;
		try {

			Object idInstance = pm.newObjectIdInstance(CompanyDao.class, id);
			companyDao = (CompanyDao) pm.getObjectById(idInstance);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (closePM) {
				pm.close();
			}
		}

		return companyDao;

	}

	/**
	 * 
	 * @param dto
	 */
	public void delete(Object dto) {
		// TODO Auto-generated method stub

	}

	public AppUserJdoService getAppUserJdoService() {
		return appUserJdoService;
	}

	public void setAppUserJdoService(AppUserJdoService appUserJdoService) {
		this.appUserJdoService = appUserJdoService;
	}

}
