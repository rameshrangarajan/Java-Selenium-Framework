package com.FP.Pages;

import com.FP.global.GlobalCommonMethods;

public class FoodPandaWebElementLocators extends GlobalCommonMethods {
	
	// LOCATORS FOR LOGIN PAGE
		public String FP_SignUp_Link_Locator = "xpath=//*[contains(text(),'Log in or Sign up')]";
		public String FP_Login_Email_Textbox_Locator = "xpath=//*[@id='customer_login_email']";
		public String FP_Login_Password_Textbox_Locator = "id=customer_login_password";
		public String FP_Login_Button_Locator = "xpath=//*[@id='customer_login_login']";
		
		public String FP_City_Dropdown_Locator = "xpath=(//input[@type='text'])[2]";
		public String FP_Area_Textbox_Locator = "id=area";
		public String FP_Show_Restaurant_Button_Locator = "xpath=//*[contains(text(),'Show restaurants')]";
		public String FP_First_retaurant = "xpath=//article[@class='vendor list js-vendor-list-vendor-panel']/a[@data-clicked_restaurant_position='1']";
		public String FP_My_Account = "xpath= //header//ul/li[2]/a";
		public String FP_Logout = "xpath=//li[@class='header-links__customer-account open']//ul/li[5]/a[@href = '/logout']";
		//public String NLPRO_Upload_Text_Locator = "xpath=//*[@id='uploadData']/input[@id='loadTextFile']";
		public String NLPRO_Upload_Text_Locator = "id=loadTextFile";
		//public String NLPRO_Upload_Text_Locator = "id=textEditorData";
		public String NLPRO_Select_Person_Sub_Menu = "xpath=//ul[@class='context-menu-list']//li[@class='context-menu-item'][1]//span[text()='Person']";
        public String NLPRO_Hover_Add_Menu = "xpath=//ul/li[1]/span[text()='Add']";
        public String NLPRO_Lookup_Organization_Locator = "xpath=//ul[@class='ng-scope']//li[@class='ng-scope']//button//span[text()='organization']";
        public String NLPRO_Lookup_Bank_Names_File_Locator = "xpath=//*[@id='downloadFileBtn0']";
        public String NLPRO_Lookup_Screen_Locator = "xpath=//*[@id='wrapper']/nav/div/div[2]/button[2]";
}
