package com.silverquest.timesheets.jdo.service;

import com.silverquest.timesheets.dto.ConsultantAssignmentDto;


public interface ConsultantAssignmentJdoService {

	
	public ConsultantAssignmentDto findCurrentConsultantContract(String userId);
	
	public ConsultantAssignmentDto save(ConsultantAssignmentDto dto);
	
	
	
}
