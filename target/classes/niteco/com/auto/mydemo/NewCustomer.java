package niteco.com.auto.mydemo;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class NewCustomer {

	WebDriver driver;
	public String baseUrl= "http://demo.guru99.com/v4/";
	public String userName="mngr40953";
	public String correctPass="jumYsuq";
	public String chromeDriverPath = "E:/Projects/Automation/auto.mydemo/src/main/resources/chromedriver.exe";
	
	int ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	WebElement btnNewCustomer;
	WebElement txtCustomerName;
	WebElement txtDOB;
	WebElement txtAddress;
	WebElement txtCity;
	WebElement txtState;
	WebElement txtPIN;
	WebElement txtMobileNumber;
	WebElement txtEmail;
	WebElement txtNewPass;
	WebElement btnSubmit;
	WebElement btnReset;
	
	String customerName= "hien";
	String gender="Female";
	String dob= "12/05/1988";
	String address="156 Xa Dan2";
	String city= "Ha Noi";
	String state="Ha Noi";
	String pin="545345";
	String mobile="543534597";
	String email="hien.test"+ran+"@niteco.se";
	String newPass= "123456";
	public WebElement txtUserId;
	public WebElement txtPass;
	public WebElement btnLogin;
	
	@BeforeTest
	public void setBase(){
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		//txtUserId= driver.findElement(By.name("uid"));
		txtUserId= driver.findElement(By.cssSelector("input[name=uid]"));
		
		
		txtPass= driver.findElement(By.name("password"));
		btnLogin= driver.findElement(By.name("btnLogin"));
		txtUserId.sendKeys(userName);
		txtPass.sendKeys(correctPass);
		btnLogin.click();
		//btnNewCustomer= new WebDriverWait(driver, 15).until(
			   // ExpectedConditions.presenceOfElementLocated(By.partialLinkText("tomer")));
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    btnNewCustomer= driver.findElement(By.partialLinkText("tomer"));
		btnNewCustomer.click();
		txtCustomerName= driver.findElement(By.name("name"));
		txtDOB= driver.findElement(By.name("dob"));
		txtAddress= driver.findElement(By.name("addr"));
		txtCity= driver.findElement(By.name("city"));
		txtState= driver.findElement(By.name("state"));
		txtPIN= driver.findElement(By.name("pinno"));
		txtMobileNumber= driver.findElement(By.name("telephoneno"));
		txtEmail= driver.findElement(By.name("emailid"));
		txtNewPass= driver.findElement(By.name("password"));
		btnSubmit= driver.findElement(By.name("sub"));
		btnReset= driver.findElement(By.name("res"));
		//btnNewCustomer= driver.findElement(By.xpath("//a[@href='addcustomerpage.php']"));
		
		
	}
	/*@Test(priority=0)
	public void VerifyTitlePage(){
		
		WebElement lblTitle= new WebDriverWait(driver, 15).until(
			    ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='heading3']")));
		String actualTitle= lblTitle.getText();
		
		String expectedTitle= "Add New Customer";
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	
	@Test(priority=2)
	public void VerifyErrorShownIfFieldIsBlank(){
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		txtCustomerName.sendKeys(Keys.TAB);
		String errorText="Customer name must not be blank";	
		WebElement lblErrorMess= new WebDriverWait(driver, 15).until(
			    ExpectedConditions.presenceOfElementLocated(By.id("message")));
		String actualErrorText=lblErrorMess.getText(); 
		System.out.println("Expected: "+errorText);
		System.out.println("Actual: "+actualErrorText);
		Assert.assertEquals(errorText,actualErrorText );
	}
	
	@Test(priority=1)
	public void VerifyColorBackgroundWhenHoverMouse(){
		
		
		  Actions builder = new Actions(driver);
		  btnNewCustomer= new WebDriverWait(driver, 15).until(
				    ExpectedConditions.presenceOfElementLocated(By.partialLinkText("tomer")));
	      Action mouseOverNewCustomer = builder
	                .moveToElement(btnNewCustomer).build();
	      String expectedBgColor = "rgba(254, 245, 238, 1)";
	      System.out.println("Expected backgound Color: "+ expectedBgColor);
	      mouseOverNewCustomer.perform();
	      String actualBgColor = btnNewCustomer.getCssValue("background-color");
	      System.out.println("Actual backgound Color: "+ actualBgColor);
	      Assert.assertEquals(expectedBgColor, actualBgColor);
	}*/
	
	
	/*@Test
	public void AddNewCustomerNotSuccess(){
		
	}*/
	@Test
	public void AddNewCustomerSuccess(){
		txtCustomerName.click();
		txtCustomerName.sendKeys(customerName);
		
		List<WebElement> radGender = driver.findElements(By.name("rad1"));
		
		if(gender=="Female")
		{
			radGender.get(1).click();
		}
		else
		{
			radGender.get(0).click();
		}
		txtDOB.sendKeys(dob);
		txtAddress.sendKeys(address);
		txtCity.sendKeys(city);
		txtState.sendKeys(state);
		txtPIN.sendKeys(pin);
		txtMobileNumber.sendKeys(mobile);
		txtEmail.sendKeys(email);
		txtNewPass.sendKeys(newPass);
		
		btnSubmit.click();
		
		String successMessage= "Customer Registered Successfully!!!";
		
		WebElement lblAddNewCustomerSuccessMessage= driver.findElement(By.xpath("//p[@class='heading3']"));
		Assert.assertEquals(successMessage, lblAddNewCustomerSuccessMessage.getText());
		
	}
	@AfterTest
    public void exit()
    {
		driver.close();
		System.exit(0);
    }
}
