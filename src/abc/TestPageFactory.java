package abc;

import org.testng.annotations.Test;

import abc.launch.*;
import abc.pages.*;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestPageFactory {
	
	WebDriver driver;
	String baseUrl;
	
  @Test
  public void Pagefactory() throws Exception{
	  
	  String baseUrl = "http://www.jd.com/";
	  String name = "zlissb";
	  String word = "zlissb";
	  
	  JDFirstPage jdFirst = new JDFirstPage(driver);
	  JDRegisterPage jdRegister = new JDRegisterPage(driver);
	  
	  jdFirst.getUrl(baseUrl);
	  Thread.sleep(1000);
	  jdFirst.mianfeizhuce();
	  Thread.sleep(1000);
	  jdRegister.yonghuming(name);
	  jdRegister.mima(word);
	  jdRegister.lijizhuce();
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
