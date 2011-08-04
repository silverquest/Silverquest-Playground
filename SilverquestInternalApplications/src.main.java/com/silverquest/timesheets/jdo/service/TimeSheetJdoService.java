package com.silverquest.timesheets.jdo.service;

import com.silverquest.timesheets.dto.TimeSheetDto;

public interface TimeSheetJdoService {

   public TimeSheetDto getTimeSheetById(String userId, String timeSheetId );

	
}
