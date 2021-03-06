package niteco.com.auto.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FHomePage {

	WebDriver driver;
	@FindBy(xpath="//table//tr[@class='heading3']")
	WebElement homePageUserName;
	
	public FHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

		public String getHomePageDashboardUserName(){
		 return	homePageUserName.getText();
		}
}
