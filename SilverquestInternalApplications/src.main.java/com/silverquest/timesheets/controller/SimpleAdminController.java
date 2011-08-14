package com.silverquest.timesheets.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
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
import com.silverquest.timesheets.command.CreateConsultantCommand;
import com.silverquest.timesheets.dto.AppUserDto;
import com.silverquest.timesheets.dto.CompanyDto;
import com.silverquest.timesheets.dto.CompanyType;
import com.silverquest.timesheets.dto.ConsultantAssignmentDto;
import com.silverquest.timesheets.service.AppUserService;
import com.silverquest.timesheets.service.CompanyService;
import com.silverquest.timesheets.service.ConsultantAssignmentService;
import com.silverquest.timesheets.service.ConsultantService;
import com.silverquest.timesheets.service.TimeSheetService;
import com.silverquest.timesheets.service.util.CSVDataUploaderUtil;

@Controller
public class SimpleAdminController extends MultiActionController implements
		InitializingBean {

	@Autowired
	private ConsultantService consultantService;
	@Autowired 
	private CompanyService companyService;
	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private ConsultantAssignmentService consultantAssigmentService;
	@Autowired
	CSVDataUploaderUtil csvDataUploaderUtil;
	@Autowired
	private TimeSheetService timeSheetService;


	@RequestMapping("/simple-admin/intro.htm")
	public ModelAndView intro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("PPP" + request.getContextPath());
		
		String now = (new Date()).toString();
		System.out.println("Returning hello view with " + now);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("now", now);
		
		
		model.put("clientCompanies",  companyService.findCompaniesByType(CompanyType.CLIENT.toString()));

		List<AppUserDto> consultants = appUserService.findParentEmployees();
		model.put("consultants", consultants);
		
		model.put("clientCompanies",  companyService.findCompaniesByType(CompanyType.CLIENT.toString()));
		
		
		request.setAttribute("model", model);
		return new ModelAndView("simple-admin-view", model);
	}
	
	
	
	/*
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
	*/
	
	@RequestMapping("/simple-admin/saveAssignment.htm")
	public ModelAndView saveAssignment(HttpServletRequest request,
			HttpServletResponse response, ConsultantAssignmentDto command)
			throws ServletException, IOException {


		command = consultantAssigmentService.save(command);

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("message", "Saved");
		
		
		model.put("assingmentId", command.getId());
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

		consultantService.saveConsultant(command);

		Map<String, Object> model = new HashMap<String, Object>();
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

		Map<String, Object> model = new HashMap<String, Object>();

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
	
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
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
	
	public AppUserService getAppUserService() {
		return appUserService;
	}


	public void setAppUserService(AppUserService appUserService) {
		this.appUserService = appUserService;
	}
	
	public ConsultantAssignmentService getConsultantAssigmentService() {
		return consultantAssigmentService;
	}


	public void setConsultantAssigmentService(
			ConsultantAssignmentService consultantAssigmentService) {
		this.consultantAssigmentService = consultantAssigmentService;
	}
	
	public TimeSheetService getTimeSheetService() {
		return timeSheetService;
	}


	public void setTimeSheetService(TimeSheetService timeSheetService) {
		this.timeSheetService = timeSheetService;
	}

}
