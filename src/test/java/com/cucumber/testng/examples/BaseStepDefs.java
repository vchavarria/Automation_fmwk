package com.cucumber.testng.examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testng.pageobjects.Login_Page_PO;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by Victor Chavarria
 * 
 */
public class BaseStepDefs {
	// public String BaseURL = "http://omdev.ca-labs.com/app/queue/reviewer";
	public static WebDriver driver;
	Login_Page_PO LoginpagePO;

	/* @Parameters("browser") */

	/* @Test */

	@Before()
	public void openBrowser(Scenario scenario) throws Exception {
		System.out.println("This is before Scenario: " + scenario.getName().toString());
		System.out.println("Called openBrowser");

		System.setProperty("webdriver.firefox.marionette",
				"C://Users//vrca//Documents//Automation base framework//Automation Frwk//mavne_failsafe_test//src//test//resources//com//drivers//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(utilis.Constant.BaseURL);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());

		LoginpagePO = PageFactory.initElements(driver, Login_Page_PO.class);

	}

	@After
	public void after(Scenario scenario) {
		System.out.println("This is after Scenario: " + scenario.getName().toString());
		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); // ... and embed it in the
														// report.
		}
		driver.quit();
	}
}
