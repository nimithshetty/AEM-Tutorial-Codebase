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
class SecondComponentModelTest {

	private final AemContext aemContext = new AemContext();

	SecondComponentModel secondComponentModel;

	@BeforeEach
	void setUp() throws Exception {
		aemContext.addModelsForClasses(SecondComponentModel.class);
		aemContext.load().json("/components/secondcomponent/SecondComponentModel.json", "/component");
		Resource resource = aemContext.resourceResolver().getResource("/component/data");
		secondComponentModel = aemContext.getService(ModelFactory.class).createModel(resource,
				SecondComponentModel.class);
	}

	@Test
	void testGetTitle() {
		String expected = "Title example";
		String actual = secondComponentModel.getTitle();
		assertEquals(expected,actual);
	}

	@Test
	void testGetText() {
		String expected = "Text example";
		String actual = secondComponentModel.getText();
		assertEquals(expected,actual);
	}

	@Test
	void testGetEyebrow() {
		String expected = "Eyebrow example";
		String actual = secondComponentModel.getEyebrow();
		assertEquals(expected,actual);
	}

	@Test
	void testGetHeader() {
		String expected = "Header example";
		String actual = secondComponentModel.getHeader();
		assertEquals(expected,actual);
	}

}
