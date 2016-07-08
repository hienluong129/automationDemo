package niteco.com.auto.mydemo;

import junit.framework.Assert;
import niteco.com.auto.PageFactory.FHomePage;
import niteco.com.auto.PageFactory.FLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class POMwithPageFactory {

	WebDriver driver;
	FLoginPage login;
	FHomePage homePage;
	String baseUrl="http://demo.guru99.com/v4/";
	String userName="mngr40953";
	String pass="jumYsuq";
	String expectedWelcomeText="Manger Id : "+userName;
	String chromeDriverPath = "E:/Projects/Automation/auto.mydemo/src/main/resources/chromedriver.exe";
	@BeforeTest
	public void setBase(){
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver= new ChromeDriver();
		driver.get(baseUrl);
	}
	@Test
	public void verifyLoginSuccess(){
		login= new FLoginPage(driver);
		login.login(userName, pass);
		homePage= new FHomePage(driver);
		String actualWelcomeText=homePage.getHomePageDashboardUserName();
		Assert.assertEquals(expectedWelcomeText, actualWelcomeText);
	}
	@AfterTest
	public void close(){
		driver.close();
		System.exit(0);
	}
}
