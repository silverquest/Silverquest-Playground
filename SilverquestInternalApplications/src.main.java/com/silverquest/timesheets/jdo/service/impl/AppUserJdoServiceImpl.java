package com.silverquest.timesheets.jdo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.silverquest.timesheets.PMF;
import com.silverquest.timesheets.dao.CompanyDao;
import com.silverquest.timesheets.dao.AppUserDao;
import com.silverquest.timesheets.dao.ConsultantDao;
import com.silverquest.timesheets.dto.AppUserDto;
import com.silverquest.timesheets.jdo.service.AppUserJdoService;

public class AppUserJdoServiceImpl implements AppUserJdoService{

	public final static String SELECT_USERS_BY_COMPANY = "SELECT from " + ConsultantDao.class.getName() + " WHERE clientCompanyId==:companyId";

	public final static String SELECT_USER_BY_ID = "SELECT from " + ConsultantDao.class.getName() + " WHERE id==:id";
	
	@Override
	public AppUserDao getById(String id) {
	
		PersistenceManager pm = PMF.get().getPersistenceManager();
		AppUserDao userDao = null;
		
		try{

			Query q = pm.newQuery(SELECT_USER_BY_ID);
			q.setUnique(true);
			userDao = (AppUserDao) q.execute(id);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			pm.close();
		}
		return userDao;	
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppUserDto> findAppUsersByCompanyId(String companyId) {
		
		List<AppUserDto> appUsers = new ArrayList<AppUserDto>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			
			Query q = pm.newQuery(SELECT_USERS_BY_COMPANY);
			List<AppUserDao> daos = (List<AppUserDao>)q.execute(companyId);
			
			if( daos != null ){
			  for(AppUserDao dao : daos ){
				  appUsers.add(dao.toDto());
			  }
			}
			
		}
		catch(Exception e){
		  e.printStackTrace();
		}
		finally{
		  pm.close();
		}
		return appUsers;
	
		
		
		
	}

	@Override
	public List<AppUserDto> findAppUsersByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}
}
