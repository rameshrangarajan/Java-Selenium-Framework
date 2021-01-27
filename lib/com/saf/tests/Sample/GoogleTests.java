package com.saf.tests.Sample;
import org.testng.annotations.Test;

import com.saf.data.BaseData;
import com.saf.global.PageFactory;
import com.saf.global.TestGroups;
import com.saf.testng.RetryAnalyzer;

public class GoogleTests extends PageFactory {
	
	@Test(retryAnalyzer = RetryAnalyzer.class, groups = {TestGroups.BVT,TestGroups.SEARCH, TestGroups.Regression,TestGroups.ALL})
	public final void testGoogleSearch() throws Exception {
		open(url);
		GooglePage().search(BaseData.keyword);
		GooglePage().verifySearchResults();
		pause(5);
		
		checkinglist(getAssertList());
	}
	

}
