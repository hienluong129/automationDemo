package niteco.com.auto.mydemo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import niteco.com.auto.model.NewUser;
import niteco.com.auto.util.ExcelDeserializer;
import niteco.com.auto.util.ReadExcel;

public class POISample {
	WebDriver driver;
	public String baseUrl= "http://demo.guru99.com/v4/";
	public String userName="mngr40953";
	public String correctPass="jumYsuq";
	public String chromeDriverPath = "E:/Projects/Automation/auto.mydemo/src/main/resources/chromedriver.exe";

	public WebElement txtUserId;
	public WebElement txtPass;
	public WebElement btnLogin;
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
	
	String customerName;
	String gender;
	String dob;
	String address;
	String city;
	String state;
	String pin;
	String mobile;
	String email;
	String newPass;
	
	public String filePath;
	public String fileName= "NewUser.xlsx";
	public String sheetName= "Sheet1";
	NewUser myUser;
	ArrayList<ArrayList> myArray;
	
	
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
	
	/*@Test
	public void AddNewCustomerSuccess(){
		filePath= System.getProperty("user.dir")+"\\src\\main\\resources\\"+fileName;
		List<NewUser> listObj = new ExcelDeserializer().convert(filePath,NewUser.class);
		for(int i=0; i< listObj.size();i++)
		{
		customerName= listObj.get(i).getUserName();
		gender= listObj.get(i).getGender();
		dob=listObj.get(i).getDob();
		address=listObj.get(i).getAddress();
		city=listObj.get(i).getCity();
		state=listObj.get(i).getState();
		pin=listObj.get(i).getPin();
		mobile=listObj.get(i).getPhone();
		email=listObj.get(i).getEmail();
		newPass=listObj.get(i).getPass();
		System.out.println(customerName);
		System.out.println(dob);
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
		
		
	}*/
	@Test
	public void AddNewCustomerSuccess() throws Exception{
		filePath= System.getProperty("user.dir")+"\\src\\main\\resources\\"+fileName;
		List<NewUser> listObj = ReadExcel.read(filePath, fileName, sheetName);
		for(int i=0; i< listObj.size();i++)
		{
		customerName= listObj.get(i).getUserName();
		gender= listObj.get(i).getGender();
		dob=listObj.get(i).getDob();
		address=listObj.get(i).getAddress();
		city=listObj.get(i).getCity();
		state=listObj.get(i).getState();
		pin=listObj.get(i).getPin();
		mobile=listObj.get(i).getPhone();
		email=listObj.get(i).getEmail();
		newPass=listObj.get(i).getPass();
		System.out.println(customerName);
		System.out.println(dob);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
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
		ReadExcel.write(filePath, fileName, sheetName, "Passed", 10);
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		    btnNewCustomer= driver.findElement(By.partialLinkText("tomer"));
			btnNewCustomer.click();
		}
	}
	
	@AfterTest
    public void exit()
    {
		driver.close();
		System.exit(0);
    }


}
