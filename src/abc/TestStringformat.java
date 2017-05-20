package abc;

import org.testng.annotations.Test;
import abc.interfaces.*;
import abc.launch.*;
import abc.pages.*;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestStringformat {
	WebDriver driver;
  @Test
  public void Stringformat() throws Exception{
	  LoginPage loginPage = new LoginPage(driver, UrlNameWord.Url);
	  WritePage writePage = new WritePage(driver);
      loginPage.login(UrlNameWord.u4, UrlNameWord.p);
	  Thread.sleep(3000);
	  writePage.backzhu();
	  writePage.backwait();
	  Assert.assertEquals(writePage.greet().isDisplayed(),true);
	  System.out.println(Outputs.tags2);
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
