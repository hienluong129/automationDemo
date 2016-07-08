package niteco.com.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	String userName;
	String pass;
	By txtUserName= By.name("uid");
	By txtPass= By.name("password");
	By btnLogin= By.name("btnLogin");
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}
	public void setUserName(String userName){
		driver.findElement(txtUserName).sendKeys(userName);
	}
	public void setPass(String pass){
		driver.findElement(txtPass).sendKeys(pass);
	}
	public String getUserName(){
		return this.userName;
	}
	public String getPass(){
		return this.pass;
	}
	public void clikLogin(){
		driver.findElement(btnLogin).click();
	}
	public void login(String userName, String pass){
		this.setUserName(userName);
		this.setPass(pass);
		this.clikLogin();
	}

}
