package com.silverquest.timesheets.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.silverquest.timesheets.command.TimeSheetCommand;
import com.silverquest.timesheets.service.TimeSheetService;
import com.silverquest.timesheets.service.impl.TimeSheetTemplate;

@Controller
public class TimeSheetController extends MultiActionController implements InitializingBean{

	@Autowired
	private TimeSheetService timeSheetService;
	
	@RequestMapping("/timesheet/intro")
	public ModelAndView intro(HttpServletRequest request, HttpServletResponse response, TimeSheetCommand command)
	            throws ServletException, IOException {

	   
	  Map<String, Object> model = referenceData(request, response, command);   	
	
	  return new ModelAndView( "XXX.jsp", model);
	
	}
	

	@RequestMapping("/apps/timesheets/createNew")
	public ModelAndView createNew(HttpServletRequest request, HttpServletResponse response, TimeSheetCommand command)
	            throws ServletException, IOException {

	   
	  Map<String, Object> model = referenceData(request, response, command);   	
	
	  return new ModelAndView( "time-sheet-view", model);
	
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 */
	private Map<String, Object> referenceData(HttpServletRequest request,
			HttpServletResponse response, TimeSheetCommand command) {
		// TODO Auto-generated method stub
		Map<String, Object> model = new HashMap<String, Object>();
		
		//Find logged in user from google login service
		String userId = "nicshel2";
		
		TimeSheetTemplate timeSheetTemplate = getTimeSheetService().getTimeSheetTemplate(userId);
		
		if( timeSheetTemplate != null ){
		
				model.put("TimeSheetTemplate", timeSheetTemplate);
		}
		return model;
		
	}
	
	public TimeSheetService getTimeSheetService() {
		return timeSheetService;
	}

	public void setTimeSheetService(TimeSheetService timeSheetService) {
		this.timeSheetService = timeSheetService;
	}


	@Override
	public void afterPropertiesSet() throws Exception {
	
	  if( timeSheetService == null ){
        System.out.println("TimeSheet is null from TimeSheetController");
	  }
	  else{
		   System.out.println("TimeSheet is fine from TimeSheetController"); 
	  }
		
	}
	
	
	
	
	
	
	
}
