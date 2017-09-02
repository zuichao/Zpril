package abc.homework;

import org.openqa.selenium.WebDriver;


public class QQmailFirstPage extends BasePage {
	
	private WebDriver driver;
	
	
	public QQmailFirstPage(WebDriver driver){
		super(driver,"QQmailFirstPage");
		this.driver = driver;
	
	}
	
	public void login(String userName,String password){
		
		this.setout();
		
		getLoc("IdPasswordLogin").click();
		
		getLoc("UserName").sendKeys(userName);
		
		getLoc("PassWord").sendKeys(password);
		
		getLoc("Submit").click();
	}

	public void setout(){
		this.driver.switchTo().defaultContent();
		this.driver.switchTo().frame("login_frame");
	}
	
	public void setout1(){
		this.driver.switchTo().defaultContent();
		this.driver.switchTo().frame("mainFrame");
	}
}
