package com.qa.tutninja.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.tutninja.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic - 100: design open cart application")
@Story("US - 101: Design login page with different features")
public class LoginPageTest extends BaseTest {	
	
@Description("Login page title test...")
@Severity(SeverityLevel.TRIVIAL)
@Test
public void loginPageTitleTest() {
	String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
}

@Description("forgot pwd link test...")
@Severity(SeverityLevel.CRITICAL)
@Test
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

@Description("Application login test with corrent username/password...")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginTest() {
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accountsPage.getAccountPageTitle(), Constants.ACCOUNTS_PAGE_TITLE);
	}

}
