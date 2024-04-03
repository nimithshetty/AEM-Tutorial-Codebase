package com.adobe.aem.tutorial.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class ThirdComponentModel {

	@ValueMapValue
	private String title;
	
	@ValueMapValue
	private String text;
	
	@ChildResource
	private List<ThirdComponentListModel> multifieldList;

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public List<ThirdComponentListModel> getMultifieldList() {
		return multifieldList;
	}
	
}
