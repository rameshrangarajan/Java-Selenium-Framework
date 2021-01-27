package com.FP.Pages;

import com.FP.global.TestStepType;

public class FoodPandaLoginLogout extends FoodPandaWebElementLocators {

	// FOR LOGIN
	public void foodPandaLogin(String UserName, String Password) {

		log("Clicking 'Log in or Sign up' link", TestStepType.INNER_SUBSTEP);
		click(FP_SignUp_Link_Locator);
		log("Entering the Email. ", TestStepType.INNER_SUBSTEP);
		type(FP_Login_Email_Textbox_Locator, UserName);
		log("Entering the Password. ", TestStepType.INNER_SUBSTEP);
		type(FP_Login_Password_Textbox_Locator, Password);
		log("Clicking on LOGIN button.", TestStepType.INNER_SUBSTEP);

		clickAndWait(FP_Login_Button_Locator);
		pause(3);
	}

	public void foodPandaLogout() {

		log("Clicking My Account link", TestStepType.INNER_SUBSTEP);
		click(FP_My_Account);
		pause(4);
		log("Logging out ", TestStepType.INNER_SUBSTEP);
		clickAndWait(FP_Logout);

	}

}
