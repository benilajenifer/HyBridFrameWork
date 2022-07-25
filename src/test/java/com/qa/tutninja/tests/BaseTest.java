package com.qa.tutninja.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.tutninja.factory.DriverFactory;
import com.qa.tutninja.pages.AccountsPage;
import com.qa.tutninja.pages.LoginPage;
import com.qa.tutninja.pages.ProductInfoPage;
import com.qa.tutninja.pages.RegistrationPage;
import com.qa.tutninja.pages.SearchResultsPage;

public class BaseTest {
	public WebDriver driver;
	public DriverFactory driverFactory;
	public Properties prop;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public SearchResultsPage searchResultsPage;
	public ProductInfoPage productInfoPage;
	public RegistrationPage registrationPage;

	public SoftAssert softAssert = new SoftAssert();

	@Parameters({ "browser", "browserversion" })
	@BeforeTest
	public void setUp(String browserName, String browserVersion) {
		driverFactory = new DriverFactory();
		prop = driverFactory.init_prop();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
			prop.setProperty("browserversion", browserVersion);
		}

		driver = driverFactory.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
