package niteco.com.auto.mydemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	
	//Declare variables
	WebDriver driver;
	public String baseUrl= "http://demo.guru99.com/v4/";
		
	public String expectedTitle = "Guru99 Bank";
	
	public String userName="mngr40953";
	public String pass="jumYsuq";
	public String incorrectPass="123456";
	
	public String expectedLoginFailedMessage="User or Password is not valid";
	String expectedLogoutMessage= "You Have Succesfully Logged Out!!";
	public String expectedWelcomeText="Manger Id : "+userName;
	public String actualTitle= "";
	public String chromeDriverPath = "E:/Projects/Automation/auto.mydemo/src/main/resources/chromedriver.exe";
	
	
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
		txtUserId= driver.findElement(By.name("uid"));
		txtPass= driver.findElement(By.name("password"));
		btnLogin= driver.findElement(By.name("btnLogin"));
		
	}
	@Test (priority=0)	
	public void verifyTitle(){
		//Get label text element by tagName
		//WebElement lblTitle= driver.findElement(By.tagName("h2"));
		//Get label text element by xpath
		//WebElement lblTitle= driver.findElement(By.xpath("//h2[@class='barone']"));
		WebElement lblTitle= driver.findElement(By.cssSelector(".barone"));
		//Verify the title of the page
		actualTitle= lblTitle.getText();
		Assert.assertEquals(actualTitle,expectedTitle,"Title is not correct!");
	}
	//Verify that user can not login if username/pass is incorrect
	@Test (priority=1)	
	public void verifyLoginNotSuccessCase(){
		
		txtUserId.sendKeys("hien");
		txtPass.sendKeys(incorrectPass);
		
		btnLogin.click();	
		
		Alert alert = driver.switchTo().alert();
		String actualText=alert.getText();
		System.out.println(actualText);
		Assert.assertEquals(actualText, expectedLoginFailedMessage, "Loggin failed message is not correct!");
		alert.dismiss();
		
		
	}
	@Test (priority=2)	
	public void LoginSuccessfully()
	{
		
		/*txtUserId = new WebDriverWait(driver, 15).until(
			    ExpectedConditions.presenceOfElementLocated(
			    		By.name("uid")
			    )
			);*/
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		txtUserId= driver.findElement(By.name("uid"));
		txtUserId.sendKeys(userName);
		/*txtPass = new WebDriverWait(driver, 15).until(
			    ExpectedConditions.presenceOfElementLocated(
			    		By.name("password")
			    )
			);*/
		txtPass= driver.findElement(By.name("password"));
		txtPass.sendKeys(pass);
		//Login
		/*btnLogin = new WebDriverWait(driver, 15).until(
			    ExpectedConditions.presenceOfElementLocated(
			    		By.name("btnLogin")
			    )
			);*/
		btnLogin= driver.findElement(By.name("btnLogin"));
		btnLogin.click();	
		//Verify the welcome text is correct for logged user name
		lblWelcomeText= driver.findElement(By.xpath("//tr[@class='heading3']"));
		String welcomeText= lblWelcomeText.getText();
		Assert.assertEquals(welcomeText,expectedWelcomeText,"Welcome Text is not correct!");
		
	}
	@Test (priority =3)
	public void checkLogout(){
		//WebElement btnLogout= driver.findElement(By.xpath("//a[@href='Logout.php']"));
		WebElement btnLogout= driver.findElement(By.linkText("Log out"));
		btnLogout.click();
		Alert alert = driver.switchTo().alert();
		String actualLogoutMessage= alert.getText();
		System.out.println(actualLogoutMessage);
		
		Assert.assertEquals(actualLogoutMessage, expectedLogoutMessage, "The logout message is not correct! ");
		alert.dismiss();
		
		
	}
	@AfterTest
    public void exit()
    {
		driver.close();
		System.exit(0);
    }

}
