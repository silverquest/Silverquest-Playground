package com.silverquest.timesheets.service.impl;

import org.springframework.beans.factory.InitializingBean;

import com.silverquest.timesheets.service.TestWiring;

public class TestWiringImpl implements TestWiring, InitializingBean{


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("XXXXX");
		
	}

	@Override
	public void test() {
		
		System.out.println("HEEEEEEEEELLLO");
		
	}
	
	

}
