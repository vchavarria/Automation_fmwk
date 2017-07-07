package com.cucumber.testng.examples;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilis.Constant;
import utilis.ExcelLoadUtil;
import utilis.ExcelUtils;

public class Login {
	public WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	public Login() throws Exception {
		driver = BaseStepDefs.driver;
	}

	@When("^User enters a valid user name$")
	public void user_enters_a_valid_user_name() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// This is to get the Path of the excel file
		ExcelLoadUtil excelUtil = new ExcelLoadUtil();
		excelUtil.setExcelFile(Constant.Path_TestDataLogin + Constant.File_TestDataLogin);
		// This is to get the values from Excel sheet, passing parameters (Row
		// num &amp; Col num)
		String sUserName = ExcelUtils.getStringCellValue(excelUtil.getExcelWBook(), 0, 0, 0);

		System.out.println("User Name is " + sUserName);

		// throw new PendingException();
	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ExcelLoadUtil excelUtil = new ExcelLoadUtil();
		excelUtil.setExcelFile(Constant.Path_TestDataLogin + Constant.File_TestDataLogin);
		String sPassword = ExcelUtils.getStringCellValue(excelUtil.getExcelWBook(), 0, 0, 1);

		System.out.println("Password is " + sPassword);

		// throw new PendingException();
	}

	@And("^User clicks in the Login button$")
	public void clicks_into_the_login_button() throws Throwable {
		System.out.println("Hello World ");
	}

	@Then("^user shall be redirected to the FB main page$")
	public void user_shall_be_redirected_to_the_OM_main_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Hello World ");
		// throw new PendingException();
	}

}
