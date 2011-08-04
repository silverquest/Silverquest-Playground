package com.silverquest.timesheets.jdo.service;

import com.silverquest.timesheets.dto.ConsultantContractDto;


public interface ConsultantContractJdoService {

	
	public ConsultantContractDto findCurrentConsultantContract(String userId);
	
	public ConsultantContractDto save(ConsultantContractDto dto);
	
}
