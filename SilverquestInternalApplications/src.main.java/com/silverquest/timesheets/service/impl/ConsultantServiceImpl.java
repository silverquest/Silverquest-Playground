package com.silverquest.timesheets.service.impl;

import com.silverquest.timesheets.dto.ConsultantAssignmentDto;
import com.silverquest.timesheets.dto.ConsultantDto;
import com.silverquest.timesheets.jdo.service.impl.ConsultantJdoServiceImpl;
import com.silverquest.timesheets.service.ConsultantService;

public class ConsultantServiceImpl extends ConsultantJdoServiceImpl implements ConsultantService {

	@Override
	public ConsultantDto getConsultantByUsername() {
		
		return new ConsultantDto();
	}

	@Override
	public ConsultantDto getConsultantDetails(String userId) {
	  return super.getConsultantDetails(userId);
	}

	@Override
	public ConsultantAssignmentDto findCurrentConsultantContract(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
