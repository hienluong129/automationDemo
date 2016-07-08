package niteco.com.auto.mydemo;

import junit.framework.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GetElement {
	public String chromeDriverPath = "E:/Projects/Automation/auto.mydemo/src/main/resources/chromedriver.exe";
	String testUrl= "https://www.zalora.vn";
	String searchKey= "bag";
	WebDriver driver;
	@Test
	public void setBase(){
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(testUrl);
		
		String popup= driver.getWindowHandle();
		
		
		//Get element by name
		WebElement txtSearch= driver.findElement(By.name("q"));
		//Get element by class name
		//WebElement txtSearch= driver.findElement(By.className("lfloat js-seg-bar-search__selSearchInput seg-bar-search__selSearchInput"));
        txtSearch.sendKeys(searchKey);
        WebElement btnSearch = driver.findElement(By.xpath(".//*[@id='onsiteSearch']/button"));
        btnSearch.submit();
        
        WebElement lblSearchResult = new WebDriverWait(driver, 10).until(
        		ExpectedConditions.presenceOfElementLocated(
        				By.xpath("//div[@class='b-catalogList__searchInfo lfloat']")));
        String expectedSearchText= "Kết quả tìm kiếm cho : "+searchKey;
        String actualSearchText= lblSearchResult.getText();
        System.out.println(actualSearchText);
        System.out.println(expectedSearchText);
        Assert.assertEquals(expectedSearchText, actualSearchText);
		driver.close();
		System.exit(0);
	}
	

}
