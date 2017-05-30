package abc.homework;

import abc.interfaces.Outputs;
import abc.launch.*;
import abc.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginMail {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod(){
		Browsers browsers = new Browsers(BrowsersType.firefox);
		this.driver = browsers.driver;
	}
	
	@AfterMethod
	public void afterMethod(){
		this.driver.quit();
	}
	
	@Test
	public void loginMail() throws Exception{
		DBOp test = new DBOp("QQmailFirstPage");
		QQmailFirstPage mail = new QQmailFirstPage(driver);
		WritePage writePage = new WritePage(driver);
		test.conn(System.getProperty("user.dir")+"/src/abc/homework/qqmailDB.sqlite");
		
		this.driver.get(test.getValues("BaseUrl"));
		mail.login(test.getValues("UserName"), test.getValues("PassWord"));
		
		Thread.sleep(5000);
		
		mail.setout1();
		
		Assert.assertEquals(writePage.greet().isDisplayed(),true);
		System.out.println(Outputs.tags2);
	}

}
