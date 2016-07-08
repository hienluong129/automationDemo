package niteco.com.auto.mydemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSample{
	WebDriver driver;
	public String baseUrl= "http://demo.guru99.com/v4/";
	public String chromeDriverPath = "E:/Projects/Automation/auto.mydemo/src/main/resources/chromedriver.exe";
	public String expectedTitle = "Guru99 Bank";
	public WebElement txtUserId;
	public WebElement txtPass;
	public WebElement btnLogin;
	public WebElement lblWelcomeText;	
	
	@BeforeTest
	public void setBaseUrl()
	{
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}
	@DataProvider(name = "account")
	public Object[][] accountData(){
		Object[][] myAccount = new Object[1][2];
		myAccount[0][0]="mngr40953";
		myAccount[0][1]= "jumYsuq";
		return myAccount;
		
	}

	@Test(dataProvider="account")
	public void login(String userName, String pass){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		txtUserId= driver.findElement(By.name("uid"));
		txtUserId.sendKeys(userName);
		txtPass= driver.findElement(By.name("password"));
		txtPass.sendKeys(pass);
		btnLogin= driver.findElement(By.name("btnLogin"));
		btnLogin.click();
		
		lblWelcomeText= driver.findElement(By.xpath("//tr[@class='heading3']"));
		String welcomeText= lblWelcomeText.getText();
		String expectedWelcomeText="Manger Id : "+userName;
		Assert.assertEquals(welcomeText,expectedWelcomeText,"Welcome Text is not correct!");
		
		
	}
	@AfterTest
    public void exit()
    {
		driver.close();
		System.exit(0);
    }
}
