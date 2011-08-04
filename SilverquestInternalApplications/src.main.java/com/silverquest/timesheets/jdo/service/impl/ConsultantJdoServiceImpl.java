package com.silverquest.timesheets.jdo.service.impl;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.beans.factory.InitializingBean;

import com.silverquest.timesheets.PMF;
import com.silverquest.timesheets.dao.ConsultantDao;
import com.silverquest.timesheets.dto.ConsultantDto;
import com.silverquest.timesheets.jdo.service.ConsultantJdoService;

public class ConsultantJdoServiceImpl implements ConsultantJdoService, InitializingBean{


	private final String SELECT_BY_USERNAME = "SELECT from com.silverquest.timesheets.dao.ConsultantDao where userId =:userId";
	
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public ConsultantDto getConsultantDetails(String userId){
		
		PersistenceManager pm = PMF.get().getPersistenceManager();

		ConsultantDao dao = null;
		try {
			Query query = pm.newQuery( SELECT_BY_USERNAME, userId );
			
			query.setUnique(true);
			dao = (ConsultantDao) query.execute(userId);

		} finally {
			pm.close();
		}
		
		if( dao != null ){
		  return dao.toDto();
		}
		return null;
		
	}
	

	
	
	/**
	 * 
	 * @param consultantDto
	 * @return
	 */
	public ConsultantDto saveConsultant(ConsultantDto consultantDto) {
		
		ConsultantDao consultantDao = new ConsultantDao(consultantDto);

		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			consultantDao = pm.makePersistent(consultantDao);

		} 
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			pm.close();
		}
		if( consultantDao != null ){
			return consultantDao.toDto();
		}
		return null;
	}
	





	@Override
	public void afterPropertiesSet() throws Exception {
	

		
	}

}
