package com.silverquest.timesheets.jdo.service.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.beans.factory.InitializingBean;


import com.silverquest.timesheets.PMF;

import com.silverquest.timesheets.dao.ConsultantContractDao;
import com.silverquest.timesheets.dto.ConsultantContractDto;
import com.silverquest.timesheets.jdo.service.ConsultantContractJdoService;



public class ConsultantContractJdoServiceImpl implements ConsultantContractJdoService, InitializingBean{


	public ConsultantContractDto save(ConsultantContractDto dto){
		
		ConsultantContractDao consultantContractDao = new ConsultantContractDao(dto);

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
	
	

	public ConsultantContractDto findCurrentConsultantContract(String userId){

		PersistenceManager pm = PMF.get().getPersistenceManager();

		ConsultantContractDao dao = null;
		try {
			
			Query query = pm.newQuery(ConsultantContractDto.class);
		    query.declareParameters("String userId, boolean isClosed, ");
		    query.setFilter("this.consultantId == userId and this.isClosed == isClosed");
		    query.setOrdering("this.dateStarted descending");
		    
		    
		    List<ConsultantContractDao> list = (List<ConsultantContractDao>) query.execute(userId, false);
		    
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
