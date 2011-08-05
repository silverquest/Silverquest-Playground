package com.silverquest.timesheets.jdo.service.impl;


import org.junit.Test;


import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.silverquest.timesheets.dto.AddressDto;
import com.silverquest.timesheets.dto.CompanyDto;
import com.silverquest.timesheets.dto.CompanyType;

public class CompanyJdoServiceImplTest extends TestCase {

	
    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());


    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }
    
    @Test
    public void testSave(){
    	
    	try{
    	
	    	CompanyDto dto = new CompanyDto();
	    	dto.setCompanyName("Lisa's Company");
	    	dto.setType(CompanyType.CLIENT);
	    	AddressDto address = new AddressDto();;
	    	address.setAddressLine1("72 Avondale Park");
	    	dto.setAddress(address);
	    	
	    	CompanyJdoServiceImpl service = new CompanyJdoServiceImpl();
	    	
	    	dto = service.save(dto);
	    	
	    	System.out.println(dto.getId());
	    	System.out.println("xxx");
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	
    	
    }


}


