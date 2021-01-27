package com.FP.global;

import com.FP.Pages.*;

public class FoodPandaPageFactory extends TESTURL {

	public FoodPandaLoginLogout FoodPandaLoginLogout() {
		return new FoodPandaLoginLogout();
	}

	public FoodPandaTest FoodPandaTest() {
		return new FoodPandaTest();
	}
	
	public NLProTest NLProTest() {
		return new NLProTest();
	}
	
	public GlobalCommonMethods GlobalCommonMethods()
	{
		return new GlobalCommonMethods();
	}

}
