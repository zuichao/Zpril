package abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import abc.testdatas.*;

public class LoginPage1 {
	
//此页为测试数据库页面
	
	private WebDriver driver;
	private DBOp dbsession = new DBOp("LoginPage1");
	
	public LoginPage1(WebDriver driver){
		this.driver = driver;
		dbsession.conn();
	}
	
	
	public void LoginStep(){
		this.driver.switchTo().defaultContent();
		this.driver.switchTo().frame("login_frame");
	}
	
	public void IDPassWord(){
		this.driver.findElement(By.xpath(dbsession.getXpath("IDpassword"))).click();
	}
	
	public void setUserName(String username){
		this.driver.findElement(By.xpath(dbsession.getXpath("UserName"))).sendKeys(username);
	}
	
	
	public void setPassword(String password){
		this.driver.findElement(By.xpath(dbsession.getXpath("PassWord"))).sendKeys(password);
	}
	
	public void SignIn(){
		this.driver.findElement(By.xpath(dbsession.getXpath("Submit"))).click();
	}

}
