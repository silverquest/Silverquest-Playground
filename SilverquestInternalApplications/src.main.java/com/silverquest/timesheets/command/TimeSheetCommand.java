package com.silverquest.timesheets.command;

import com.silverquest.timesheets.dto.TimeSheetDto;
import com.silverquest.timesheets.dto.TimeSheetEntryDto;

public class TimeSheetCommand extends TimeSheetDto{


  /**
	 * 
	 */
  private static final long serialVersionUID = 7138956268562427072L;
  int size = 7;
  
  
  public TimeSheetCommand(){
	  
	super();
    
	//Initializing timeSheetEntries
    for( int i = 0 ; i < size; i ++ ){
    	super.getTimeSheetEntries().add( new TimeSheetEntryDto() );
    }
 
  }
    	
}
