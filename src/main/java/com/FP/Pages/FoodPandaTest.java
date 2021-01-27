package com.FP.Pages;

import com.FP.global.GlobalCommonMethods;
import com.FP.global.TestStepType;

public class FoodPandaTest extends FoodPandaWebElementLocators {

	GlobalCommonMethods GM = new GlobalCommonMethods();

	public void enteringAddressdetails(String City, String Area) {
		try {
			log("Entering city", TestStepType.INNER_SUBSTEP);
			type(FP_City_Dropdown_Locator, City);
			log("Entering Area", TestStepType.INNER_SUBSTEP);
			type(FP_Area_Textbox_Locator, Area);
			pause(3);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickingShowrestaurantButton() {

		try {
			log("Clicking button", TestStepType.INNER_SUBSTEP);
			clickAndWait(FP_Show_Restaurant_Button_Locator);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectingFirstRestaurant() {
		try {
			log("Selecting first retaurant", TestStepType.INNER_SUBSTEP);
			click(FP_First_retaurant);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
