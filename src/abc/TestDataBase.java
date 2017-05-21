package abc;

import org.testng.annotations.Test;

import abc.launch.*;
import abc.pages.*;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestDataBase {
	
	WebDriver driver;
  @Test
  public void dataBase() throws Exception {
	  this.driver.get("http://mail.qq.com/");
	  DataBasePage dataBasePage = new DataBasePage(driver);
	  dataBasePage.setUserName("zuichao124");
	  dataBasePage.setPassword("sunjian123");
	  dataBasePage.SignIn();
	  Thread.sleep(5000);
  }
  @BeforeMethod
  public void beforeMethod() {
	  Browsers browsers = new Browsers(BrowsersType.firefox);
	  this.driver = browsers.driver;
  }

  @AfterMethod
  public void afterMethod() {
	  this.driver.quit();
  }

}
