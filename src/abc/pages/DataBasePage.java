package abc.pages;

import abc.testdata.DBOp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataBasePage {
	
	private WebDriver driver;
	private DBOp dbsession = new DBOp("LoginPage");
	
	public DataBasePage(WebDriver driver){
		this.driver = driver;
		dbsession.conn();
	}
	
	
	public void setUserName(String username){
		driver.findElement(By.xpath(dbsession.getLocatorXpath("UserName"))).sendKeys(username);
	}
	
	
	public void setPassword(String password){
		this.driver.findElement(By.xpath(dbsession.getLocatorXpath("Password"))).sendKeys(password);
	}
	
	public void SignIn(){
		this.driver.findElement(By.xpath(dbsession.getLocatorXpath("submit"))).click();
	}

}
