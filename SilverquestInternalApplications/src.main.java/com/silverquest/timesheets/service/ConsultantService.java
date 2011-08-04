package com.silverquest.timesheets.service;

import com.silverquest.timesheets.dto.ConsultantContractDto;
import com.silverquest.timesheets.dto.ConsultantDto;
import com.silverquest.timesheets.jdo.service.ConsultantJdoService;


public interface ConsultantService extends ConsultantJdoService{

	/**
	 * 
	 * @return
	 */
	public ConsultantDto getConsultantByUsername();

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public ConsultantDto getConsultantDetails(String userId);

	public ConsultantContractDto findCurrentConsultantContract(String userId);

}
