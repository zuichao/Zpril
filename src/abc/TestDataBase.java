package abc;

import org.testng.annotations.Test;

import abc.interfaces.Outputs;
import abc.launchs.*;
import abc.pages.*;
import abc.testdatas.*;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestDataBase {
	
	WebDriver driver;
	
  @Test
  public void dataBase() throws Exception {
	  	  
	  DBOp test = new DBOp("LoginPage1");
	  LoginPage1 login1 = new LoginPage1(driver);
	  test.conn();
	  this.driver.get(test.getValues("BaseUrl"));
	  Thread.sleep(3000);
	  login1.LoginStep();
	  login1.IDPassWord();
	  login1.setUserName(test.getValues("UserName"));
	  login1.setPassword(test.getValues("PassWord"));
	  login1.SignIn();
	  Thread.sleep(5000);
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
