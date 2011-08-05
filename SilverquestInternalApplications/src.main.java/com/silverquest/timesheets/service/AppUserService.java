package com.silverquest.timesheets.service;

import java.util.List;
import com.silverquest.timesheets.dto.AppUserDto;
import com.silverquest.timesheets.jdo.service.AppUserJdoService;

public interface AppUserService extends AppUserJdoService{

	public AppUserDto getDtoById(String id);
	
	public List<AppUserDto> findParentEmployees();
	
}
