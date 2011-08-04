package example.controllers.hello;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.silverquest.timesheets.service.TestWiring;

import example.command.UserCommand;

@Controller
public class HelloController extends MultiActionController implements InitializingBean{
	
	@Autowired
	private TestWiring testWiring;

	@RequestMapping("/hello/test")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	     String now = (new Date()).toString();
	     System.out.println("Returning hello view with " + now);

	      Map model = new HashMap();
	      model.put("now", now);
	      request.setAttribute("model", model);
	      return new ModelAndView("hello/hello", model);
	 }
	
	
	@RequestMapping("/hello/save")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response, UserCommand command)
	            throws ServletException, IOException {

		 Map model = new HashMap();
		 
		 System.out.println(command.getFirstName());
		 System.out.println(command.getLastName());
		 
	     request.setAttribute("model", model);
	     return new ModelAndView("hello/hello", model);
	 }
	
	
	
	/*
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name, Model model) {

		testWiring.test();
		
		model.addAttribute("name", name);
		return "hello/hello";
	}*/



	public TestWiring getTestWire() {
		return testWiring;
	}

	public void setTestWire(TestWiring testWire) {
		this.testWiring = testWire;
	}



	@Override
	public void afterPropertiesSet() throws Exception {
		if( testWiring== null ){
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX  - error");
		}
		
	}
}