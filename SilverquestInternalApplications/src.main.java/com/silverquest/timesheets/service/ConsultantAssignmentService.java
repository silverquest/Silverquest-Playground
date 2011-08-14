package com.silverquest.timesheets.service;

import com.silverquest.timesheets.dto.TimeSheetTemplate;
import com.silverquest.timesheets.jdo.service.ConsultantAssignmentJdoService;


public interface ConsultantAssignmentService extends ConsultantAssignmentJdoService{
	
	public TimeSheetTemplate getCurrentAssignmentTimeSheetTemplate(String userId);


}
