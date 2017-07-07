package com.cucumber.testng.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_Page_PO {
	final WebDriver driver;

	@FindBy(how = How.ID, using = "email")
	public static WebElement Inpt_Username;

	@FindBy(how = How.ID, using = "pass")
	public static WebElement Inpt_Password;

	@FindBy(how = How.ID, using = "u_0_v")
	public static WebElement Btn_Login;

	@FindBy(how = How.CSS, using = "[type='submit']")
	public static WebElement Btn_Login2;

	public Login_Page_PO(WebDriver driver) {

		this.driver = driver;

	}
}
