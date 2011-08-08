package com.silverquest.timesheets.jdo.service;

import com.silverquest.timesheets.dto.TimeSheetDto;

public interface TimeSheetJdoService {

   public TimeSheetDto getTimeSheetById(String userId, String timeSheetId );
   
   /**
    * save or update timesheets
    * @param dto
    * @return
    */
   public TimeSheetDto save(TimeSheetDto dto);

	
}
