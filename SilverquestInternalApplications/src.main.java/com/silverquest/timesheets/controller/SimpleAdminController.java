package com.silverquest.timesheets.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.silverquest.timesheets.command.CreateConsultantCommand;
import com.silverquest.timesheets.command.FileUploadBean;
import com.silverquest.timesheets.dto.CompanyDetailsDto;
import com.silverquest.timesheets.dto.CompanyDto;
import com.silverquest.timesheets.dto.CompanyType;
import com.silverquest.timesheets.service.CompanyService;
import com.silverquest.timesheets.service.ConsultantService;
import com.silverquest.timesheets.service.util.CSVDataUploaderUtil;

@Controller
public class SimpleAdminController extends MultiActionController implements
		InitializingBean {

	@Autowired
	private ConsultantService consultantService;

	@Autowired CompanyService companyService;



	@Autowired
	CSVDataUploaderUtil csvDataUploaderUtil;

	@RequestMapping("/simple-admin/intro")
	public ModelAndView intro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String now = (new Date()).toString();
		System.out.println("Returning hello view with " + now);

		Map model = new HashMap();
		model.put("now", now);
		
		List<CompanyDetailsDto> companies = getListOfCompanies();
		if( companies != null ){
			model.put("companies", companies);
		}
		
		
		request.setAttribute("model", model);
		return new ModelAndView("simple-admin-view", model);
	}
	
	
	private List<CompanyDetailsDto> getListOfCompanies(){
		
		return companyService.getListOfCompanies(CompanyType.CLIENT_COMPANY.toString());
		
	}

	@RequestMapping(value = "/simple-admin/createTestData", method = RequestMethod.POST)
	public ModelAndView createTestData(HttpServletRequest request,
			HttpServletResponse response, FileUploadBean command)
			throws ServletException, IOException {

		if (command.getFile() != null) {
			InputStream inputStream = command.getFile().getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));

			while (reader.readLine() != null) {

			}

		}

		Map model = new HashMap();

		model.put("message", "Saved");
		request.setAttribute("model", model);
		return new ModelAndView("simple-admin-view", model);
	}

	@RequestMapping("/simple-admin/saveconsultant.htm")
	public ModelAndView saveconsultant(HttpServletRequest request,
			HttpServletResponse response, CreateConsultantCommand command)
			throws ServletException, IOException {

		if (command != null) {
			System.out.println("Name: " + command.getFirstName() + ", "
					+ command.getLastName());
		}

		// / NB - TEST THIS !!!!!!!!!!!!!!!!!!
		consultantService.saveConsultant(command);

		Map model = new HashMap();

		model.put("message", "Saved");
		request.setAttribute("model", model);
		return new ModelAndView("simple-admin-view", model);
	}
	
	
	@RequestMapping("/simple-admin/savecompany.htm")
	public ModelAndView savecompany(HttpServletRequest request,
			HttpServletResponse response, CompanyDto command)
			throws ServletException, IOException {

		// / NB - TEST THIS !!!!!!!!!!!!!!!!!!
		companyService.save(command);

		Map model = new HashMap();

		model.put("message", "Saved");
		request.setAttribute("model", model);
		return new ModelAndView("simple-admin-view", model);
	}
	

	public ConsultantService getConsultantService() {
		return consultantService;
	}

	public void setConsultantService(ConsultantService consultantService) {
		this.consultantService = consultantService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		if (consultantService == null) {
			System.out.println("ERROR -  consultantService is null");
		} else {
			System.out
					.println("ConsultantService is fine from SimpleAdminController");
		}

		if (csvDataUploaderUtil == null) {
			System.out.println("ERROR !!!! -  csvDataUploaderUtil is null");
		}
		if( companyService == null ){
			System.out.println("CompanyService is null from SimpleAdminController");
		}
	}

	public CSVDataUploaderUtil getCsvDataUploaderUtil() {
		return csvDataUploaderUtil;
	}

	public void setCsvDataUploaderUtil(CSVDataUploaderUtil csvDataUploaderUtil) {
		this.csvDataUploaderUtil = csvDataUploaderUtil;
	}
	
	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

}
