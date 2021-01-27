package com.FP.data;

import java.util.Random;

public class FoodPanda_BaseData {
	
	public static final Random rand = new Random();
	public static final int randNumb = rand.nextInt();
	public static final String randNumber = Integer.toString(randNumb);

	// INPUTS FOR LOGIN TO PlatformOne
	public static final String FP_Login_Email_Input = "test_account@gmail.com";
	public static final String FP_Login_Password_Input = "testing";
	

}
