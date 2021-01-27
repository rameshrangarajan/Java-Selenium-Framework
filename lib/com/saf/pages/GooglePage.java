package com.saf.pages;

import com.saf.data.BaseData;

public class GooglePage extends Page {

	private static final String inputSearch = "name=q";
	private static final String buttonSearch = "name=btnG";
	private static final String sectionResult = "//h3/a";

	public void search(String keyword) {
		type(inputSearch, keyword);
		clickAndWait(buttonSearch,2);		
	}

	public void verifySearchResults() {
		logWithScreenshot("First Result :"+getText(sectionResult));		
		waitForText(BaseData.result,3);
		retry("id=hfhjv", new Object(){},1);
	}
	
	


}
