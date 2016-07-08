package niteco.com.auto.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FLoginPage {
	
	WebDriver driver;
	@FindBy(name="uid")
	WebElement txtUserName;
	@FindBy(name="password")
	WebElement txtPass;
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	public FLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void setUserName(String userName){
		txtUserName.sendKeys(userName);
	}
	public void setPass(String pass){
		txtPass.sendKeys(pass);
	}
	public void clickLogin(){
		btnLogin.click();
	}
	public void login(String userName, String pass){
		this.setUserName(userName);
		this.setPass(pass);
		this.clickLogin();
	}
}
