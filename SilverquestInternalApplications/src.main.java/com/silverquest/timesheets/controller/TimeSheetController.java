package com.silverquest.timesheets.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.silverquest.timesheets.command.TimeSheetCommand;
import com.silverquest.timesheets.dto.AppUserDto;
import com.silverquest.timesheets.dto.CompanyDetailsDto;
import com.silverquest.timesheets.dto.CompanyType;
import com.silverquest.timesheets.dto.TimeSheetEntryDto;
import com.silverquest.timesheets.service.AppUserService;
import com.silverquest.timesheets.service.CompanyService;
import com.silverquest.timesheets.service.TimeSheetService;

@Controller
public class TimeSheetController extends MultiActionController implements
		InitializingBean {

	@Autowired
	private TimeSheetService timeSheetService;
	@Autowired
	private CompanyService companyService;

	@Autowired
	private AppUserService appUserService;

	@RequestMapping("/timesheets/intro.htm")
	public ModelAndView intro(HttpServletRequest request,
			HttpServletResponse response, TimeSheetCommand command)
			throws ServletException, IOException {

		Map<String, Object> model = new HashMap<String, Object>();

		model = referenceData(model);

		model.put("message", "Saved");
		request.setAttribute("model", model);
		
		return new ModelAndView("time-sheet-extjs-view", model);

	}

	private Map<String, Object> referenceData(Map<String, Object> model) {

		List<TimeSheetEntryDto> timeSheetEntries = new ArrayList<TimeSheetEntryDto>();

		for (int i = 0; i <= 7; i++) {
			timeSheetEntries.add(new TimeSheetEntryDto());
		}

		List<CompanyDetailsDto> companies = companyService
				.findCompaniesByType(CompanyType.PARENT.toString());
		if (companies != null) {
			model.put("companies", companies);
		}

		List<AppUserDto> consultants = appUserService.findParentEmployees();
		model.put("consultants", consultants);

		model.put("clientCompanies", companyService
				.findCompaniesByType(CompanyType.CLIENT.toString()));

		model.put("timeSheetEntries", timeSheetEntries);

		return model;

	}

	@RequestMapping("/timesheets/createNewTimeSheet.htm")
	public ModelAndView createNewTimeSheet(HttpServletRequest request,
			HttpServletResponse response, TimeSheetCommand command)
			throws ServletException, IOException {

		// save the time sheet
		timeSheetService.save(command);

		Map<String, Object> model = new HashMap<String, Object>();
		
		model = referenceData(model);

		model.put("message", "Saved");
		request.setAttribute("model", model);
		return new ModelAndView("time-sheet-view", model);
	}

	public TimeSheetService getTimeSheetService() {
		return timeSheetService;
	}

	public void setTimeSheetService(TimeSheetService timeSheetService) {
		this.timeSheetService = timeSheetService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		if (timeSheetService == null) {
			System.out.println("TimeSheet is null from TimeSheetController");
		} else {
			System.out.println("TimeSheet is fine from TimeSheetController");
		}

	}

	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		binder.registerCustomEditor(String.class,
				new StringTrimmerEditor(false));
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public AppUserService getAppUserService() {
		return appUserService;
	}

	public void setAppUserService(AppUserService appUserService) {
		this.appUserService = appUserService;
	}

}
