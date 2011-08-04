package com.silverquest.timesheets.service;

import com.silverquest.timesheets.jdo.service.TimeSheetJdoService;
import com.silverquest.timesheets.service.impl.TimeSheetTemplate;

public interface TimeSheetService extends TimeSheetJdoService{

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public TimeSheetTemplate getTimeSheetTemplate(String userId);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public TimeSheetTemplate getTimeSheetForUpdate(String timeSheetId, String userId);
	

	
}
