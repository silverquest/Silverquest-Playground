package com.silverquest.timesheets.jdo.service;

import java.util.List;

import com.silverquest.timesheets.dao.AppUserDao;
import com.silverquest.timesheets.dto.AppUserDto;


public interface AppUserJdoService {

	public AppUserDao getById(String id);

	public List<AppUserDto> findAppUsersByCompanyId(String id);
	
	public List<AppUserDto> findAppUsersByType(String type);
	
}
