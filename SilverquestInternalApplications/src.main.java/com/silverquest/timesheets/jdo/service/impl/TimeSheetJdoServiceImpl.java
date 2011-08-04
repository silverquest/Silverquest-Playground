package com.silverquest.timesheets.jdo.service.impl;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import com.silverquest.timesheets.PMF;
import com.silverquest.timesheets.dao.TimeSheetDao;
import com.silverquest.timesheets.dto.TimeSheetDto;
import com.silverquest.timesheets.jdo.service.TimeSheetJdoService;

public class TimeSheetJdoServiceImpl implements TimeSheetJdoService{

	private final String SELECT_BY_ID_AND_USER = "SELECT from com.silverquest.timesheets.dao.TimeSheetDao WHERE owner = :userId AND contractId =:contractId ";
	
	@Override
	public TimeSheetDto getTimeSheetById(String userId, String timeSheetId) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		TimeSheetDto timeSheetDto = null;
		TimeSheetDao timeSheetDao = null;
		try {

			Query q = pm.newQuery(SELECT_BY_ID_AND_USER);
		    q.setUnique(true);
		    
		    timeSheetDao = (TimeSheetDao) q.execute(userId, timeSheetId);
		    
		    if( timeSheetDao != null ){
		      timeSheetDto = timeSheetDao.toDto();
		    }

		} finally {
			pm.close();
		}
		return timeSheetDto;	
		
		
	}
	

}
