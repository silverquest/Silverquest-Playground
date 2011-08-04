package com.silverquest.timesheets.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class SimpleLandingPageController extends MultiActionController implements InitializingBean{

	
	@RequestMapping("/index.htm")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     String now = (new Date()).toString();
     System.out.println("Returning hello view with " + now);

      Map model = new HashMap();
      model.put("now", now);
      request.setAttribute("model", model);
      return new ModelAndView("simple-landing-view", model);
	}
	
	@RequestMapping("/simple-landing/intro.htm")
	public ModelAndView intro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     String now = (new Date()).toString();
     System.out.println("Returning hello view with " + now);

      Map model = new HashMap();
      model.put("now", now);
      request.setAttribute("model", model);
      return new ModelAndView("simple-landing-view", model);
	}
	
	
	
	
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}


}
