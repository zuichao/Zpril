package abc;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import abc.interfaces.*;
import abc.launch.*;
import abc.pages.*;

public class TestInterFace {
	WebDriver driver;
  @Test
  public void login() {
	  LoginPage loginPage = new LoginPage(driver, UrlNameWord.Url);
	  loginPage.login(UrlNameWord.u1, UrlNameWord.p);
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
