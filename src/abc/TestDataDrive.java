package abc;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import abc.interfaces.Outputs;
import abc.launchs.*;
import abc.pages.*;
import abc.testdatas.*;

public class TestDataDrive {
	WebDriver driver;
  @Test
  public void dataDrive() throws Exception{
	  Datas a = new Datas(System.getProperty("user.dir")+"/src/abc/testdatas/testdata.csv");
	  LoginPage loginPage = new LoginPage(driver, a.getTestData("URL", "tc2"));
	  loginPage.login(a.getTestData("username", "tc2"), a.getTestData("password", "tc2"));
	  WritePage writePage = new WritePage(driver);
	  writePage.backzhu();
	  writePage.backwait();
	  Thread.sleep(3000);
	  Assert.assertEquals(writePage.greet().isDisplayed(), true);
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
