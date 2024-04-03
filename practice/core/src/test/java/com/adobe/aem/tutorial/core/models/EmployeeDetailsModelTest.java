package com.adobe.aem.tutorial.core.models;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
class EmployeeDetailsModelTest {
	
	private final AemContext aemContext = new AemContext();
	
	EmployeeDetailsModel employeeDetailsModel;

	@BeforeEach
	void setUp() throws Exception {
		aemContext.addModelsForClasses(EmployeeDetailsModel.class);
		aemContext.load().json("/components/employeedetails/EmployeeDetailsModel.json", "/component");
		Resource resource = aemContext.resourceResolver().getResource("/component/data");
		employeeDetailsModel = aemContext.getService(ModelFactory.class).createModel(resource,
				EmployeeDetailsModel.class);
	}

	@Test
	void testGetName() {
		String expected = "Nimith";
		String actual = employeeDetailsModel.getName();
		assertEquals(expected,actual);
	}

	@Test
	void testGetAge() {
		String expected = "29";
		String actual = employeeDetailsModel.getAge();
		assertEquals(expected,actual);
	}

	@Test
	void testGetNumber() {
		String expected = "11111111111";
		String actual = employeeDetailsModel.getNumber();
		assertEquals(expected,actual);
	}

	@Test
	void testGetCompany() {
		String expected = "Test Company";
		String actual = employeeDetailsModel.getCompany();
		assertEquals(expected,actual);
	}

	@Test
	void testGetDesignation() {
		String expected = "Lead AEM Developer";
		String actual = employeeDetailsModel.getDesignation();
		assertEquals(expected,actual);
	}
	
	@Test
	void testGetMultifieldList() {
		String expectedEyebrow = "AEM";
		String actualEyebrow = employeeDetailsModel.getMultifieldList().get(0).getSkill();
		assertEquals(expectedEyebrow,actualEyebrow);
		
	}

}
