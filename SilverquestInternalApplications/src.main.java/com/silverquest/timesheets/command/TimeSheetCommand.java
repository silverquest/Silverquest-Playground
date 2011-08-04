package com.silverquest.timesheets.command;

import java.util.ArrayList;
import java.util.List;

import com.silverquest.timesheets.dao.TimeSheetEntryDao;

public class TimeSheetCommand {

  private String weekStarting = "";
  private List<TimeSheetEntryDao> entries;
  int size = 7;
  
  
  public TimeSheetCommand(){
    
    entries = new ArrayList<TimeSheetEntryDao>();
    
    for( int i = 0 ; i < size; i ++ ){
      entries.add( new TimeSheetEntryDao() );
    }
 
  }
  
  public void setWeekStarting(String weekStarting){
    this.weekStarting = weekStarting;
  }
  
  public String getWeekStarting(){
    return weekStarting;
  }
  
  	
}
