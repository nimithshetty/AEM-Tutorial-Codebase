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
class ThirdComponentModelTest {

	private final AemContext aemContext = new AemContext();
	
	ThirdComponentModel thirdComponentModel;
	
	@BeforeEach
	void setUp() throws Exception {
		aemContext.addModelsForClasses(ThirdComponentModel.class);
		aemContext.load().json("/components/thirdcomponent/ThirdComponentModel.json", "/component");
		Resource resource = aemContext.resourceResolver().getResource("/component/data");
		thirdComponentModel = aemContext.getService(ModelFactory.class).createModel(resource,
				ThirdComponentModel.class);
	}

	@Test
	void testGetTitle() {
		String expected = "Title example";
		String actual = thirdComponentModel.getTitle();
		assertEquals(expected,actual);
	}

	@Test
	void testGetText() {
		String expected = "Text example";
		String actual = thirdComponentModel.getText();
		assertEquals(expected,actual);
	}

	@Test
	void testGetMultifieldList() {
		String expectedEyebrow = "Eyebrow 1";
		String actualEyebrow = thirdComponentModel.getMultifieldList().get(0).getEyebrow();
		assertEquals(expectedEyebrow,actualEyebrow);
		
		String expectedHeader = "Header 1";
		String actualHeader = thirdComponentModel.getMultifieldList().get(0).getHeader();
		assertEquals(expectedHeader,actualHeader);
		
	}

}
