package com.silverquest.timesheets.jdo.service.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.beans.factory.InitializingBean;


import com.silverquest.timesheets.PMF;

import com.silverquest.timesheets.dao.ConsultantAssignmentDao;
import com.silverquest.timesheets.dto.ConsultantAssignmentDto;
import com.silverquest.timesheets.jdo.service.ConsultantAssignmentJdoService;



public class ConsultantAssignmentJdoServiceImpl implements ConsultantAssignmentJdoService, InitializingBean{

	
	private final static String SELECT_CONTRACT_BY_USERS = "SELECT from " + ConsultantAssignmentDao.class.getName() +  " WHERE consultantId==:userId"; 
	private final static String SELECT_CONTRACT_BY_USERS_OPEN = SELECT_CONTRACT_BY_USERS;

	public ConsultantAssignmentDto save(ConsultantAssignmentDto dto){
		
		ConsultantAssignmentDao consultantContractDao = new ConsultantAssignmentDao(dto);

		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			consultantContractDao = pm.makePersistent(consultantContractDao);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
		if (consultantContractDao != null) {
			return consultantContractDao.toDto();
		}
		return null;
		
	}
	
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ConsultantAssignmentDto findCurrentConsultantContract(String userId){

		PersistenceManager pm = PMF.get().getPersistenceManager();

		ConsultantAssignmentDao dao = null;
		try {
			
			String queryStr = SELECT_CONTRACT_BY_USERS_OPEN;

			Query query = pm.newQuery(queryStr);

		    List<ConsultantAssignmentDao> list = (List<ConsultantAssignmentDao>) query.execute(userId);
		    
		    if( list != null ){
		    	dao = list.get(0);
		    }

		} finally {
			pm.close();
		}
		
		if( dao != null ){
		  return dao.toDto();
		}
		return null;	
		
		
	}
	


	@Override
	public void afterPropertiesSet() throws Exception {
	

		
	}
	
}
