package com.silverquest.timesheets.service;

import com.silverquest.timesheets.dto.TimeSheetTemplate;
import com.silverquest.timesheets.jdo.service.TimeSheetJdoService;

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
