package com.silverquest.timesheets.jdo.service;

import com.silverquest.timesheets.dto.ConsultantDto;

public interface ConsultantJdoService {
	
	public ConsultantDto getConsultantDetails(String userId);
	
	/**
	 * 
	 * @param consultantDto
	 * @return
	 */
	public ConsultantDto saveConsultant(ConsultantDto consultantDto) ;
	

	
}
